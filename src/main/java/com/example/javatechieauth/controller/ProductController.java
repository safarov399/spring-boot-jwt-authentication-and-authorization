package com.example.javatechieauth.controller;

import com.example.javatechieauth.dto.Product;
import com.example.javatechieauth.entity.UserInfo;
import com.example.javatechieauth.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this endpoint is not secure";
    }


    @GetMapping("/{id}")
    public Product findByID(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> all() {
        return service.getProducts();
    }

    @PostMapping("/save")
    public void save(@RequestBody UserInfo user) {
        service.save(user);
    }

}
