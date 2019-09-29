package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.Billing;

@Controller
public class BillingController {

	@Autowired
	private Billing billing;

	@PostMapping(value = "/total", consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody TotalResponse computeTotalPrice(@RequestBody TotalRequest request) {
		TotalResponse totalResponse = new TotalResponse();
		totalResponse.setTotal(billing.getTotalPrice(request.getCart()));
		return totalResponse;
	}

}
