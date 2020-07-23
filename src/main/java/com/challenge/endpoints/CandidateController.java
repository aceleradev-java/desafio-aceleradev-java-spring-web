package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateService;
    
    @GetMapping("/user/{userId}/company/{companyId}/acceleration/{accelerationId}")
    public Candidate findById(
            @PathVariable("userId") Long userId,
            @PathVariable("companyId")Long companyId,
            @PathVariable("accelerationId") Long accelerationId) {
        return this.candidateService.findById(userId, companyId, accelerationId).get();
    }
    
    @GetMapping("/company/{companyId}")
    public List<Candidate> findByCompanyId(@PathVariable("companyId")Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }
    
    @GetMapping("/acceleration/{accelerationId}")
    public List<Candidate> findByAccelerationId(@PathVariable("accelerationId")Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }
    
}
