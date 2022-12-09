
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;

public class Smoother 
{
    
    public ArrayList<Point> smoothPoints(ArrayList<Point> points)
    {
        ArrayList<Point> smoothPoints = new ArrayList<Point>();
        WeightedObservedPoints wop = new WeightedObservedPoints(); //creates set of points
        
        for(int i = 0;i < points.size();i++) //adds the salted points to smoothPoints and to Weighted points
        {  
            smoothPoints.add(new Point (points.get(i).getX(),points.get(i).getY()));
            
            wop.add(points.get(i).getX(),points.get(i).getY());
        }

        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3); //creates a function to the third degree
        final double[] coeff = fitter.fit(wop.toList()); //list of the coefficents for the fitted function using weighted point
        
        for(int i = 0;i<points.size();i++) //changes the y values to the smoothed y value
        {
            smoothPoints.get(i).setY(getSmoothY(smoothPoints.get(i).getX(),coeff));
        }
        
        return smoothPoints;
    }
    
    public double getSmoothY(double x, double[] coeff) //uses function to get y
    {  
        return (coeff[3] * x) + (coeff[2] * x) + (coeff[1] * x) + coeff[0];
    }
    

    public static void graphSmooth(ArrayList<Point> points)throws Exception //runs the graph
    {		
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlotGraph(points,"smooth").setVisible(true);
            }
        });
    }
    
}
