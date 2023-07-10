package com.orderManagement.controller;

import com.orderManagement.dto.ProductDto;
import com.orderManagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product/getAll")
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();

    }
    @GetMapping("/product/get")
     public ProductDto getProduct(@RequestParam("productId") long productId) {
        productService.getProduct(productId);
        return new ProductDto();
     }
    @PostMapping("/product/create")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
         productService.createProduct(productDto);
       return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
    }
    @PutMapping("/product/update")
    public ProductDto updateProduct(@RequestBody ProductDto product) {
        productService.updateProduct(product);
        return new ProductDto();
    }
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return "product is delete";
     }

}
