package com.codegym.tikistore.repository.accountDAO;

import com.codegym.tikistore.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountRepo {

    public static void updateAccount(Account account) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prstm = connection.prepareStatement("UPDATE account SET birth=?, address=?, wallet=? WHERE email=?")) {
            prstm.setString(1,
                    account.getBirth());
            prstm.setString(2,
                    account.getAddress());
            prstm.setDouble(3,
                    account.getWallet());
            prstm.setString(4,
                    account.getEmail());
            prstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Account getAccount(String email) {
        Account account = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prstm = connection.prepareStatement("select * from account where email=?")) {
            prstm.setString(1,
                    email);
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                String accEmail = rs.getString("email");
                String accPassword = rs.getString("password");
                String accGender = rs.getString("gender");
                String accBirth = rs.getString("birth");
                String accAddress = rs.getString("address");
                String accRole = rs.getString("role");
                double accWallet = rs.getDouble("wallet");

                account = new Account(accEmail,
                        accPassword,
                        accBirth,
                        accAddress,
                        accRole,
                        accWallet,
                        accGender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

    public boolean checkAccountSignIn(String email,
                                      String password) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prstm = connection.prepareStatement("select * from account where email=? and password=?;")) {
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
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prstm = connection.prepareStatement("insert into account(email, password, role) values (?,?,?);")) {
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
