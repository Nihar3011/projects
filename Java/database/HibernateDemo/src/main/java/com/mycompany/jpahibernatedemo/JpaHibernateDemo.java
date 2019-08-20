package com.mycompany.jpahibernatedemo;

import com.mycompany.controller.GreetingsController;

/**
 *
 * @author nihar
 */
public class JpaHibernateDemo {
    public static void main(String[] args) {
        GreetingsController greetingsController = new GreetingsController();
       greetingsController.createHelloWorld();
       // greetingsController.getHelloWorldById(1);
    }
}
