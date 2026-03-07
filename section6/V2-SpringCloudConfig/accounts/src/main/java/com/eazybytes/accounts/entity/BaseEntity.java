package com.eazybytes.accounts.entity;

import com.eazybytes.accounts.audit.AccountsAuditImpl;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.object.UpdatableSqlQuery;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @LastModifiedDate
    @Column(insertable = false)
    public LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    public String updatedBy;

    @CreatedDate
    @Column(updatable = false)
    public LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    public String createdBy;

}
