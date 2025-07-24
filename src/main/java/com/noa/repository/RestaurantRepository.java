package com.noa.repository;

import com.noa.model.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantUser, String> {
    Optional<RestaurantUser> findByEmailAndPhone(String email, String phone);
    Optional<RestaurantUser> findByEmail(String email);
    void deleteByEmail(String email);
}
