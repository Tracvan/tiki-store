package com.codegym.tikistore.repository.dao;

import com.codegym.tikistore.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;

    public Product selectProduct(int id) throws SQLException;

    public List<Product> selectAllProduct() throws SQLException;

    public boolean deleteProduct(int id) throws SQLException;

    public boolean updateProduct(Product Product) throws SQLException;

    public List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException;

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}


