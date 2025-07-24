package com.noa.service;

import com.noa.model.RestaurantUser;
import com.noa.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repo;

    public RestaurantUser registerUser(RestaurantUser user) {
        return repo.save(user);
    }

    public List<RestaurantUser> getAllUsers() {
        return repo.findAll();
    }

    public boolean loginUser(String email, String phone) {
        return repo.findByEmailAndPhone(email, phone).isPresent();
    }

    public Optional<RestaurantUser> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public boolean deleteUser(String email) {
        Optional<RestaurantUser> existing = repo.findByEmail(email);
        if (existing.isPresent()) {
            repo.deleteByEmail(email);
            return true;
        }
        return false;
    }

    public boolean updateUser(String email, String name, String phone) {
        Optional<RestaurantUser> optionalUser = repo.findByEmail(email);
        if (optionalUser.isPresent()) {
            RestaurantUser user = optionalUser.get();
            user.setName(name);
            user.setPhone(phone);
            repo.save(user);
            return true;
        }
        return false;
    }
}

