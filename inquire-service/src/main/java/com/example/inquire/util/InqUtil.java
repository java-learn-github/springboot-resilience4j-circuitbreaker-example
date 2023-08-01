package com.example.inquire.util;

import com.example.inquire.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class InqUtil {

    public static final String DOWNSTREAM_INTERFACE_CALL = "productservice";
    @Autowired
    RestTemplate restTemplate;

    //    @Retry(name = DOWNSTREAM_INTERFACE_CALL, fallbackMethod = "callFallBack")
    @CircuitBreaker(name = DOWNSTREAM_INTERFACE_CALL, fallbackMethod = "callFallBack")
    public List<Product> productByProductService() {
        return restTemplate.getForObject("http://localhost:8086/products", List.class);
    }

    public List<Product> callFallBack(Throwable throwable) {
        log.error(throwable.getMessage());
        log.info("FallBack Method Called");
        return Arrays.asList((new Product(1, "Dummy_product")));
    }


}
