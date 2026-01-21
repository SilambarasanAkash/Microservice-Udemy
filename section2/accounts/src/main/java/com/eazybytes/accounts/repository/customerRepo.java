package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepo extends JpaRepository<customer,Long> {

    Optional<customer> findByMobileNumber(String mobileNumber);


}
