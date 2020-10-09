package br.com.exactalabs.bicycleshop.controller;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> findAllProducts(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProducts(pageNumber).getContent();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/product/")
    public ResponseEntity<Product> findProductById(@RequestParam(value = "id") Long id){
        var product = this.productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/name/")
    public ResponseEntity<List<Product>> findProductByName(
            @RequestParam(value = "productName") String name,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProductsByName(name, pageNumber).getContent();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/product/priceAsc/")
    public ResponseEntity<List<Product>> findProductByPriceAsc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber) {
        var productList = this.productService.findAllProductByPriceAsc(pageNumber).getContent();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/product/priceDesc/")
    public ResponseEntity<List<Product>> findProductByPriceDesc(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber){
        var productList = this.productService.findAllProductByPriceDesc(pageNumber).getContent();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        var newProduct = this.productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/product/")
    public ResponseEntity<Product> updateProduct(@RequestParam Long id, @RequestBody Product product){
        if (! (this.productService.existsById(id))) {
            return ResponseEntity.noContent().build();
        }
        var productToUpdate = this.productService.updateProduct(id, product);
        return ResponseEntity.ok(productToUpdate);
    }

    @DeleteMapping("/product/")
    public ResponseEntity<Product> deleteProductById(@RequestParam(value = "id") Long id){
        if (! (this.productService.existsById(id)) ){
            return ResponseEntity.notFound().build();
        }
        this.productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

}
