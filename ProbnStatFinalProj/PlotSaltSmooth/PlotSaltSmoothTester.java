import javax.swing.SwingUtilities; 
import java.util.ArrayList;

public class PlotSaltSmoothTester
{

	
    public static void main(String[] args) throws Exception
    {
        Plot plotter = new Plot();  //creates plotter
        ArrayList<Point> points = plotter.setPoints(300,0,2000);  //sets points 300 points from 0-2000  
       //  plotter.graphPlot(points);//graphs plot points
		
       // Salter salt = new Salter(); //creates salter
       // ArrayList<Point> saltPoints = salt.saltPoints(0,3000,points); //sets salted points with a difference of -3000-3000
       // salt.graphSalt(saltPoints);//graphs salt points
        
       // Smoother smooth = new Smoother();//creates smoother
       // ArrayList<Point> smoothPoints = smooth.smoothPoints(saltPoints); //sets smoothed points 
       // smooth.graphSmooth(smoothPoints);//graphs smooth points
        
       
       //commented out code could be used to make 3 seperate graphs
       
        
        SwingUtilities.invokeLater(new Runnable() {  //runs joint graph for points
            @Override
            public void run() {
                new PlotGraph(points,"joint").setVisible(true);
            }
            });
        
    }
	
}