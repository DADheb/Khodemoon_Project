package SQL;

import Controller.UserController;
import DataBase.DataBase;
import entity.*;

import java.sql.*;
import java.util.ArrayList;

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
        initFollowRequestTable(connection.createStatement());
        initViewerOfPostTable(connection.createStatement());
        initDataPDOfPostTable(connection.createStatement());
        initViewPDOfUserTable(connection.createStatement());
        initInterestTable(connection.createStatement());
        initBlockTable(connection.createStatement());
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
                        "date varchar(255), " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initPostTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "post(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "time varchar(255), " +
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
                        "project.group(id int NOT NULL AUTO_INCREMENT, " +
                        "name varchar(255), " +
                        "bio varchar(255), " +
                        "creatDate varchar(255), " +
                        "user_id int, " +
                        "type int, " +
                        "g_id int, " +
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
                        "time varchar(255), " +
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
                        "project.like(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "type int, " +
                        "mother_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initMessageTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "project.message(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "type int, " +
                        "mother_id int, " +
                        "text varchar(2000), " +
                        "time varchar(255), " +
                        "edited int, " +
                        "seen int, " +
                        "reply_id int DEFAULT '-1',  " +
                        "forward_id int DEFAULT '-1',  " +
                        "date varchar(255), " +
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
    private void initFollowRequestTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "followRequest(id int NOT NULL AUTO_INCREMENT, " +
                        "userA_id int, " +
                        "userB_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initViewerOfPostTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "viewerOfPost(id int NOT NULL AUTO_INCREMENT, " +
                        "p_id int, " +
                        "user_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }

    private void initDataPDOfPostTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "dataPDOfPost(id int NOT NULL AUTO_INCREMENT, " +
                        "date varchar(255), " +
                        "numberOfView int, " +
                        "numberOfLike int, " +
                        "p_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initViewPDOfUserTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "viewPDOfUser(id int NOT NULL AUTO_INCREMENT, " +
                        "date varchar(255), " +
                        "number int, " +
                        "u_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initInterestTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "interest(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "u_id int, " +
                        "interest int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
    private void initBlockTable(Statement statement) throws SQLException {
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS " +
                        "block(id int NOT NULL AUTO_INCREMENT, " +
                        "user_id int, " +
                        "u_id int, " +
                        "PRIMARY KEY (id))");
        statement.close();
    }
}
class UserRepository {

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
            user.setDate(resultSet.getString("date"));
            DataBase.getUsers().add(user);
            if(user.isUserType()){
                DataBase.getBusinessUsers().add(user);
            }
            DataBase.getUserNames().add(user.getUserName());
            DataBase.getUserPasswords().add(user.getPassword());
        }
        statement.close();
    }

    public void insertUsers(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM user");
        preparedStatement.executeUpdate();
        for (User user : DataBase.getUsers()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO user(id,userName, password, bio, name, lastName, birthday, email,"+
                            " securityQuestionsAnswers, privacy, numberOfPosts, numberOfFollowers ,numberOfFollowings, userType,date ) " +
                            "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatementA.setInt(1,DataBase.getUserID(user)+1);
            preparedStatementA.setString(2, user.getUserName());
            preparedStatementA.setString(3, user.getPassword());
            preparedStatementA.setString(4, user.getBio());
            preparedStatementA.setString(5, user.getName());
            preparedStatementA.setString(6, user.getLastName());
            preparedStatementA.setString(7, user.getBirthday());
            preparedStatementA.setString(8, user.getEmail());
            preparedStatementA.setString(9, user.getSecurityQuestionsAnswers());
            if(user.getPrivacy()) {
                preparedStatementA.setInt(10, 1);
            } else {
                preparedStatementA.setInt(10, 0);
            }
            preparedStatementA.setInt(11, user.getNumberOfPosts());
            preparedStatementA.setInt(12, user.getNumberOfFollowers());
            preparedStatementA.setInt(13, user.getNumberOfFollowings());
            if(user.getUserType()) {
                preparedStatementA.setInt(14, 1);
            } else {
                preparedStatementA.setInt(14, 0);
            }
            preparedStatementA.setString(15,user.getDate());
            preparedStatementA.executeUpdate();
        }
    }
}

class PostRepository {
    public void loadPosts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM post ORDER BY id" );
        while (resultSet.next()){
            Post post = new Post();
            post.setUser(DataBase.getUsers().get(resultSet.getInt("id")-1));
            post.setText(resultSet.getString("text"));
            post.setDate(resultSet.getString("date"));
            post.setTime(Long.parseLong(resultSet.getString("time")));
            post.setNumberOfView(resultSet.getInt("numberOfView"));
            post.setNumberOfLikes(resultSet.getInt("numberOfLikes"));
            DataBase.getPosts().add(post);
            //Complete... -------------
            post.getUser().getPosts().add(post);
        }
        statement.close();
    }

    public void insertPost(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM post");
        preparedStatement.executeUpdate();

        for (Post post : DataBase.getPosts()){
            PreparedStatement preparedStatementA = connection.prepareStatement( "INSERT INTO post(id,user_id, time, edited, "+
                    "numberOfView,numberOfLikes, text, date)"+
                    "VALUES (?,?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setInt(1,DataBase.getPosts().indexOf(post)+1);
            preparedStatementA.setInt(2, DataBase.getUserID(post.getUser())+1);
            preparedStatementA.setString(3, Long.toString(post.getTime()));
            if(post.getEdited()){
                preparedStatementA.setInt(4, 1);
            } else {
                preparedStatementA.setInt(4, 0);
            }
            preparedStatementA.setInt(5, post.getNumberOfView());
            preparedStatementA.setInt(6, post.getNumberOfLikes());
            preparedStatementA.setString(7, post.getText());
            preparedStatementA.setString(8, post.getDate());

            preparedStatementA.executeUpdate();
        }
    }
}

class ChatRepository {
    public void loadChats(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM chat ORDER BY id" );
        while (resultSet.next()){
            Chat chat = new Chat(DataBase.getUsers().get(resultSet.getInt("userA_id")-1),DataBase.getUsers().get(resultSet.getInt("userB_id")-1));
            DataBase.getChats().add(chat);
            for (User u : chat.getUsers()) {
                u.getChats().add(chat);
            }
        }
        statement.close();
    }
    public void insertChats(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM chat");
        preparedStatement.executeUpdate();
        for (Chat chat : DataBase.getChats()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO chat(id,userA_id, userB_id)"+
                            "VALUES (?,?, ?)");

            preparedStatementA.setInt(1,DataBase.getChats().indexOf(chat)+1);
            boolean frist = true;
            for (User u : chat.getUsers()){
                if(frist){
                    preparedStatementA.setInt(2,DataBase.getUserID(u)+1);
                    frist=false;
                } else {
                    preparedStatementA.setInt(3,DataBase.getUserID(u)+1);
                }
            }

            preparedStatementA.executeUpdate();
        }
    }
}

