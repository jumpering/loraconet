package com.jumpering.loraconet.service;

import com.jumpering.loraconet.dao.ProductRepository;
import com.jumpering.loraconet.dto.ProductEntity;
import com.jumpering.loraconet.exceptions.NameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<ProductEntity> showProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findByName(String name) throws Exception {
        if(name.isEmpty()){
//            throw new Exception("El nombre está vacío");
            throw new NameException("El nombre está vacio");
        }
        return (ProductEntity) productRepository.findByName(name);
    }

    public Iterable<ProductEntity> findUpperAt (Double price) throws Exception {
        if (price < 0) {
            throw new Exception("El precio debe de ser mayor que 0");
        }
        return productRepository.priceUpperTo(price);
    }
}
