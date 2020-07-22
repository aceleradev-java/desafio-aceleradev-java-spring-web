package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public User save(@PathVariable("id") Long userId) {
        return this.userService.findById(userId).get();
    }
    
    @GetMapping("/acceleration/{name}")
    public List<User> findByAccelerationName(@PathVariable("name") String accelerationName) {
        return this.userService.findByAccelerationName(accelerationName);
    }
    
    @GetMapping("/company/{id}")
    public List<User> findByCompanyId(@PathVariable("id") Long companyId) {
        return this.userService.findByCompanyId(companyId);
    }

}
