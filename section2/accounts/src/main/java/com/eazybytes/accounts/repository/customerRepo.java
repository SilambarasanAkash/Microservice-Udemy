package com.eazybytes.accounts.repository;

import com.eazybytes.accounts.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepo extends JpaRepository<customer,Long> {

}
