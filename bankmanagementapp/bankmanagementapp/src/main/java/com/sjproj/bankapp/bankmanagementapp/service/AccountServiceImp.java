package com.sjproj.bankapp.bankmanagementapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjproj.bankapp.bankmanagementapp.DAO.AccountDao;
import com.sjproj.bankapp.bankmanagementapp.entity.Account;
@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    AccountDao accountDao ;
    @Override
    public Account createAccount(Account account) {
        Account account_saved = accountDao.save(account);
        return account_saved;    
    }

    @Override
    public Account getAccDetByAccNo(Long accountNumber) {
        Account accountRequested;
        Account account = accountDao.findById(accountNumber).orElse(null);
        if(account==null){
            throw new RuntimeException("Account doesn't Exist");
        }
        else{
            accountRequested = account;
        }
        return accountRequested;    
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> allAccounts = accountDao.findAll();

    return allAccounts;    
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Account accountUpdated;

        Account account = accountDao.findById(accountNumber).orElse(null);
        if(account==null){
            throw new RuntimeException("Account doesn't Exist");
        }
        else{
            account.setAccount_balance(account.getAccount_balance()+amount);
            accountUpdated=account;
            accountDao.save(accountUpdated);
        }
        return accountUpdated;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Account accountUpdated;

        Account account = accountDao.findById(accountNumber).orElseThrow(() -> new RuntimeException("Account doesn't Exist"));

            account.setAccount_balance(account.getAccount_balance()-amount);
            accountUpdated=account;
            accountDao.save(accountUpdated);
    
        return accountUpdated;
    }

    @Override
    public void closeAccount(Long accountNumber) {
        //check if account exiist 
        getAccDetByAccNo(accountNumber);
        accountDao.deleteById(accountNumber);
        return ;
    }


}
