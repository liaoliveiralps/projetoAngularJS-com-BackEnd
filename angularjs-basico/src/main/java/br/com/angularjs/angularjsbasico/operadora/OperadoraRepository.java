package br.com.angularjs.angularjsbasico.operadora;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OperadoraRepository {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<OperadoraDto> listarTodasOperadoras() {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<OperadoraDto> query = builder.createQuery(OperadoraDto.class);
        final Root<Operadora> operadora = query.from(Operadora.class);
        query.multiselect(operadora.get("nome"), operadora.get("codigo"), operadora.get("categoria"));
        return this.entityManager.createQuery(query).getResultList();
    }
    
    public Optional<Operadora> procurarPorNome(final String nome) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Operadora> query = builder.createQuery(Operadora.class);
        final Root<Operadora> operadora = query.from(Operadora.class);
        final Predicate predicate = builder.equal(operadora.get("nome"), nome);
        query.select(operadora);
        query.where(predicate);
        try {
            return Optional.of(this.entityManager.createQuery(query).getSingleResult());
        } catch (final NoResultException resultException) {
            return Optional.empty();
        }
    }
}
