package com.codegym.tikistore.controller;

import com.codegym.tikistore.service.account.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "authsignincontroller", urlPatterns = "/authin")
public class AuthSignInController extends HttpServlet {
    AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("a");
        if (a == null) {
            a = "";
        }
        switch (a) {
            case "signin":
                checkAccountToIn(request,
                        response);
                break;
            case "signup":
                createAccount(request,
                        response);
                break;
            default:
                response.sendRedirect("/home");
        }
    }

    private void checkAccountToIn(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        boolean isValidAccount = accountService.checkAccountSignIn(request.getParameter("email"),
                request.getParameter("password"));
        String url = null;
        if (isValidAccount) {
            url = "landingPage.jsp";
        } else {
            url = "/home";
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request,
                response);
    }

    private void createAccount(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        accountService.createAccount(request.getParameter("emailsu"),
                request.getParameter("passwordsu"));
        response.sendRedirect("/home");
    }
}