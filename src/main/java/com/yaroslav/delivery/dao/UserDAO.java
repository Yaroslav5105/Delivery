package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.DBManager;
import com.yaroslav.delivery.db.entity.User;

import com.yaroslav.delivery.model.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO {

    private static final String AUTHENTICATE = "select * from user where email=? and password = ?";
    private static final String SELECT_USER_BY_EMAIL = "select id,name,email,password,number from user where email =?";
    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (name, password , number , email) VALUES " + " (?,?,?,?);";
    private static final String FIND_ALL_USERS = "SELECT * FROM user";
    private static final String UPDATE_USERS_SQL = "update user set name = ?, password =? , number= ? ,email= ? where id = ?;";
    private static final String SELECT_USER_BY_ID = "select id,name,email,password,number from user where id =?";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
    private static final Connection connection;

    static {
        new DBManager();
        connection = DBManager.connection;
    }

    public void insertUser(User user) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getNumber());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<UserModel> findAllUsers() {
        List<UserModel> users = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(FIND_ALL_USERS)) {
                while (rs.next()) {
                    UserModel user = new UserModel();
                    users.add(user);
                    user.setId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setNumber(rs.getString(4));
                    user.setMail(rs.getString(5));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return users;
    }

    public void  updateUser(UserModel user) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNumber());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getId());

            statement.executeUpdate();
        }
    }
    public UserModel selectUser(int id) {
        UserModel user = new UserModel();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("name");
                String password = rs.getString("password");
                String number = rs.getString("number");
                String email = rs.getString("email");

                user = new UserModel(id, login, password, number, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void deleteUser(int id) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public UserModel selectUserByEmail(String email) {
        UserModel user = new UserModel();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("name");
                String password = rs.getString("password");
                String number = rs.getString("number");
                int id = rs.getInt("id");

                user = new UserModel(id, login, password, number, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int authenticate(String name, String password) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(AUTHENTICATE)) {
            st.setString(1, name);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            if (result.next()) {
                do {
                    return result.getInt("id");

                } while (result.next());
            }
        } catch (SQLException e) {
            System.out.println("Error :" + e.getMessage());
        }
        return 0;
    }
}
