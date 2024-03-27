package com.codegym.tikistore.controller;

import com.codegym.tikistore.model.Account;
import com.codegym.tikistore.repository.accountDAO.AccountRepo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "updateacc", urlPatterns = "/updateacc")
public class UpdateAccController extends HttpServlet {
    private static void setAccount(HttpServletRequest request,
                                   Account account) {

        String date = request.getParameter("year") + request.getParameter("month") + request.getParameter("date");

        account.setBirth(date);

        account.setAddress(request.getParameter("address"));

        Double newWallet = account.getWallet() + Double.parseDouble(request.getParameter("addWallet"));

        account.setWallet(newWallet);

        AccountRepo.updateAccount(account);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");


        setAccount(request,
                account);

        Account newAccount = AccountRepo.getAccount(account.getEmail());
        session.setAttribute("account",
                newAccount);
        response.sendRedirect("accountInformation");
    }
}