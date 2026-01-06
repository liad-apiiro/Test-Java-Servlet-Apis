package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet that handles custom/non-standard HTTP methods
 * Uses service() method to intercept all requests
 */
public class CustomMethodServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String method = req.getMethod();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        // Handle standard methods
        if ("GET".equals(method)) {
            out.println("{\"method\": \"GET\", \"type\": \"standard\"}");
        } else if ("POST".equals(method)) {
            out.println("{\"method\": \"POST\", \"type\": \"standard\"}");
        } 
        // Handle non-standard methods
        else if ("FUNKYTOWN".equalsIgnoreCase(method)) {
            out.println("{\"method\": \"FUNKYTOWN\", \"type\": \"custom\", \"message\": \"Non-standard method accepted\"}");
        } else if ("DANCEPARTY".equalsIgnoreCase(method)) {
            out.println("{\"method\": \"DANCEPARTY\", \"type\": \"custom\", \"message\": \"Another made-up method\"}");
        } else if ("SUPERDUPER".equalsIgnoreCase(method)) {
            out.println("{\"method\": \"SUPERDUPER\", \"type\": \"custom\", \"message\": \"Yet another custom method\"}");
        } else {
            resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            out.println("{\"error\": \"Method " + method + " not supported\"}");
        }
    }
}

