package com.eazybytes.accounts.services;

import com.eazybytes.accounts.Constants.AccountsConstant;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.customerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.customer;
import com.eazybytes.accounts.exception.customerAlreadyExistException;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.accountsRepo;
import com.eazybytes.accounts.repository.customerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private accountsRepo accountsRepo;
    private customerRepo customerRepo;


    /**
     *
     * @param customerDto
     */
    @Override
    public void createAccount(customerDto customerDto){

        com.eazybytes.accounts.entity.customer customer =CustomerMapper.mapToCustomer(new customer(),customerDto);
        Optional<customer> AlreadyexistMobile=customerRepo.findByMobileNumber(customer.getMobileNumber());
        if (AlreadyexistMobile.isPresent())
           throw  new customerAlreadyExistException("already given mobile number is exist"+customer.getMobileNumber());

        customer savedCustomer =customerRepo.save(customer);
        accountsRepo.save(createNewAccount(savedCustomer));

    }


    public Accounts createNewAccount(customer customer){

       Accounts accounts =new Accounts();

       accounts.setCustomerID(customer.getCustomerId());
        long randomAcctNumber = 1000000000L + new Random().nextInt(900000000);
       accounts.setAccountNumber(randomAcctNumber);
       accounts.setAccountType(AccountsConstant.SAVINGS);
       accounts.setBranchAddress(AccountsConstant.ADDRESS);

       return accounts;
    }



}
