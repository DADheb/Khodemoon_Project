package SQL;

import java.sql.*;

public class DataInitializer {
    public void insertCities(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(*) from city");
        if (resultSet.next()) {
            int countAll = resultSet.getInt(1); //
            if (countAll == 0) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into city(name) values(?)");
                preparedStatement.setString(1, "قم");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "تهران");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "تبریز");
                preparedStatement.executeUpdate()
                ;preparedStatement.setString(1, "اصفهان");
                preparedStatement.executeUpdate();
                preparedStatement.setString(1, "گیلان");
                preparedStatement.executeUpdate();
                preparedStatement.setString(1, "کرمانشاه");
                preparedStatement.executeUpdate();
            }
        }
    }
}
