package com.payment_service.payment_service;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Here we are not using request mapping because we are doing the server.servlet.context-path=/payment in the application properties, this acts same as request mapping

@CrossOrigin(origins="*")
public class PaymentController {

	@GetMapping("/options")
	public List<String> paymentOption(){
		return List.of("UPI","NetBanking","CreditCard","DebitCard");
	}
}
