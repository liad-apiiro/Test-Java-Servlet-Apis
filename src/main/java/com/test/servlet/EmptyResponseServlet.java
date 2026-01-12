package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BAD PRACTICE: Servlet that doesn't write any response
 * Methods are implemented but don't produce output
 */
public class EmptyResponseServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Method implemented but does nothing
        // No response written, no status set
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Sets status but no response body
        resp.setStatus(HttpServletResponse.SC_OK);
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Sets content type but no content
        resp.setContentType("application/json");
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Commits response without content
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        resp.flushBuffer();
    }
    
    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Method implemented but does nothing
        // No response written
    }
    
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Sets Allow header but no response body
        resp.setHeader("Allow", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
    }
}

