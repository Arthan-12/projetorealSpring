package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idcustomer;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar(40)")
    private String firstName;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar(40)")
    private String lastName;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar(40)")
    private String city;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar(40)")
    private String country;

    @Column(nullable = false, length = 40, columnDefinition = "nvarchar(20)")
    private String phone;
}