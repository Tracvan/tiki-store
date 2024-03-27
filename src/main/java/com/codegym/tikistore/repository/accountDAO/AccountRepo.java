package com.codegym.tikistore.repository.accountDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountRepo {
    public boolean checkAccountSignIn(String email,
                                      String password) {
        try (Connection connection = DBConnection.getConnection(); PreparedStatement prstm = connection.prepareStatement("select * from account where email=? and password=?;")) {
            prstm.setString(1,
                    email);
            prstm.setString(2,
                    password);

            ResultSet rs = prstm.executeQuery();
            if (rs.next()) {
                rs.close();
                prstm.close();
                connection.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createAccount(String email,
                              String password) {
        try (Connection connection = DBConnection.getConnection(); PreparedStatement prstm = connection.prepareStatement("insert into account(email, password, role) values (?,?,?);")) {
            prstm.setString(1,
                    email);
            prstm.setString(2,
                    password);
            prstm.setString(3,
                    "Customer");
            prstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
