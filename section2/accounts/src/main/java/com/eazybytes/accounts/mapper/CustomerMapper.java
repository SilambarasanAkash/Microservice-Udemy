package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.customerDto;
import com.eazybytes.accounts.entity.customer;
import lombok.Data;

@Data
public class CustomerMapper {

    /**
     *
     * @param customer
     * @param customerDto
     * @return
     */
    public static customerDto mapToCustomerDto(customer customer, customerDto customerDto){

        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());

        return customerDto;
    }

    /**
     *
     * @param customer
     * @param customerDto
     * @return
     */
    public static customer mapToCustomer(customer customer, customerDto customerDto){

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());

        return customer;
    }



}
