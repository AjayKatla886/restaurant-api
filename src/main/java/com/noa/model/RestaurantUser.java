package com.noa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity
public class RestaurantUser {
	 @Id
	    @Email(message = "Invalid email format")
	    private String email;

	    @NotBlank(message = "Name is required")
	    private String name;

	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
	    private String phone;

    public RestaurantUser() {}

    public RestaurantUser(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
