/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author nihar
 */
public class SwimCoach implements Coach {

    private final FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Value("${team.id}")
    private String id;
    
    @Value("${team.name}")
    private String name;
    
    @Value("${team.email}")
    private String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    

    @Override
    public String getDailyWorkout() {
        return "Swim 10 km every day! ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
