package lesson09;

import lesson09.generics.Earring;
import lesson09.generics.GenPair;
import lesson09.generics.Pair;
import lesson09.generics.Sock;

public class Application3Generics
{
	public static void main(String[] args)
	{
		System.out.println("--Generics--");
		//using objects
			//buildPairs();
		//using objects results in errors
			//buildStrangePairs();
		//solution using generics
			//buildGenPairs();
		//working with data structures
			//printPair(new GenPair<Sock>(new Sock(), new Sock()));
				//printPair(new GenPair<Earring>(new Earring(), new Earring()));
	}
	
	/**
	 * Show, how pairs can be built
	 */
	private static void buildPairs()
	{
		Sock s1 = new Sock();
		Sock s2 = new Sock();
		Pair pairOfSocks = new Pair(s1, s2);
		System.out.println("1. pair: " + pairOfSocks);
		
		Earring e1 = new Earring();
		Earring e2 = new Earring();
		Pair earrings = new Pair(e1, e2);
		System.out.println("2. pair: " + earrings);
		
//(1)	we have to cast to a sock, since the method returns an Object
		Sock s =  (Sock) pairOfSocks.getL();
		System.out.println("Left item in pair 1: " + s);
	}
	
	/**
	 * Show that strange combinations are possible.
	 * However, they may result in errors.
	 */
	private static void buildStrangePairs()
	{
		//Given our definition of a pair, we can create strange combinations
		Sock s1 = new Sock();
		Earring e1 = new Earring();
		Pair strange = new Pair(s1, e1);
		System.out.println("Strange pair: " + strange);
		
		//*********************************
		// next, you will get a type error!
		//*********************************
		Earring e = (Earring) strange.getL(); 
		System.out.println("Left item of the strange pair: " + e);
	}
	
	/**
	 * Solution using Generics. A new Pair class was written called GenPair.
	 */
	private static void buildGenPairs()
	{
		Sock s1 = new Sock();
		Sock s2 = new Sock();
		//Show the class GenPair
		GenPair<Sock> pairOfSocks = new GenPair<Sock>(s1, s2);
		System.out.println("1. pair: " + pairOfSocks);
		
		Earring e1 = new Earring();
		Earring e2 = new Earring();
		GenPair<Earring> earrings = new GenPair<Earring>(e1, e2);
		System.out.println("2. pair: " + earrings);
		
		//No cast is necessary, since the objects in the pair are all socks
		Sock s = pairOfSocks.getL();
		System.out.println("Left item in pair 1: " + s);
		
		//Constructing strange pairs is not possible anymore
			//GenPair<Sock> strange = new GenPair<Sock>(s1, e2);
	}
	
	private static void printPair(GenPair<Sock> pair)
	{
		System.out.println(pair);
	}
}
