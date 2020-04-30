package com.jumpering.loraconet.service;

import com.jumpering.loraconet.dao.UserRepository;
import com.jumpering.loraconet.dto.UserEntity;
import com.jumpering.loraconet.exceptions.NameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<UserEntity> showUsers() {
        return userRepository.findAll();
    }

    public UserEntity findByName(String name) throws Exception {
        if(name.isEmpty()){
            throw new NameException("El nombre está vacio");
        }
        return userRepository.findByName(name);
    }

    public Optional<UserEntity> findById(int id) throws Exception {
        return userRepository.findById(id);
    }

    public UserEntity findByMail (String mail) throws Exception {
        if (mail.isEmpty()) {
            throw new Exception("El campo mail no puede estar vacio");
        }
        return userRepository.findByMail(mail);
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }

}
