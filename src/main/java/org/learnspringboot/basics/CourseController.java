package org.learnspringboot.basics;


import org.learnspringboot.basics.model.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1,"Learn AWS", "Madhu"),
                new Course(2,"Learn DevOps", "Madhu"),
                new Course(3,"Learn Azure", "Madhu"),
                new Course(4,"Learn DotNet", "Madhu"),
                new Course(5,"Learn Android", "Madhu")
        );
    }

}
