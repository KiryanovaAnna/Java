package com.epam.kiryanova_anna.java.lesson10.task10;

import com.epam.kiryanova_anna.java.lesson10.task10.connection.Connection;

import java.sql.SQLException;

public interface ConnectionFactory {
    Connection getConnection(String... args) throws SQLException;
}
