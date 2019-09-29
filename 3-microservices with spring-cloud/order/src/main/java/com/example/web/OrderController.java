package com.example.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.client.CartFeignClient;
import com.example.model.CartLine;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

//	private RestTemplate restTemplate = new RestTemplate();

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Autowired
//	private CartFeignClient cartFeignClient;
//
	@Autowired
	private OrderRepository orderRepository;
//
//	@Autowired
//	private DiscoveryClient discoveryClient;

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@PostMapping("/checkout/{cartId}")
	public ResponseEntity<?> newOrder(@PathVariable String cartId) {

		// ------------------------------------------
		// without discovery server
		// ------------------------------------------

//		String cartServiceUrl = "http://localhost:8083/cart/Nag";
//
//		ResponseEntity<CartLine[]> responseEntity = restTemplate.getForEntity(cartServiceUrl, CartLine[].class);
//		CartLine[] cartLines = responseEntity.getBody();

		// ------------------------------------------
		// with discovery server
		// ------------------------------------------

//		List<ServiceInstance> list = discoveryClient.getInstances("cart");
//
//		if (list != null && list.size() > 0) {
//			URI uri = list.get(0).getUri();
//			if (uri != null) {
//				ResponseEntity<CartLine[]> responseEntity = restTemplate.getForEntity(uri + "/cart/Nag",
//						CartLine[].class);
//
//				CartLine[] cartLines = responseEntity.getBody();
//				double totalAmount = Arrays.stream(cartLines)
//						.mapToDouble(line -> line.getQty() * line.getItem().getPrice()).sum();
//				Order order = new Order();
//				order.setTotalAmount(totalAmount);
//				order.setDateTime(LocalDateTime.now());
//				order = orderRepository.save(order);
//				restTemplate.delete(uri + "/cart/Nag");
//				return new ResponseEntity<>(order, HttpStatus.CREATED);
//
//			} else {
//				return new ResponseEntity<>("Cart Service Unavailable.", HttpStatus.OK);
//			}
//
//		} else {
//			return new ResponseEntity<>("Failed.", HttpStatus.OK);
//		}

		// ------------------------------------------
		// with client load balancer
		// ------------------------------------------

//		ResponseEntity<CartLine[]> responseEntity = restTemplate.getForEntity("http://cart/cart/Nag", CartLine[].class);
//		CartLine[] cartLines = responseEntity.getBody();

		// ------------------------------------------
		// with client load balancer + feign wrapper
		// ------------------------------------------

//		CartLine[] cartLines = cartFeignClient.getCart(cartId);
//
//		double totalAmount = Arrays.stream(cartLines).mapToDouble(line -> line.getQty() * line.getItem().getPrice()).sum();
//		Order order = new Order();
//		order.setTotalAmount(totalAmount);
//		order.setDateTime(LocalDateTime.now());
//		order = orderRepository.save(order);
//
//		cartFeignClient.clearCart(cartId);
//
//		return new ResponseEntity<>(order, HttpStatus.CREATED);

		// ------------------------------------------
		// with circuit breaker pattern with hystrix
		// ------------------------------------------

		Order order = orderService.newOrder(cartId);
		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

}
