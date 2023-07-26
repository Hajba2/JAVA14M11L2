package org.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();

        add("John", "john.smith@gmail.com");
        add("Ivan", "Ivan.Smith@google.com");
    }

    public User add(String name, String email) {
        User u = new User(name, email);
        users.add(u);
        return u;
    }

    public User search(String searchBy) {
        for (User u : users) {
            if (u.getEmail().toLowerCase().contains(searchBy.toLowerCase())
                    || u.getName().toLowerCase().contains(searchBy.toLowerCase())) {
                return u;
            }
        }
        return null;
    }

    public Optional<User> searchOpt(String searchBy) {
        return users.stream()
                .filter(u -> u.getEmail().toLowerCase().contains(searchBy.toLowerCase())
                        || u.getName().toLowerCase().contains(searchBy.toLowerCase()))
                .findFirst();
    }
}
