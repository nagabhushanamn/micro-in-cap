package com.example.service;

import java.util.List;

public interface Billing {

	double getTotalPrice(List<String> cart);

}