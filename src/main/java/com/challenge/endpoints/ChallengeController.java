package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeService;
    
    @GetMapping("/acceleration/{accelerationId}/user/{userId}")
    public List<Challenge> findByAccelerationIdAndUserIs(
            @PathVariable("accelerationId") Long accelerationId, 
            @PathVariable("userId") Long userId) {
        return this.challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
