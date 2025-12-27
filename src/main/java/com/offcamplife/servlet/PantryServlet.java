package com.offcamplife.servlet;

import com.offcamplife.dao.PantryItemDAO;
import com.offcamplife.model.PantryItem;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/pantry")
public class PantryServlet extends HttpServlet {

    private final PantryItemDAO dao = new PantryItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // ✅ HANDLE DELETE
        String action = req.getParameter("action");
        String idParam = req.getParameter("id");

        if ("delete".equals(action) && idParam != null) {
            dao.deleteById(Long.parseLong(idParam));
            resp.sendRedirect("pantry");
            return;
        }

        List<PantryItem> items = dao.findAll();
        req.setAttribute("items", items);

        try {
            req.getRequestDispatcher("/pantry.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        PantryItem item = new PantryItem();

        item.setName(req.getParameter("name"));
        item.setCategory(req.getParameter("category"));
        item.setStorageType(req.getParameter("storageType"));

        String expiry = req.getParameter("expiryDate");
        if (expiry != null && !expiry.isEmpty()) {
            item.setExpiryDate(LocalDate.parse(expiry));
        }

        dao.save(item);
        resp.sendRedirect("pantry");
    }
}
