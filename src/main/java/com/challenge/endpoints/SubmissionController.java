package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Submission;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@RestController
@RequestMapping(value = "/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionService;
    
    @GetMapping("/challenge/{challengeId}/acceleration/{accelerationId}")
    public List<Submission> findByChallengeIdAndAccelerationId(
            @PathVariable("challengeId") Long challengeId, 
            @PathVariable("accelerationId")Long accelerationId
    ) {
        return this.submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
    
}
