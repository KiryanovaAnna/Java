package com.epam.kiryanova_anna.java.lesson10.task10;

import com.epam.kiryanova_anna.java.lesson10.task10.connection.Connection;
import com.epam.kiryanova_anna.java.lesson10.task10.connection.OracleConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectionFactory implements ConnectionFactory {
    @Override
    public Connection getConnection(String... args) throws SQLException {
        if (!args[0].contains("jdbc") || !args[0].contains("oracle"))
            throw new IllegalArgumentException("Wrong url");

        return new OracleConnection(DriverManager.getConnection(args[0], args[1], args[2]));
    }
}
