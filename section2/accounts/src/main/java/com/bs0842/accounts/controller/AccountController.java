package com.bs0842.accounts.controller;

import com.bs0842.accounts.constants.AccountsConstants;
import com.bs0842.accounts.dto.CustomerDto;
import com.bs0842.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping
    public String getAccounts() {
        return "List of accounts";
    }

}
