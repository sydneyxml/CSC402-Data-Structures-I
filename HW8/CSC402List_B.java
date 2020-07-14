package homework;


import stdlib.StdOut;
// import stdlib.StdRandom;

// Homework 8   version 1.0
//   
//   Ximan Liu
//	 CSC 402
//
//   In this homework you will implement a scaled down version of the Java List Interface
//    As noted in class, Java provides two implementations of the List Interface:
//        -  ArrayList :   using resizable arrays
//        -  Linkedlist:   using a linked list of nodes
// 
//  And so this List ADT can be implemented using either a basic Java array or linked structure
//  Each implementation has performance advantages and disadvantages
//
//  a Simplification:    The Java List interface is GENERIC; this one is NOT
//                       You are implementing a 'list' of integers - int
//
//  You will complete this exercise twice, once for each possible implementation
//  Eclipse will not allow you to have two copies of the same class in one package
//  So you can either: 
//    A)  complete one version of the exercise; save the Java file for submission
//        complete the second version, starting with a fresh copy of the starter file
//    B)  put a copy of the starter file in two separate packages, this will allow you to
//        have access to both versions at the same time ( be sure you know which is which)
//   Complete all the ToDos   in this order:
//   Setup:      ToDo 0.1, ToDo 0.2, ToDo 0.3, ToDo 0.4
//   Functions:  ToDo 1,   ToDo 2,   ToDo 3,   ToDo 4,   ToDo 5
//
//-------------------------------------------------------------------------------------------
//    Some helper functions are provided for you
//    Do not change them since some of them are used in the testing framework
//
//    createFrom  can be used to populate  your list using data from an input array.
//             you will need to comment-in the correct part corresponding to your implementation choice
//    
//    resize   this only applies to array implementations. 
//             to use it you will need to comment-in the body of the function
//
//    print      will print the list information:  size and contents.  
//------------------------------------------------------------------------------------------------
//    Note that the provided testing framework will not work correctly until you have completed some of the
//    required functions.  And all testing is NOT automated; in some cases you will need to examine the output and verify
//    that the output is as expected.
//
//    You may not use any other Java classes or algorithms in creating your solutions.
//    
public class CSC402List_B {
	// ToDo 0.1

	// choose the implementation for your container
	//  b) resizing array

	// ToDo  0.2
	//   choose your private data variables:   comment-in the ones you want:   B
	//   you can delete the other ones if you want
	//   you will also need to comment-in the relevant sections in the helper functions at the bottom of the file
	//  --> ToDo 0.3, 0.4

	//B
	//	private   int[] a;     // a is to be a resizeable array
	//	private   int N;      // how many spaces in the array are currently used, NOT necessarily the array size

	// instance data
	private int[] a;
	private int N;
	
	public CSC402List_B ( ) {   // the List constructor
		// ToDo 1  initialize your private data
		//   for an array start with an array of size 5, Note that N will NOT be 5
		this.a = new int[5];
		this.N = 0;
	}

	// size
	//
	//  return the number of elements in the list.
	//      this *may not be* the same as the size of the array 
	public int size() {
		return N;  // toDo 2  fix this
	}

	//  get
	//
	//  return the value in position i of your list
	//  Hint:  for an array this is *really* easy
	//              for a linked list, you will need to traverse the list, counting as  you go
	// precondition:   i  is a valid position for the list  
	public int get( int  i) {
		return a[i];  // ToDo 3  fix this
	}

	// remove
	//
	// delete and return the element in position k (where k is between 0 and N-1 inclusive)
	// positions are numbered starting with 0, N is the size of the list
	// preconditions:  0 <= k <= N-1
	//                            :  N >=1 ; list is not empty
	//     Examples:   
	//             10   20   30   40   50,   remove(0)  would result in:    20  30  40  50
	//             10   20   30   40   50,   remove(1)  would result in:    10  30  40  50
	//             10   20   30   40   50,   remove(4)  would result in:    10   20  30  40 
	//   Hint:  for an array, you will need to move every value to the right of position k, left one position
	//          for a linked list you will need to delete the node in that position
	//              deleting the  first node in a linked list is a special case to handle
	public int remove (int k) {
		
		int[] a1 = new int[a.length - 1];
		
		for (int p = 0, q = 0; p < a.length; p++, q++) {
			if (p == k) {
				return a[k];
			}
			else {
				a1[q++] = a[p];
			}
		}
		return 0;
	}
		// ToDo 4
		//return StdRandom.uniform(1000);

	
	// add
	//
	// insert a new value into the list at position k with value: val
	// positions are numbered starting with 0
	// preconditions:  0 <= k <= N-1
	//               list may be empty
	//  Hint:  for an array, you will need to move every value to the right of position k, right one position
	//     for an array, this operation may require resizing the array. A resize method is provided for you;
	//         just invoke   resize( newCapacity );  
	//    for a linked list:  inserting at the front of a list is a special case
	public void add( int k, int value) {
		
		if (N == a.length) {
			resize(a.length *2);
		}
		int prev = value;
		int temp = 0;
		for(int i = k; i < a.length; i++) {
			temp = a[i];
			a[i] = prev;
			prev = temp;
		}
		N++;
		//ToDo 5    fix this
	}

