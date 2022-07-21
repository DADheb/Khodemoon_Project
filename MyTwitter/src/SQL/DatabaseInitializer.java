package SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    public void createTables(Connection connection) throws SQLException {
        initUserTable(connection.createStatement());
        initPostTable(connection.createStatement());
        initChatTable(connection.createStatement());
        initGroupTable(connection.createStatement());
        initCommentTable(connection.createStatement());
        initLikeTable(connection.createStatement());
        initMessageTable(connection.createStatement());
        initFollowerTable(connection.createStatement());
        initFollowingTable(connection.createStatement());
        initFollowRequestTable(connection.createStatement());
        initRequestTable(connection.createStatement());
    }

    private void initUserTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "user(id int NOT NULL AUTO_INCREMENT, " +
                        "userName varchar(255), " +
                        "password varchar(255), " +
                        "bio varchar(255), " +
                        "name varchar(255), " +
                        "lastName varchar(255), " +
                        "birthday varchar(255), " +
                        "email varchar(255), " +
                        "securityQuestionsAnswers varchar(255), " +
                        "privacy int, " +
                        "numberOfPosts int, " +
                        "numberOfFollowers int, " +
                        "numberOfFollowings int, " +
                        "userType int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initPostTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "post(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "time int, " +
                        "edited int, " +
                        "numberOfView int, " +
                        "numberOfLikes int, " +
                        "text varchar(2000), " +
                        "date varchar(255), " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initChatTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "chat(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initGroupTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "group(id int NOT NULL AUTO_INCREMENT, " +
                        "name varchar(255), " +
                        "bio varchar(255), " +
                        "creatDate varchar(255), " +
                        "user_id int, " +
                        "type int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initCommentTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "comment(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "type int, " +
                        "mother_id int, " +
                        "time int, " +
                        "edited int, " +
                        "numberOfView int, " +
                        "numberOfLikes int, " +
                        "text varchar(2000), " +
                        "date varchar(255), " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initLikeTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "like(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "type int, " +
                        "mother_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }private void initMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "message(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "type int, " +
                        "mother_id int, " +
                        "text varchar(2000), " +
                        "time int, " +
                        "edited int, " +
                        "seen int, " +
                        "reply_id int, DEFAULT '-1'  " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initFollowerTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "followers(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initFollowingTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "following(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initFollowRequestTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "followRequest(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initRequestTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "request(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }

}
