package com.abdev.http.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var value = req.getParameter("param");
        var parameterMap = req.getParameterMap();
        resp.setContentType("text/html");
        try (var writer = resp.getWriter()) {
            writer.println("Hello from servlet");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
