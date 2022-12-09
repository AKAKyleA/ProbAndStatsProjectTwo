
import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
   ArrayList<Card> cards = new ArrayList<>(); //array list of 52 cards

   
    public Deck()
    {
        for(int i = 0; i < 4; i++) //loops 4 time once each suit
        {
            if(i == 0) //for hearts
            {
                for(int j = 1; j < 14; j++) //loops 13 time Ace-King
                {  
                    if(j == 1) //if Ace rank is 14
                    {
                        String name = getNameVal(j); //returns name of card 1 is Ace, number is number, and face card is jack,queen, or king
                        cards.add(new Card("Heart",name,14));
                    }
                    else //anything else rank is number or face card value
                    {
                        String name = getNameVal(j);
                        cards.add(new Card("Heart",name,j));
                    }
                }
            }
            else if(i == 1) //for diamond
            {
                for(int j = 1; j < 14; j++)//loops 13 time Ace-King
                {   
                    if(j == 1)//if Ace rank is 14
                    {
                        String name = getNameVal(j);//returns name of card 1 is Ace, number is number, and face card is jack,queen, or king
                        cards.add(new Card("Diamond",name,14));
                    }
                    else//anything else rank is number or face card value
                    {
                        String name = getNameVal(j);
                        cards.add(new Card("Diamond",name,j));
                    }
                }
            }
            else if(i == 2) //for club
            {
                for(int j = 1; j < 14; j++)//loops 13 time Ace-King
                {   
                    if(j == 1)//if Ace rank is 14
                    {
                        String name = getNameVal(j);//returns name of card 1 is Ace, number is number, and face card is jack,queen, or king
                        cards.add(new Card("Club",name,14));
                    }
                    else//anything else rank is number or face card value
                    {
                        String name = getNameVal(j);
                        cards.add(new Card("Club",name,j));
                    }
                }
            }
            else //for spade
            {
                for(int j = 1; j < 14; j++)//loops 13 time Ace-King
                {   
                    if(j == 1)//if Ace rank is 14
                    {
                        String name = getNameVal(j);//returns name of card 1 is Ace, number is number, and face card is jack,queen, or king
                        cards.add(new Card("Spade",name,14));
                    }
                    else//anything else rank is number or face card value
                    {
                        String name = getNameVal(j);
                        cards.add(new Card("Spade",name,j));
                    }
                }
            }
        }
 
    }
    
    
    String getNameVal(int j) //enter in rank number and returns name of card 1 is Ace, number is number, and face card is jack,queen, or king
    {    
        if(j == 1)
        {
            return "Ace";
        }
        else if(j > 1 && j < 11)
        {
            return String.valueOf(j);
        }
        else if(j == 11)
        {
            return "Jack";
        }
        else if(j == 12)
        {
            return "Queen";
        }
        else
        {
          return "King"; 
        }
    }
    
    
    public void printCards() //prints out all cards in deck with variables suit, name, and rank
    {
        for(int i = 0; i < cards.size();i++)
        {
            System.out.println(cards.get(i).getSuit() + " " + cards.get(i).getName() + " " + cards.get(i).getRank() );
        }
    }
    
    
    public void shuffleDeck() //shuffles the deck 
    {   
        for(int i = 0; i < cards.size();i++) //loops over each position 
        {
            Random rand = new Random();
            
            int swapPos = rand.nextInt(52); //gets a random positon 0-51
            
            swapSpots(cards.get(i),cards.get(swapPos)); //swaps current position card with random position
        } 
    }
    
    
    public void swapSpots(Card one,Card two) // takes in two cards and swaps their positions
    {
        Card temp = new Card("","",0); //creates a temp card to hold values of first card
        
        temp.setSuit(one.getSuit());
        temp.setName(one.getName()); // temp card set to first cards values
        temp.setRank(one.getRank());
        
        one.setSuit(two.getSuit());
        one.setName(two.getName()); //card one position set to card two
        one.setRank(two.getRank());
        
        two.setSuit(temp.getSuit());
        two.setName(temp.getName()); // temp card with card ones values is set to card twos position
        two.setRank(temp.getRank());
    }
    
    
    public void giveHand(ArrayList<Card> hand) //takes in hands arraylist and gives first 5 cards of the deck to the hand. used in initalizing hand
    {
        for(int i = 0; i < 5; i++) //loops first 5 cards
        {
            hand.add(new Card("","",0)); //adds a new card
            hand.get(i).setSuit(cards.get(0).getSuit());
            hand.get(i).setName(cards.get(0).getName());   // gives new card first card in the decks values
            hand.get(i).setRank(cards.get(0).getRank());
            
            cards.remove(0); //removes card from deck
        }
    }
    
    
    public void returnHand(ArrayList<Card> hand) //takes in hands arraylist and gives the deck the hands 5 cards
    {
        int size = cards.size(); 
        
        for(int i = 0; i < 5; i++)
        {
            cards.add(new Card("","",0));// adds a new card to the deck
            cards.get(i + size).setSuit(hand.get(0).getSuit());
            cards.get(i + size).setName(hand.get(0).getName()); //sets the new cards value to first card in the hand
            cards.get(i + size).setRank(hand.get(0).getRank());
            
            hand.remove(0); //removes the card from the hand
        }
    }
 
    
    public void exchangeCard(Card handCard)//used in changeOutCards to give handCard the top card in the deck and returns handCard to end of deck
    {
         Card temp = new Card("","",0);   
         
         temp.setSuit(cards.get(0).getSuit());
         temp.setName(cards.get(0).getName());   // gives new card first card in the decks values
         temp.setRank(cards.get(0).getRank());
    
         cards.remove(0); //removes card from deck
         
         cards.add(new Card(handCard.getSuit(),handCard.getName(),handCard.getRank())); //adds hand card to end of deck
         
         handCard.setSuit(temp.getSuit());
         handCard.setName(temp.getName()); //changes hand card values to new deck card values
         handCard.setRank(temp.getRank());
    }
    
    
    
    
}
