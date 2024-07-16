package org.learnspringboot;


import org.learnspringboot.config.ServiceConfiguration;
import org.learnspringboot.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyController {

    @Autowired
    private ServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public ServiceConfiguration retrieveAllCourses() {
        return configuration;
    }

}
