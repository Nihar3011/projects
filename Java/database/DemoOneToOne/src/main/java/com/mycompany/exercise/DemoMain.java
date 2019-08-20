package com.mycompany.exercise;

import com.mycompany.exercise.model.Address;
import com.mycompany.exercise.model.Education;
import com.mycompany.exercise.model.Student;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nihar
 */
public class DemoMain {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(DemoMain.class.getName());

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        DemoMain.createStudent(entityManager);
        DemoMain.getStudent(entityManager).forEach(System.out::println);

        JPAUtil.shutdown();
    }

    /**
     * Create New Student
     *
     * @param entityManager
     */
    public static void createStudent(EntityManager entityManager) {

        entityManager.getTransaction().begin();
        entityManager.merge(new Student("Nihar",
                "R", "Patel", "Mr.", " ",
                "npatel@argusoft.in", "95565656", new Address(
                        "37", "Alok", "palanpur", "gujarat", "india"),
                new Education("BE", "new", "Nothing", "2015", "VGEC")));
        entityManager.getTransaction().commit();
    }

    /**
     *
     * @param entityManager
     * @return Students List
     */
    public static List<Student> getStudent(EntityManager entityManager) {

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Student");

        List<Student> students = query.getResultList();
        entityManager.getTransaction().commit();

        return students;
    }

}
