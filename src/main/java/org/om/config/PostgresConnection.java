package org.om.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

    public Connection connection() {

        String url = "jdbc:postgresql://database-1.cultd7iwyred.ap-south-1.rds.amazonaws.com:5432/postgres";
        String user = "postgres";
        String password = "postgres";

        Connection con=null;

        try {
            return con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
