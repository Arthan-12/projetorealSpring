package com.example.project.controller;

import java.util.List;

import com.example.project.domain.CustomerOrder;
import com.example.project.service.CustomerOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerorder")
public class CustomerOrderController {

	@Autowired
	private CustomerOrderService customerorderService;

	@GetMapping(value = "/list")
	public ResponseEntity<List<CustomerOrder>> list() {
		return ResponseEntity.ok(customerorderService.list());
	}
}