package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Standard HTTP methods servlet - implements GET, POST, PUT, DELETE
 */
public class StandardMethodsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"GET\", \"message\": \"Standard GET request\"}");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"POST\", \"message\": \"Standard POST request\"}");
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"PUT\", \"message\": \"Standard PUT request\"}");
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"DELETE\", \"message\": \"Standard DELETE request\"}");
    }
}

