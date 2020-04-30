package com.jumpering.loraconet.dao;

import com.jumpering.loraconet.dto.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    ProductEntity findByName(String name); //ejemplo findBy...

    @Query(value = "Select * from raconet where price > :price", nativeQuery = true)
    Iterable<ProductEntity> priceUpperTo(Double price);//ejemplo con Query propia
}
