package lesson09Script;

/**
 * (*7*)
 * To use an interface, you write a class that implements the interface. 
 * When an instantiable class implements an interface, it provides a 
 * method body for each of the methods declared in the interface.
 * Our Apple makes use of the interface Buyable. Therefore, it has to implement
 * this interface with the keyword 'implements'. Many interfaces can be implemented
 * by a class. The interfaces are then just comma separated e.g.,
 * 			public class Apple implements Buyable, Comparable
 * By convention, the implements clause follows the extends clause, if there is one.
 * If a class implements an interface it has to implement all abstract methods
 * of the respective interface. In our case, we have to implement the method
 * getPrice().
 * 
 * @author fuchs
 *
 */
public class Apple implements Buyable
{
	//a property of the apple
	private double price;
	/**
	 * The constructor expects a price
	 * 
	 * @param price - how much does the apple cost in Euro
	 */
	public Apple(double price)
	{
		this.price = price;
	}
	
	@Override
	public double getPrice()
	{
		return this.price;
	}
	/*
	 * Since we implemented the interface Buyable we HAVE TO implement the abstract
	 * method getPrice(). If we do not implement the method, the class Apple 
	 * must be declared abstract.
	 */
	//->switch to Interfaces.java (*8*)
}
