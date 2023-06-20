package lesson09Script;

/**
 * (*6*)
 * Defining an interface is similar to creating a new class.
 * We just have to change the keyword 'class' to 'interface'.
 * In an interface all methods are public and abstract (except for static methods)
 * that is why we do not have to write these keywords:
 * 						double getPrice();
 * reads like:
 * 				public abstract double getPrice();
 * 
 * The idea of our interface is to have a common ground for buying products.
 * Any product (in our case class), which implements this interface can be bought
 * and we can retrieve the price using the method getPrice(). It does not
 * matter what specifics this product has, as long as it implements the interface
 * Buyable we have access to the method getPrice().
 * 
 * @author fuchs
 *
 */
public interface Buyable
{
	/**
	 * Return the price of the product in Euro.
	 * 
	 * @return the price in Euro
	 */
	double getPrice();
	/*
	 * Note that the method signatures have no braces and are terminated with a 
	 * semicolon.
	 */
	//->switch to Apple.java (*7*)
}
