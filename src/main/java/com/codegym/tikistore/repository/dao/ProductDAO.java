package com.codegym.tikistore.repository.dao;

import com.codegym.tikistore.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String INSERT_PRODUCT = "Insert into product (productName, productPrice, productQuantity,productType, productImage) values (?, ?, ?, ?, ?)";

    private static final String SELECT_PRODUCT_BY_ID = "select productID, productName, productPrice, productQuantity, " +
            "productType, productImage  from product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from product";
    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "update users set productName = ?,productPrice= ?, productQuantity =?, productType=?, productImage=?" +
            " where id = ?;";
    private static final String SEARCH_PRODUCT = "select name, price, quantity, type, image from product where name like ?; ";

    public ProductDAO() {

    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/shop?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "0775086426";
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT);
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getType());
            statement.setString(5, product.getImage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                String image = rs.getString("image");
                productList.add(new Product(productName, price, quantity, image, type));
            }
        }
        return productList;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product Product) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            statement.setString(1, Product.getProductName());
            statement.setDouble(2, Product.getPrice());
            statement.setInt(3, Product.getQuantity());
            statement.setString(4, Product.getType());
            statement.setString(5, Product.getImage());

            rowUpdate = statement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String searchQuery = (String) request.getAttribute("searchQuery");
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_PRODUCT)) {
            statement.setString(1, searchQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                String image = rs.getString("image");
                productList.add(new Product(productName, price, quantity, image, type));
            }

        }
        return productList;
    }

    @Override
    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
        String productName = request.getParameter("name");
        String
    }

}

