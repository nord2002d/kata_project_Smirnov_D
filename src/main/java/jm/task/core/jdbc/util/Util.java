package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util implements AutoCloseable {
    private static Connection connection;
    private static final String DB_NAME = "testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "testtest";
    private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME +
                        "?user=" + DB_USER + "&password=" + DB_PASS);
                LOGGER.log(Level.INFO, "Successful connection");
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "Unsuccessful connection");
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
