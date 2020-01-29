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
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idorderitem;

    @ManyToOne
    @JoinColumn (name = "OrderId", nullable = false)
    private CustomerOrder orderid;

    @ManyToOne
    @JoinColumn (name = "ProductId", nullable = false)
    private Product productid;

    @Column (name = "UnitPrice", nullable = false, length = 12, columnDefinition = "decimal(12,2)")
    private Double unitprice;

    @Column (name = "Quantity", nullable = false)
    private Integer quantity;

}