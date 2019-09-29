package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.repository.PriceMatrix;

@Service
public class BillingImpl implements Billing {


	private PriceMatrix priceMatrix;

	public BillingImpl(PriceMatrix priceMatrix) {
		this.priceMatrix = priceMatrix;
	}

	@Override
	public double getTotalPrice(List<String> cart) {
		double total = 0.0;
		for (String itemCode : cart) {
			total += priceMatrix.getPrice(itemCode);
		}
		return total;
	}

}
