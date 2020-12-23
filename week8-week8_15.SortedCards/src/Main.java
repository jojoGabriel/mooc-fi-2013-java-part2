
public class Main {

    public static void main(String[] args) {
        // write some test code here
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );
        
        System.out.println("SORT 1");
        hand.sort();
        hand.print();
        
        System.out.println("SORT 2");
        hand.sortAgainstSuit();
        hand.print();
    }
}
