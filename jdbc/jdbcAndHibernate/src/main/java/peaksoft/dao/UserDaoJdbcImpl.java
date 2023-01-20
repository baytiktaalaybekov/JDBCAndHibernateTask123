package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDaoJdbcImpl implements UserDao {
    private Connection connection;

    public UserDaoJdbcImpl() {
        this.connection = Util.getConnection();
    }

    public void createUsersTable() {
        String query = """
                create table if not exists users(
                id serial primary key,
                name varchar,
                last_name varchar,
                age smallint not null
                )""";

        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Successfully created!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void dropUsersTable() {
        String query = """
                Drop  table users;
                """;
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully drop !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String query = """
                    INSERT INTO users (name, last_name, age)
                    VALUES (?,?,?)
                    """ ;
        try(PreparedStatement preparedStatement= connection.prepareStatement(query)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println("Users " + name + " Successfully saved !!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void removeUserById(long id) {
        String query = """
                delete from users where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            System.out.println("Successfully removed User!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public List<User> getAllUsers() {
            List<User> users = new ArrayList<>();
            String query = """
                Select * from users;
                """;
            try(PreparedStatement statement = connection.prepareStatement(query)){
                ResultSet resultSet= statement.executeQuery();
                while (resultSet.next()){
                    users.add(new User(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("last_name"),
                            resultSet.getByte("age")));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return users;
    }

    @Override
    public void cleanUsersTable() {
        String query = """
                truncate users;
                """;
        try {
            Connection connection = Util.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println(" Successfully cleaned!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    }