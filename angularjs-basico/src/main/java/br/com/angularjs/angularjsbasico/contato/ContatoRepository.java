package br.com.angularjs.angularjsbasico.contato;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ContatoRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ContatoDto> listarTodosContatos() {
        final StringBuilder sql = new StringBuilder();
        sql.append(" SELECT new br.com.angularjs.angularjsbasico.contato.ContatoDto(c.id, c.nome, c.telefone, c.data, c.operadora) ");
        sql.append(" FROM Contato c JOIN c.operadora p ");
        final TypedQuery<ContatoDto> typedQuery = this.entityManager.createQuery(sql.toString(), ContatoDto.class);
        return typedQuery.getResultList();
    }
    
    public Optional<ContatoDto> contatoPorId(final Long id) {
        final StringBuilder sql = new StringBuilder();
        sql.append(" SELECT new br.com.angularjs.angularjsbasico.contato.ContatoDto(c.id, c.nome, c.telefone, c.data, c.operadora) ");
        sql.append(" FROM Contato c JOIN c.operadora p WHERE c.id=:id");
        final TypedQuery<ContatoDto> typedQuery = this.entityManager.createQuery(sql.toString(), ContatoDto.class);
        typedQuery.setParameter("id", id);
        try {
            return Optional.of(typedQuery.getSingleResult());
        } catch (final NoResultException resultException) {
            return Optional.empty();
        }
        
    }
    
    public void salvarContato(final Contato contato) {
        this.entityManager.persist(contato);
    }
    
}
