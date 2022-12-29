package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getList() {
        return entityManager.createQuery("select  role from Role role", Role.class).getResultList();
    }

    @Override
    public void removeRole(long id) {
        entityManager.createQuery("delete  from Role role where role.id =: id", Role.class)
                .setParameter("id", id).executeUpdate();

    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role findByName(String name) {
        return entityManager.createQuery("select role from Role role where role.role in (:id)", Role.class)
                .setParameter("id", name ).getResultList().stream().findAny().orElse(null);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return entityManager.createQuery("select role from Role role where role.role in (:id)", Role.class)
                .getResultList();
    }

    @Override
    public boolean addRole(Role role) {
        entityManager.persist(role);
        return true;
    }
}
