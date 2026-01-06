package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BAD PRACTICE: Servlet that only implements GET but is mapped to handle all methods
 * Missing implementations for POST, PUT, DELETE will cause 405 errors
 */
public class MissingMethodServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"GET\", \"status\": \"ok\"}");
    }
    
    // INTENTIONALLY MISSING: doPost, doPut, doDelete
    // This will cause 405 Method Not Allowed for those methods
    // This is a discouraged practice - should implement all expected methods
}