class GroupRepository {
    public void loadGroup(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM project.group ORDER BY g_id" );
        Group group = new Group();
        while (resultSet.next()){
            if(resultSet.getInt("g_id")==DataBase.getGroups().size()+1) {
                group = new Group();
                group.setName(resultSet.getString("name"));
                group.setBio(resultSet.getString("bio"));
                group.setCreatDate(resultSet.getString("creeatDate"));
                User u = DataBase.getUsers().get(resultSet.getInt("user_id")-1);
                group.getMembers().add(u);
                switch (resultSet.getInt("type")){
                    case 1: group.setCreator(u);
                        group.getAdmins().add(u);
                        break;
                    case 2: group.getAdmins().add(u);
                        break;
                    case 3: group.getBans().add(u);
                        break;
                }
                DataBase.getGroups().add(group);
                continue;
            }
            User a = DataBase.getUsers().get(resultSet.getInt("user_id")-1);
            group.getMembers().add(a);
            switch (resultSet.getInt("type")){
                case 1: group.setCreator(a);
                    group.getAdmins().add(a);
                    break;
                case 2: group.getAdmins().add(a);
                    break;
                case 3: group.getBans().add(a);
                    break;
            }
        }
        statement.close();
        for (Group g : DataBase.getGroups()){
            for (User u : g.getMembers()){
                u.getGroups().add(g);
            }
        }
    }
    public void insertGroup(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM project.group");
        preparedStatement.executeUpdate();
        for (Group group : DataBase.getGroups()){
            for (User u : group.getMembers()){
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO project.group(name, bio, creeatDate, user_id, type, g_id)"+
                                "VALUES(?, ?, ?, ?, ?, ?)");
                preparedStatementA.setString(1,group.getName());
                preparedStatementA.setString(2,group.getBio());
                preparedStatementA.setString(3,group.getCreatDate());
                preparedStatementA.setInt(4,DataBase.getUserID(u)+1);
                int t;
                if(u.equals(group.getCreator())){
                    t=1;
                } else if(group.getAdmins().contains(u)){
                    t=2;
                } else if(group.getBans().contains(u)){
                    t=3;
                } else {
                    t=0;
                }
                preparedStatementA.setInt(5,t);
                preparedStatementA.setInt(6,DataBase.getGroups().indexOf(group)+1);
                preparedStatementA.executeUpdate();

            }
        }
    }
}

