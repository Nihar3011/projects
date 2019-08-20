package com.mvc.jpademo.main;

import com.mvc.jpademo.controller.GreetingsController;

/**
 *
 * @author nihar
 */
public class DemoApp {
    public static void main(String[] args) {
       GreetingsController greetingsController = new GreetingsController();
       greetingsController.createHelloWorld();
       JPAUtil.shutdown();
    }
}
