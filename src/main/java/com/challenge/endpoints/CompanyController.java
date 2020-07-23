package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyServiceInterface companyService;

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return this.companyService.findById(id).get();
    }

    @GetMapping("/acceleration/{accelerationId}")
    public List<Company> findByAccelerationId(@PathVariable("accelerationId") Long accelerationId) {
        return this.companyService.findByAccelerationId(accelerationId);
    }
    
    @GetMapping("/user/{userId}")
    public List<Company> finByUserId(@PathVariable("userId") Long userId) {
        return this.companyService.findByUserId(userId);
    }

}
