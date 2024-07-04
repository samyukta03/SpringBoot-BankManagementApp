package com.sjproj.bankapp.bankmanagementapp.service;

import java.util.List;

import com.sjproj.bankapp.bankmanagementapp.entity.Account;

public interface AccountService {

    
    public Account createAccount(Account account);
    public Account getAccDetByAccNo(Long accountNumber);
    public List<Account> getAllAccountDetails();
    public Account depositAmount(Long accountNumber, Double amount);
    public Account withdrawAmount(Long accountNumber, Double amount);
    public void closeAccount(Long accountNumber);
    

}
