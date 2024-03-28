package com.codegym.tikistore.repository.dao;

import com.codegym.tikistore.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void insertProduct(Product product) throws SQLException;

    Product selectProduct(int id) throws SQLException;


    public List<Product> selectAllProduct() throws SQLException;

    public void deleteProduct(int productID) throws SQLException;

    public void updateProduct(Product Product) throws SQLException;

    public List<Product> searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException;


    List<Product> filter(String action) throws SQLException;

    List<String> getTypeList() throws SQLException;
}


