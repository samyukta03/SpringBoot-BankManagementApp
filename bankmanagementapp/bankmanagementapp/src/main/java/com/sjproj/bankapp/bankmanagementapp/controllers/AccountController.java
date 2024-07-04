package com.sjproj.bankapp.bankmanagementapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjproj.bankapp.bankmanagementapp.entity.Account;
import com.sjproj.bankapp.bankmanagementapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service; //using auto write here creates an object of the service implemented and inject it here so u can just use that service object directly like this.service.method()

    //rest api funcs with mappings as post or get and such
    //1. to creat accunt
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
       //business logic for this will be in the service 
       Account accountCreated = service.createAccount(account);
        // return accountCreated ;
        // instead of returning the account created like this, 
        // we return the HTTP status as response created so that the post request says 201 

        return ResponseEntity.status(HttpStatus.CREATED).body(accountCreated);   
    }

    @GetMapping("/getAccDetByAccNo/{accountNo}")
    public Account getAccDetByAccNo(@PathVariable Long accountNo){
        Account accountRequested = service.getAccDetByAccNo(accountNo);
        return accountRequested;
    }

    @GetMapping("/getAllAccountDetails")
    public List<Account> getAllAccountDetails(){
        List<Account> allAccounts = service.getAllAccountDetails();
        return allAccounts;
    }
    @PutMapping("/deposit/{accountNumber}/{Amount}")
    public Account depositAmount(@PathVariable Long accountNumber,@PathVariable Double Amount){
        Account accountUpdated = service.depositAmount(accountNumber, Amount);
        return accountUpdated;
    }
    @PutMapping("/withdraw/{accountNumber}/{Amount}")
    public Account withdrawAmount(@PathVariable Long accountNumber,@PathVariable Double Amount){
        Account accountUpdated = service.withdrawAmount(accountNumber, Amount);
        return accountUpdated;
    }

    @DeleteMapping("/closeAccount/{accountNumber}")
    public ResponseEntity<String> closeAccount(@PathVariable Long accountNumber) {
        service.closeAccount(accountNumber);
        // return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account closed");
        return ResponseEntity.ok("Account closed");
    }
}
