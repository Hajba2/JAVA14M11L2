package org.example.random;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomAlgStream {

    public static void main(String[] args) {
        RandomAlg randomAlg = new RandomAlg();


        Stream<Integer> integerStream = Stream.iterate(5895156, (seed) -> randomAlg.withSeed(seed).next());

        integerStream
                .peek(System.out::println)
                .limit(55)
                .collect(Collectors.toList());


    }
}
