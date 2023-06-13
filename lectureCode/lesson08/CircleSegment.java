package lesson08;

/**
 * 
 * @author Fuchs
 *
 */
public class CircleSegment extends Circle
{
	private double angle;

	/**
	 * Initializes a circle segment with the specified
	 * radius and angle
	 * @param radius
	 * @param angle
	 */
	public CircleSegment(double radius, double angle)
	{
		super(radius);
		this.angle = angle;
	}
	/**
	 * Get the area of the circle segment by
	 * taking the area of the circle and considering
	 * the angle of the segment.
	 */
	public double getArea()
	{
		return super.getArea() * this.angle/360;
	}	
	/**
	 * Get the circumference of the circle segment
	 * by taking the circumference and the radius of the circle
	 * and taking into account the angle of the circle
	 * segment.  
	 */
	public double getCircumference()
	{
		return super.getCircumference() * this.angle/360 + 2 * super.getRadius();
	}
}
