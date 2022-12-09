

import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;


public class Salter
{
    
    public ArrayList<Point> saltPoints(int minRange,int maxRange, ArrayList<Point> points) //inputs range of random values and adds or subtracts a random number from that range to y value
    {
        Random rnd = new Random();
        ArrayList<Point> saltPoints = new ArrayList<Point>();
        
        for(int i = 0;i < points.size();i++)
        {  
            saltPoints.add(new Point (points.get(i).getX(),points.get(i).getY()));
        }
        
        
        
        for(int i = 0;i < saltPoints.size();i++)
        {
            int saltVal = rnd.nextInt(maxRange - minRange) + minRange;    //random value in range min to max
            
            int negOrPos = rnd.nextInt(2); // random value 0 or 1
            
            if(negOrPos == 0) //if 0 adds value to y
            {
               double y = saltPoints.get(i).getY();
               saltPoints.get(i).setY(y + saltVal);
            }
            else //else it subtracts value from y
            {
               double y = saltPoints.get(i).getY();
               saltPoints.get(i).setY(y - saltVal);   
            }       
        }
       return saltPoints;
    }
    

    public static void graphSalt(ArrayList<Point> points)throws Exception//runs the graph
    {
			
    SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlotGraph(points,"salt").setVisible(true);
            }
    });
		
		
    }
}
