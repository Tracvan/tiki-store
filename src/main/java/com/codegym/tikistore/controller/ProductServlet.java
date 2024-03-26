package com.codegym.tikistore.controller;

import com.codegym.tikistore.model.Product;
import com.codegym.tikistore.repository.dao.IProductDAO;
import com.codegym.tikistore.repository.dao.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/webapp")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showAll(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    showAll(request, response);
//                    break;
//                case "edit":
////                    showEditForm(request, response);
//                    break;
//                case "delete":
////                    deleteUser(request,response);
//                default:
////                    listUser(request,response);
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            searchProduct(req, resp);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList = productDAO.selectAllProduct();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("landingPage.jsp");
        dispatcher.forward(request, response);
    }

//    public void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        List<Product> productList = productDAO.searchProduct();
//        request.setAttribute("productList", productList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("landingPage.jsp");
//        dispatcher.forward(request, response);
//    }
}
