package com.codegym.tikistore.service.account;

import com.codegym.tikistore.repository.accountDAO.AccountRepo;

public class AccountService {
    AccountRepo accountRepo = new AccountRepo();

    public boolean checkAccountSignIn(String email,
                                      String password) {
        return accountRepo.checkAccountSignIn(email,
                password);
    }

    public void createAccount(String email,
                              String password) {
        accountRepo.createAccount(email,
                password);
    }
}
