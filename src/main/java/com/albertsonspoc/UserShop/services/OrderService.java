package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.dto.OrderTileDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Order;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.CartRepository;
import com.albertsonspoc.UserShop.repositories.OrderRepository;
import com.albertsonspoc.UserShop.repositories.ProductRepository;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public void placeOrder(String userName) throws ActionFailureException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("Username not found"));
        List<Cart> cartList = cartRepository.findByUser(user).stream().filter((e) -> !e.getOrderPlaced()).collect(Collectors.toList());
        if (cartList.size() == 0) throw new ActionFailureException("Cart empty");
        for (Cart cart : cartList) {
            //create order for each product
            Order order = new Order();
            order.setOrderId("#" + new Date().getTime());
            order.setAddress(user.getAddress());
            order.setProduct(cart.getProduct());
            order.setPricePerUnit(cart.getProduct().getPricePerUnit());
            if (cart.getProduct().getStock() < cart.getQuantity()) {
                throw new ActionFailureException("Out of stock");
            }
            order.setQuantity(cart.getQuantity());
            order.setUser(user);
            order.setOrderStatus("PROCESSING");
            orderRepository.save(order);
            cart.setOrderPlaced(true);
            cartRepository.save(cart);
            Product product = cart.getProduct();
            product.setStock(product.getStock() - order.getQuantity());
            productRepository.save(product);
        }

    }

    public List<OrderTileDto> findUserOrders(String userName) throws ActionFailureException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("Username not found"));
        List<Order> orders = orderRepository.findByUser(user);
        return orders.stream().map(order -> new OrderTileDto(order.getOrderId(), order.getProduct().getName(),
                order.getProduct().getId(), order.getProduct().getImageUrl(), order.getQuantity(), order.getQuantity() * order.getPricePerUnit(), order.getPricePerUnit(), order.getOrderStatus(), order.getModifiedAt(), order.getAddress()
        )).collect(Collectors.toList());
    }

}
