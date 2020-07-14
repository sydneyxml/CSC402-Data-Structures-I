package homework;

import java.util.Arrays;
import stdlib.*;

/**
CSC402Homework4  version 1.0
 * 
 *   Ximan Liu
 *   CSC 402
 *   
 *   
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may add new functions. You may also edit the function "main" to test your
 * code.
 *
 * You must not add static variables. You MAY add static functions.
 *
 * It is okay to add functions, such as
 *
 * <pre>
 *     public static double sumOfOddsHelper (double[] list, int i) {
 * </pre>
 *
 * but it is NOT okay to add static variables, such as
 *
 * <pre>
 * public static int x;
 * </pre>
 *
 * As in homework 1,2,3 you must not change the declaration of any method.
 * 
 * You can edit the main function all you want. I will not run your main
 * function when grading. For example, you can "comment out" sections of main
 *  when testing your functions
 */
public class CSC402Homework4 {

	/**
	 * As a model for Problem 1, here are two functions to find the minimum value of an array of ints
	 * an iterative version and a recursive version
	 *
	 * precondition:   list is not empty
	/** iterative version */
	public static double minValueIterative (int[] list) {
		int result = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] < result) {
				result = list[i];
			}
		}
		return result;
	}

	/** recursive version 
	 * Find minimum of a list of size N starting at location 0
	 * Smaller problem is :  Find minimum of list of size N-1, starting at 0
	 * 
	 * precondition:   list is not empty
	 */
	public static int minValueRecursive (int[] list) {
		return minValueHelper (list, list.length);  
	}
	private static int minValueHelper (int[] list, int n) {
		if (n == 1)           // the list of size 1 is the single element list[0]
			return list[0];   //  the minimum of this list is just that element.

		//  else:  find minimum of smaller list

		int minOfSmallerList = minValueHelper( list, n-1);  // recursive call, 'smaller' list

		//  now compare min of smaller list to 'last' element of this list
		//  the list is of size n, the 'last' element is at position n-1
		//    because indexes start at 0.
		int theMin;

		if ( list[n-1] < minOfSmallerList)
			theMin = list[n-1];
		else
			theMin = minOfSmallerList;

		return theMin;
	}

	/**
	 * PROBLEM 1: Translate the following summing function from iterative to
	 * recursive.
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * 
	 * Precondition:  a list of ints, - maybe empty!
	 * Postcondition: the sum of the odd values is returned
	 */
	public static int sumOfOdds (int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				result = result + a[i];
			}
		}
		return result;
	}

	public static int sumOfOddsRecursive (int[] a) {
		return sumOfOddsHelper (a, a.length);
	}
	private static int sumOfOddsHelper (int[] a, int n) {
		if(n == 0)
			return 0;

		int sumOfOdds = sumOfOddsHelper (a, n-1);
		
		int sum = 0;

		if (a[n-1] % 2 != 0) {
			sum += sumOfOdds + a[n-1];
		}
		else {
			sum = sumOfOdds;
		}
		return sum; // TODO 1  replace this by a call to your helper function, then write the helper function below
	}
    // this would be a good place to put the helper function for #1
	/**
	 * Here is an in-place iterative function to reverse an array.
	 * 
	 * in-place means:  we don't create an extra array (to simplify coding)
	 *
	 */
	public static void reverseIterative (int[] a) {
		int hi = a.length - 1;
		int lo = 0;
		while (lo < hi) {
			int loVal = a[lo];
			int hiVal = a[hi];
			a[hi] = loVal;
			a[lo] = hiVal;
			lo = lo + 1;
			hi = hi - 1;
		}
	}
/*
 * * PROBLEM 2: Convert the above iterative function to a recursive version
 * 
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * You may not use any other methods
	 * 
	 * Your helper function must be parameterized to allow a smaller problem to
	 * be specified.  How do you reverse an array of size N?
	 * (the answer is NOT: reverse an array of size N-1 ! )
 */
	public static void reverseArray (int[] a) {
		reverse(a, 0, a.length -1);
	}
	static void reverse(int[] x, int i, int j) {
		if(i<j) {
			int tmp = x[i];
		    x[i] = x[j];
		    x[j] = tmp;
		    reverse(x, ++i, --j);
		}	
		// TODO 2   replace this by a call to your recursive helper function, then write the helper function below		
	}
