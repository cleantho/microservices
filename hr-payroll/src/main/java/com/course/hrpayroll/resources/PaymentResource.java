package com.course.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.hrpayroll.entities.Payment;
import com.course.hrpayroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service; 
	
	@CircuitBreaker(name = "getPayment", fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment obj = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days, Throwable e){
		Payment obj = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok().body(obj);
	}
}
