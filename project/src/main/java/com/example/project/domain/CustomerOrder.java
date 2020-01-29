package com.example.project.domain;

import java.util.Calendar;

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
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer idorder;

    @Column(name = "OrderDate", nullable = false, length = 40, columnDefinition = "datetime")
    private Calendar orderdate;

    @Column(name = "OrderNumber", nullable = true, length = 10, columnDefinition = "nvarchar(10)")
    private String ordernumber;

    @ManyToOne
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customerid;

    @Column(name = "TotalAmount", nullable = true, length = 12, columnDefinition = "decimal(12,2)")
    private Double totalamount;
}