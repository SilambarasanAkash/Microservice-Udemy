package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.customerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(customerDto customerDto);

    customerDto fetchCustomer(String mobileNumber) throws Throwable;

    boolean updateAccount(customerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
