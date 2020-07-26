package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.mappers.CandidateMapperImpl;
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
    public List<CandidateDTO> findBy(
            @RequestParam(name = "accelerationId", required = true, defaultValue = "0")Long accelerationId,
            @RequestParam(name = "companyId", required = true, defaultValue = "0")Long companyId) {
        List<Candidate> candidates;
        CandidateMapperImpl mapper = new CandidateMapperImpl();
        if (accelerationId != 0) {
            candidates = candidateService.findByAccelerationId(accelerationId);
            return mapper.map(candidates);
        }
        candidates = candidateService.findByCompanyId(companyId);
        if (candidates.isEmpty()) {
            throw new ResourceNotFoundException("Candidate not found");
        }
        return mapper.map(candidates);
    }
    
}
