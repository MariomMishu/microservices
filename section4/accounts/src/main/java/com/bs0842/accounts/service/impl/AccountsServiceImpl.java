package com.bs0842.accounts.service.impl;

import com.bs0842.accounts.constants.AccountsConstants;
import com.bs0842.accounts.dto.AccountsDto;
import com.bs0842.accounts.dto.CustomerDto;
import com.bs0842.accounts.entity.AccountsEntity;
import com.bs0842.accounts.entity.CustomerEntity;
import com.bs0842.accounts.exception.CustomerAlreadyExistException;
import com.bs0842.accounts.exception.ResourceNotFoundException;
import com.bs0842.accounts.mapper.AccountsMapper;
import com.bs0842.accounts.mapper.CustomerMapper;
import com.bs0842.accounts.repository.AccountsRepository;
import com.bs0842.accounts.repository.CustomerRepository;
import com.bs0842.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.mapToCustomer(customerDto, new CustomerEntity());
        Optional<CustomerEntity> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobileNumber " + customerDto.getMobileNumber());
        }
        customerEntity.setCreatedAt(LocalDateTime.now());
        customerEntity.setCreatedBy("Anonymous");
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        CustomerEntity customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer ", "mobileNumber", mobileNumber));

        AccountsEntity accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account ", "CustomerId", customer.getCustomerId()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if (accountsDto != null) {
          AccountsEntity accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(()->
                  new ResourceNotFoundException("Account ", "AccountNumber", accountsDto.getAccountNumber().toString())
          );
          AccountsMapper.mapToAccounts(accountsDto, accounts);
          accounts = accountsRepository.save(accounts);
          Long customerId = accounts.getCustomerId();
            CustomerEntity existingCustomer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer ", "CustomerId", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto, existingCustomer);
            customerRepository.save(existingCustomer);
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        CustomerEntity customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer ", "mobileNumber", mobileNumber));
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    private AccountsEntity createNewAccount(CustomerEntity newCustomer) {
        AccountsEntity newAccount = new AccountsEntity();
        newAccount.setCustomerId(newCustomer.getCustomerId());
        newAccount.setAccountNumber(100000000L + new Random().nextInt(900000000));
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");
        return newAccount;
    }
}
