
import java.util.ArrayList;


public class PokerMonteCarlo 
{
    
    int isPair = 0;
    int isTwoPairs = 0;
    int isThreePair = 0;
    int isFourPair = 0;
    int isFullHouse = 0;  //ints of all hand types
    int isFlush = 0;
    int isStraight = 0;     
    int isStraightFlush = 0;
    int isRoyalFlush = 0;
    int isNothing = 0;
    
    
    
    public void handProbability(int runs)  //gives each type of hand probability based of number of runs
    {
        ArrayList<Hand> hands = new ArrayList<>(); //arraylist of hands
        
        Deck test = new Deck(); 
        test.shuffleDeck(); 
        
        for(int i = 0;i < runs; i++) //loops for number of runs
        {
            hands.add(new Hand(test));//adds a new hand
            hands.get(i).evaluateHand(); //evaluates hand
            addCounter(hands.get(i).handName()); //adds hands type to counter
            
            hands.get(i).returnHandToDeck(test); //returns hand to deck
            test.shuffleDeck();  //shuffles deck
        }
        
        double total = runs; 
        displayOutput(total); //displays output
        resetCount(); //resets the counts
    }
    
    
    public void addCounter(String handType) //takes in hand type and adds one to its counter
    {
        if(handType.equals("Pair"))
        {
            isPair = isPair + 1;
        }
        else if(handType.equals("Two Pairs"))
        {
            isTwoPairs = isTwoPairs + 1;
        }
        else if(handType.equals("Three of a Kind"))
        {
            isThreePair = isThreePair + 1;
        }
        else if(handType.equals("Four of a Kind"))
        {
            isFourPair = isFourPair + 1;
        }
        else if(handType.equals("Full House"))
        {
            isFullHouse = isFullHouse + 1;
        }
        else if(handType.equals("Straight"))
        {
            isStraight = isStraight + 1;
        }
        else if(handType.equals("Flush"))
        {
            isFlush = isFlush + 1;
        }
        else if(handType.equals("Straight Flush"))
        {
            isStraightFlush = isStraightFlush + 1;
        }
        else if(handType.equals("Royal Flush"))
        {
            isRoyalFlush = isRoyalFlush + 1;
        }
        else
        {
            isNothing = isNothing + 1;
        }
    }
    
    
    public void displayOutput(double total)//outputs each type and its probability
    {
        System.out.println("Probability of nothing: " + (isNothing/total)*100);
        System.out.println("Probability of a pair: " + (isPair/total)*100);
        System.out.println("Probability of two pairs: " + (isTwoPairs/total)*100);
        System.out.println("Probability of three of a kind: " + (isThreePair/total)*100);
        System.out.println("Probability of a straight: " + (isStraight/total)*100);
        System.out.println("Probability of a flush: " + (isFlush/total)*100);
        System.out.println("Probability of a full house: " + (isFullHouse/total)*100);
        System.out.println("Probability of four of a kind: " + (isFourPair/total)*100);
        System.out.println("Probability of a straight flush: " + (isStraightFlush/total)*100);
        System.out.println("Probability of a royal flush: " + (isRoyalFlush/total)*100);
    }
     
    
    public void resetCount()
    {
        isPair = 0;
        isTwoPairs = 0;
        isThreePair = 0;
        isFourPair = 0;
        isFullHouse = 0;
        isFlush = 0;
        isStraight = 0;     
        isStraightFlush = 0;
        isRoyalFlush = 0;
        isNothing = 0; 
    }

}
