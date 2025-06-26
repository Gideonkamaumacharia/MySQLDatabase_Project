package com.store.mysqlsampledatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productCode", nullable = false, length = 15)
    private String productCode;

    @Column(name = "productName", nullable = false, length = 70)
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productLine", nullable = false)
    private Productline productLine;

    @Column(name = "productScale", nullable = false, length = 10)
    private String productScale;

    @Column(name = "productVendor", nullable = false, length = 50)
    private String productVendor;

    @Lob
    @Column(name = "productDescription", nullable = false)
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private Short quantityInStock;

    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;

    @Lob
    @Column(name = "imageUrl")
    private String imageUrl;


    //A product can be in many orderDetails
    @OneToMany(mappedBy ="product",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore()
    private Set<Orderdetail> orderdetails;

}