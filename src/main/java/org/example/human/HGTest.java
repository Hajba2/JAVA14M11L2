package org.example.human;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HGTest {

    public static void main(String[] args) {
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> generate = hg.generate(30);

        Comparator<Human> humanComparator = Comparator
                .comparing(Human::getName)
                .reversed()
                .thenComparing(Human::getSalary);

        Comparator<Human> humanComparatorHand1 = (Human h1, Human h2) -> h2.getName().compareTo(h1.getName());
        Comparator<Human> humanComparatorHand2 = humanComparatorHand1.thenComparing(Human::getSalary);

        List<Human> collect = generate.stream()
                .sorted()
                .collect(Collectors.toList());

        for (Human h : collect) {
            System.out.println(h);
        }


    }


}
