package lab7.lab7.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import lab7.lab7.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{}

