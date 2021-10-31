package ru.app.database.mysql;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;

@Singleton
public class ConnectionManager {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/task_db";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "root";

    private Connection connection;

    @SneakyThrows
    public Connection getConnection() {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return connection;
    }

    @SneakyThrows
    public void closeConnection() {
        connection.close();
    }
}
