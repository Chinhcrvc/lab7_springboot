package lab7.lab7.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab7.lab7.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{}
