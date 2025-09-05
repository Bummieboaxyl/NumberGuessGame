package com.studentapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NumberGuessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // No instance variable needed; target number is per user session

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Number Guessing Game</h1>");
        out.println("<form action='guess' method='post'>");
        out.println("Guess a number between 1 and 100: <input type='text' name='guess' />");
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Get the current user's session
            HttpSession session = request.getSession();

            // Retrieve the target number from session, or generate a new one if missing
            Integer targetNumber = (Integer) session.getAttribute("targetNumber");
            if (targetNumber == null) {
                targetNumber = new Random().nextInt(100) + 1; // 1-100
                session.setAttribute("targetNumber", targetNumber);
            }

            // Parse the user's guess
            int guess = Integer.parseInt(request.getParameter("guess"));
            if (guess < targetNumber) {
                out.println("<h2>Your guess is too low. Try again!</h2>");
            } else if (guess > targetNumber) {
                out.println("<h2>Your guess is too high. Try again!</h2>");
            } else {
                out.println("<h2>Congratulations! You guessed the number!</h2>");
                // Reset the number for a new game
                session.removeAttribute("targetNumber");
            }

        } catch (NumberFormatException e) {
            out.println("<h2>Invalid input. Please enter a valid number.</h2>");
        }

        out.println("<a href='guess'>Play Again</a>");
    }
}

