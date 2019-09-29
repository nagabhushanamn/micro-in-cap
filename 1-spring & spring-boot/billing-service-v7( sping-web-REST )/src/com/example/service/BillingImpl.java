package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.PriceMatrix;

@Service
public class BillingImpl implements Billing {

	private Logger logger = Logger.getLogger("billing");

	private PriceMatrix priceMatrix;

	public BillingImpl(PriceMatrix priceMatrix) {
		this.priceMatrix = priceMatrix;
		logger.info("BillingImpl instance created...");
	}

	@Override
	public double getTotalPrice(List<String> cart) {
		logger.info("calculating cart total-price..");
		double total = 0.0;
		for (String itemCode : cart) {
			total += priceMatrix.getPrice(itemCode);
		}
		logger.info("calculating cart total finished");
		return total;
	}

}
