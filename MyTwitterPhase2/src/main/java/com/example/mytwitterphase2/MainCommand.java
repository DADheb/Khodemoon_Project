package com.example.mytwitterphase2;

import com.example.mytwitterphase2.DataBase.DataBase;
import com.example.mytwitterphase2.SQL.SQL;
import com.example.mytwitterphase2.ViewCommand.Menu.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainCommand {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
        DataBase.setConnection(connection);
        SQL.getDatabaseInitializer().createTables(connection);
        SQL.loadAll(connection);
        Login.showMain();
    }

}