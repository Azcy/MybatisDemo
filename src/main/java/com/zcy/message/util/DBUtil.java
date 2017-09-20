package com.zcy.message.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/wetchatmessage?useSSL=false";
        Connection conn= DriverManager.getConnection(url,"root","root");
        return conn;
    }
}
