package com.yaroslav.delivery.dao;

import com.yaroslav.delivery.db.ConnectionPool;
import com.yaroslav.delivery.model.UserModel;
import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDao {

    private static final Logger LOG = Logger.getLogger(UserDao.class.getName());

    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "select * from user where email=? and password = ?";
    private static final String SELECT_USER_BY_EMAIL_SQL = "select id,name,email,password,number from user where email =?";
    private static final String INSERT_USER_SQL = "INSERT INTO user (name, password , number , email) VALUES (?,?,?,?);";
    private static final String SELECT_USERS_SQL = "SELECT * FROM user limit ";
    private static final String UPDATE_USER_SQL = "update user set name = ?, password =? , number= ? ,email= ? where id = ?;";
    private static final String SELECT_USER_BY_ID = "select name,email,password,number from user where id =?";
    private static final String DELETE_USER_SQL = "delete from user where id = ?;";


    public void insertUser(UserModel user) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, getHash(user.getPassword()));
            preparedStatement.setString(3, user.getNumber());
            preparedStatement.setString(4, user.getMail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can not insert user" , e);
            throw new RuntimeException(e);
        }
    }

    public List<UserModel> selectUsers(int start, int total) {
        List<UserModel> users = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement ps = connection.createStatement()) {
            try (ResultSet rs = ps.executeQuery(SELECT_USERS_SQL + (start - 1) + "," + total)) {
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
        } catch (SQLException e) {
            LOG.error("Can not select users" , e);
            throw new RuntimeException(e);
        }
        return users;
    }

    public void updateUser(UserModel user) throws SQLException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, getHash(user.getPassword()));
            statement.setString(3, user.getNumber());
            statement.setString(4, user.getMail());
            statement.setInt(5, user.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            LOG.error("Can not update user" , e);
            throw new RuntimeException(e);
        }
    }

    public UserModel selectUser(int id) {
        UserModel user = new UserModel();
        try (Connection connection = ConnectionPool.getConnection();
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
            LOG.error("Can not select user" , e);
            throw new RuntimeException(e);
        }
        return user;
    }

    public void deleteUser(int id) throws SQLException {

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e){
            LOG.error("Can not selete user" , e);
            throw new RuntimeException(e);
        }
    }

    public UserModel selectUserByEmail(String email) {
        UserModel user = new UserModel();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_SQL)) {
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
            LOG.error("Can not select user by email" , e);
            throw new RuntimeException(e);
        }
        return user;
    }

    public int selectUserAuthenticate(String name, String password) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement st = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            st.setString(1, name);
            st.setString(2, getHash(password));
            ResultSet result = st.executeQuery();
            if (result.next()) {
                return result.getInt("id");
            }

        } catch (SQLException e) {
            LOG.error("Can not select user authenticate " , e);
            throw new RuntimeException(e);
        }
        return 0;
    }

    public String getHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteDate = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : byteDate) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception ex) {
            LOG.error("Can not get hash " , ex);
            throw new RuntimeException(ex);
        }
    }
}
