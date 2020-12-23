package moving;

import moving.domain.*;

public class Main {

    public static void main(String[] args) {
        // test your program here
        Box box = new Box(100);
        Item item = new Item("a", 10);
        if (box.addThing(item)) {
            System.out.println("added");
        } else {
            System.out.println("not added");
        }
    }
}
