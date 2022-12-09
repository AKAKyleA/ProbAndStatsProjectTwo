
import java.util.ArrayList;

public class Hand
{
    ArrayList<Card> cards = new ArrayList<>(); //arraylist of 5 cards
    
    boolean isPair;
    boolean isTwoPairs;
    boolean isThreePair;
    boolean isFourPair;
    boolean isFullHouse;
    
    boolean isFlush;
    boolean isStraight;     //booleans for all hand sinarios 
    boolean isStraightFlush;
    boolean isRoyalFlush;
    
    boolean isNothing;
    
    
    public Hand(Deck deck) //gets first 5 cards from deck
    {
        deck.giveHand(cards);
    }

    
    public void printCards()//prints hand
    {
        for(int i = 0; i < cards.size();i++)
        {
            System.out.println(cards.get(i).getSuit() + " " + cards.get(i).getName());
        }
    }
    
    
    public void evaluateHand() //sets hand to only one of the booleans that the hand is
    {
        checkForPair();
        checkTwoPairs();
        checkThreeAndFourPair();
        checkFullHouse();         //checks all possibilies to see if it is one
        checkFlush();
        checkStraight();
        checkStraightFlush();
        checkRoyalFlush();
        
        
        if(isFullHouse == true) //if it is a full house: 1 pair, 2 pairs, and 3 of a kind also come up as true so sets them to false
        {
            isThreePair = false;
            isTwoPairs = false;
            isPair = false;
        }
        
        if(isFourPair == true) // if 4 of a kind is true: 1 pair also comnes up as true, sets it to false
        {
            isPair = false;
        }
        
        if(isThreePair == true) // if 3 of a kind is true: 1 pair comes up as true and 2 pairs could come up as true so sets them to false
        {
            isPair = false;
            isTwoPairs = false;
        }
        
        if(isTwoPairs == true) //if 2 pairs is true: sets 1 pair to false
        {
            isPair = false;
        }
        
        if(isRoyalFlush == true) // if royal flush is true: straight, straight flush, and flush are true so sets them to false
        {
            isStraight = false;
            isFlush = false;
            isStraightFlush = false;
        }
        
        if(isStraightFlush == true) //if straight flush is true: straight and flush are true sets them as false
        {
           isStraight = false;
           isFlush = false;
        }   
    }
    
    
    public String handName() //returns a string of what kind of hand
    {
        if(isPair == true)
        {
            return "Pair";
        }
        else if(isTwoPairs == true)
        {
            return "Two Pairs";
        }
        else if(isThreePair == true)
        {
            return "Three of a Kind";
        }
        else if(isFourPair == true)
        {
            return "Four of a Kind";
        }
        else if(isFullHouse == true)
        {
            return "Full House";
        }
        else if(isStraight == true)
        {
            return "Straight";
        }
        else if(isFlush == true)
        {
            return "Flush";
        }
        else if(isStraightFlush == true)
        {
            return "Straight Flush";
        }
        else if(isRoyalFlush == true)
        {
            return "Royal Flush";
        }
        else
        {
            return "Nothing";
        }
    }
    
    
    public void checkForPair() //checks if hand contains a pair
    {
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    isPair = true;
                }        
            } 
        }
    }
    
    
    public void checkTwoPairs()//checks if hand contains 2 pairs
    {
        boolean firstPair = false;
        int firstPairRank = 0;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    if(firstPair == false)//if its the first pair to come across sets first pair to true and saves pairs rank
                    {
                        firstPair = true;
                        firstPairRank = cards.get(i).getRank();
                    }
                    else //if second pair sees if the pair is the same rank as the first pair
                    {
                        if(cards.get(i).getRank() != firstPairRank)//if second pair isnt the same rank as first pair
                        {
                            isTwoPairs = true; //there is 2 pairs
                        }   
                    }  
                }        
            } 
        }
    }
    
    
    public void checkThreeAndFourPair()//check if hand contains 3 or 4 of a kinid
    {
        boolean firstPair = false;
        int firstPairRank = 0;
        int count = 0;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    if(firstPair == false)//if its the first pair to come across sets first pair to true and saves pair's rank
                    {
                        firstPair = true;
                        firstPairRank = cards.get(i).getRank();
                         count = 1; //adds one to first pairs count 
                    }
                    else //if next pair sees if the pair is the same rank as the first pair
                    {
                        if(cards.get(i).getRank() == firstPairRank) //if the pair is the same rank as the first pair
                        {
                            count = count + 1; //adds one to the count
                        } 
                    }
                }        
            } 
        }
        
        if(count == 3)//for 3 of the same card there would be 3 pairs
        {
            isThreePair = true;
        }
        else if(count == 6) //for 4 of the same number there would be 6 ways to pair the cards
        {
            isFourPair = true;
        }
    }
    
    
    public void checkFullHouse()//checks if hand contains full house
    {
        boolean firstPair = false;
        int firstPairRank = 0;
        int count = 0;
        int secondPairCount = 0;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    if(firstPair == false)//if its the first pair to come across sets first pair to true and saves pairs rank
                    {
                        firstPair = true;
                        firstPairRank = cards.get(i).getRank();
                         count = 1; //adds one to first pairs count
                    }
                    else //if next pair sees if the pair is the same rank as the first pair
                    {
                        if(cards.get(i).getRank() == firstPairRank) // if pair is same pair as the first pair adds one to first pair count
                        {
                            count = count + 1;
                        }
                        else //else if a new pair
                        {
                           secondPairCount = secondPairCount + 1; //adds one to second pairs rank   
                        }
                    }   
                }        
            } 
        }
        
        
        if(firstPair == true && secondPairCount == 3 || count == 3 && secondPairCount == 1) //if there is a first pair and the second pair contains 3 cards or
        {                                                                                   //if the first pair contains 3 cards and a second pair exists
            isFullHouse = true; //is a full house
        }
    }
    
    
    public void checkFlush() //checks if hand contains a flush
    {
        String suitFirstCard = "";
        
        boolean matchesFirstSuit = true;
        
        for(int i = 0; i < 5; i++) //loops 5 cards
        {
            if(i == 0) //sets to first cards suit
            {
                suitFirstCard = cards.get(i).getSuit();
            }
            else
            {
                if(suitFirstCard != cards.get(i).getSuit()) //if any other card doesnt match the first suit its not a flush
                {
                    matchesFirstSuit = false;
                }
            }
        }
        
        if(matchesFirstSuit == true) //if it stays true is a flush
        {
            isFlush = true;
        }   
    }
    
    
    public void checkStraight() //checks if hand is a straight
    {
        ArrayList<Card> decending = new ArrayList<>(); //create an array list of hand in decending order by rank
        
        copyHand(decending); //copies hand in decending
        
        putDecending(decending); //puts array list in decending order
        
        boolean equalsOne = true;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            int j = i + 1; //j is next card after i
            
            if(decending.get(i).getRank() - decending.get(j).getRank() != 1) //if straight card - next card in decending order would be 1
            {
                equalsOne = false; //if not one not a straight 
            }
            
        }
        if(equalsOne == true) //if it stays true then its a straight
        {
            isStraight = true;
        }
    }
    
    
    public void putDecending(ArrayList<Card> decending) //used in checkStraight. puts hand in decending order by rank
    {
        for(int i = 0; i < 5;i++)
        {
            for(int j = 0; j < 5;j++)
            {
                if(j != i)
                {
                    if(i < j)
                    {
                        if(decending.get(i).getRank() < decending.get(j).getRank())
                        {
                            swapSpots(decending.get(i),decending.get(j));
                        }
                    }   
                }       
            }   
        }
    }
    
    
    public void swapSpots(Card one,Card two) //used in putDecending. swaps 2 cards spots
    {
        Card temp = new Card("","",0);
        
        temp.setSuit(one.getSuit());
        temp.setName(one.getName());
        temp.setRank(one.getRank());
        
        one.setSuit(two.getSuit());
        one.setName(two.getName());
        one.setRank(two.getRank());
        
        two.setSuit(temp.getSuit());
        two.setName(temp.getName());
        two.setRank(temp.getRank());
    }
    
    
    public void copyHand(ArrayList<Card> decending) //used in checkStraight. copys hand array list to decending arraylist
    {
        for(int i = 0; i < 5; i++)
        {
            decending.add(new Card("","",0));
            decending.get(i).setSuit(cards.get(i).getSuit());
            decending.get(i).setName(cards.get(i).getName());
            decending.get(i).setRank(cards.get(i).getRank());
        }    
    }
    
    
    public void checkStraightFlush() // checks hand for straight flush
    {
        if(isStraight == true && isFlush == true) //if hand is a straight and a flush
        {
            isStraightFlush = true; //is a straight flush
        }
    }
    
    
    public void checkRoyalFlush() //checks hand for a royal flush
    {
        boolean hasAce = false;
        
        if(isStraightFlush == true) //royal flush has to be a straight flush
        {
            for(int i = 0;i<5;i++) //loops 5 cards in hand
            {
                if(cards.get(i).getRank() == 14) //if any are an ace and id a straight flush
                {
                    hasAce = true;
                }
            }
        }
        
        if(hasAce == true)
        {
           isRoyalFlush = true; //hand is royal flush
        }
    }
    
    
    public void returnHandToDeck(Deck deck) //returns cards in hand to a deck
    {
        deck.returnHand(cards);
    }
    
    
    public void setHand() //used when test can set hand cards to any values
    {
        cards.get(0).setSuit("dim");
        cards.get(0).setName("four");
        cards.get(0).setRank(10);
            
        cards.get(1).setSuit("dim");
        cards.get(1).setName("four");
        cards.get(1).setRank(12);
            
        cards.get(2).setSuit("dim");
        cards.get(2).setName("seven");
        cards.get(2).setRank(11);
            
        cards.get(3).setSuit("dim");
        cards.get(3).setName("four");
        cards.get(3).setRank(14);
            
        cards.get(4).setSuit("dim");
        cards.get(4).setName("four");
        cards.get(4).setRank(13);
    }
    
    
    public int highestRank() //method used in determine tie winner assumes hand is a straight flush, straight, flush, or nothing. returns value of highest card in hand
    {
        int tempHighest = 0;
        
        for(int i = 0; i < 5; i++) //loops 5 cards
        {
            if(i == 0)
            {
                tempHighest = cards.get(i).getRank(); //sets first card as highest ranks
            }
            else
            {
                if(tempHighest < cards.get(i).getRank()) //checks other cards to see if its higher
                {
                    tempHighest = cards.get(i).getRank();
                }
            }
        }
        return tempHighest;
    }
    
    
    public int highestRankPair()//method used in determine tie winner assumes hand is a pair, 3 or 4 of a kind. returns value of pair
    {
        int tempHighest = 0;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    tempHighest = cards.get(i).getRank(); //sets rank of pair
                }        
            } 
        }
    
        return tempHighest; //returns rank of pair
    }
    
    
    public int highestRankPairs()//method used in determine tie winner assumes hand is 2 pairs or a full house. returns value of highest pair
    {
        int tempHighest = 0;
        
        boolean firstPair = false;
        int firstPairRank = 0;
        
        for(int i = 0; i < cards.size() - 1; i++)//loops first 4 cards
        {      
            for(int j = i+1; j < cards.size(); j++) //loops cards after i card
            {       
                if(cards.get(i).getRank() == cards.get(j).getRank()) // if card i matches card j then is a pair
                {
                    if(firstPair == false)//if its the first pair to come across sets first pair to true and saves pairs rank
                    {
                        firstPair = true;
                        firstPairRank = cards.get(i).getRank();
                        tempHighest = firstPairRank; //sets first pair as highest rank
                    }
                    else //if second pair sees if the pair is the same rank as the first pair
                    {
                        if(cards.get(i).getRank() != firstPairRank) //if its a new pair
                        {
                            if(cards.get(i).getRank() > firstPairRank) //checks if new pair is a higher rank then the first pair
                            {
                                tempHighest = cards.get(i).getRank(); // if the second pair is a higher rank, second pair is highest rank
                            }
                        } 
                    } 
                }        
            } 
        }
        
        return tempHighest;
    }
   
    
    public void changeOutCards(ArrayList<Integer> numbers, Deck deck) //takes in arraylist of positions and deck and swaps cards at each
    {
        
        if(numbers.get(0) == 0) //if switching no cards does nothing
        {
            
        }
        else 
        {
            for(int i = 0; i < numbers.size();i++) //loops number of cards to switch out
            {  
                deck.exchangeCard(cards.get(numbers.get(i) - 1));   //changes out hand card in numbers position
            } 
        }  
    }

}
