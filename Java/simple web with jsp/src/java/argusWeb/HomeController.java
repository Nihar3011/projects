/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nihar
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showPage(){
        return "main-menu";
    }
    
    @RequestMapping("/homePage")
    public String homePage(){
        return "main-menu";
    }
}
