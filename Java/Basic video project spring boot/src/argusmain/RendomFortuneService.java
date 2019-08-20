/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import java.util.Random;
import org.springframework.stereotype.Component;

/**
 *
 * @author nihar
 */
@Component
public class RendomFortuneService implements FortuneService{

    private String[] data={
                        "Stay Alert!!",
                          "Nice Shot",
                          "You are good in this.."
    };
    
    private Random  myRandom =new Random();
    
    @Override
    public String getFortune() {
        int index=myRandom.nextInt(data.length);
        return data[index];
    }
    
}
