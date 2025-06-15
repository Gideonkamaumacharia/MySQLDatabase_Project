package com.store.mysqlsampledatabase.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "officeCode", nullable = false)
    @JsonBackReference
    private Office office;

    // Self referencing relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    // Fixed: Added mappedBy to establish bidirectional relationship
    // This tells Hibernate that the relationship is managed by the 'salesRepresentative' field in Customer
    @OneToMany(mappedBy = "salesRepresentative", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Customer> customers;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;

    }