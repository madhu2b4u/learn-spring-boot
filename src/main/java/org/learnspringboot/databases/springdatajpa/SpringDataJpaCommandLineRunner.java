package org.learnspringboot.databases.springdatajpa;

import jakarta.transaction.Transactional;
import org.learnspringboot.databases.jdbc.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*

@Component
@Transactional
public class SpringDataJpaCommandLineRunner implements CommandLineRunner {


    @Autowired
    private SpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn AWS in Spring DATA JPA","Madhu"));
        repository.save(new Course(2,"Learn Auzre in Spring DATA","Madhu"));
        repository.save(new Course(3,"Learn AI in Spring DATA","Madhu"));
        repository.save(new Course(4,"Learn Android in Spring DATA","Madhu"));
        repository.deleteById(1L);
        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        System.out.println(repository.findByAuthor("Madhu"));
    }
}
*/
