package com.example;

import java.util.Arrays;
import java.util.List;

import com.example.repositoy.PriceMatrix;
import com.example.repositoy.PriceMatrixImpl_v2;
import com.example.service.Billing;
import com.example.service.BillingImpl;

public class App {

	public static void main(String[] args) {

		// phase-1 : init/boot
		PriceMatrix priceMatrix = new PriceMatrixImpl_v2();
		Billing billing = new BillingImpl(priceMatrix);
		System.out.println();

		// phase-2 : use

		List<String> cart1 = Arrays.asList("121", "122", "123");
		double totalPrice = billing.getTotalPrice(cart1);
		System.out.println(totalPrice);

		System.out.println();

		List<String> cart2 = Arrays.asList("121", "122", "124");
		totalPrice = billing.getTotalPrice(cart2);
		System.out.println(totalPrice);

		// phase-3 : destroy
		// ....
	}

}
