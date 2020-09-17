package br.com.exactalabs.bicycleshop.service;


import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;

    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository){
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public Product saveProduct(Product product) {
        this.productCategoryRepository.save(product.getProductCategory());
        return this.productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Collection<Product> findProductByPriceAsc() {
        return this.productRepository.findProductByPriceAsc();
    }

    public Collection<Product> findProductByPriceDesc() {
        return this.productRepository.findProductByPriceDesc();
    }

    public Collection<Product> findProductByName(String name){
        return this.productRepository.findProductByName(name);
    }

    public Collection<Product> findProductByCategory(String name){
        return this.productRepository.findProductByCategory(name);
    }



}
