package SQL;

import DataBase.DataBase;
import entity.User;

import java.sql.*;

public class UserRepository {

    public void loadUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM user ORDER BY id" );
        while (resultSet.next()) {
            User user = new User();
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
            user.setBio(resultSet.getString("bio"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setBirthday(resultSet.getString("birthday"));
            user.setEmail(resultSet.getString("email"));
            user.setSecurityQuestionsAnswers(resultSet.getString("securityQuestionsAnswers"));
            if(resultSet.getInt("privacy")==0){
                user.setPrivacy(false);
            } else {
                user.setPrivacy(true);
            }
            user.setNumberOfPosts(resultSet.getInt("numberOfPosts"));
            user.setNumberOfFollowers(resultSet.getInt("numberOfFollowers"));
            user.setNumberOfFollowings(resultSet.getInt("numberOfFollowings"));
            if(resultSet.getInt("userType")==0){
                user.setUserType(false);
            } else {
                user.setUserType(true);
            }
            DataBase.getUsers().add(user);
        }

        statement.close();
    }

    public void insertUsers(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM user");
        preparedStatement.executeUpdate();
        for (User user : DataBase.getUsers()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO user(userName, password, bio, name, lastName, birthday, email,"+
                            " securityQuestionsAnswers, privacy, numberOfPosts, numberOfFollowers ,numberOfFollowings, userType ) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setString(1, user.getUserName());
            preparedStatementA.setString(2, user.getPassword());
            preparedStatementA.setString(3, user.getBio());
            preparedStatementA.setString(4, user.getName());
            preparedStatementA.setString(5, user.getLastName());
            preparedStatementA.setString(6, user.getBirthday());
            preparedStatementA.setString(7, user.getEmail());
            preparedStatementA.setString(8, user.getSecurityQuestionsAnswers());
            if(user.getPrivacy()) {
                preparedStatementA.setInt(9, 1);
            } else {
                preparedStatementA.setInt(9, 0);
            }
            preparedStatementA.setInt(10, user.getNumberOfPosts());
            preparedStatementA.setInt(11, user.getNumberOfFollowers());
            preparedStatementA.setInt(12, user.getNumberOfFollowings());
            if(user.getUserType()) {
                preparedStatementA.setInt(13, 1);
            } else {
                preparedStatementA.setInt(13, 0);
            }
            preparedStatementA.executeUpdate();
        }
    }
}
