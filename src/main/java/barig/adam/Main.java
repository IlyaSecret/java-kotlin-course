package barig.adam;

import barig.adam.list.CustomLinkedList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomLinkedList<String> l = new CustomLinkedList<String>();
        l.add("dsadasd");
        l.add("andrey");

        CustomLinkedList<String> part2 = Stream.of("123", "Andrey", "Barigadey")
                .reduce(
                        new CustomLinkedList<String>(),
                        (list, el) -> {list.add(el); return list;},
                        (a, b) -> {return null;}
                );


        for (String s : part2) {
            System.out.println(s);
        }
    }
}
