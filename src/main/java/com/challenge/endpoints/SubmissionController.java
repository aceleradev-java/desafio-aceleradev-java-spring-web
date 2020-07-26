package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Submission;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.mappers.SubmissionMapperImpl;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping(value = "/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionService;
    
    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findById(
            @RequestParam(value = "challengeId", required = true, defaultValue = "0") Long challengeId,
            @RequestParam(value = "accelerationId", required = true, defaultValue = "0") Long accelerationId) {

        List<Submission> submissions = submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
        SubmissionMapper mapper = new SubmissionMapperImpl();
        if (submissions.isEmpty()) {
            throw new ResourceNotFoundException("Submission not found");
        }
        return ResponseEntity.ok().body(mapper.map(submissions));
    }
    
}
