import java.util.ArrayList;
public class PokerTester
{
    
    public static void main(String[] args)
    {
        PokerMonteCarlo test = new PokerMonteCarlo(); //creates new monte carlo test
        test.handProbability(200000); //prints out probabilites of all hand types based off 200000 total hands
        
        System.out.println();//used to put line space
        
        CompareHand compare = new CompareHand(); //creates new compare hands object
        
        compare.compareHands(1); //prints out 2 hands and says who the winner is. (does this once)   
    }
  
}