	// contains
	//
	// returns true if the list contains the value: val;  false otherwise
	//
	public boolean contains( int val) {
		int length = a.length;
		for (int i = 0; i < length; i++) {
			if (a[i] == val) {
				return true;
			}
		}
		return false; // ToDo 6  fix this
	}

	
	public static void main(String[] args) {

		// comment out tests you want to skip while working on the assignment
		// comment all in when you submit the assignment
		testContainsMethod();
		testGetMethod();
		testaddMethod();
		testremoveMethod();
	}

	// Testing functions
	//   Each testing function contains at least one sample test case.
	//   Review these test cases and then develop your own test case ( test something different than the example tests!)
	//   Include a comment and a print statement that indicates what you are trying test for.  Hint: think about the extremes

	private static void containsTest( int[] data1, int key, boolean expected) {
		// Test #1 
		CSC402List_B x = createFrom( data1 );
		StdOut.println("----------Contains " + key + " ------------------------");
		print(x);
		boolean result = x.contains(key); // test:    
		if ( result == expected ) 
			StdOut.println("   test successful");
		else
			StdOut.println("   test fails");
	}
	public static void testContainsMethod() {

		containsTest( new int[] {0,1,2,3,4,5}, 3, true);
		containsTest( new int[] {0,1,2,3,4,5}, 8, false);

		// Bonus: ToDo   T1    add one test case after the print statement below
		// should be substantively different from the above two tests
		// uncomment the following line
		StdOut.println("MY bonus test: "); 
		containsTest( new int[] {0,1,2,3,4,6}, 7, false);

	}

	private static void getTest( int[] data1, int index, int expected) {
		// Test #1 
		CSC402List_B x = createFrom( data1 );
		StdOut.println("----------Get " + index + " ------------------------");
		print(x);
		int result = x.get(index); // test:    
		if ( result == expected ) 
			StdOut.println("   test successful");
		else
			StdOut.println("   test fails");
	}
	public static void testGetMethod() {
		getTest( new int[] {0,17,9,12,-1},  2, 9);  // value in position 2 is 9
		getTest( new int[] {17,9,12,-1},  0, 17);  // value in position 2 is 4

		// Bonus: ToDo   T2    add one test case after the print statement below
		// should be substantively different from the above two tests
		// uncomment the following line
		StdOut.println("MY bonus test: ");
		getTest( new int[] {9,12,-1},  0, 9);

	}
	private static void addTest( int[] data1, int data, int index) {
		CSC402List_B x = createFrom( data1 );
		StdOut.println("----------add " + data + " at " + index + " ------------------------");
		print(x);
		x.add(index, data);
		StdOut.format("test:  add(%d, %d)       Result: \n", data, index); 
		print(x);

	}
	public static void testaddMethod() {

		addTest( new int[] {0,17,9,12,-1},  2, 0);  // add 2 in position 9
		addTest( new int[] {0,17,9,12,-1},  5, 3);  // add 5 in position 3

		// Bonus: ToDo   T3    add one test case after the print statement below
		// should be substantively different from the above two tests
		// uncomment the following line
		StdOut.println("MY bonus test: ");
		addTest( new int[] {1,17,9,12,-1},  3, 0);

	}

	private static void removeTest( int[] data1, int index, int expected) {
		CSC402List_B x = createFrom( data1 );
		StdOut.println("----------remove " + index + " ------------------------");
		print(x);
		int result  = x.remove(index);	// insert a value 'in the middle' of the list
		if ( expected == result )
			StdOut.println(" correct result returned");
		else
			StdOut.println(" **incorrect result returned");
		print(x);

	}
	public static void testremoveMethod() {

		removeTest(new int[] {9,8,7,6,5 }, 2,7);  //  remove element 2, should return 7
		removeTest(new int[] {9,8,7,6,5 }, 0,9);  //  remove element 0, should return 9

		// Bonus: ToDo   T4    add one test case after the print statement below
		// should be substantively different from the above two tests
		// uncomment the following line
		StdOut.println("MY bonus test: ");
		removeTest(new int[] {4,8,7,6,5 }, 0,4);
	}


	// ---------------------------------------------------------------------------------------------
	// Helper functions.  
	// These require your methods to work correctly.
	//
	// print
	// print the list information
	public static void print( CSC402List_B a) {
		StdOut.format(" size: %d\n", a.size());
		for (int i=0; i < a.size(); i++)
			StdOut.format(" %d ", a.get(i));
		StdOut.println();
	}

	//createFrom
	//  creates a list instance using the input array data
	//  comment in/out the segment corresponding to your implementation
	//  for an array implementation the array size will be exactly equal to the data array size
	//
	//  To Do 0.3
	public static CSC402List_B createFrom(int[] data) {

		CSC402List_B result = new CSC402List_B ();
		//  B   Array creation code
		//  Comment-in the code below if you are using an array implementation
		//	
			int[] temp = new int[data.length];
			for (int i=0; i < temp.length; i++ ) temp[i] = data[i];
			result.a = temp;
			result.N= data.length;

		return result;

	}

	// resize
	// resizes the array to the specified capacity
	//     copies the old data to the new space
	//     precondition:  capacity >= a.length
	// ToDo 0.4  Comment-in the body of this function if you are doing the array implementation
	// 
	private void resize(int capacity) {
		StdOut.println("***** array resized *****");
		int[] b = new int[capacity];
		for ( int i=0; i < a.length; i++) 
			b[i] = a[i];
		this.a = b;
	}

}



