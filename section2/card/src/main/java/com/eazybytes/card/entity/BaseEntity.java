package com.eazybytes.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @LastModifiedDate
    @Column(name="updated_at",insertable = false)
    public LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name="updated_by",insertable = false)
    public String updatedBy;

    @CreatedDate
    @Column(name="created_at",updatable = false)
    public LocalDateTime createdAt;

    @CreatedBy
    @Column(name="created_by",updatable = false)
    public String createdBy;

}
