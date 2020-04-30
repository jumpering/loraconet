package com.jumpering.loraconet.dao;

import com.jumpering.loraconet.dto.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByName(String name);

    UserEntity findByMail(String mail);

    Optional<UserEntity> findById(int id);

    void deleteById(int id);

//    @Query(value = "Select * from raconet where mail > :mail", nativeQuery = true)
//    Iterable<UserEntity> priceUpperTo(String mail);//ejemplo con Query propia
}
