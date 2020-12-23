
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
        Suitcase suitcase;
        Thing thing;
        
        for (int i = 0; i < 100; i++) {
            thing = new Thing("Brick", i+1);
            suitcase = new Suitcase(100);
            suitcase.addThing(thing);
            container.addSuitcase(suitcase);
        }
        
    }
}
