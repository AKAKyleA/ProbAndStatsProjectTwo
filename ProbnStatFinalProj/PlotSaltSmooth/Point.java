public class Point //class creates a point with x and y
{
	double x;
    double y;
    
    public Point(double newX,double newY) 
    {
        x = newX;
        y = newY;
     
    }
    
    
    public void setX(double newX) //set x
    {
        x = newX;
    }
    
    public void setY(double newY)//set y
    {
        y = newY;
    }
    
    public double getX() //get x
    {
        return x;
    }
    
    public double getY() //get y
    {
        return y;
    }
}