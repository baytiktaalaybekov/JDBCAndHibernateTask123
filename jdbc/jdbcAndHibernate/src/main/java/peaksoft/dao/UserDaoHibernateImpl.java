package peaksoft.dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory = Util.getSessionFactory();



    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("drop table user").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User( name, lastName, age);
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.save(user);
       session.getTransaction().commit();
       session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
       session.beginTransaction();
       User user = (User) session.get(User.class,id);
       session.delete(user);
       session.getTransaction().commit();
       session.close();

    }

    @Override
    public List<User> getAllUsers() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//      List<User>resultlist=session.createQuery("From User").getResultList();
//      session.getTransaction().commit();
//      session.close();
//      return resultlist;
        return null;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
