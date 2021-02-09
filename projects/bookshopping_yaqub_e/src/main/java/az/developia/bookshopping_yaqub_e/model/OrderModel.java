package az.developia.bookshopping_yaqub_e.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bookName;
	private Integer bookCount;
	private String username;
	private String fullName;
	private String address;
	private String phone;
	
	
	@CreationTimestamp
	private Timestamp register;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private List<BasketBook> basketBooks;

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public Integer getBookCount() {
		return bookCount;
	}



	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Timestamp getRegister() {
		return register;
	}



	public void setRegister(Timestamp register) {
		this.register = register;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public List<BasketBook> getBasketBooks() {
		return basketBooks;
	}



	public void setBasketBooks(List<BasketBook> basketBooks) {
		this.basketBooks = basketBooks;
	}



	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", bookName=" +bookName+", bookCount=" +bookCount+", username=" + username
				+ ",fullName=" +fullName+",address=" +address+",phone=" +phone+", register=" + register + ", customer=" + customer + ", basketBooks=" + basketBooks + "]";
	}
	

}
