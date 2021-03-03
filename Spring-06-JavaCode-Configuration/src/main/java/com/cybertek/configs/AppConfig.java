package com.ticketing.configs;

import com.ticketing.interfaces.ExtraSessions;
import com.ticketing.services.Java;
import com.ticketing.services.OfficeHours;
import com.ticketing.services.Selenium;
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
