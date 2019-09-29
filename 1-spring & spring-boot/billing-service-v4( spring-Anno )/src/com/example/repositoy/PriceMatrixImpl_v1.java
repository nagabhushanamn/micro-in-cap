package com.example.repositoy;

import org.apache.log4j.Logger;

public class PriceMatrixImpl_v1 implements PriceMatrix {

	private Logger logger = Logger.getLogger("billing");

	public PriceMatrixImpl_v1() {
		logger.info("PriceMatrixImpl_v1 instance created..");
	}

	@Override
	public double getPrice(String itemCode) {

		logger.info("loading price of item " + itemCode);
		// ..
		return 100.00;
	}

}
