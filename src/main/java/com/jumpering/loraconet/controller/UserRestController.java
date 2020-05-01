package com.jumpering.loraconet.controller;

import com.jumpering.loraconet.dto.UserEntity;
import com.jumpering.loraconet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/showusers")
    public List<UserEntity> showUsers(){
        return (List<UserEntity>) userService.showUsers();
    }

    @GetMapping(value = "/showuser/{id}")
    public Optional<UserEntity> showUser(@PathVariable int id) throws Exception {
        return userService.findById(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity){
        UserEntity obj = userService.saveUser(userEntity);
        return new ResponseEntity<UserEntity>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<UserEntity> delete(@PathVariable int id) throws Exception {
        Optional<UserEntity> user = userService.findById(id);
        if (user != null) {
            userService.deleteUserById(id);
        }else {
            return new ResponseEntity<UserEntity>(user.get(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<UserEntity>(user.get(), HttpStatus.OK);
    }
}
