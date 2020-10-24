package com.cybertek.configs;

import com.cybertek.interfaces.ExtraSessions;
import com.cybertek.services.Java;
import com.cybertek.services.OfficeHours;
import com.cybertek.services.Selenium;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cybertek")
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public Java java(){
        return new Java(extraSessions());
    }

    @Bean
    public Selenium selenium(){
        return new Selenium();
    }
  /*
    @Bean
    public OfficeHours officeHours(){
        return new OfficeHours();
    }

   */

    @Bean
    public ExtraSessions extraSessions(){
        return new OfficeHours();
    }

}
