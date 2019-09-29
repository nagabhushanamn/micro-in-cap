package com.example.repositoy;

import org.apache.log4j.Logger;

public class PriceMatrixImpl_v2 {

	private Logger logger = Logger.getLogger("billing");

	public PriceMatrixImpl_v2() {
		logger.info("PriceMatrixImpl_v2 instance created..");
	}

	public double getPrice(String itemCode) {

		logger.info("loading price of item " + itemCode);
		// ..
		return 200.00;
	}

}
