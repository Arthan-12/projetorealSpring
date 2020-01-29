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
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idsupplier;

    @Column(name = "CompanyName", nullable = false, length = 40, columnDefinition = "nvarchar(40)")
    private String companyname;

    @Column(name = "ContactName", nullable = true, length = 50, columnDefinition = "nvarchar(50)")
    private String contactname;

    @Column(name = "ContactTitle", nullable = true, length = 40, columnDefinition = "nvarchar(40)")
    private String contacttitle;

    @Column(name = "City", nullable = true, length = 40, columnDefinition = "nvarchar(40)")
    private String city;

    @Column(name = "Country", nullable = true, length = 40, columnDefinition = "nvarchar(40)")
    private String country;

    @Column(name = "Phone", nullable = true, length = 30, columnDefinition = "nvarchar(30)")
    private String phone;

    @Column(name = "Fax", nullable = true, length = 30, columnDefinition = "nvarchar(30)")
    private String fax;
}