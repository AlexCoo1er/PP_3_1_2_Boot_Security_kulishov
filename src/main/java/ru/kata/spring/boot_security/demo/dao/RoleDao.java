package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDao {

    Role getRole(long id);

    List<Role> getList();

    void removeRole(long id);

    void editRole(Role role);

    Role findByName(String name);

    List<Role> listByName (List<String> name);

    boolean addRole (Role role);

}
