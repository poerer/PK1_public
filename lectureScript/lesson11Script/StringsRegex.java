package lesson11Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_ref_string.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_String
 https://openbook.rheinwerk-verlag.de/javainsel/19_001.html
 */

/**
 * (*3*)
 * Introduction to Strings and regular expressions (regex).
 * Strings are how you work with text in Java. Once a Java String is created you 
 * can search inside it, create substrings from it, create new strings based on 
 * the first but with some parts replaced, plus many other things.
 * Strings in Java are objects. Therefore you need to use the new operator to 
 * create a new Java String object. Here is a Java String instantiation (creation) 
 * example:
 * 				String myString = new String("Hello World");
 * The text inside the quotes is the text the String object will contain. Java 
 * has a shorter way of creating a new String:
 * 				String myString = "Hello World";
 * Instead of passing the text "Hello World" as a parameter to the String 
 * constructor, you can just write the text itself inside the double quote 
 * characters. This is called a String literal. The Java compiler will internally 
 * figure out how to create a new Java String representing the given text
 * 
 * Regular expressions are a way to describe a set of strings based on common 
 * characteristics shared by each string in the set. They can be used to search, 
 * edit, or manipulate text and data. You must learn a specific syntax to create 
 * regular expressions — one that goes beyond the normal syntax of the Java 
 * programming language. Regular expressions vary in complexity, but once you 
 * understand the basics of how they're constructed, you'll be able to decipher 
 * (or create) any regular expression.
 * 
 * @author Fuchs
 *
 */
