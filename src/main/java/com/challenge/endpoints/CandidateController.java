package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Candidate;
import com.challenge.service.interfaces.CandidateServiceInterface;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateService;
    
    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<Candidate> findById(
            @PathVariable(value = "userId") Long userId,
            @PathVariable(value = "companyId") Long companyId,
            @PathVariable(value = "accelerationId") Long accelerationId) {
        return ResponseEntity.ok()
                .body(candidateService.findById(userId, companyId, accelerationId)
                        .orElse(new Candidate()));
    }
    
    @GetMapping
    public List<Candidate> findBy(
            @RequestParam(name = "accelerationId", required = true, defaultValue = "0")Long accelerationId,
            @RequestParam(name = "companyId", required = true, defaultValue = "0")Long companyId) {
        if (accelerationId != 0) {
            return this.candidateService.findByAccelerationId(accelerationId);
        }
        return this.candidateService.findByCompanyId(companyId);
    }
    
}
