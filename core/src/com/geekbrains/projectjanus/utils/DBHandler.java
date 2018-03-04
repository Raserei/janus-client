package com.geekbrains.projectjanus.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Raserei on 27.02.2018.
 */

public class DBHandler {

    private Connection connection;
    private static final String connectionURL = "jdbc:sqlite:dbref.db";

    public Connection getConnection() {
        return connection;
    }

    public DBHandler() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        try {
            DriverManager.registerDriver((Driver) Class.forName("org.sqlite.JDBC").newInstance());
            //System.out.println("URL: " + connectionURL + "\n");

            connection = DriverManager.getConnection(connectionURL);
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            try {
                connection.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                throw e;
            }
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
