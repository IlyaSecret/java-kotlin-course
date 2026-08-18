package barig.adam;

import barig.adam.list.CustomLinkedList;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomLinkedList<String> l = new CustomLinkedList<String>();
        l.add(null);
        l.add("andrey");
        System.out.println(l.size());
        System.out.println(l.contains("dasda"));
    }
}
