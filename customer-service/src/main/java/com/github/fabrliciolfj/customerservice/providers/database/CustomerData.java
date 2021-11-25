package com.github.fabrliciolfj.customerservice.providers.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerData {

    @Id
    private Long id;
    private String name;
    private String document;
    private String code;
    @CreatedDate
    @Column(value = "created_date")
    private Long createdDate;
    private String status;
    @LastModifiedDate
    @Column(value = "last_modified_date")
    private Long lastModifiedDate;
    @Version
    private int version;
}
