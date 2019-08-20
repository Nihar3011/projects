/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusWeb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author nihar
 */
@Controller
public class FormController {
    
    @RequestMapping("/showForm")
    public String showForm(Model model){
        
        Login login=new Login();
        
        model.addAttribute("login",login); 
        
        return "form";
    }
    
    @RequestMapping("/formData")
    public String formData(@ModelAttribute("login") Login login){
        
        System.out.println("Login"+login.getEmail() + login.getPassword());
        
        return "loginConfim";
    }
}
