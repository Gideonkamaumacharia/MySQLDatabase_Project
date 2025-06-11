package com.store.mysqlsampledatabase.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employeeNumber", nullable = false)
    // Add this if employeeNumber is auto-generated in your database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "extension", nullable = false, length = 10)
    private String extension;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    // Fixed: Better property name
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "officeCode", nullable = false)
    private Office office;

    // Self referencing relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    // Fixed: Added mappedBy to establish bidirectional relationship
    // This tells Hibernate that the relationship is managed by the 'salesRepresentative' field in Customer
    @OneToMany(mappedBy = "salesRepresentative", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;

    }