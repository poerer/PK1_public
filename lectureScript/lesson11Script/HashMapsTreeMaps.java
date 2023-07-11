package lesson11Script;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * Additional resources you might find useful:
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
 * 
 */

/**
 * (*4*)
 * Introduction to HashMaps and TreeMaps.
 * A Map is an object that maps keys to values. A map cannot contain duplicate 
 * keys: Each key can map to at most one value. It models the mathematical 
 * function abstraction. The Map interface includes methods for basic operations 
 * (such as put, get, remove, containsKey, containsValue, size, and empty), 
 * bulk operations (such as putAll and clear), and collection views (such as 
 * keySet, entrySet, and values).
 * The Java platform contains three general-purpose Map implementations: 
 * HashMap, TreeMap, and LinkedHashMap. In this session we are just interested in
 * HashMaps and TreeMaps.
 *  
 * 
 * 
 * @author fuchs
 *
 */
public class HashMapsTreeMaps
{
	public static void main(String[] args)
	{
		//input sentence.
		String example = "to be or not to be";
		//split each word at a white space.
		String[] input = example.split(" ");
		//Initialize the HashMap data structure (or TreeMap for ordered output)
		Map<String, Integer> counter = new HashMap<String, Integer>();
									// new TreeMap<String, Integer>(); //order outcome
        
        for (String token : input) 
        {
            Integer freq = counter.get(token); //Integer because possible null reference
            /*
             * The next line is interesting because it contains a shorter form of an
             * if-statement: 
             * 			(freq == null) ? 1 : freq + 1
             * 						   ^
             * 						decide
             * 			true:	1. alternative: 1
             * 			false:	2. alternative: freq + 1
             * That argument is a conditional expression that has the effect of 
             * setting the frequency to one if the word has never been seen before 
             * or one more than its current value if the word has already been seen.
             */
            counter.put(token, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(counter.size() + " distinct words:");
        System.out.println(counter);
        /*
         * Suppose you'd prefer to see the frequency table in alphabetical order. 
         * All you have to do is change the implementation type of the Map from 
         * HashMap to TreeMap.
         * 
         * We can also access the single entries of a HashMap making use of keyset
         * and entryset:
         */
        for(String key: counter.keySet())
        {
        	System.out.println("Keys: " + key);
        }
        for(Entry<String, Integer> map: counter.entrySet())
        {
        	System.out.println("Key: " + map.getKey() + " value: " + map.getValue());
        }
        //->DONE
    }
	
}
