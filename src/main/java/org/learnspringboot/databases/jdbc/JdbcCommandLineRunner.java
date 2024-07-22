package org.learnspringboot.databases.jdbc;

import org.learnspringboot.databases.jdbc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
       /* repository.insert(new Course(1,"Learn AWS","Madhu"));
        repository.insert(new Course(2,"Learn Auzre","Madhu"));
        repository.insert(new Course(3,"Learn AI","Madhu"));
        repository.insert(new Course(4,"Learn Android","Madhu"));
        repository.deleteById(1);
        System.out.println(repository.getCourseById(2));
        System.out.println(repository.getCourseById(3));*/
    }
}
