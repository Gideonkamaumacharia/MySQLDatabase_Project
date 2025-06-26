package com.store.mysqlsampledatabase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "orderdetails")
public class Orderdetail {
    @EmbeddedId
    private OrderdetailId id;
    //@MapsId maps the orderNumber and the productCode composite primary keys
    //Without @MapsId("productCode" or ""orderNumber), JPA doesn't know that orderNumber and productCode in the @ManyToOne
    // relationships should be used as part of the embedded ID (OrderDetailId).

    @MapsId("orderNumber")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    @JoinColumn(name = "orderNumber", nullable = false)
    private Order order;

    @MapsId("productCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productCode", nullable = false)
    private Product product;

    @Column(name = "quantityOrdered", nullable = false)
    private Integer quantityOrdered;

    @Column(name = "priceEach", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber", nullable = false)
    private Short orderLineNumber;

}