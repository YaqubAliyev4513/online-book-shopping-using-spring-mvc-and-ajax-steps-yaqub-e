package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/customer")
public class CustomerController{
	
	@GetMapping()
	public String showCustomerPage(){
		return "customer-ajax";
	}
	
	@GetMapping(path="confirmation-form")
	public String showConfirmationForm(){
		return "confirmation-form";
	}
  
}
