package com.example.project.service;

import java.util.List;

import com.example.project.domain.CustomerOrder;
import com.example.project.repository.CustomerOrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerorderRepository;

    public List<CustomerOrder> list() {
        return customerorderRepository.findAll();
    }
}