package com.google.sps.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /fib URL. */

@WebServlet("/fib")
public class DisplayNextFibonacciServlet extends HttpServlet {
    int fib = 1;
    int prevFib = 0;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int temp = prevFib;
        prevFib = fib;
        fib = fib + temp;
        response.setContentType("text/html;");
        response.getWriter().println("<h1>Fibonacci Number</h1>");
        response.getWriter().println("<p>The current Fib Number: " + fib + ".</p> <p>Refresh to get the next one</p>");
    }

}
