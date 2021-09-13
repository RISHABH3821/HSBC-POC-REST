package com.albertsonspoc.UserShop.controllers;

import com.albertsonspoc.UserShop.dto.ProductDetailDto;
import com.albertsonspoc.UserShop.dto.ProductTileDto;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.services.ProductService;
import domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping()
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Response<ProductTileDto>> getAllProducts(){
        Response<ProductTileDto> response = new Response<>();
        response.setData(productService.getAllProducts());
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Response<ProductDetailDto>> getProduct(@PathVariable int id){
        Response<ProductDetailDto> response = new Response<>();
        response.setData(Collections.singletonList(productService.getProduct(id)));
        response.setSuccessMessage("Success");
        response.setStatusCode("Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
