package com.bank.controller;

import com.bank.application.AccountService;
import com.bank.entity.AccountDetails;
import com.bank.entity.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountDetailsController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{customerid}")
    public ResponseEntity<List<AccountDetails>> getAccountDetails(
            @PathVariable("customerid") Long id,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return new ResponseEntity<>(accountService.getAccountDetailsList(id, pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("{accountid}/transactions")
    public ResponseEntity<List<TransactionDetails>> getTransactionDetails(
            @PathVariable("accountid") Long accountid,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "transDate") String sortBy) {
        return new ResponseEntity<>(accountService.getTransactionDetailsList(pageNo, pageSize, sortBy, accountid), HttpStatus.OK);
    }
}
