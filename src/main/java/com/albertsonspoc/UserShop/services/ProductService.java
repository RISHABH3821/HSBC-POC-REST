package com.albertsonspoc.UserShop.services;

import com.albertsonspoc.UserShop.dto.ProductDetailDto;
import com.albertsonspoc.UserShop.dto.ProductTileDto;
import com.albertsonspoc.UserShop.models.Product;
import com.albertsonspoc.UserShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductTileDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().
                map((product -> new ProductTileDto(product.getId(), product.getName(), product.getPricePerUnit(), product.getImageUrl(), product.getOriginalPricePerUnit())))
                .collect(Collectors.toList());
    }

    public ProductDetailDto getProduct(int id){
        Product product = productRepository.findById(id).orElse(null);
        if(product==null) return null;
        return new ProductDetailDto(product.getId(), product.getName(), product.getDescription(), product.getPricePerUnit(), product.getImageUrl(), product.getOriginalPricePerUnit());
    }

}
