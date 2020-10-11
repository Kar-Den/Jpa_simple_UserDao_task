package by.it.dao;

import by.it.JpaEntityManagerFactoryUtil;
import by.it.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {


    public User findByID(long id) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }


    public List<User> findAll() {
        return null;
    }


    public User create(User user) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }


    public User update(User user) {
        return null;
    }


    public void deleteById(long id) {
        EntityManager em = JpaEntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(findByID(id));
        em.getTransaction().commit();

    }
}
