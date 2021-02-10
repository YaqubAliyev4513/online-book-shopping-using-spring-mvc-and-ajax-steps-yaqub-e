package az.developia.bookshopping_yaqub_e.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping_yaqub_e.config.MySession;
import az.developia.bookshopping_yaqub_e.dao.CustomerDAO;
import az.developia.bookshopping_yaqub_e.dao.OrderDAO;
import az.developia.bookshopping_yaqub_e.model.Customer;
import az.developia.bookshopping_yaqub_e.model.OrderModel;



@RestController
@RequestMapping(path="/orders-rest")
@CrossOrigin(origins="*")

public class OrderRestController {
		
	@Autowired
	private OrderDAO orderDAO;
	private String username;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private MySession mySession;
	

	@PostMapping (consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	public OrderModel add(@RequestBody OrderModel orderModel){
		System.out.println(orderModel); // 022-222-2222
		Customer customer =customerDAO.findByPhone(orderModel.getCustomer().getPhone());
		
		if(customer==null){
			
		}else{
			orderModel.setCustomer(customer);
		}
		return this.orderDAO.save(orderModel);
	}
	
	@GetMapping(path="/{username}",produces = MediaType.APPLICATION_XML_VALUE)
	public List<OrderModel> findAllByUsername(@PathVariable(name="username") String username){
			return orderDAO.findAllByUsername(username);
	} 
	
	  
}
