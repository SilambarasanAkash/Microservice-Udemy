package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Accounts extends BaseEntity {


    @Id
    @Column(name = "account_number")
    public Integer accountNumber;

    @Column(name = "customer_id")
    public long customerID;

    @Column(name = "account_type")
    public String accountType;

    @Column(name = "branch_address")
    public String branchAddress;


}
