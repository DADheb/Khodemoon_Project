package SQL;

import DataBase.DataBase;
import entity.Post;

import java.sql.*;

public class PostRepository {
    public void loadPosts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM post ORDER BY id" );
        while (resultSet.next()){
            Post post = new Post();
            post.setUser(DataBase.getUsers().get(resultSet.getInt("id")));
            post.setText(resultSet.getString("text"));
            post.setDate(resultSet.getString("date"));
            post.setTime(resultSet.getInt("time"));
            post.setNumberOfView(resultSet.getInt("numberOfView"));
            post.setNumberOfLikes(resultSet.getInt("numberOfLikes"));
            DataBase.getPosts().add(post);
        }
    }

    public void insertPost(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM post");
        preparedStatement.executeUpdate();

        for (Post post : DataBase.getPosts()){
            PreparedStatement preparedStatementA = connection.prepareStatement( "INSERT INTO post(user_id, time, edited, "+
                    "numberOfView,numberOfLikes, text, date)"+
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

            preparedStatementA.setInt(1, DataBase.getUserID(post.getUser()));
            preparedStatementA.setInt(2, post.getTime());
            if(post.getEdited()){
                preparedStatementA.setInt(3, 1);
            } else {
                preparedStatementA.setInt(3, 0);
            }
            preparedStatementA.setInt(4, post.getNumberOfView());
            preparedStatementA.setInt(5, post.getNumberOfLikes());
            preparedStatementA.setString(6, post.getText());
            preparedStatementA.setString(7, post.getDate());

            preparedStatementA.executeUpdate();
        }
    }
}
