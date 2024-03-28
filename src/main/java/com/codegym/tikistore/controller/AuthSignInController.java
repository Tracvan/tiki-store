package com.codegym.tikistore.controller;

import com.codegym.tikistore.model.Account;
import com.codegym.tikistore.repository.accountDAO.AccountRepo;
import com.codegym.tikistore.repository.accountDAO.DBConnection;
import com.codegym.tikistore.repository.dao.ProductDAO;
import com.codegym.tikistore.service.account.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "authsignincontroller", urlPatterns = "/authin")
public class AuthSignInController extends HttpServlet {
    AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        if (request.getAttribute("signUpAlert") == null) {
            request.setAttribute("signUpAlert",
                    "");
        }
        if (request.getAttribute("signInAlert") == null) {
            request.setAttribute("signInAlert",
                    "");
        }

        if (request.getAttribute("signUpSuccess") == null) {
            request.setAttribute("signUpSuccess",
                    "");
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "signout":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("/authin");
                break;
            default:
                request.getRequestDispatcher("/signPage.jsp").forward(request,
                        response);
        }
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
                if (!isVariableAccount(request)) {
                    createAccount(request,
                            response);
                } else {
                    request.setAttribute("emailsu",
                            request.getParameter("emailsu"));
                    request.setAttribute("signUpAlert",
                            "This email has already existed!");
                    request.getRequestDispatcher("/signPage.jsp").forward(request,
                            response);
                }
                break;
            default:
                response.sendRedirect("/authin");
        }
    }

    private void checkAccountToIn(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        boolean isValidAccount = accountService.checkAccountSignIn(request.getParameter("email"),
                request.getParameter("password"));
        String url = null;
        if (isValidAccount) {
            HttpSession session = request.getSession();
            Account account = AccountRepo.getAccount(request.getParameter("email"));
            session.setAttribute("account",
                    account);
            session.setAttribute("isSignIn",
                    true);
            url = "/webapp?page=1";
            ProductDAO.countProduct(request,
                    "");
        } else {
            request.setAttribute("email",
                    request.getParameter("email"));
            request.setAttribute("signInAlert",
                    "Your email or password is not right, try again!");
            request.getRequestDispatcher("/signPage.jsp").forward(request,
                    response);
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request,
                response);
    }

    private boolean isVariableAccount(HttpServletRequest request) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prstm = connection.prepareStatement("select * from account where binary email=?")) {
            prstm.setString(1,
                    request.getParameter("emailsu"));

            ResultSet rs = prstm.executeQuery();

            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAccount(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {
        accountService.createAccount(request.getParameter("emailsu"),
                request.getParameter("passwordsu"));

        request.setAttribute("emailsu",
                request.getParameter("emailsu"));
        HttpSession session = request.getSession();
        session.setAttribute("signUpSuccess",
                "Your account has created!");
        request.getRequestDispatcher("/signPage.jsp").forward(request,
                response);
    }
}