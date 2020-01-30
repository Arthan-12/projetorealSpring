package com.example.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idproduct;

    @Column(name = "ProductName", nullable = false, length = 50, columnDefinition = "nvarchar(50)")
    private String productname;

    @ManyToOne
    @JoinColumn(name = "SupplierId", nullable = false)
    private Supplier supplierid;

    @Column(name = "UnitPrice", nullable = true, length = 12, columnDefinition = "decimal(12,2)")
    private Double unitprice;

    @Column(name = "Package", nullable = true, length = 30, columnDefinition = "nvarchar(30)")
    private String packagename;

    @Column(name = "ProductImage", nullable = true, length = 400, columnDefinition = "nvarchar(400")
    private String imagem;

    @Column(name = "IsDiscontinued", nullable = false)
    private Boolean isdiscontinued;
}