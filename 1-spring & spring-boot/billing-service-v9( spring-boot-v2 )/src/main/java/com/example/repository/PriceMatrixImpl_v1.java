package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PriceMatrixImpl_v1 implements PriceMatrix {

	@Autowired
	private MatrixRepository matrixRepository;

	public PriceMatrixImpl_v1() {
	}

	@Override
	public double getPrice(String itemCode) {

		// ..
		return matrixRepository.findById(itemCode).get().getPrice();
	}

}
