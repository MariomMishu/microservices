package com.bs0842.accounts.service.impl;

import com.bs0842.accounts.dto.CustomerDto;
import com.bs0842.accounts.entity.CustomerEntity;
import com.bs0842.accounts.repository.AccountsRepository;
import com.bs0842.accounts.repository.CustomerRepository;
import com.bs0842.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        return false;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        return false;
    }
}
