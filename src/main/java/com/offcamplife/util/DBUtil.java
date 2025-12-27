package com.offcamplife.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    // This creates a local file-based database automatically
    private static final String URL = "jdbc:sqlite:offcamp_life.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
