package com.albertsonspoc.UserShop.repositories;

import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("Select c FROM Cart c WHERE c.orderPlaced = false AND c.product = ?1 AND c.user=?2")
    public Optional<Cart> findByProductAndUser(Product product, User user);

    @Query("Select c FROM Cart c WHERE c.user = ?1 AND c.orderPlaced = false")
    public List<Cart> findByUser(User user);
}
