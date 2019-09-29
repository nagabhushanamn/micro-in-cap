package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.CartLine;

@Component
@FeignClient(value = "cart")
public interface CartFeignClient {

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
	CartLine[] getCart(@PathVariable String id);

	@RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
	CartLine[] clearCart(@PathVariable String id);

}
