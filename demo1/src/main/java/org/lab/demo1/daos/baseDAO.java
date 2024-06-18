package org.lab.demo1.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class baseDAO {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lab9", "root", "root");
    }
}
