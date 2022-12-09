import java.util.ArrayList;
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;



public class Plot
{

    public static ArrayList<Point> setPoints(int numOfPoints,double lowRange, double highRange) //inputs number of points wanted, range of x values
    {
		ArrayList<Point> points = new ArrayList<Point>();
        double pointInterval = (highRange - lowRange) / (numOfPoints - 1); //starting at low range for first point ending at high range for last point, gives interval between x values
        double currentX = lowRange;
        
        for(int i = 0; i < numOfPoints;i++) //loads all the point into an array list
        {
            points.add(new Point(currentX,getYfromX(currentX)));
            
            currentX = currentX + pointInterval;
        }
        
        return points;
    }
	
    public static double getYfromX(double xValue)  // sets the y value based on linear  
    {
	double m = 3.5; // slope  values can be changed 
	double b = 5; // sets b 
	        
	return (m*xValue) + b; 
    }
	
    public static void graphPlot(ArrayList<Point> points)throws Exception //runs the graph
    {
	
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlotGraph(points,"plot").setVisible(true);
            }
        });
	
    }
	
	
}
