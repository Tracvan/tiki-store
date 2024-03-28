package com.codegym.tikistore.repository.dao;

import com.codegym.tikistore.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public static final String FILTER_PRODUCT = "select * from product where type = ?;";
    public static final String GET_TYPE = "select distinct type from product; ";
    private static final String INSERT_PRODUCT = "Insert into product (name, price, quantity,type, image) values (?, ?, ?, ?, ?);";
    private static final String SELECT_PRODUCT_BY_ID = "select productId, productName, productPrice, productQuantity, "
                                                       + "productType, productImage  from product where id =?";
    private static final String SELECT_ALL_PRODUCT = "select * from product;";
    private static final String DELETE_PRODUCT_SQL = "delete from product where productId = ?;";
    private static final String UPDATE_PRODUCT_SQL =
            "update product set name = ?,price= ?, quantity =?, type=?, image=?"
            + " where productId = ?;";
    private static final String SEARCH_PRODUCT = "select productId, name, price, quantity, type, image from product where name LIKE ? ORDER BY productId DESC LIMIT 6 OFFSET ?; ";


    public ProductDAO() {

    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcURL = "jdbc:mysql://localhost:3306/shop?useSSL=false";
            String jdbcUsername = "root";
            String jdbcPassword = "123456";

            connection = DriverManager.getConnection(jdbcURL,
                    jdbcUsername,
                    jdbcPassword);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    /*public static void countFilter(HttpServletRequest request,
                                   String filter) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT COUTN(*) FROM product WHERE type = ?")) {
            statement.setString(1,
                    filter);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int endPage = 1;
                if ((total % 6) != 0) {
                    endPage = (total / 6) + 1;
                } else {
                    endPage = total / 6;
                }
                request.setAttribute("endPage",
                        endPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void countProduct(HttpServletRequest request,
                                    String searchQuery) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM product WHERE name LIKE ?")) {
            searchQuery = "%" + searchQuery + "%";
            statement.setString(1,
                    searchQuery);
            ResultSet rs = statement.executeQuery();
            int total = 1;
            int endPage = 1;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            if ((total % 6) != 0) {
                endPage = (total / 6) + 1;
            } else {
                endPage = total / 6;
            }
            request.setAttribute("endPage",
                    endPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT);
            statement.setString(1,
                    product.getProductName());
            statement.setDouble(2,
                    product.getPrice());
            statement.setInt(3,
                    product.getQuantity());
            statement.setString(4,
                    product.getType());
            statement.setString(5,
                    product.getImage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        try {
            Connection connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * from product where productId=?");
            statement.setInt(1,
                    id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = id;
                String proName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                String image = rs.getString("image");

                product = new Product(productId,
                        proName,
                        price,
                        quantity,
                        type,
                        image);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct(HttpServletRequest request,
                                          HttpServletResponse response) throws SQLException {
        /*List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                String image = rs.getString("image");

                productList.add(new Product(productId,
                        productName,
                        price,
                        quantity,
                        type,
                        image));

            }
        }*/
        request.setAttribute("searchQuery",
                "");
        List<Product> productList = searchProduct(request,
                response);
        return productList;
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {

        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);
        statement.setInt(1,
                productId);
        statement.executeUpdate();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            statement.setString(1,
                    product.getProductName());
            statement.setDouble(2,
                    product.getPrice());
            statement.setInt(3,
                    product.getQuantity());
            statement.setString(4,
                    product.getType());
            statement.setString(5,
                    product.getImage());
            statement.setInt(6,
                    product.getProductId());

            statement.executeUpdate();
        }
    }

    @Override
    public List<Product> searchProduct(HttpServletRequest request,
                                       HttpServletResponse response) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String searchQuery = (String) request.getAttribute("searchQuery");
        searchQuery = "%" + searchQuery + "%";
        countProduct(request,
                searchQuery);
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SEARCH_PRODUCT)) {
            statement.setString(1,
                    searchQuery);
            int page = 1;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            statement.setInt(2,
                    (page - 1) * 6);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String type = rs.getString("type");
                String image = rs.getString("image");

                productList.add(new Product(productId,
                        productName,
                        price,
                        quantity,
                        type,
                        image));

            }
        }
        return productList;
    }

    public List<Product> filter(String filerType) throws SQLException, NullPointerException {
        List<Product> productList = new ArrayList<>();
        Connection connection = getConnection();

        /*countFilter(request,
                filerType);*/

        PreparedStatement statement = connection.prepareStatement(FILTER_PRODUCT);
        statement.setString(1,
                filerType);
        /*statement.setInt(2,
                (page - 1) * 6);*/
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            String type = rs.getString("type");
            String image = rs.getString("image");
            productList.add(new Product(productId,
                    productName,
                    price,
                    quantity,
                    type,
                    image));
        }
        return productList;
    }

    @Override
    public List<String> getTypeList() throws SQLException {
        List<String> typeList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_TYPE);
        statement.executeQuery();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String type = rs.getString("type");
            typeList.add(type);
        }
        return typeList;
    }
}

