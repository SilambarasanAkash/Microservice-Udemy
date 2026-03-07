package com.eazybytes.accounts.services;

import com.eazybytes.accounts.Constants.AccountsConstant;
import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.dto.customerDto;
import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.customer;
import com.eazybytes.accounts.exception.ResourceNotFoundException;
import com.eazybytes.accounts.exception.customerAlreadyExistException;
import com.eazybytes.accounts.mapper.AccountsMapper;
import com.eazybytes.accounts.mapper.CustomerMapper;
import com.eazybytes.accounts.repository.accountsRepo;
import com.eazybytes.accounts.repository.customerRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
       accounts.setBranchAddress(AccountsConstant.ADDRESS );

       return accounts;
    }


    @Override
    public customerDto fetchCustomer(String mobileNumber) {

        customer customer =customerRepo.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
        );

        Accounts accounts =accountsRepo.findByCustomerID(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Customer","CustomerId",String.valueOf(customer.getCustomerId()))
        );

        customerDto customerDto =CustomerMapper.mapToCustomerDto(customer,new customerDto());
        AccountsDto accountsDto =AccountsMapper.mapToAccountsDto(accounts,new AccountsDto());
        customerDto.setAccounts(accountsDto);

        return customerDto;
    }

    /**
     *
     * @param customerDto
     * @return
     */
    @Override
    public boolean updateAccount(@RequestBody customerDto customerDto) {

        boolean isUpdate = false;
        com.eazybytes.accounts.dto.AccountsDto accountsDto =customerDto.getAccounts();

        if(accountsDto!=null){

            com.eazybytes.accounts.entity.Accounts accounts =accountsRepo.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()-> new ResourceNotFoundException("Accounts","AccountNumber",String.valueOf(accountsDto.getAccountNumber()))
            );

            AccountsMapper.mapToAccounts(accountsDto,accounts);
            com.eazybytes.accounts.entity.Accounts updatedAccount =accountsRepo.save(accounts);

            customer customer =customerRepo.findById(updatedAccount.getCustomerID()).orElseThrow(
                    ()-> new ResourceNotFoundException("Customer","Customer Id",String.valueOf(updatedAccount.getCustomerID()))
            );



            CustomerMapper.mapToCustomer(customer,customerDto);
            customerRepo.save(customer);

            return true;
        }

        return false;
    }

    /**
     *
     * @param mobileNumber
     * @return
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {


        if(mobileNumber!=null){
            customer customer =customerRepo.findByMobileNumber(mobileNumber).orElseThrow(
                    ()-> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber)
            );

            com.eazybytes.accounts.entity.Accounts accounts =accountsRepo.findByCustomerID(customer.getCustomerId()).orElseThrow(
                    ()-> new ResourceNotFoundException("Accounts","AccountNumber",String.valueOf(customer.getCustomerId()))
            );
            accountsRepo.deleteById(accounts.getAccountNumber());
            customerRepo.deleteById(customer.getCustomerId());

            return true;
        }

        return false;
    }


}
