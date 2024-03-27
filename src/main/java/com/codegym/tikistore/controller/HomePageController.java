package com.codegym.tikistore.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "homepagecontroller", value = "/homepage-controller")
public class HomePageController extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("landingPage.jsp");
        rd.forward(request, response);
    }
}