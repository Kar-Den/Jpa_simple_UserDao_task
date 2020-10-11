package by.it;

import by.it.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Runner {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    public static void main(String[] args) {

        User user1 = User.builder()
                .firstName("Денис")
                .lastName("Карпенко")
                .build();

        User user2 = User.builder()
                .firstName("Иван")
                .lastName("Семёнов")
                .build();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user1);
        em.persist(user2);

        em.getTransaction().commit();

        User userFind = em.find(User.class, 2);
        System.out.println(userFind.getFirstName() + " " + userFind.getLastName());

    }

}