class CommentRepository {
    public void loadComment(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM comment ORDER BY mother_id");
        while (resultSet.next()){
            Comment comment = new Comment();
            comment.setUser(DataBase.getUsers().get(resultSet.getInt("user_id")-1));
            if(resultSet.getInt("type")==1){
                comment.setType(false);
                comment.setComment(DataBase.getComments().get(resultSet.getInt("mother_id")-1));
            } else {
                comment.setType(true);
                comment.setPost(DataBase.getPosts().get(resultSet.getInt("mother_id")-1));
            }
            comment.setTime(Long.parseLong(resultSet.getString("time")));
            if(resultSet.getInt("edited")==1){
                comment.setEdited(true);
            } else {
                comment.setEdited(false);
            }
            comment.setNumberOfLikes(resultSet.getInt("numberOfLikes"));
            comment.setNumberOfView(resultSet.getInt("numberOfView"));
            comment.setText(resultSet.getString("text"));
            comment.setDate(resultSet.getString("date"));
            DataBase.getComments().add(comment);
            if(comment.isType()){
                comment.getPost().getComments().add(comment);
            } else {
                comment.getComment().getComments().add(comment);
            }
        }
        statement.close();
    }
    public void insertComment(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM comment");
        preparedStatement.executeUpdate();
        for (Comment comment : DataBase.getComments()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO comment(user_id, type, mother_id, time, edited, numberOfView, numberOfLikes, text, date)"+
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatementA.setInt(1,DataBase.getUserID(comment.getUser())+1);
            if(comment.isType()){
                preparedStatementA.setInt(2,0);
                preparedStatementA.setInt(3,DataBase.getPosts().indexOf(comment.getPost())+1);
            } else {
                preparedStatementA.setInt(2,1);
                preparedStatementA.setInt(3,DataBase.getComments().indexOf(comment.getComment())+1);
            }
            preparedStatementA.setString(4,Long.toString(comment.getTime()));
            if(comment.isEdited()){
                preparedStatementA.setInt(5,1);
            } else {
                preparedStatementA.setInt(5,0);
            }
            preparedStatementA.setInt(6,comment.getNumberOfView());
            preparedStatementA.setInt(7,comment.getNumberOfLikes());
            preparedStatementA.setString(8,comment.getText());
            preparedStatementA.setString(9,comment.getDate());
            preparedStatementA.executeUpdate();
        }
    }
}

class LikeRepository {
    public void loadLike(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM project.like ORDER BY id");
        while (resultSet.next()){
            Like like = new Like();
            like.setUser(DataBase.getUsers().get(resultSet.getInt("user_id")-1));
            if(resultSet.getInt("type")==1){
                like.setType(false);
                like.setComment(DataBase.getComments().get(resultSet.getInt("mother_id")-1));
            } else {
                like.setType(true);
                like.setPost(DataBase.getPosts().get(resultSet.getInt("mother_id")-1));
            }
            DataBase.getLikes().add(like);
            if(like.isType()){
                like.getPost().getLikes().add(like);
                like.getPost().getUserLikes().add(like.getUser());
            } else {
                like.getComment().getLikes().add(like);
                like.getComment().getUserLikes().add(like.getUser());
            }
        }
        statement.close();
    }
    public void insertLike(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM project.like");
        preparedStatement.executeUpdate();
        for (Like like : DataBase.getLikes()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO project.like(user_id, type, mother_id)"+
                            "VALUES(?, ?, ?)");
            preparedStatementA.setInt(1,DataBase.getUserID(like.getUser())+1);
            if(like.isType()){
                preparedStatementA.setInt(2,0);
                preparedStatementA.setInt(3,DataBase.getPosts().indexOf(like.getPost())+1);
            } else {
                preparedStatementA.setInt(2,1);
                preparedStatementA.setInt(3 , DataBase.getComments().indexOf(like.getComment())+1);
            }
            preparedStatementA.executeUpdate();
        }
    }
}

