package ru.app.database.mysql;

import lombok.SneakyThrows;
import ru.app._infrastructure.annotations.InjectByType;
import ru.app.database.Extractor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQLExecutor {
    @InjectByType
    ConnectionManager connectionManager;

    @SneakyThrows
    public <T> List<T> executeQuery(String query, Extractor<T> extractor) {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return extractor.extract(resultSet);
    }

    @SneakyThrows
    public Integer executeUpdate(String query) {
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        var affectedRows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

        if (affectedRows == 0) {
            throw new SQLException("executeUpdate failed, no rows affected");
        }

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("executeUpdate failed, no id obtained");
        }
    }
}
