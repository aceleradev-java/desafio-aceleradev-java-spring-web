package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Acceleration;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.interfaces.AccelerationServiceInterface;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationService;

    @GetMapping("/{id}")
    public Acceleration findById(@PathVariable("id") Long id) {
        return this.accelerationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Acceleration not found"));
    }

    @GetMapping
    public List<Acceleration> findByCompany(
            @RequestParam(name = "companyId", required = true, defaultValue = "0") @PathVariable("companyId") Long companyId) {
        if (companyId == 0) {
            return this.accelerationService.findAll();
        }
        return this.accelerationService.findByCompanyId(companyId);
    }

}
