package com.epam.kiryanova_anna.java.lesson10.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static void cloneRecordsTenTimes(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM SCOTT.EMP");

        List<Object[]> toClone = new ArrayList<>();

        int pk = 0;
        while (rs.next()) {
            Object[] row = new Object[7];

            row[0] = rs.getString("ename");
            row[1] = rs.getString("job");
            row[2] = rs.getInt("mgr");
            row[3] = rs.getDate("hiredate");
            row[4] = rs.getInt("sal");
            row[5] = rs.getInt("comm");
            row[6] = rs.getInt("deptno");

            toClone.add(row);
            pk = Math.max(pk, rs.getInt("empno"));
        }

        for (Object[] row : toClone)
            for (int i = 0; i < 10; i++) {
                statement.executeUpdate(
                        "INSERT INTO SCOTT.EMP " +
                                "(`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) " +
                                "VALUES (" +
                                ++pk + "," +
                                row[0] + ", " +
                                row[1] + ", " +
                                row[2] + ", " +
                                row[3] + ", " +
                                row[4] + ", " +
                                row[5] + ", " +
                                row[6] + ")"
                );
            }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter connection url: ");
        String url = br.readLine();

        System.out.print("Enter user: ");
        String user = br.readLine();

        System.out.print("Enter password: ");
        String pass = br.readLine();

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection dbConnection = DriverManager.getConnection(url, user, pass);
        Database.cloneRecordsTenTimes(dbConnection);

        System.out.println("Done");
    }
}