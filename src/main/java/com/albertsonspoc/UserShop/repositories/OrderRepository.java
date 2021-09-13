package com.albertsonspoc.UserShop.repositories;

import com.albertsonspoc.UserShop.models.Order;
import com.albertsonspoc.UserShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Orders o WHERE o.user = ?1 ORDER BY o.modifiedAt DESC")
    public List<Order> findByUser(User user);

}
