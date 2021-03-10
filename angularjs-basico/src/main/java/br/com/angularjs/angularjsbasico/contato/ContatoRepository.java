package br.com.angularjs.angularjsbasico.contato;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ContatoDto> listarTodosContatos() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" SELECT new br.com.angularjs.angularjsbasico.contato.ContatoDto(c.nome, c.telefone, c.data, c.operadora) ");
        sql.append(" FROM Contato c JOIN c.operadora p ");
        final TypedQuery<ContatoDto> typedQuery = this.entityManager.createQuery(sql.toString(), ContatoDto.class);
        return typedQuery.getResultList();
    }
    
    public void salvarContato(final Contato contato) {
        this.entityManager.persist(contato);
    }
    
    public Optional<Contato> procurarContato(final String nome, final String telefone) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Contato> query = builder.createQuery(Contato.class);
        final Root<Contato> contato = query.from(Contato.class);
        final Predicate predicate = builder.equal(contato.get("nome"), nome);
        final Predicate predicate2 = builder.equal(contato.get("telefone"), telefone);
        query.select(contato);
        query.where(predicate, predicate2);
        try {
            return Optional.of(this.entityManager.createQuery(query).getSingleResult());
        } catch (final NoResultException resultException) {
            return Optional.empty();
        }
    }
}
