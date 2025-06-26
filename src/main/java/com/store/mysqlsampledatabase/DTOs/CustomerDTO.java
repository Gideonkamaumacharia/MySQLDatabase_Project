package com.store.mysqlsampledatabase.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerDTO {
    private String customerName;
    private String contactFirstName;
    private String contactLastName;
    private String phone;
    private String addressLine1;
    private String city;
    private String country;
    private Integer salesRepId;
    private BigDecimal creditLimit;
}