class MessageRepository {
    public void loadMessage(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM message ORDER BY id");
        while (resultSet.next()){
            Message message = new Message();
            message.setUser(DataBase.getUsers().get(resultSet.getInt("user_id")-1));
            if(resultSet.getInt("type")==1){
                message.setType(false);
                message.setChat(DataBase.getChats().get(resultSet.getInt("mother_id")-1));
            } else {
                message.setType(true);
                message.setGroup(DataBase.getGroups().get(resultSet.getInt("mother_id")-1));
            }
            message.setText(resultSet.getString("text"));
            message.setTime(Long.parseLong(resultSet.getString("time")));
            if(resultSet.getInt("edited")==1){
                message.setEdited(true);
            } else {
                message.setEdited(false);
            }
            if(resultSet.getInt("seen")==1){
                message.setSeen(true);
            } else {
                message.setSeen(false);
            }
            int n = resultSet.getInt("reply_id");
            if(n==-1){
                message.setReply(false);
            } else {
                message.setReply(true);
                message.setMessage(DataBase.getMessages().get(n-1));
            }
            n = resultSet.getInt("forward_id");
            if(n==-1){
                message.setForwarded(false);
            } else {
                message.setForwarded(true);
                message.setForwarder(DataBase.getUsers().get(n-1));
            }
            message.setDate(resultSet.getString("date"));
            DataBase.getMessages().add(message);
            if(message.isType()){
                message.getGroup().getMessages().add(message);
            } else {
                message.getChat().getMessages().add(message);
            }
            if(message.isReply()){
                message.getMessage().getReplyOn().add(message);
            }
        }
        statement.close();
    }
    public void insertMessage(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM message");
        preparedStatement.executeUpdate();
        for (Message message : DataBase.getMessages()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO message(user_id, type, mother_id, text, time,  edited, seen, reply_id, forward_id, date)"+
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatementA.setInt(1,DataBase.getUserID(message.getUser())+1);
            if(message.isType()){
                preparedStatementA.setInt(2,0);
                preparedStatementA.setInt(3,DataBase.getGroups().indexOf(message.getGroup())+1);
            } else {
                preparedStatementA.setInt(2,1);
                preparedStatementA.setInt(3,DataBase.getChats().indexOf(message.getChat())+1);
            }
            preparedStatementA.setString(4,message.getText());
            preparedStatementA.setString(5,Long.toString(message.getTime()));
            if(message.isEdited()){
                preparedStatementA.setInt(6,1);
            } else {
                preparedStatementA.setInt(6,0);
            }
            if(message.isSeen()){
                preparedStatementA.setInt(7,1);
            } else {
                preparedStatementA.setInt(7,0);
            }
            if(message.isReply()){
                preparedStatementA.setInt(8,DataBase.getMessages().indexOf(message.getMessage())+1);
            } else {
                preparedStatementA.setInt(8,-1);
            }
            if(message.isForwarded()){
                preparedStatementA.setInt(9,DataBase.getUserID(message.getUser())+1);
            } else {
                preparedStatementA.setInt(9,-1);
            }
            preparedStatementA.setString(10 , message.getDate());
            preparedStatementA.executeUpdate();
        }
    }
}

class FollowersRepository {
    public void loadFollowers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM followers ORDER BY id");
        while (resultSet.next()) {
            User a = DataBase.getUsers().get(resultSet.getInt("userA_id")-1);
            User b = DataBase.getUsers().get(resultSet.getInt("userB_id")-1);
            a.getFollowings().add(b);
            b.getFollowers().add(a);
        }
        statement.close();
    }
    public void insertFollowers(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM followers");
        preparedStatement.executeUpdate();
        for (User b : DataBase.getUsers()){
            for (User a : b.getFollowers()){
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO followers(userA_id, userB_id)"+
                                "VALUES(?, ?)");
                preparedStatementA.setInt(1 , DataBase.getUserID(a)+1);
                preparedStatementA.setInt(2 , DataBase.getUserID(b)+1);
                preparedStatementA.executeUpdate();
            }
        }
    }
}

