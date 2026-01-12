package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * BAD PRACTICE: Servlet that overrides service() method incorrectly
 * This bypasses the standard doGet/doPost/etc. method routing
 */
public class OverloadedServiceServlet extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // BAD: Overriding service() without calling super.service() 
        // This breaks the standard HTTP method routing
        String method = req.getMethod();
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
        // BAD: Manual method handling instead of using doGet/doPost/etc.
        switch (method.toUpperCase()) {
            case "GET":
                out.println("{\"method\": \"GET\", \"warning\": \"Using service() override\"}");
                break;
            case "POST":
                out.println("{\"method\": \"POST\", \"warning\": \"Using service() override\"}");
                break;
            case "PUT":
                out.println("{\"method\": \"PUT\", \"warning\": \"Using service() override\"}");
                break;
            case "DELETE":
                out.println("{\"method\": \"DELETE\", \"warning\": \"Using service() override\"}");
                break;
            case "PATCH":
                out.println("{\"method\": \"PATCH\", \"warning\": \"Using service() override\"}");
                break;
            case "OPTIONS":
                resp.setHeader("Allow", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
                out.println("{\"method\": \"OPTIONS\", \"warning\": \"Using service() override\", \"allowed\": [\"GET\", \"POST\", \"PUT\", \"DELETE\", \"PATCH\", \"OPTIONS\"]}");
                break;
            default:
                out.println("{\"method\": \"" + method + "\", \"warning\": \"Custom method via service() override\"}");
        }
    }
    
    // These methods will never be called because service() is overridden
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // This will never execute
        resp.getWriter().println("This should never appear");
    }
}

