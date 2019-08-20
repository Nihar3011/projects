/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package argusmain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author nihar
 */

@Configuration
@PropertySource("classpath:teamData.properties")
public class Config1 {
    
    @Bean
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }
    
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService());
    }
}
