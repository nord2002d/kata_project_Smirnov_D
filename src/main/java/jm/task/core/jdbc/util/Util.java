package jm.task.core.jdbc.util;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util implements Closeable {
    private static Connection connection;

    private static String dbName = "kata_project";
    private static String dbUser = "root";
    private static String dbPass = "testtest";
    private static Logger LOGGER = Logger.getLogger(Util.class.getName());

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
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
            throw new RuntimeException(e);
        }
    }
}
