package peaksoft.service;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
   private UserDaoHibernateImpl userDaoHibernate;
    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        userDaoHibernate.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name,lastName,age);

    }

    @Override
    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);

    }

    @Override
    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();

    }
}
