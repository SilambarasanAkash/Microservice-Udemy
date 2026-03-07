package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.actuate.endpoint.annotation.EndpointExtension;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
@Data
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
