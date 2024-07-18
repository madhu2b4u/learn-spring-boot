package org.learnspringboot.users.service;

import org.learnspringboot.users.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Madhu", LocalDate.now().minusYears(5)));
        users.add(new User(2, "Kalyan", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Yunay", LocalDate.now().minusYears(30)));
        users.add(new User(4, "Priya", LocalDate.now().plusYears(5)));
    }

    public List<User> getUsers() {
        return users;
    }

    public User saveUser(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.remove(predicate);
    }

}
