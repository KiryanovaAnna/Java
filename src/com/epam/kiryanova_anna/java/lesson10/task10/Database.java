package com.epam.kiryanova_anna.java.lesson10.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static class EmpRow {
        String ename;
        String job;
        int mgr;
        Date hiredate;
        int sal;
        int comm;
        int deptno;
    }

    public static void cloneRecordsTenTimes(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM SCOTT.EMP");

        List<EmpRow> toClone = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        EmpRow row;

        int pk = 0;
        while (rs.next()) {
            row = new EmpRow();

            row.ename = rs.getString("ename");
            row.job = rs.getString("job");
            row.mgr = rs.getInt("mgr");
            row.hiredate = rs.getDate("hiredate");
            row.sal = rs.getInt("sal");
            row.comm = rs.getInt("comm");
            row.deptno = rs.getInt("deptno");

            toClone.add(row);
            pk = Math.max(pk, rs.getInt("empno"));
        }

        for (EmpRow empRow : toClone)
            for (int i = 0; i < 10; i++) {
                PreparedStatement insert = connection.prepareStatement(
                        "INSERT INTO SCOTT.EMP " +
                                "(`empno`, `ename`, `job`, `mgr`, `hiredate`, `sal`, `comm`, `deptno`) VALUES " +
                                "(?, ?, ?, ?, ?, ?, ?, ?)"
                );

                insert.setInt(1, ++pk);

                insert.setString(2, empRow.ename);
                insert.setString(3, empRow.job);
                insert.setInt(4, empRow.mgr);
                insert.setDate(5, empRow.hiredate);
                insert.setInt(6, empRow.sal);

                insert.setInt(7, empRow.comm);
                insert.setInt(8, empRow.deptno);

                insert.executeUpdate();
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
