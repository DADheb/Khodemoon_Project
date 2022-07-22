import SQL.SQL;
import View.Show;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234N");

        SQL.getDatabaseInitializer().createTables(connection);
        SQL.loadAll(connection);

    }
}