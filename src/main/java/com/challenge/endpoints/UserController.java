package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public User save(@PathVariable("id") Long userId) {
        return this.userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    
    @GetMapping
    public List<User> findAll(
            @RequestParam(value = "accelerationName", required = false, defaultValue = "") String accelerationName,
            @RequestParam(value = "companyId", required = false, defaultValue = "0") Long companyId) {
        if (companyId != 0) {
            return this.userService.findByCompanyId(companyId);
        }
        return this.userService.findByAccelerationName(accelerationName);
    }
    
}
