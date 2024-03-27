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
    private final IProductDAO productDAO = new ProductDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                try {
                    searchProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "create":
                try {
                    addProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                String name = request.getParameter("name");
                ProductDAO productDAO1 = new ProductDAO();
                try {
                    Product product = productDAO1.selectProduct(name);
                    request.setAttribute("product", product);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                editProduct(request, response);
                break;
            case "delete":
                try {
                    deleteProduct(request);
                    response.sendRedirect("/webapp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showAll(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                response.sendRedirect("/webapp");
                break;
            case "edit":
                try {
                    updateProduct(request, response);
                    response.sendRedirect("/webapp");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    showAll(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> productList;
        try {
            productList = productDAO.selectAllProduct();
            RequestDispatcher dispatcher = request.getRequestDispatcher("landingPage.jsp");
            request.setAttribute("productList", productList);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String searchQuery = request.getParameter("searchQuery");
        if (searchQuery.equals("")) {
            searchQuery = "%%";
            request.setAttribute("searchQuery", searchQuery);
        } else {
            request.setAttribute("searchQuery", searchQuery);
        }
        List<Product> productList = productDAO.searchProduct(request, response);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("landingPage.jsp");
        dispatcher.forward(request, response);
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
        dispatcher.forward(request, response);
    }

    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("editProductPage.jsp");
        dispatcher.forward(request, response);
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String newName = request.getParameter("name");
        double newPrice = Double.parseDouble(request.getParameter("price"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        String newType = request.getParameter("type");
        String newImage = request.getParameter("image");
        Product newProduct = new Product(newName, newPrice, newQuantity, newType, newImage);
        productDAO.updateProduct(newProduct);

    }

    public void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String type = request.getParameter("type");
        String image = request.getParameter("image");
        Product newProduct = new Product(productName, price, quantity, image, type);
        try {
            productDAO.insertProduct(newProduct);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(HttpServletRequest request) throws SQLException {
        productDAO.deleteProduct(request.getParameter("name"));
    }
}