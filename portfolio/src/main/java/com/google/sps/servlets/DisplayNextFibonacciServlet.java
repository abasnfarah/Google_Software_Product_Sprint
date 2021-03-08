package com.google.sps.servlets;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.sps.data.FibonacciNumbers;

/** Handles requests sent to the /fib URL. */

@WebServlet("/fib")
public final class DisplayNextFibonacciServlet extends HttpServlet {
    // Using BigInteger to avoid integer overflow
    BigInteger fib = new BigInteger("1");
    BigInteger prevFib = new BigInteger("0");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Calculate the next fibonnaci number
        BigInteger temp = prevFib;
        prevFib = fib;
        fib = fib.add(temp);

        // Convert the server stats to JSON
        
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers(temp, prevFib, fib);
        String json = convertToJson(fibonacciNumbers);

        // Send the JSON as the response
        response.setContentType("application/json;");
        response.getWriter().println(json);
   }

    private String convertToJson(FibonacciNumbers fibonacciNumbers){

        Gson gson = new Gson();
        String json = gson.toJson(fibonacciNumbers);
        return json;

    }

}
