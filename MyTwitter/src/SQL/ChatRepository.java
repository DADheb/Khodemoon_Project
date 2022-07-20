package SQL;

import DataBase.DataBase;
import entity.Chat;

import java.sql.*;

public class ChatRepository {
    public void loadChats(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =
                statement
                        .executeQuery(
                                "SELECT * FROM chat ORDER BY id" );
        while (resultSet.next()){
            Chat chat = new Chat(DataBase.getUsers().get(resultSet.getInt("userA_id")),DataBase.getUsers().get(resultSet.getInt("userB_id")));
            DataBase.getChats().add(chat);
        }
    }
    public void insertChats(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM chat");
        preparedStatement.executeUpdate();
        for (Chat chat : DataBase.getChats()){
            PreparedStatement preparedStatementA = connection.prepareStatement(
                    "INSERT INTO chat(userA_id, userB_id)"+
                            "VALUES (?, ?)");
            preparedStatementA.setInt(1,DataBase.getUserID(chat.getA()));
            preparedStatementA.setInt(2,DataBase.getUserID(chat.getB()));

            preparedStatementA.executeUpdate();
        }
    }
}
