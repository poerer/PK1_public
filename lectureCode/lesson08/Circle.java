package lesson08;

/**
 * This class describes a circle with some
 * fundamental methods.
 * @author Fuchs
 *
 */
public class Circle
{
	private double radius;

	/**
	 * Instantiate a circle with a 
	 * given radius.
	 * @param radius
	 */
	public Circle(double radius)
	{
		this.radius = radius;
	}
	/**
	 * get the radius of the circle
	 * @return
	 */
	public double getRadius()
	{
		return this.radius;
	}
	/**
	 * set the radius of the circle
	 * @param radius
	 */
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	/**
	 * get the area of the circle
	 * @return
	 */
	public double getArea()
	{
		return Math.PI * this.radius * this.radius;
	}
	/**
	 * get the circumference of the circle
	 * @return
	 */
	public double getCircumference()
	{
		return 2 * Math.PI * this.radius;
	}
}
