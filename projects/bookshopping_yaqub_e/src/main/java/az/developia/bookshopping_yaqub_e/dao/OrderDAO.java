package az.developia.bookshopping_yaqub_e.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping_yaqub_e.model.OrderModel;

public interface OrderDAO extends JpaRepository<OrderModel, Integer>{

}
