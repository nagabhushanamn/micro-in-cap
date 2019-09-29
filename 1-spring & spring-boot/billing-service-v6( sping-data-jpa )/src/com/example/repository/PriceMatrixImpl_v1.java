package com.example.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PriceMatrixImpl_v1 implements PriceMatrix {

	private Logger logger = Logger.getLogger("billing");

	@Autowired
	private MatrixRepository matrixRepository;

	public PriceMatrixImpl_v1() {
		logger.info("PriceMatrixImpl_v1 instance created..");
	}

	@Override
	public double getPrice(String itemCode) {

		logger.info("loading price of item " + itemCode);
		// ..
		return matrixRepository.findById(itemCode).get().getPrice();
	}

}
