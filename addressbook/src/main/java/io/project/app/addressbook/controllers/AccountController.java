/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.addressbook.controllers;

import io.project.app.addressbook.domain.Account;
import io.project.app.addressbook.services.AccountService;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gayanec
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        log.info("Create account");
        Optional<Account> savedAccount = accountService.createAccount(account);

        if (savedAccount.isPresent()) {
            log.info("Account saved and all is ok!");
            return ResponseEntity.status(HttpStatus.OK).body(savedAccount.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry I can't save ths account, please try again!");
    }

}
