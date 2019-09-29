package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.example.repositoy.PriceMatrixImpl_v1;

public class BillingImpl {

	private Logger logger = Logger.getLogger("billing");

	public BillingImpl() {
		logger.info("BillingImpl instance created...");
	}

	public double getTotalPrice(List<String> cart) {
		logger.info("calculating cart total-price..");
		PriceMatrixImpl_v1 priceMatrix = new PriceMatrixImpl_v1();
		double total = 0.0;
		for (String itemCode : cart) {
			total += priceMatrix.getPrice(itemCode);
		}
		logger.info("calculating cart total finished");
		return total;
	}

}
