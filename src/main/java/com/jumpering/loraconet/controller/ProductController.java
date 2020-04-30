package com.jumpering.loraconet.controller;

import com.jumpering.loraconet.dto.ProductEntity;
import com.jumpering.loraconet.dto.UserEntity;
import com.jumpering.loraconet.exceptions.NameException;
import com.jumpering.loraconet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProductController
{
    @Autowired
    ProductService productService;

//DEMO
//    @GetMapping(path = "/")
//    public String index(@RequestParam(value = "varEnUrl", required = false, defaultValue = "World") String miString, Model model) {
//        model.addAttribute("datos",miString);
//        return "index";
//    }

    @GetMapping(path = "/")
    public String index( Model model ) throws Exception {
        //Iterable<ProductEntity> list = productService.showProducts();
        ProductEntity product = productService.findByName("pitet");
        //Iterable<ProductEntity> listUpperAt = productService.findUpperAt(7.0);
        model.addAttribute("datos", product);
        return "index";
    }

    @ExceptionHandler
    protected String handleEntityNotFound(NameException e, Model model) {
        model.addAttribute("datos", e.getMessage());
        return "error";
    }
}
