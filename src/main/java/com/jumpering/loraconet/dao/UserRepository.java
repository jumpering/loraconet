package com.jumpering.loraconet.dao;

import com.jumpering.loraconet.dto.ProductEntity;
import com.jumpering.loraconet.dto.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByName(String name); //ejemplo findBy...

    UserEntity findByMail(String mail);

//    @Query(value = "Select * from raconet where mail > :mail", nativeQuery = true)
//    Iterable<UserEntity> priceUpperTo(String mail);//ejemplo con Query propia
}
