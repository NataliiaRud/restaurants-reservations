package ua.study.restaurant.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Database initialization utility
 * PATH_TO_RESOURCES should be pointed to resources folder
 */

public class InitializeDatabase {
    private static final String PATH_TO_RESOURCES = "";

    public static Properties loadProperties() {
        try (InputStream input = new FileInputStream(PATH_TO_RESOURCES + "application.properties")) {
            if (input == null) {
                System.out.println("Cannot load config.properties");
                return null;
            }

            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ex) {
            System.out.println("Error occurred while loading config.properties");
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties properties = loadProperties();

        Class.forName(properties.getProperty("db.driver"));

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));

            statement = connection.createStatement();

            String schema;
            try (InputStream inputStream = new FileInputStream(PATH_TO_RESOURCES + "schema.sql")) {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                for (int length; (length = inputStream.read(buffer)) != -1; ) {
                    result.write(buffer, 0, length);
                }
                schema = result.toString("UTF-8");
            }

            String data;
            try (InputStream inputStream = new FileInputStream(PATH_TO_RESOURCES + "data.sql")) {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                for (int length; (length = inputStream.read(buffer)) != -1; ) {
                    result.write(buffer, 0, length);
                }
                data = result.toString("UTF-8");
            }

            String sql = schema + "\r\n" + data;
            statement.execute(sql);
        } catch (SQLException | IOException e) {
            System.out.println("Error occurred while initializing H2 database");
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

    }
}

