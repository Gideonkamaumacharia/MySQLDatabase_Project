package com.store.mysqlsampledatabase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "productlines")
public class Productline {
    @Id
    @Column(name = "productLine", nullable = false, length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "imageUrl")
    private String imageUrl;

    @OneToMany(mappedBy = "productLine",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;
}