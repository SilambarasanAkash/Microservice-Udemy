package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.EndpointExtension;

@Data
@Entity
@Table(name = "customer")
public class customer extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long customerId;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "mobile_number")
    public String mobileNumber;



}
