package com.example.inquire.controller;

import com.example.inquire.model.Product;
import com.example.inquire.service.InqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inquire")
@Slf4j
public class InqController {

    private InqService service;

    public InqController(InqService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        log.info("getAllProducts() enter");
        List<Product> allProducts = service.getAllProducts();
        log.info("getAllProducts() exit");
        return allProducts;
    }
}
