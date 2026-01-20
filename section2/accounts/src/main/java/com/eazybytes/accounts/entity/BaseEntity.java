package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.jdbc.object.UpdatableSqlQuery;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    @Column(insertable = false)
    public LocalDateTime updatedAt;

    @Column(insertable = false)
    public String updatedBy;

    @Column(updatable = false)
    public LocalDateTime createdAt;

    @Column(updatable = false)
    public String createdBy;

}
