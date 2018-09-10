package com.springbootrest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootrest.model.User;


@Service("userService")
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static {
        users = populateDummyUsers();
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findById(final long id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User findByName(String name) {
        return users.stream().filter(user -> user.getName() == name)
                .findFirst()
                .orElse(null);
    }

    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

    public void deleteAllUsers() {
        users.clear();
    }

    private static List<User> populateDummyUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(), "Alexandr", 30, 70000));
        users.add(new User(counter.incrementAndGet(), "Tom", 40, 50000));
        users.add(new User(counter.incrementAndGet(), "Jerome", 45, 30000));
        users.add(new User(counter.incrementAndGet(), "Silvia", 50, 40000));
        return users;
    }

}
