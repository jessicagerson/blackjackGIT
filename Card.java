
public class Card
{
    // instance variables - replace the example below with your ownr  
    private int value;
    private String rank;
    private String suit;
    
    /**
     * Constructor for objects of class Card
     */
    public Card(String s, String r, int v)
    {
        this.suit = s;
        this.rank = r;
        this.value = v;
    }

    public String getSuit()
    {
        // put your code here
        return "The suit is: " + suit + ".";
    }
    public String getRank(){
        return "The rank is: " +rank +  ".";
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String toString() {
        return "Suit: " + suit + " Rank: " + rank + " Value: " + value;
    }
    
}
