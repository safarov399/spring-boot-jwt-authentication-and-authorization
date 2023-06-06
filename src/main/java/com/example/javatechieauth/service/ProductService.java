package com.example.javatechieauth.service;

import com.example.javatechieauth.dto.Product;
import com.example.javatechieauth.entity.UserInfo;
import com.example.javatechieauth.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoRepository repository;

    List<Product> list = new ArrayList<>();

    @PostConstruct
    public void fillList() {
        for (int i = 0; i < 100; i++) {
            list.add(new Product(i, i * 3, "Product " + i));
        }
    }

    public List<Product> getProducts() {
        return list;
    }

    public Product getById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void save(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

}
