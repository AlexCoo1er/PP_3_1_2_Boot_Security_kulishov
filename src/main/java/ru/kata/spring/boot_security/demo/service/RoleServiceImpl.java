package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role getRole(long id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public void removeRole(long id) {
        roleDao.removeRole(id);
    }

    @Override
    public void editRole(Role role) {
roleDao.editRole(role);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    @Override
    public List<Role> listByName(List<String> name) {
        return roleDao.listByName(name);
    }

    @Override
    public boolean addRole(Role role) {
        roleDao.addRole(role);
        return true;
    }
}