// a good place for your helper function for #2
	/**
	 * PROBLEM 3: merge together two sorted arrays of ints into a new array.
	 * 
	 * Example1  merge: [1 3 5 7 ] with [ 2 4 6 8] would yield [1 2 3 4 5 6 7 8] 
	 * Example2  merge: [1 6  ] with [ 2 3  8 9] would yield [1 2 3 6 8 9] 
	 * There is no guarantee about the size of either array. When/if you run out of elements in 
	 * either array, copy all the remaining elements from the nonempty array to the the new array 
	 * preconditions:
	 *          both arrays are sorted low to high
	 *          there are no duplicate values among the two arrays
	 *          either array may be empty
	 * postcondition: an array with all elements from both arrays sorted from low to high
	 * 
	 * You may not use any additional methods, sorting routines etc
	 * For full credit, your solution may only go through each array one time ( so in particular - no nested loops)
	 * 
	 * You will need to create a new array inside the function
	 * You do not have to write this recursively. 
	 */

	public static int[] mergeArrays( int[] a, int[] b) {
		
		int n1 = a.length;
		int n2 = b.length;
		
		int[] answer1 = new int[n1+n2];
		
		int i = 0, j = 0, k = 0;
		
		while (i < n1 && j < n2) {
			if (a[i] < b[j]) 
                answer1[k++] = a[i++]; 
            else
                answer1[k++] = b[j++]; 
		}
		while (i < n1) 
            answer1[k++] = a[i++]; 
		while (j < n2) 
            answer1[k++] = b[j++]; 
		
		return answer1; // ToDo  3 .   Fix this.
	}


	/*
	 * testing functions and main.
	 * There are no Todo's for you in the code below.
	 */
	public static void mergeArrayTests() {

		int a[] = new int[] {1,3,5,7,9,11};
		int b[] = new int[] {2,4,6};
		int[] combinedArray = mergeArrays( a,b);
		StdOut.println("merging: "+ Arrays.toString(a) + " " + Arrays.toString(b));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int c[] = new int[] {1,3,5,7,9,11};
		int d[] = new int[] {2,4};
		combinedArray = mergeArrays( c,d);
		StdOut.println("merging: "+ Arrays.toString(c) + " " + Arrays.toString(d));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int e[] = new int[] {1,3,5,7,9,11};
		int f[] = new int[] {};
		combinedArray = mergeArrays( e,f);
		StdOut.println("merging: "+ Arrays.toString(e) + " " + Arrays.toString(f));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int g[] = new int[] {3,11};
		int h[] = new int[] {2,4,6,8,10};
		combinedArray = mergeArrays( g,h);
		StdOut.println("merging: "+ Arrays.toString(g) + " " + Arrays.toString(h));
		StdOut.println("  --> " + Arrays.toString(combinedArray));
	}

	public static void main (String[] args) {
		int[] list0 = new int[] {};
		int[] list1 = new int[] { 5 };
		int[] list2 = new int[] { 3, 4 };
		int[] list3 = new int[] { 2, 3, 4 };
		int[] list4 = new int[] { 1, 2, 4, 5 };
		int[] list5 = new int[] { 6, 1, 2, 3, 8 };

		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list0), sumOfOddsRecursive (list0));
		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list1), sumOfOddsRecursive (list1));
		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list2), sumOfOddsRecursive (list2));
		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list3), sumOfOddsRecursive (list3));
		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list4), sumOfOddsRecursive (list4));
		StdOut.format(" list: %s  sum of odds: %d\n",Arrays.toString(list5), sumOfOddsRecursive (list5));
		StdOut.println();

		StdOut.println ("Reverse: Before: " + Arrays.toString(list1 )  );
		reverseArray (list1);
		StdOut.println ("         After:  " + Arrays.toString (list1) + "\n" );

		StdOut.println ("Reverse: Before: " + Arrays.toString(list2 )  );
		reverseArray (list2);
		StdOut.println ("         After:  " + Arrays.toString (list2) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list3 )  );
		reverseArray (list3);
		StdOut.println ("         After:  " + Arrays.toString (list3) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list4 ) );
		reverseArray (list4);
		StdOut.println ("         After:  " + Arrays.toString (list4) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list5 ) );
		reverseArray (list5);
		StdOut.println ("         After:  " + Arrays.toString (list5) + "\n");

		mergeArrayTests();
	
	}

}
