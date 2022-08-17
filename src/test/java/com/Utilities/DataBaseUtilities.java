package com.Utilities;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtilities {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;

    public static void CreateConnection(String url, String username, String password) {

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }

    }
    public static void runQuery(String query) {

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query); // setting the value of ResultSet object
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY " + e.getMessage());
        }
    }
    public static void destroy() {

        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("ERROR OCCURRED WHILE CLOSING RESOURCES " + e.getMessage());
        }

    }
    public static List<String> getColumnNames(String query) {
        runQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columns;

    }

}
