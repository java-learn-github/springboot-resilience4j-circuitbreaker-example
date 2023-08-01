package com.example.inquire.service;

import com.example.inquire.model.Product;
import com.example.inquire.util.InqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InqServiceImpl implements InqService {

    @Autowired
    InqUtil inqUtil;

    @Override
    public List<Product> getAllProducts() {
        return inqUtil.productByProductService();
    }
}
