package com.challenge.endpoints;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.interfaces.CompanyServiceInterface;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyServiceInterface companyService;

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id) {
        return this.companyService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Company not found"));
    }

    @GetMapping
    public Set<Company> findBy(
            @RequestParam(value = "accelerationId", required = false, defaultValue = "0") Long accelerationId,
            @RequestParam(value = "userId", required = false, defaultValue = "0") Long userId
            ) {
        Set<Company> companies = new HashSet<>();
        if (accelerationId != 0) {
            companies.addAll(this.companyService.findByAccelerationId(accelerationId));
            return companies;
        }
        companies.addAll(this.companyService.findByUserId(userId));
        return companies;
    }

}