class FollowRequestRepository {
    public void loadFollowRequest(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM followRequest ORDER BY id");
        while (resultSet.next()){
            User a = DataBase.getUsers().get(resultSet.getInt("userA_id")-1);
            User b = DataBase.getUsers().get(resultSet.getInt("userB_id")-1);
            a.getRequests().add(b);
            b.getFollowRequests().add(a);
        }
        statement.close();
    }
    public void insertFollowRequest(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM followRequest");
        preparedStatement.executeUpdate();
        for (User a : DataBase.getUsers()){
            for (User b : a.getRequests()){
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO followRequest(userA_id, userB_id)"+
                                "VALUES(?, ?)");
                preparedStatementA.setInt(1 , DataBase.getUserID(a)+1);
                preparedStatementA.setInt(2 , DataBase.getUserID(b)+1);
                preparedStatementA.executeUpdate();
            }
        }
    }
}

class ViewerOfPostRepository {
    public void loadViewerOfPost(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM viewerOfPost ORDER BY id");
        while (resultSet.next()){
            Post p = DataBase.getPosts().get(resultSet.getInt("p_id")-1);
            User u = DataBase.getUsers().get(resultSet.getInt("user_id")-1);
            p.getViewers().add(u);
        }
        statement.close();
    }
    public void insertViewerOfPost(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM viewerOfPost");
        preparedStatement.executeUpdate();
        for (Post p : DataBase.getPosts()) {
            for (User u : p.getViewers()) {
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO viewerOfPost(p_id, user_id)" +
                                "VALUES(?, ?)");
                preparedStatementA.setInt(1, DataBase.getPosts().indexOf(p) + 1);
                preparedStatementA.setInt(2, DataBase.getUserID(u) + 1);
                preparedStatementA.executeUpdate();
            }
        }
    }
}

class DataPDOfPostRepository {
    public void loadDataPDOfPost(Connection connection) throws SQLException {
        for (Post p : DataBase.getPosts()) {
            int n = DataBase.getPosts().indexOf(p);
            n++;
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement
                            .executeQuery(
                                    "SELECT * FROM dataPDOfPost WHERE p_id='"+n+"' ORDER BY id");
            while (resultSet.next()) {
                p.getViewPD().put(resultSet.getString("date") , resultSet.getInt("numberOfView"));
                p.getLikePD().put(resultSet.getString("date") , resultSet.getInt("numberOfLike"));
            }
            statement.close();
        }
    }
    public void insertDataPDOfPost(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM dataPDOfPost");
        preparedStatement.executeUpdate();
        for (Post p : DataBase.getPosts()){
            for (String s : p.getLikePD().keySet()){
                int n = p.getLikePD().get(s);
                if(p.getViewPD().containsKey(s)){
                    int m = p.getViewPD().get(s);
                    PreparedStatement preparedStatementA = connection.prepareStatement(
                            "INSERT INTO dataPDOfPost(date, numberOfView, numberOfLike , p_id)" +
                                    "VALUES(?, ?, ?, ?)");
                    preparedStatementA.setString(1,s);
                    preparedStatementA.setInt(2,m);
                    preparedStatementA.setInt(3,n);
                    preparedStatementA.setInt(4,DataBase.getPosts().indexOf(p)+1);
                    preparedStatementA.executeUpdate();
                } else {
                    PreparedStatement preparedStatementA = connection.prepareStatement(
                            "INSERT INTO dataPDOfPost(date, numberOfView, numberOfLike , p_id)" +
                                    "VALUES(?, ?, ?, ?)");
                    preparedStatementA.setString(1,s);
                    preparedStatementA.setInt(2,0);
                    preparedStatementA.setInt(3,n);
                    preparedStatementA.setInt(4,DataBase.getPosts().indexOf(p)+1);
                    preparedStatementA.executeUpdate();
                }
            }
            for (String s : p.getViewPD().keySet()){
                if(!p.getLikePD().containsKey(s)){
                    int m = p.getViewPD().get(s);
                    PreparedStatement preparedStatementA = connection.prepareStatement(
                            "INSERT INTO dataPDOfPost(date, numberOfView, numberOfLike , p_id)" +
                                    "VALUES(?, ?, ?, ?)");
                    preparedStatementA.setString(1,s);
                    preparedStatementA.setInt(2,m);
                    preparedStatementA.setInt(3,0);
                    preparedStatementA.setInt(4,DataBase.getPosts().indexOf(p)+1);
                    preparedStatementA.executeUpdate();
                }
            }
        }
    }
}

