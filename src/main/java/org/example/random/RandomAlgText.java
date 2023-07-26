package org.example.random;

public class RandomAlgText {

    public static void main(String[] args) {
        RandomAlg randomAlg = new RandomAlg();
        randomAlg.withSeed(34544);

        for (int i = 0; i < 10; i++) {
            System.out.println("randomAlg.next() = " + randomAlg.next());
        }
    }
}
