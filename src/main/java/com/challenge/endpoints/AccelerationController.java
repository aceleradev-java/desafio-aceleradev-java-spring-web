package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationService;

    @GetMapping
    public List<Acceleration> findAll() {
        return this.accelerationService.findAll();
    }

    @GetMapping("/{id}")
    public Acceleration findById(@PathVariable("id") Long id) {
        return this.accelerationService.findById(1l).get();

    }

    @GetMapping("/company/{companyId}")
    public List<Acceleration> findByCompany(@PathVariable("companyId") Long companyId) {
        return this.accelerationService.findByCompanyId(companyId);
    }

}
