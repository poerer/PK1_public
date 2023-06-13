package lesson08;

/**
 * 
 * @author Fuchs
 *
 */
public class ApplicationCircle
{
	public static void main(String[] args)
	{
		System.out.println("--Circle and CircleSegments--");
		
		//Initialize a circle
		System.out.println("----Circle----");
		Circle c = new Circle(3);
		System.out.println("Radius: " + c.getRadius());
		System.out.println("Area: " + c.getArea());
		System.out.println("Circumference: " + c.getCircumference());
		
		//Initialize a circle segement
		System.out.println("-----Circle Segement-----");
		CircleSegment cs = new CircleSegment(3, 180);
		System.out.println("Radius: " + cs.getRadius());
		System.out.println("Area: " + cs.getArea());
		System.out.println("Circumference: " + cs.getCircumference());
	}
}
