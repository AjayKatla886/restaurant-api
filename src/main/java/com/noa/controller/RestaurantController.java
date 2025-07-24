package com.noa.controller;

import com.noa.model.RestaurantUser;
import com.noa.service.RestaurantService;
import com.noa.dto.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "APIs for user operations")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping("/register")
    @Operation(summary = "Register new user", description = "Registers a new user with name, email, and phone")
    public ResponseEntity<ResponseDTO<RestaurantUser>> registerUser(@Valid @RequestBody RestaurantUser user) {
        RestaurantUser savedUser = service.registerUser(user);
        return ResponseEntity.ok(new ResponseDTO<>("success", "User registered successfully", savedUser));
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<RestaurantUser>>> getAllUsers() {
        List<RestaurantUser> users = service.getAllUsers();
        return ResponseEntity.ok(new ResponseDTO<>("success", "User list fetched successfully", users));
    }

    @GetMapping("/test")
    public ResponseEntity<ResponseDTO<String>> testApi() {
        return ResponseEntity.ok(new ResponseDTO<>("success", "Swagger Test Success", "API is reachable"));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<String>> login(@RequestParam String email, @RequestParam String phone) {
        boolean success = service.loginUser(email, phone);
        if (success) {
            return ResponseEntity.ok(new ResponseDTO<>("success", "Login successful", null));
        } else {
            return ResponseEntity.status(401).body(new ResponseDTO<>("error", "Invalid credentials", null));
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseDTO<RestaurantUser>> getUser(@PathVariable String email) {
        Optional<RestaurantUser> user = service.findByEmail(email);
        return user.map(value -> ResponseEntity.ok(new ResponseDTO<>("success", "User found", value)))
                   .orElse(ResponseEntity.status(404).body(new ResponseDTO<>("error", "User not found", null)));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<ResponseDTO<String>> deleteUser(@PathVariable String email) {
        boolean deleted = service.deleteUser(email);
        if (deleted) {
            return ResponseEntity.ok(new ResponseDTO<>("success", "User deleted", null));
        } else {
            return ResponseEntity.status(404).body(new ResponseDTO<>("error", "User not found", null));
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<ResponseDTO<String>> updateUser(@PathVariable String email,
                                                          @RequestParam String name,
                                                          @RequestParam String phone) {
        boolean updated = service.updateUser(email, name, phone);
        if (updated) {
            return ResponseEntity.ok(new ResponseDTO<>("success", "User updated", null));
        } else {
            return ResponseEntity.status(404).body(new ResponseDTO<>("error", "User not found", null));
        }
    }
}
