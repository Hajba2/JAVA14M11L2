package org.example.user;

import java.util.Optional;

public class UserServiceTest {

    public static void main(String[] args) {
        UserService userService = new UserService();

        User john = userService.search("john");

        User java = userService.search("java");

        Optional<User> john1 = userService.searchOpt("john");
        Optional<User> java1 = userService.searchOpt("java");

        User abcUser = java1.orElseGet(() -> {
            //requesting data from other app
            return new User("abc User", "abc.user@domain.com");
        });

        john1.ifPresentOrElse((u) -> {
                    //make request to anatic app that user found
                    System.out.println("user founded " + u);
                },
                () -> {
                    //make request to anatic app that user not found
                    System.out.println("user not founded");
                });


        System.out.println();
    }
}
