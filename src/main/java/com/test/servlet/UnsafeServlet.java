package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BAD PRACTICES: Multiple security and design issues
 * - No input validation
 * - Direct SQL-like string concatenation (vulnerable to injection)
 * - No authentication/authorization
 * - Returns sensitive error information
 */
public class UnsafeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: No input validation
        String userId = req.getParameter("userId");
        String query = req.getParameter("query");
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        // BAD: Direct string concatenation (SQL injection risk)
        String sqlQuery = "SELECT * FROM users WHERE id = " + userId + " AND name LIKE '%" + query + "%'";
        
        // BAD: Exposing internal details in response
        out.println("{\"sql\": \"" + sqlQuery + "\", \"userId\": \"" + userId + "\"}");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: No authentication check
        // BAD: No CSRF protection
        // BAD: No input sanitization
        
        String data = req.getParameter("data");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        // BAD: Directly echoing user input without validation
        out.println("{\"received\": \"" + data + "\", \"status\": \"processed\"}");
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: No validation, no authentication
        String userId = req.getParameter("userId");
        String data = req.getParameter("data");
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"PUT\", \"userId\": \"" + userId + "\", \"data\": \"" + data + "\"}");
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: No authorization check
        String userId = req.getParameter("userId");
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"DELETE\", \"userId\": \"" + userId + "\", \"status\": \"deleted\"}");
    }
    
    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: No validation, no authentication
        String userId = req.getParameter("userId");
        String data = req.getParameter("data");
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"PATCH\", \"userId\": \"" + userId + "\", \"data\": \"" + data + "\"}");
    }
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setHeader("Allow", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"OPTIONS\", \"allowed\": [\"GET\", \"POST\", \"PUT\", \"DELETE\", \"PATCH\", \"OPTIONS\"]}");
    }
    
    // BAD: Missing proper error handling
    // BAD: No logging
    // BAD: No rate limiting
}

