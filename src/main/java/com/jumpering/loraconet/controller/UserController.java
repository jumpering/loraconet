package com.jumpering.loraconet.controller;

import com.jumpering.loraconet.dto.UserEntity;
import com.jumpering.loraconet.exceptions.NameException;
import com.jumpering.loraconet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController
{
    @Autowired
    UserService userService;

//DEMO
//    @GetMapping(path = "/")
//    public String index(@RequestParam(value = "varEnUrl", required = false, defaultValue = "World") String miString, Model model) {
//        model.addAttribute("datos",miString);
//        return "index";
//    }

    @GetMapping(path = "/showusers")
    public String showUsers( Model model ) {
        Iterable<UserEntity> list = userService.showUsers();
        //ProductEntity product = productService.findByName("pitet");
        //Iterable<ProductEntity> listUpperAt = productService.findUpperAt(7.0);
        model.addAttribute("datos", list);
        return "showusers";
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
//
//        userService.saveUser(add);
//
//        //model.addAttribute("datos", add);
//        return "adduser"; //http://localhost:8080/adduser?id=1&name=marteta&password=1234&mail=marta@marta.cat
//    }

    @GetMapping(path = "/new")
    public String newUser(Model model){
        model.addAttribute("user", new UserEntity());
        return "adduserform";
    }

    @PostMapping(path = "/save")
    public String save(@Valid UserEntity user, Model model){
        userService.saveUser(user);
        return "redirect:/showusers";
    }

    @ExceptionHandler
    protected String handleEntityNotFound(NameException e, Model model) {
        model.addAttribute("datos", e.getMessage());
        return "error";
    }
}
