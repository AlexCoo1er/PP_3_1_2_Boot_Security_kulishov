package ru.kata.spring.boot_security.demo.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //специальный компонент, используется для ДАО
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {

    }

    @PersistenceContext
    private EntityManager entityManager; // создается автоматически

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();

    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void removeUser(long id) {
        entityManager.createQuery("delete from User user WHERE user.id =:id", User.class)
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select user from User user where user.userName =: username", User.class).getSingleResult();
    }
}
