package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.OrderTileDto;
import com.albertsonspoc.UserShop.exception.ActionFailureException;
import com.albertsonspoc.UserShop.services.OrderService;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public void placeOrder(@RequestParam("userName") String userName) throws ActionFailureException {
        orderService.placeOrder(userName);
    }

    @GetMapping("/order")
    public ResponseEntity<Response<OrderTileDto>> getAllOrders(@RequestParam("userName") String userName) throws ActionFailureException {
        Response<OrderTileDto> response = new Response<>();
        response.setData(orderService.findUserOrders(userName));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
