package com.offcamplife.dao;

import com.offcamplife.model.PantryItem;
import com.offcamplife.util.DBUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PantryItemDAO {

    public void save(PantryItem item) {
        String sql = """
            INSERT INTO pantry_items (name, category, storage_type, expiry_date)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getName());
            ps.setString(2, item.getCategory());
            ps.setString(3, item.getStorageType());
            ps.setString(4, item.getExpiryDate() != null
                    ? item.getExpiryDate().toString()
                    : null);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PantryItem> findAll() {
        List<PantryItem> items = new ArrayList<>();

        String sql = "SELECT * FROM pantry_items ORDER BY id DESC";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PantryItem item = new PantryItem();
                item.setId(rs.getLong("id"));
                item.setName(rs.getString("name"));
                item.setCategory(rs.getString("category"));
                item.setStorageType(rs.getString("storage_type"));

                String dateStr = rs.getString("expiry_date");
                if (dateStr != null) {
                    item.setExpiryDate(LocalDate.parse(dateStr));
                }

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    // ✅ NEW: DELETE BY ID
    public void deleteById(long id) {
        String sql = "DELETE FROM pantry_items WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
