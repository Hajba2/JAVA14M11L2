package org.example;

import java.util.Optional;

public class NpeTest {

    public static void main(String[] args) {

        Optional<String> nameEmpty = getNameFromOtherApplication(3);
        Optional<String> namePresent = getNameFromOtherApplication(2);
        //String s = name.get();

        System.out.println("nameEmpty.isPresent() = " + nameEmpty.isPresent());
        System.out.println("namePresent.isPresent() = " + namePresent.isPresent());

        System.out.println("nameEmpty.isEmpty() = " + nameEmpty.isEmpty());
        System.out.println("namePresent.isEmpty() = " + namePresent.isEmpty());

        System.out.println("namePresent.get() = " + namePresent.get());

        System.out.println("nameEmpty.orElse(\"defaultStr\") = " + nameEmpty.orElse("defaultStr"));
        System.out.println("namePresent.orElse(\"defaultStr\") = " + namePresent.orElse("defaultStr"));

        System.out.println();

        nameEmpty.ifPresent(System.out::println);
        namePresent.ifPresent(System.out::println);

        System.out.println();

        nameEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("there is no value"));
        namePresent.ifPresentOrElse(System.out::println, () -> System.out.println("there is no value"));

        System.out.println();

        System.out.println("nameEmpty.orElseGet(() -> getNameFromOtherApplication(2).get()) = " +
                nameEmpty.orElseGet(() -> getNameFromOtherApplication(2).get()));
        System.out.println("namePresent.orElseGet(() -> getNameFromOtherApplication(2).get()) = " +
                namePresent.orElseGet(() -> getNameFromOtherApplication(2).get()));

        System.out.println();

        System.out.println("namePresent.flatMap((str) -> {\n            return Optional.of(new Human(str));\n        }).get() = " + namePresent.flatMap((str) -> {
            return Optional.of(new Human(str));
        }).get());

        System.out.println();
        //String s = nameEmpty.orElseThrow(() -> new ArrayIndexOutOfBoundsException());

        if (nameEmpty.isPresent()) {
            System.out.println(nameEmpty.get());
        }

        nameEmpty.ifPresent((str) -> System.out.println(str));



        //System.out.println(s);

//        if(name != null) {
//            System.out.println(name.toUpperCase());
//        }

    }

    public static Optional<String> getNameFromOtherApplication(int i) {
        if (i % 2 == 0) {
            return Optional.of("Goga");
        } else {
            return Optional.empty();
        }
    }
}
