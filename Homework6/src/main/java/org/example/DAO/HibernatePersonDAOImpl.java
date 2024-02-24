package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.Utility.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernatePersonDAOImpl implements HibernatePersonDAO {
    @Override
    public PersonDTO save(PersonDTO person) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
        em.close();
        return person;
    }

    @Override
    public List<PersonDTO> findByColumn(String colNameForFind, Number greaterThenExclude, String colNameForOrder) {
        if (colNameForFind == null || greaterThenExclude == null || colNameForOrder == null) {
            return null;
        }
        List<PersonDTO> personList;
        EntityManager entityManager = HibernateUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonDTO> criteriaQuery = criteriaBuilder.createQuery(PersonDTO.class);
        Root<PersonDTO> root = criteriaQuery.from(PersonDTO.class);
        Order order = criteriaBuilder.asc(root.get(colNameForOrder));
        try {
            criteriaQuery
                    .select(root)
                    .where(criteriaBuilder.gt(root.get(colNameForFind), greaterThenExclude))
                    .orderBy(order);
            Query query = entityManager.createQuery(criteriaQuery);
            personList = query.getResultList();
        } catch (IllegalArgumentException e) {
            entityManager.close();
            return null;
        }
        entityManager.close();
        return personList;
    }
}
