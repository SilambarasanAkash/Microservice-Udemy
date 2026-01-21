package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.customerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(customerDto customerDto);

}
