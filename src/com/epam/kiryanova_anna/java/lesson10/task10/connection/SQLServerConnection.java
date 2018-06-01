package com.epam.kiryanova_anna.java.lesson10.task10.connection;

import java.sql.SQLException;

public class SQLServerConnection extends Connection {
    public SQLServerConnection(java.sql.Connection connection) {
        super(connection);
    }

    @Override
    public void process() {
        System.out.println("Connection successful");
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }
}
