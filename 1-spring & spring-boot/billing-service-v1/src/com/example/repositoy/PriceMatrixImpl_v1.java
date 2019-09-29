package com.example.repositoy;

import org.apache.log4j.Logger;

public class PriceMatrixImpl_v1 {

	private Logger logger = Logger.getLogger("billing");

	public PriceMatrixImpl_v1() {
		logger.info("PriceMatrixImpl_v1 instance created..");
	}

	public double getPrice(String itemCode) {

		logger.info("loading price of item " + itemCode);
		// ..
		return 100.00;
	}

}