public class StringsRegex
{
	public static void main(String[] args)
	{
		/*
		 * Before we start manipulating Strings, we first have to see, how we
		 * can compare two or more Strings:
		 */
		String test1 = "hello world";
		String test2 = "hello world";
		String test3 = new String("hello world");
		String test4 = new String("hello world");
		System.out.println("test1 == test2: " + (test1 == test2));
		System.out.println("test3 == test4: " + (test3 == test4));
		System.out.println("test1 == test4: " + (test1 == test4));
		/*
		 * This behavior seems really strange. To understand what is going on
		 * we have to check the inner workings on how Strings are kept in memory:
		 * If you use the same string (e.g. "hello world") in another String 
		 * variable declarations, the Java virtual machine may only create a 
		 * single String instance in memory. The string literal thus becomes a 
		 * de facto constant or singleton. The various different variables 
		 * initialized to the same constant string will point to the same String 
		 * instance in memory. That is why test1 and test2 are identical because
		 * the Java virtual machine will make both test1 and test2 point to the 
		 * same String object. If we use the new operator the Java virtual machine 
		 * will create two different objects in memory to represent them. Our 
		 * variables test3 and test4 reference, therefore, separate String objects.
		 */
		System.out.println("+++++++++++++++++++++++++++");
		//Since Strings are objects, we have access to many methods:
		System.out.println("test1 is this long: " + test1.length());
		System.out.println("A substring of test1: " + test1.substring(6));
		System.out.println("The substring 'world' of test1 starts at index: " + 
							test1.indexOf("world"));
		System.out.println("test1 starts with hello: " + test1.startsWith("hello"));
		/*
		 * However, more interesting is to combine Strings with regular expressions:
		 * The most basic form of pattern matching is the match of a string literal. 
		 * For example, if the regular expression is 'foo' and the input string is 
		 * 'foo', the match will succeed because the strings are identical.
		 * If you browse through the Pattern class specification, you'll see tables 
		 * summarizing the supported regular expression constructs. In the "Character 
		 * Classes" section you'll find the following:
		 * 		Construct		Description
		 * 		[abc]			a, b, or c (simple class)
		 * 		[^abc]			Any character except a, b, or c (negation)
		 * 		[a-zA-Z]		a through z, or A through Z, inclusive (range)
		 * 		[a-d[m-p]]		a through d, or m through p: [a-dm-p] (union)
		 * 		[a-z&&[def]]	d, e, or f (intersection)
		 * 		[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
		 * 		[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z] (subtraction)
		 * The left-hand column specifies the regular expression constructs, while 
		 * the right-hand column describes the conditions under which each construct 
		 * will match. The most basic form of a character class is to simply place a 
		 * set of characters side-by-side within square brackets. For example, the 
		 * regular expression [bcr]at will match the words "bat", "cat", or "rat" 
		 * because it defines a character class (accepting either "b", "c", or "r") 
		 * as its first character. We can make use of the following method to check
		 * whether a String satisfies the regular expression (regex):
		 * 					String.matches(regex)						
		 */
		System.out.println("Character Classes:");
		String example = "cat"; //change to rat, bat will also work
		String regex = "[cbr]at";
		System.out.println("cat matches [cbr]at: " + example.matches(regex));
		/*
		 * To match all characters except those listed, insert the "^" metacharacter 
		 * at the beginning of the character class. This technique is known as 
		 * negation. The match is successful only if the first character of the 
		 * input string does not contain any of the characters defined by the 
		 * character class:
		 */
		String hat = "hat";
		regex = "[^cbr]at"; //negation symbol ^
		System.out.println("cat matches [^cbr]at: " + example.matches(regex));
		System.out.println("hat matches [^cbr]at: " + hat.matches(regex));
		/*
		 * Sometimes you'll want to define a character class that includes a 
		 * range of values, such as the letters "a through h" or the numbers 
		 * "1 through 5". To specify a range, simply insert the "-" metacharacter 
		 * between the first and last character to be matched, such as [1-5] or 
		 * [a-h]. You can also place different ranges beside each other within 
		 * the class to further expand the match possibilities. For example, 
		 * [a-zA-Z] will match any letter of the alphabet: a to z (lowercase) 
		 * or A to Z (uppercase).
		 */
		String bat = "bat";
		regex = "[c-h]at";
		System.out.println("cat matches [c-h]at: " + example.matches(regex));
		System.out.println("bat matches [c-h]at: " + bat.matches(regex));
		
		/*
		 * The Pattern API contains a number of useful predefined character 
		 * classes, which offer convenient shorthands for commonly used regular 
		 * expressions:
		 * 		Construct		Description
		 * 		.				Any character (may or may not match line terminators)
		 * 		\d				A digit: [0-9]
		 * 		\D				A non-digit: [^0-9]
		 * 		\s				A whitespace character: [ \t\n\x0B\f\r]
		 * 		\S				A non-whitespace character: [^\s]
		 * 		\w				A word character: [a-zA-Z_0-9]
		 * 		\W				A non-word character: [^\w]
		 * In the table above, each construct in the left-hand column is shorthand 
		 * for the character class in the right-hand column. For example, \d means 
		 * a range of digits (0-9), and \w means a word character (any lowercase 
		 * letter, any uppercase letter, the underscore character, or any digit). 
		 * Use the predefined classes whenever possible. They make your code easier 
		 * to read and eliminate errors introduced by malformed character classes.
		 * Constructs beginning with a backslash are called escaped constructs. 
		 * If you are using an escaped construct within a string literal, you 
		 * must precede the backslash with another backslash for the string to 
		 * compile. For example:
		 * 					String regex = "\\d"; // a single digit
		 * In this example \d is the regular expression; the extra backslash is 
		 * required for the code to compile. 
		 */
		System.out.println("Predefined Character Classes:");
		regex = "\\wat";
		System.out.println("cat matches \\wat: " + example.matches(regex));
		System.out.println("bat matches \\wat: " + bat.matches(regex));
		/*
		 * Quantifiers allow you to specify the number of occurrences to match 
		 * against.
		 * 		Quantifier			Meaning
		 * 		X?					X, once or not at all
		 * 		X*					X, zero or more times
		 * 		X+					X, one or more times
		 * 		X{n}				X, exactly n times
		 * 		X{n,}				X, at least n times
		 * 		X{n,m}				X, at least n but not more than m times
		 * 
		 * Example:
		 */
		System.out.println("Quantifier:");
		String empty = "";
		System.out.println("empty matches a?: " + empty.matches("a?"));
		System.out.println("empty matches a*: " + empty.matches("a*"));
		System.out.println("empty matches a+: " + empty.matches("a+"));
		/*
		 * In the above example, the match is successful in the first two cases 
		 * because the expressions a? and a* both allow for zero occurrences of 
		 * the letter a.
		 */
		String as = "aaa";
		System.out.println("as matches a?: " + as.matches("a?"));
		System.out.println("as matches a*: " + as.matches("a*"));
		System.out.println("as matches a+: " + as.matches("a+"));
		/*
		 * Now, we see that 'aaa' does not match a?. Since there are three as and
		 * only the last one is optional you investigate the following possible
		 * alternatives:
		 * 			  String  regex
		 * 				aaa == a
		 * 				aaa ==
		 * None, are correct matches.
		 * What about ranges:
		 */
		System.out.println("as matches a{4}: " + as.matches("a{4}"));
		System.out.println("as matches a{2,}: " + as.matches("a{2,}"));
		System.out.println("as matches a{3,8}: " + as.matches("a{3,8}"));
		/*
		 * Until now, we've only tested quantifiers on input strings containing 
		 * one character. In fact, quantifiers can only attach to one character 
		 * at a time, so the regular expression "abc+" would mean "a, followed 
		 * by b, followed by c one or more times". It would not mean "abc" one 
		 * or more times. However, quantifiers can also attach to Character Classes 
		 * and Capturing Groups, such as [abc]+ (a or b or c, one or more times) 
		 * or (abc)+ (the group "abc", one or more times).
		 */
		String abc = "abc";
		regex = "[abc]{3}";
		System.out.println("abc matches [abc]{3}: " + abc.matches(regex));
		System.out.println("bbc matches [abc]{3}: " + abc.matches(regex));
		System.out.println("abcabc matches [abc]{3}: " + "abcabc".matches(regex));
		//Here the quantifier {3} applies to the entire character class.
		/*
		 *  Capturing groups are a way to treat multiple characters as a single 
		 *  unit. They are created by placing the characters to be grouped inside 
		 *  a set of parentheses. For example, the regular expression (dog) 
		 *  creates a single group containing the letters "d" "o" and "g".
		 */
		System.out.println("Groups:");
		String dog = "dog";
		String dogs = "dogdog";
		regex = "(dog)";
		System.out.println("dog matches (dog): " + dog.matches(regex));
		System.out.println("dogdog matches (dog): " + dogs.matches(regex));
		System.out.println("dogdog matches (dog){2}: " + dogs.matches(regex+"{2}"));
		/*
		 * Until now, we've only been interested in whether or not a match is 
		 * found at some location within a particular input string. We never 
		 * cared about where in the string the match was taking place. You can 
		 * make your pattern matches more precise by specifying such information 
		 * with boundary matchers. For example, maybe you're interested in 
		 * finding a particular word, but only if it appears at the beginning or 
		 * end of a line. Or maybe you want to know if the match is taking place 
		 * on a word boundary, or at the end of the previous match.
		 * 		Boundary Construct	Description
		 * 		^					The beginning of a line
		 * 		$					The end of a line
		 * 		\b					A word boundary
		 * 		\B					A non-word boundary
		 * 		\A					The beginning of the input
		 * 		\G					The end of the previous match
		 * 		\Z					The end of the input but for the final terminator, if any
		 * 		\z					The end of the input
		 * To show an example we switch to a different method:
		 * 			String.replaceAll(regex, String)
		 * This method replaces all occurrences of a regex with a String. 
		 */
		System.out.println("Boundaries:");
		String begin = "hello world hello students";
		regex = "^hello\\b";
		System.out.println(begin.replaceAll(regex, "-"));
		/*
		 * We are just replacing the first occurrence of 'hello' because of the 
		 * boundary ^ (beginning of line). 
		 * Play around with these boundaries e.g., change to:
		 * 					regex = "\\bhello\\b";
		 */
		/*
		 * Summary:
		 * Strings are a sequence of characters and are widely used in Java 
		 * programming. In the Java programming language, strings are objects. 
		 * The String class has over 60 methods and 13 constructors. The String 
		 * class also includes a number of utility methods, among them split(), 
		 * toLowerCase(), toUpperCase(), and valueOf(). The latter method is 
		 * indispensable in converting user input strings to numbers. The Number 
		 * subclasses also have methods for converting strings to numbers and 
		 * vice versa.
		 * 
		 * For a more precise description of the behavior of regular expression 
		 * constructs, we recommend reading the book Mastering Regular Expressions 
		 * by Jeffrey E. F. Friedl.
		 */
        
        /* 
         * DONE!
         * If you are interested in an associative data structure,
         * you can switch to HashMapsTreeMaps.java (*4*) 
		 * IMPORTANT: this data structure is NOT part of the lecture!
        */
	}
}
