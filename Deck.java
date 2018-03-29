
import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    // instance variables - replace the example below with your own
    private ArrayList<Card> deckArray = new ArrayList<Card>();
    private int index;
    private Random randomGenerator = new Random();
    private String[] suits = {"Clubs", "Diamonds", "Spades", "Hearts"};
    private String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    

        /**
         * Constructor for objects of class Deck
         */
        public Deck()
    {
        
        for(String s : suits) {
            int value = 1;
            for(String r: ranks) {
                Card temp = new Card(s, r, value);
                value++;
                if (value > 10) {
                    value = 10;
                }
                
                deckArray.add(temp);
            }
        }
        
    }
    public void printDeck() {
        for(Card c: deckArray) {
            System.out.println(c);
        }
    }
    public  Card deal() {
        
        int randomIndex = randomGenerator.nextInt(deckArray.size()); 
        return deckArray.remove(randomIndex);
        
        }

    }