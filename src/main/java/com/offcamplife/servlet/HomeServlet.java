package com.offcamplife.servlet;

import com.offcamplife.util.DBInit;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Ensure DB + table exist
        DBInit.init();

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h2>OffCamp-Life is running.</h2>");
        resp.getWriter().println("<p>SQLite database initialized.</p>");
    }
}
