package br.com.exactalabs.bicycleshop.controller;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable Long id){
        return this.productService.findProductById(id);
    }


}
