/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author nihar
 */
@Component
public class CarromCoach implements Coach{

    private FortuneService fortuneService;

    public CarromCoach() {
        System.out.println("CarromCoach:Hey I am in default constructor.");
    }

    @Autowired
    @Qualifier("rendomFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CarromCoach:Hey I am in setFortuneService method.");
        this.fortuneService = fortuneService;
    }
    
    
    
   //Using constructor injection 
//    @Autowired
//    public CarromCoach(FortuneService fortuneService) {
//      System.out.println("CarromCoach:Hey I am in CarromCoach constructor with parameter.");
//        this.fortuneService = fortuneService;
//    }
    
    @Override
    public String getDailyWorkout() {
        return "Let's play..";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

   @PostConstruct
   public void postCounstruct(){
       System.out.println("PostConstruct");
   }
   
   @PreDestroy
   public void preDestroy(){
       System.out.println("PreConstruct");
   }
   
    
}
