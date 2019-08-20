/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author nihar
 */
public class ArgusMainConfig1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        System.out.println("Id  Name  Email");
        System.out.println(coach.getId() + coach.getName() + coach.getEmail());
        
        context.close();
    }

}
