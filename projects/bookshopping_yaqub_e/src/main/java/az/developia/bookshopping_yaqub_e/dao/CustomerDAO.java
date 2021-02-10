package az.developia.bookshopping_yaqub_e.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping_yaqub_e.model.Customer;


public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	public  Customer  findByPhone(String phone);
}
