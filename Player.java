import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    // instance variables - replace the example below with your own
    String name;
    double money;
    int handTotal;
    ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String n, double m)
    {
        // initialise instance variables
        this.name = n;
        this.money = m;
        handTotal = 0;
    }
    public int bet()
    {
        int bet = 0;
        
            System.out.println("You cannot bet more cash than you have!");
            System.out.println("How much would you like to bet?");
            Scanner sc=new Scanner(System.in);
            bet=sc.nextInt();
        
        return bet;
    }
    
    public void updateMoney(double cash) {
        this.money += cash;
    }
    
    
    public double getMoney() {
        return this.money;
    }
    public int handTotal()
    {
        handTotal = 0;
        
        for (Card c : hand) {
            if (c.getRank().equals("Ace")){
                handTotal += 11;
            }
            else {
                handTotal += c.getValue();
            }
        }
        
        if (handTotal > 21) {
            handTotal = 0;
        
            for (Card c : hand) {
             
                    handTotal += c.getValue();
                }
        }
        return handTotal;
    }
    
    public void addCard(Card c) {
        hand.add(c);
        handTotal();
    }
 
}
