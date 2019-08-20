/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author nihar
 */
public class ArgusMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("argusData.xml");

        Coach coach = context.getBean("carromCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }

}
