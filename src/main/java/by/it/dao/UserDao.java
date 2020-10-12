package by.it.dao;

import by.it.JpaEntityManagerFactoryUtil;
import by.it.model.User;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public User findByID(long id) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return user;
    }


    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        allUsers = em.createQuery("select user from User user").getResultList();
        em.getTransaction().commit();
        em.close();
        return allUsers;
    }


    public User create(User user) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }


    public User update(User user) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }


    public void deleteById(long id) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
//        User userRemove = findByID(id);
        em.remove(findByID(id));
        em.getTransaction().commit();
        em.close();
    }
}