class ViewPDOfUserRepository {
    public void loadViewPDOfUser(Connection connection) throws SQLException {
        for (User u : DataBase.getUsers()) {
            int n = DataBase.getUserID(u);
            n++;
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement
                            .executeQuery(
                                    "SELECT * FROM viewPDOfUser WHERE u_id='"+n+"' ORDER BY id");
            while (resultSet.next()) {
                u.getViewPD().put(resultSet.getString("date") , resultSet.getInt("number"));
            }
            statement.close();
        }
    }
    public void insertViewPDOfUser(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM viewPDOfUser");
        preparedStatement.executeUpdate();
        for (User u : DataBase.getUsers()){
            for (String s : u.getViewPD().keySet()){
                int n = u.getViewPD().get(s);
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO viewPDOfUser(date, number, u_id)" +
                                "VALUES(?, ?, ?)");
                preparedStatementA.setString(1,s);
                preparedStatementA.setInt(2,n);
                preparedStatementA.setInt(3,DataBase.getUserID(u)+1);
                preparedStatementA.executeUpdate();

            }
        }
    }
}

class InterestRepository {
    public void loadInterest(Connection connection) throws SQLException {
        for (User u : DataBase.getUsers()) {
            int n = DataBase.getUserID(u);
            n++;
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement
                            .executeQuery(
                                    "SELECT * FROM interest WHERE user_id='"+n+"' ORDER BY id");
            while (resultSet.next()) {
                User a = DataBase.getUsers().get(resultSet.getInt("u_id")-1);
                u.getInterest().put(a,resultSet.getInt("interest"));
                if(a.isUserType()){
                    u.getInterestAD().put(a,resultSet.getInt("interest"));
                }
            }
            statement.close();
        }
    }
    public void insertViewPDOfUser(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM interest");
        preparedStatement.executeUpdate();
        for (User u : DataBase.getUsers()){
            for (User a : u.getInterest().keySet()){
                int n = u.getInterest().get(a);
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO interest(user_id, u_id, interest)" +
                                "VALUES(?, ?, ?)");
                preparedStatementA.setInt(1,DataBase.getUserID(u)+1);
                preparedStatementA.setInt(2,DataBase.getUserID(a)+1);
                preparedStatementA.setInt(3,n);
                preparedStatementA.executeUpdate();
            }
        }
    }
}

class BlockRepository {
    public void loadBlock(Connection connection) throws SQLException {
        for (User u : DataBase.getUsers()) {
            int n = DataBase.getUserID(u);
            n++;
            Statement statement = connection.createStatement();
            ResultSet resultSet =
                    statement
                            .executeQuery(
                                    "SELECT * FROM block WHERE user_id='"+n+"' ORDER BY id");
            while (resultSet.next()) {
                u.getBlock().add(DataBase.getUsers().get(resultSet.getInt("u_id")-1));
            }
            statement.close();
        }
    }
    public void insertBlock(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM block");
        preparedStatement.executeUpdate();
        for (User u : DataBase.getUsers()){
            for (User a : u.getBlock()){
                PreparedStatement preparedStatementA = connection.prepareStatement(
                        "INSERT INTO block(user_id, u_id)" +
                                "VALUES(?, ?)");
                preparedStatementA.setInt(1,DataBase.getUserID(u)+1);
                preparedStatementA.setInt(2,DataBase.getUserID(a)+1);
                preparedStatementA.executeUpdate();
            }
        }
    }
}

class Search{
    public ArrayList<User> searchUser(String name, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM user WHERE userName LIKE '%"+name+"%'" );
        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next()){
            User user = UserController.getUser(resultSet.getString("userName"));
            users.add(user);
        }
        statement.close();
        return users;
    }
    public ArrayList<Message> searchMessage(Chat chat,String subText,Connection connection) throws SQLException {
        int chatId = DataBase.getChats().indexOf(chat)+1;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM message WHERE type='1' AND mother_id='"+chatId+"' AND text LIKE '%"+subText+"%'" );
        ArrayList<Message> messages = new ArrayList<>();
        while (resultSet.next()){
            Message message =DataBase.getMessages().get(resultSet.getInt("id")-1);
            messages.add(message);
        }
        statement.close();
        return messages;
    }
    public ArrayList<Message> searchMessage(Group group,String subText,Connection connection) throws SQLException {
        int groupId = DataBase.getGroups().indexOf(group)+1;
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM message WHERE type='0' AND mother_id='"+groupId+"' AND text LIKE '%"+subText+"%'" );
        ArrayList<Message> messages = new ArrayList<>();
        while (resultSet.next()){
            Message message =DataBase.getMessages().get(resultSet.getInt("id")-1);
            messages.add(message);
        }
        statement.close();
        return messages;
    }
}