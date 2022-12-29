package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getList();

    void removeRole(long id);

    void editRole(Role role);

    Role findByName(String name);

    List<Role> listByName (List<String> name);

    boolean addRole (Role role);

}
