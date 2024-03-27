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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("landingPage.jsp");
        rd.forward(request,
                response);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        RequestDispatcher rd = request.getRequestDispatcher("signPage.jsp");
        rd.forward(request,
                response);
    }
}
