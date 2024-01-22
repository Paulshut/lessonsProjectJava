package client;

import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

public class Runner {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = CriteriaRealization.getCriteriaBuilder(entityManager);
        CriteriaRealization.updateNameSpecialization(criteriaBuilder);
        CriteriaRealization.getSpecializationAndDisciplineCount(criteriaBuilder);
        CriteriaRealization.getStudentByNameSpecialization(criteriaBuilder);
        CriteriaRealization.getStudentByNameWithSubQuery(criteriaBuilder);
    }
}