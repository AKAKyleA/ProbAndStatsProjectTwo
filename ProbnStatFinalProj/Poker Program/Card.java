
public class Card
{
    String suit;
    String name;
    int rank;
 
    
    public Card(String suits,String names,int ranks)  //sets a card with a suit name and rank
    {
        // initialise instance variables
        suit = suits;  // four suits
        name = names;  // if number name is number, face cards and ace named different 
        rank = ranks;  // in poker ace is highest so ranks 2-14 with ace as 14
    }

    
    public String getSuit() //suit getter
    {
        return suit;
    }
    
    
    public String getName() //name getter
    {
        return name;
    }
    
    
    public int getRank() //rank getter
    {
        return rank;        
    }
    
    
    public void setSuit(String suits) //suit setter
    {
        suit = suits;
    }
    
    
    public void setName(String names) //name setter
    {
        name = names;
    }
    
    
    public void setRank(int ranks)  //rank setter
    {
        rank = ranks;
    } 
    
}
