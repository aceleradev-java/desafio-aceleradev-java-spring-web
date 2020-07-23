package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeService;
    
    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserIs(
            @RequestParam(value = "accelerationId") Long accelerationId, 
            @RequestParam(value = "userId") Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }
    
}
