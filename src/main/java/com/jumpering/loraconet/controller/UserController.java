package com.jumpering.loraconet.controller;

import com.jumpering.loraconet.dto.UserEntity;
import com.jumpering.loraconet.exceptions.NameException;
import com.jumpering.loraconet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping (path = "/showusers")
    public String showUsers( Model model ) {
        Iterable<UserEntity> list = userService.showUsers();
        model.addAttribute("users", list);
        return "showusers";
    }

    @GetMapping(path = "/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserEntity());
        return "userform";
    }

    @PostMapping(path = "/save")
    public String save(@Valid UserEntity user, Model model){
        userService.saveUser(user);
        return "redirect:/showusers";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        userService.deleteUserById(id);
        return "redirect:/showusers";
    }

    @GetMapping(path = "/modify/{id}")
    public String modify(@PathVariable int id, Model model) throws Exception {
        Optional<UserEntity> user = userService.findById(id);
        model.addAttribute("user", user);
        return "userform";
    }
    @ExceptionHandler
    protected String handleEntityNotFound(NameException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }

    //    @GetMapping(path = "/adduser")
//    public String addUser(@RequestParam("id") Integer id,
//                          @RequestParam("name")String name,
//                          @RequestParam("password") String password,
//                          @RequestParam("mail") String mail,
//                          Model model) throws Exception {
//        UserEntity add = new UserEntity();
//        add.setId(id);
//        add.setName(name);
//        add.setPassword(password);
//        add.setMail(mail);
//        userService.saveUser(add);
//        return "adduser"; //http://localhost:8080/adduser?id=1&name=marteta&password=1234&mail=marta@marta.cat
//    }
}
