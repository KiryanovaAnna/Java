package com.epam.kiryanova_anna.java.lesson10.task10.connection;

import java.sql.SQLException;

public abstract class Connection {
    protected java.sql.Connection connection;

    public Connection(java.sql.Connection connection) {
        this.connection = connection;
    }

    public abstract void process();
    public abstract void close() throws SQLException;
}
