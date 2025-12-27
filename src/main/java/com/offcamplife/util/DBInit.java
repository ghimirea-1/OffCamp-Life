package com.offcamplife.util;

import java.sql.Connection;
import java.sql.Statement;

public class DBInit {

    public static void init() {
        String sql = """
            CREATE TABLE IF NOT EXISTS pantry_items (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                category TEXT,
                storage_type TEXT,
                expiry_date TEXT
            );
        """;

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
