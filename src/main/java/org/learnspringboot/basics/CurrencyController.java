package org.learnspringboot.basics;


import org.learnspringboot.basics.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    private ServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public ServiceConfiguration retrieveAllCourses() {
        return configuration;
    }

}
