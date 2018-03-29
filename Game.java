import java.util.Scanner;

public class Game
{
    // instance variables - replace the example below with your own
    Player[] players; 
    Deck cards;
    
    Player p = new Player("Jess", 100);
    Dealer d = new Dealer();
    /**
     * Constructor for objects of class Game
     */
    public Game(int numPlayers)
    {
        // initialise instance variables
        this.players = new Player[numPlayers];
        
        cards = new Deck();
        
        
    }
    public  void playGame(){
        //Deal player 1 two cards
        
        Card c = cards.deal();
        p.addCard(c);
        c = cards.deal();
        p.addCard(c);
        System.out.println("Your Hand: " + p.hand);
        System.out.println("You Hand Total: " + p.handTotal);
        
        //Deal dealer 2 cards
        Card c1 = cards.deal();
        d.addCard(c1);
        c1 = cards.deal();
        d.addCard(c1);
        System.out.println(d.hand);
        
        
        double moneyBet = p.bet();
        
        //Continue to ask player to hit until they say no or go over 21
            //Does player 1 need to hit?
        Scanner scan = new Scanner(System.in);  // Reading from System.in
        
        System.out.println("Do you need to hit? ");
        String i = scan.nextLine();
        
            //If yes-deal another card
        while (i.toLowerCase().equals("yes") && p.handTotal <= 21){
            c = cards.deal();
            p.addCard(c);
            
            System.out.println(p.handTotal);
            if (p.handTotal <21) {
                System.out.println("Your hand: " + p.hand);
                System.out.println("Do you need to hit? ");
                i = scan.nextLine();
            }
            
        }
            
        //Hit again and calculate hand total
         
            
        //Hit on dealer until they have 17 or more
        while (d.handTotal() < 17){
            c1 = cards.deal();
            d.addCard(c1);
        }
        
        Player winner = null;
        //Determine winner
        if (d.handTotal <=21 && p.handTotal <= 21){
            if (d.handTotal > p.handTotal){
                winner = d;
                System.out.println("The winner is the dealer.");
                p.updateMoney(-1*moneyBet);
                System.out.println("Cash: "+ p.getMoney());
            }
            else if (p.handTotal > d.handTotal){
                winner = p;
                System.out.println("You won! Congrats.");
                //add money to their total
                p.updateMoney(moneyBet);
                System.out.println("Cash: "+ p.getMoney());
                
            }
            else{
                System.out.println("it's a tie.");
            }
        }
        else if (d.handTotal <=21 && p.handTotal > 21){
            winner = d;
            System.out.println("The winner is the dealer.");
            p.updateMoney(-1*moneyBet);
            System.out.println("Cash: "+ p.getMoney());
        }
        else if (p.handTotal <=21 && d.handTotal > 21){
            winner = p;
                System.out.println("You won! Congrats.");
                //add money to their total
                p.updateMoney(moneyBet);
                System.out.println("Cash: "+ p.getMoney());
        }
        else if (p.handTotal == 21 && d.handTotal != 21){
            winner = p;
                System.out.println("You won! Congrats.");
                //add money to their total
                p.updateMoney(moneyBet);
                System.out.println("Cash: "+ p.getMoney());
        }
        
       else if ((p.handTotal > 21 && d.handTotal >21)){
           System.out.println("It's a tie.");
        }
        
        
        
        //Play again?
        System.out.println("Do you want to play again? ");
        String answer = scan.nextLine();
        if (answer.toLowerCase().equals("yes")){
            //clear hand
            p.hand.clear();
            d.hand.clear();
            playGame();
        }
        else{
            endGame();
        }
        
    }
    public void endGame(){
        System.out.println("Thanks for playing...");
        System.out.println("Cash: "+ p.getMoney());
    }
}
