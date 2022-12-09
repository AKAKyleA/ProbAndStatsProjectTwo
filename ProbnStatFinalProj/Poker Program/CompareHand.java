import java.util.ArrayList;
import java.util.Scanner;
public class CompareHand
{
    
    public void compareHands(int runs) //takes 2 hands from a deck, lets each player swap of cards and tells the winner. does runs number of times
    {
        
        ArrayList<Hand> handsOne = new ArrayList<>(); //arraylist of hands player 1
        ArrayList<Hand> handsTwo = new ArrayList<>(); //arraylist of hands player 2
        
        Deck test = new Deck(); //gets a deck and shuffles
        test.shuffleDeck();
        
        for(int i = 0;i < runs; i++) //does run nummber of times
        {
            handsOne.add(new Hand(test));//adds a hand to player 1 and 2
            handsTwo.add(new Hand(test));
            
            changeCardsDisplay(handsOne.get(i),handsTwo.get(i), test); // does and prints letting players swap cards
            
            compareTwoHands(handsOne.get(i),handsTwo.get(i)); //compares the two palyers hands displays output
            
            handsOne.get(i).returnHandToDeck(test); 
            handsTwo.get(i).returnHandToDeck(test); //returns hands to the deck 
            test.shuffleDeck(); //shuffles deck
        }
    }
   
    
    public void changeCardsDisplay(Hand one,Hand two, Deck deck) //nicely prints out the display of letting players swap out cards
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("This is Hand One:");
        one.printCards(); //prints original 
        System.out.println("");
        System.out.println("Enter the card numbers you want to switch 1-5. If entering multiple numbers use a space to seperate and if switching none enter 0. :");
        String oneSwitch = scn.nextLine();   //ex.   "0" "2 5"  "1 2 3"     "1 3 4 5"
        
        changeCards(one, oneSwitch, deck); //swaps out those cards
        System.out.println("New Hand One:"); 
        one.printCards();//prints new hand
        
        System.out.println("------------------------------------------------");
        
        System.out.println("This is Hand Two:");
        two.printCards();//prints original
        System.out.println("");
        System.out.println("Enter the card numbers you want to switch 1-5. If entering multiple numbers use a space to seperate and if switching none enter 0. :");
        String twoSwitch = scn.nextLine();//ex.   "0" "2 5"  "1 2 3"     "1 3 4 5"
        
        changeCards(two, twoSwitch, deck);//swaps out those cards
        System.out.println("New Hand Two:");
        two.printCards();//prints new hand
        
        
        System.out.println("");
        System.out.println("");//prints space to seperate compare result
    }
    

    public void changeCards(Hand theHand, String numbers, Deck deck)//changes hand cards out using numbers positions
    {
        ArrayList<Integer> swapPositions = new ArrayList<>(); //arraylist of integers of positions
        String numbersNospace = numbers.trim().replaceAll("\\s", ""); //takes out spaces in numbers
        
        
        for(int i = 0; i < numbersNospace.length(); i++) //loops numbers
        {        
            swapPositions.add(Integer.parseInt(String.valueOf(numbersNospace.charAt(i)))); //adds each one to array
        }
          
        theHand.changeOutCards(swapPositions, deck); // changes out cards  
    }
    

    public void compareTwoHands(Hand one, Hand two)
    {
        one.evaluateHand(); // determines type of hand
        two.evaluateHand();
        
        String winner = determineWinner(one, two); //sees whos type is better returns winner
        String winnerType = "";
        
        if(winner.equals("Hand 1"))
        {
            winnerType = one.handName();  //sets winnertype to hand1's type
        }
        else if(winner.equals("Hand 2"))
        {
             winnerType = two.handName();   //sets winnertype to hand1's type
        }
        else
        {
            winnerType = two.handName(); //tie doesnt matter which
        }
        
        displayCompareHands(one,two,winner,winnerType); //nicely dispalys output   
    }
    
    
    public String determineWinner(Hand one, Hand two)
    {
        String oneHandName = one.handName();//string of hand type
        String twoHandName = two.handName();
        
        int oneHand = valueHand(oneHandName);//sets a value to the hand type
        int twoHand = valueHand(twoHandName);
        
        if(oneHand == twoHand)
        {
            return determineTieWinner(one, two, oneHand);//if types are the same needs to determine winner based off highest card value
        }
        else if(oneHand > twoHand) //if hand ones type value is higher
        {
            return "Hand 1"; //hand one wins
        }
        else//else hand 2 type value is higher
        {
            return "Hand 2"; //hand 2 wins
        }  
    }
    
    
    public int valueHand(String handType) //sets a value to each hand type
    {
        if(handType.equals("Pair"))
        {
            return 2;
        }
        else if(handType.equals("Two Pairs"))
        {
            return 3;
        }
        else if(handType.equals("Three of a Kind"))
        {
            return 4;
        }
        else if(handType.equals("Four of a Kind"))
        {
            return 8;
        }
        else if(handType.equals("Full House"))
        {
            return 7;
        }
        else if(handType.equals("Straight"))
        {
            return 5;
        }
        else if(handType.equals("Flush"))
        {
            return 6;
        }
        else if(handType.equals("Straight Flush"))
        {
            return 9;
        }
        else if(handType.equals("Royal Flush"))
        {
            return 10;
        }
        else
        {
            return 1;
        }  
    }
    

    public String determineTieWinner(Hand one,Hand two,int handType) //takes in both hands and the hands type
    {
        if(handType == 10) //if both have a royal flush its a tie
        {
            return "tie";
        }
        else if(handType == 9 || handType == 6 || handType == 5 || handType == 1) // for straight, flush, straight flush, or nothing: highest card wins 
        {
            int handOneHighestRank;
            int handTwoHighestRank;
            
            
            handOneHighestRank = one.highestRank();
            handTwoHighestRank = two.highestRank();
                
            if(handOneHighestRank == handTwoHighestRank)
            {
                return "tie";
            }
            else if(handOneHighestRank > handTwoHighestRank)
            {
                return "Hand 1";
            }
            else
            {
                return "Hand 2";
            }    
                  
        }
        else if(handType == 2 || handType == 4 || handType == 8) // for a pair, highest val pair
        {                                                       
            int handOneHighestRank;
            int handTwoHighestRank;
            
            
            handOneHighestRank = one.highestRankPair(); // works with 3/4 of a kind because it knows thats the only pair
            handTwoHighestRank = two.highestRankPair();
                
            if(handOneHighestRank == handTwoHighestRank)
            {
                return "tie"; // if 3 or 4 of a kind can't tie 
            }
            else if(handOneHighestRank > handTwoHighestRank)
            {
                return "Hand 1";
            }
            else
            {
                return "Hand 2";
            } 
        }
        else // for 2 pairs and full house, highest val pair wins
        {
            int handOneHighestRank;
            int handTwoHighestRank;
            
            
            handOneHighestRank = one.highestRankPairs();
            handTwoHighestRank = two.highestRankPairs();
                
            if(handOneHighestRank == handTwoHighestRank) // full house can't tie
            {
                return "tie";
            }
            else if(handOneHighestRank > handTwoHighestRank)
            {
                return "Hand 1";
            }
            else
            {
                return "Hand 2";
            }    
        }    
    }
    

    public void displayCompareHands(Hand one,Hand two,String winner,String winnerType) //nicely displays winner output
    {
        System.out.println("Hand One:");
        one.printCards();
        System.out.println("----------------");
        System.out.println("Hand Two:");
        two.printCards();
        System.out.println();
        System.out.println("Winner: " + winner + " " + winnerType);
        System.out.println("---------------------------------------------");  
    }
     
}
