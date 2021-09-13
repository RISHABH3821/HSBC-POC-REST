package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.CartCountChangeDto;
import com.albertsonspoc.UserShop.dto.CartDto;
import com.albertsonspoc.UserShop.dto.ProductTileDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.services.CartService;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public void addToCart(@RequestBody CartDto cartDto) throws ActionFailureException {
        cartService.addToCart(cartDto);
    }

    @GetMapping("/cart")
    public ResponseEntity<Response<CartDto>> getAllProducts(@RequestParam("userName") String userName) throws ActionFailureException {
        Response<CartDto> response = new Response<>();
        response.setData(cartService.fetchCart(userName));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/cart/change")
    public void changeCartCount(@RequestBody CartCountChangeDto changeDto) throws ActionFailureException {
        cartService.changeCount(changeDto);
    }

}
