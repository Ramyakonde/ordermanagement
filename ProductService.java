package com.orderManagement.services;

import com.orderManagement.dto.ProductDto;
import com.orderManagement.mapper.ProductMapper;
import com.orderManagement.model.CustomerModel;
import com.orderManagement.model.ProductModel;
import com.orderManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDto getProduct(long productId) {
        Optional<ProductModel> productModel = productRepository.findById(productId);
       return  ProductMapper.modelToDto(productModel.get());

    }
    public void createProduct(ProductDto productDto) {
      ProductModel productModel = ProductMapper.dtoToModel(productDto);
      productRepository.save(productModel);
    }
    public void updateProduct(ProductDto product) {
        ProductModel productModel = ProductMapper.dtoToModel(product);
        Optional<ProductModel> existingProduct = productRepository.findById(product.getProductId());
        if(existingProduct.isPresent()){
                       ProductModel productModel1 = existingProduct.get();
                       ProductModel model = existingProduct.get();
                         model.setProductId(productModel.getProductId());
                         model.setProductName(productModel.getProductName());
                         model.setProductDescription(productModel.getProductDescription());
                         model.setProductPrice(productModel.getProductPrice());
                         model.setProductQuantity(productModel.getProductQuantity());
            productRepository.save(model);
        }else{
            productRepository.save(productModel);
        }
    }
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    public List<ProductDto> getAllProducts() {
      List<ProductModel> productModels = productRepository.findAll();
      return productModels.stream().map(productModel ->ProductMapper.modelToDto(productModel)).collect(Collectors.toList());

    }
}
