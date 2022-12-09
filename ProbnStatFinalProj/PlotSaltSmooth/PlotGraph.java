import java.util.ArrayList;
import javax.swing.JFrame;  
import javax.swing.JPanel;
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  


import org.jfree.data.xy.XYSeries; 
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class PlotGraph extends JFrame
{
    public PlotGraph(ArrayList<Point> points,String type) 
    {
        JPanel chartPanel = createChartPanel(points,type); //creates panel
        add(chartPanel);
 
        setSize(640, 480); //sets panel size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminate on close
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel(ArrayList<Point> points,String type) 
    {
        // creates a line chart object
        String chartTitle = "";
        
        if(type.equals("plot"))
        {
    	    chartTitle = "x y plotter";
        }
        
        if(type.equals("salt"))
        {
    	    chartTitle = "x y salter"; //sets title depending on what call
        }
        
        if(type.equals("smooth"))
        {
    	    chartTitle = "x y smoother";
        }
        
        String xAxisLabel = "X"; //labels
        String yAxisLabel = "Y";
     
        XYDataset dataset = null;
        if(type.equals("joint"))
        {    
            chartTitle = "x y plot/salt/smooth";
            dataset = createDatasetJoint(points);
        }
        else
        {    
            dataset = createDataset(points); //creates dataset
        }    

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, //adds titels labels and dataset to xylinechart
                xAxisLabel, yAxisLabel, dataset);
     
        return new ChartPanel(chart);
        // returns the chart panel
    }
 
    private XYDataset createDataset(ArrayList<Point> points) 
    {
        // creates an XY dataset
    	XYSeriesCollection dataset = new XYSeriesCollection();
    	XYSeries series1 = new XYSeries("Object 1");
    	
    	for(int i = 0; i < points.size();i++) //loops through points and adds them to dataset
    	{
    		series1.add(points.get(i).getX(),points.get(i).getY());	
    	}
    	 dataset.addSeries(series1); //adds series to data set 
    	 return dataset;
    }
    
    public XYDataset createDatasetJoint(ArrayList<Point> points)//method salts and smooths and adds all 3 to dataset
    {
        XYSeriesCollection dataset = new XYSeriesCollection();
    	XYSeries series1 = new XYSeries("Plot");
    	XYSeries series2 = new XYSeries("Salt");
    	XYSeries series3 = new XYSeries("Smooth");
        
        Salter salt = new Salter(); //creates salter
        ArrayList<Point> saltPoints = salt.saltPoints(0,3000,points);
        Smoother smooth = new Smoother();//creates smoother
        ArrayList<Point> smoothPoints = smooth.smoothPoints(saltPoints);
        
        for(int i = 0; i < points.size();i++) //loops through points and adds them to dataset
    	{
    		series1.add(points.get(i).getX(),points.get(i).getY());	
                series2.add(saltPoints.get(i).getX(),saltPoints.get(i).getY());
                series3.add(smoothPoints.get(i).getX(),smoothPoints.get(i).getY());
    	}
        
        
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        return dataset;
    }
    
    

}
