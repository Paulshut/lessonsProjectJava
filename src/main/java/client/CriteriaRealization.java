package client;

import org.entity.Specialization;
import org.entity.Student;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.*;
import java.util.List;

public class CriteriaRealization {
    private static EntityManager entityManager = JPAUtil.getEntityManager();

    public static void updateNameSpecialization(CriteriaBuilder criteriaBuilder) {
        CriteriaUpdate<Specialization> criteriaUpdateSpec = criteriaBuilder
                .createCriteriaUpdate(Specialization.class);
        Root<Specialization> root = criteriaUpdateSpec.from(Specialization.class);
        criteriaUpdateSpec
                .set("nameSpecialization", "DataScience")
                .where(criteriaBuilder.equal(root.get("nameSpecialization"), "IT"));
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery(criteriaUpdateSpec).executeUpdate();
        transaction.commit();
    }

    public static void getStudentByNameSpecialization(CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = studentCriteriaQuery.from(Student.class);
        studentCriteriaQuery
                .select(root)
                .where(criteriaBuilder.equal(root.get("specialization").get("nameSpecialization"), "Java"));

        List<Student> resultList = entityManager.createQuery(studentCriteriaQuery).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void getStudentByNameWithSubQuery(CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = studentCriteriaQuery.from(Student.class);

        Subquery<Long> subquery = studentCriteriaQuery.subquery(Long.class);
        Root<Specialization> specializationRoot = subquery.from(Specialization.class);

        subquery.select(specializationRoot.get("id"));
        subquery.where(criteriaBuilder.equal(specializationRoot.get("nameSpecialization"), "Java"));

        studentCriteriaQuery
                .select(root)
                .where(criteriaBuilder.equal(root.get("specialization").get("id"), subquery));

        List<Student> resultList = entityManager.createQuery(studentCriteriaQuery).getResultList();
        resultList.forEach(System.out::println);
    }

    public static void getSpecializationAndDisciplineCount(CriteriaBuilder criteriaBuilder) {
        CriteriaQuery<Specialization> query = criteriaBuilder.createQuery(Specialization.class);
        Root<Specialization> root = query.from(Specialization.class);
        query.multiselect(root.get("nameSpecialization"), root.get("disciplineCount"));
        List<Specialization> resultList = entityManager.createQuery(query).getResultList();
        resultList.forEach(System.out::println);
    }

    public static CriteriaBuilder getCriteriaBuilder(EntityManager entityManager) {
        return entityManager.getCriteriaBuilder();
    }
}