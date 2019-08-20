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
public class ArgusMainConfig {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
         
         Coach coach=context.getBean("carromCoach",Coach.class);
         
         System.out.println(coach.getDailyWorkout());
         
         System.out.println(coach.getDailyFortune());
         
         context.close(); 
    }
    
}
