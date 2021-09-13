package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.dto.CartCountChangeDto;
import com.albertsonspoc.UserShop.dto.CartDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.models.Cart;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.models.User;
import com.albertsonspoc.UserShop.repositories.CartRepository;
import com.albertsonspoc.UserShop.repositories.ProductRepository;
import com.albertsonspoc.UserShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<CartDto> fetchCart(String userName) throws ActionFailureException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ActionFailureException("User not found"));
        List<Cart> cartList = cartRepository.findByUser(user);
        return cartList.stream().map((cart -> {
            float pricePerUnit = cart.getProduct().getPricePerUnit();
            return new CartDto(cart.getId(), cart.getProduct().getId(), cart.getUser().getUserName(), cart.getQuantity(),
                    pricePerUnit, cart.getProduct().getName(), cart.getProduct().getImageUrl());
        })).collect(Collectors.toList());
    }

    public void addToCart(CartDto cartDto) throws ActionFailureException {
        Product product = productRepository.findById(cartDto.getProductId()).orElseThrow(() -> new ActionFailureException("Product not found"));
        User user = userRepository.findByUserName(cartDto.getUserName()).orElseThrow(() -> new ActionFailureException("User not found"));
        Cart cart = cartRepository.findByProductAndUser(product, user).orElse(new Cart());
        if (product.getStock() < 1+cart.getQuantity()) throw new ActionFailureException("Not enough stock");
        cart.setUser(user);
        cart.setProduct(product);
        cart.setOrderPlaced(false);
        cart.setPricePerUnit(product.getPricePerUnit());
        cart.setQuantity(cart.getQuantity() + 1);
        cartRepository.save(cart);
    }

    public void changeCount(CartCountChangeDto changeDto) throws ActionFailureException {
        Cart cart = cartRepository.findById(changeDto.getId()).orElseThrow(() -> new ActionFailureException("Cart Item not found"));
        if (changeDto.isIncrement() && cart.getProduct().getStock() > cart.getQuantity()) {
            cart.setQuantity(cart.getQuantity() + 1);
        } else if(!changeDto.isIncrement()){
            cart.setQuantity(cart.getQuantity() - 1);
            if (cart.getQuantity() == 0) {
                // remove item from cart.
                cartRepository.delete(cart);
                return;
            }
        }
        cartRepository.save(cart);
    }

    public void updateCart() {

    }

}
