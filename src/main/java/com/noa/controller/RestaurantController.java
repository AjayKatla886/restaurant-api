package com.noa.controller;

import com.noa.model.RestaurantUser;
import com.noa.service.RestaurantService;
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
    public RestaurantUser registerUser(@Valid @RequestBody RestaurantUser user) {
        return service.registerUser(user);
    }

    @GetMapping("/all")
    public List<RestaurantUser> getAllUsers() {
        return service.getAllUsers();
    }
    @GetMapping("/test")
    public String testApi() {
        return "Swagger Test Success";
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String phone) {
        boolean success = service.loginUser(email, phone);
        if (success) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<RestaurantUser> getUser(@PathVariable String email) {
        Optional<RestaurantUser> user = service.findByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        boolean deleted = service.deleteUser(email);
        return deleted ? ResponseEntity.ok("User deleted") : ResponseEntity.notFound().build();
    }

    @PutMapping("/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email,
                                             @RequestParam String name,
                                             @RequestParam String phone) {
        boolean updated = service.updateUser(email, name, phone);
        return updated ? ResponseEntity.ok("User updated") : ResponseEntity.notFound().build();
    }
}
