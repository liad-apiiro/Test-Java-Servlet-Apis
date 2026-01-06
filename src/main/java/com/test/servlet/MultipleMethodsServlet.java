package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet that handles multiple HTTP methods on the same endpoint
 * This is a discouraged practice - should use separate endpoints
 */
public class MultipleMethodsServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        handleRequest("GET", req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        handleRequest("POST", req, resp);
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        handleRequest("PUT", req, resp);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        handleRequest("DELETE", req, resp);
    }
    
    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        handleRequest("PATCH", req, resp);
    }
    
    // BAD PRACTICE: All methods do the same thing
    private void handleRequest(String method, HttpServletRequest req, HttpServletResponse resp) 
            throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        out.println("{\"method\": \"" + method + "\", \"endpoint\": \"/multiple\", \"warning\": \"All methods handled identically\"}");
    }
}

