package homework;
import stdlib.*;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;

/** 
 * CSC402Homework7  version 1.0
 * 
 *   Ximan Liu
 *   CSC 402
 *   
 *  this class implements a  Dequeue -  a double-ended queue, where elements may be 
 *  added or removed from either end.  
 *       pushLeft means add a value to the left end, 
 *       pushRight means add a value to the right end,
 *       similarly for popLeft, popRight
 *               
 *  The dequeue is implemented using a doubly-linked list: 
 *      each node has a link to the successor and predecessor nodes. 
 *  The instance variable  first is used to 'point' at the left-most node
 *  The instance variable  last is used to 'point' at the right-most node
 *  The instance variable N keeps a count of the size of the Dequeue
 *  
 * Complete the 6 methods below marked ToDo
 * 
 *
 * You may not add any fields to the node or list classes.
 * You may not add any methods to the node class.
 * Do not change any 'Utility' methods that I have included.
 * 
 * You should not use any loops or recursions, except in "delete"
 * Delete may use one loop or recursive helper.
 * You may NOT use any other Java classes without permission.
 * 
 * Some testing code is provided, called from main.  You can comment these in/out while 
 * you are working on the various functions.  
 * Testing code is not guaranteed to be exhaustive.  You are encouraged to review the 
 * tests and see if there other tests that are warranted.
 * 
 * Suggestion: start with push and pop
 *
 */

public class CS402Dequeue {
	Node first,last;
	int N;

	static class Node {
		public Node(double item, Node prev, Node next) { this.item = item; this.prev = prev; this.next = next; }
		// TODO Auto-generated constructor stub
		public double item;
		public Node next;
		public Node prev;
	}

	public CS402Dequeue ()         { 
		first = last = null;
		N = 0;
	};              // constructor
	public boolean isEmpty () { return N == 0; }
	public int size ()        { return N; }

	/** pushLeft
	 * 
	 * add a new node containing item as the left-most node in the Dequeue
	 * preconditions:  none
	 * 
	 */
	public void pushLeft (double item) {
		Node a = new Node(item, null, null);
		if (N == 0) {
			first = a;
			last = a;
		} else {
			a.next = first;
			first.prev = a;
			first = a;
		}
		N++;
		// ToDo 1:  fix this
	}
	/** pushRight
	 * 
	 * add a new node containing item as the right-most node in the Dequeue
	 * preconditions:  none

	 */
	public void pushRight (double item) {
		Node b = new Node(item, null, null);
		if (N == 0) {
			first = b;
			last = b;
		} else {
			b.prev = last;
			last.next = b;
			last = b;
		}
		N++;
		
		//ToDo 2: fix this

	}

	/** popLeft
	 * 
	 * remove the leftMost node in the Dequeue, return the item
	 * preconditions:  none
	 *
	 */
	public double popLeft () {
		if (N == 0) throw new NoSuchElementException ("The dequeue is empty");
		
		Node temp = first;
		if (first == last) {
			last = null;
		}
		else {
			first.next.prev = null;
		}
		first = first.next;
		temp.next = null;
		N--;
		
		return temp.item;
		
		// ToDo 3: fix this
		// return StdRandom.uniform();
	}
	


	/** popRight
	 * 
	 * remove the rightMost node in the Dequeue, return the item
	 * preconditions:  none
	 * 
	 */
	public double popRight () {
		if (N == 0) throw new NoSuchElementException ();
		
		Node temp2 = last;
		if (first == last) {
			first = null;
		}
		else {
			last.prev.next = null;
		}
		last = last.prev;
		temp2.prev = null;
		N--;
		return temp2.item;
		
		// ToDo 4: fix this
		// return StdRandom.uniform();
	}

	/** concat
	 * 
	 * The concat method should take the Nodes from "that" and add them to "this"
	 * After execution, "that" should be empty.
	 * See the tests in the main program.
	 *
	 * Do not use a loop or a recursive definition.
	 * This method should create no new Nodes;
	 * it may not call pushLeft or pushRight.
	 * 
	 */
	public void concat (CS402Dequeue that) {
		
		if(that.N == 0) return;
		
		if(this.N == 0) {
				this.first = that.first;
				this.last = that.last;
				this.N = that.N;
				that.N = 0;
				that.first = null;
				that.last = null;
		}
		else {
			this.N += that.N;
			this.last.next = that.first;
			that.first.prev = this.last;
			that.N = 0;
			this.last = that.last;
			that.first = null;
			that.last = null;
			}
		}
			
		// ToDo 5:  fix this

	/** Delete 
	 * 
	 * delete and return the kth element from the left (where k is between 0 and N-1).
	 * See the tests in the main program.
	 *
	 * You may use a loop or a recursive definition here.
	 * This method should create no new Nodes;
	 * it may not call pushLeft, pushRight, popLeft, popRight
	 * 
	 */
	public double delete (int k) {
		if (k < 0 || k >= N) throw new IllegalArgumentException ();
		
		Node temp = first;
		
		Node temp2 = last;
		
		if (k == 0) {
			if (first == last) {
				last = null;
			}
			else {
				first.next.prev = null;
			}
			first = first.next;
			temp.next = null;
			N--;
			return temp.item;		
			}
		
		if (k == N - 1) {
			if (first == last) {
				first = null;
			}
			else {
				last.prev.next = null;
			}
			last = last.prev;
			temp2.prev = null;
			N--;
			return temp2.item;	
		}
		else {
			for (int i = 0; i <= k; i++) {
				if (i != k) {
					temp = temp.next;
				}
				else {	
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					temp.prev = null;
					temp.next = null;
					N--;
					return temp.item;
				}
			}
			return 0.0;
		}
	}
	
		// ToDo 6: fix this
		// return StdRandom.uniform();


	////////////////////////////////////////////////////////////////////
	// push/pop tests
	////////////////////////////////////////////////////////////////////
	public static void pushPopTests() {

		// Here are some tests to get you started.
		// You can edit this all you like.
		CS402Dequeue d1, d2, d3;
		double k;

		d1 = new CS402Dequeue ();
		d1.pushLeft (11);
		check ("left", d1, "[ 11 ]");
		d1.pushLeft (12);
		check ("left", d1, "[ 12 11 ]");
		d1.pushLeft (13);
		check ("left", d1, "[ 13 12 11 ]");
		k = d1.popLeft ();
		check ("left", d1, "[ 12 11 ]", k, 13);
		k = d1.popLeft ();
		check ("left", d1, "[ 11 ]", k, 12);
		k = d1.popLeft ();
		check ("left", d1, "[ ]", k, 11);

		d1 = new CS402Dequeue ();
		d1.pushRight (11);
		check ("right", d1, "[ 11 ]");
		d1.pushRight (12);
		check ("right", d1, "[ 11 12 ]");
		d1.pushRight (13);
		check ("right", d1, "[ 11 12 13 ]");
		k = d1.popRight ();
		check ("right", d1, "[ 11 12 ]", k, 13);
		k = d1.popRight ();
		check ("right", d1, "[ 11 ]", k, 12);
		k = d1.popRight ();
		check ("right", d1, "[ ]", k, 11);

		d1 = new CS402Dequeue ();
		d1.pushLeft (11);
		check ("left/right", d1, "[ 11 ]");
		d1.pushRight (21);
		check ("left/right", d1, "[ 11 21 ]");
		d1.pushLeft (12);
		check ("left/right", d1, "[ 12 11 21 ]");
		d1.pushRight (22);
		check ("left/right", d1, "[ 12 11 21 22 ]");
		k = d1.popLeft ();
		check ("left/right", d1, "[ 11 21 22 ]", k, 12);
		k = d1.popLeft ();
		check ("left/right", d1, "[ 21 22 ]", k, 11);
		k = d1.popLeft ();
		check ("left/right", d1, "[ 22 ]", k, 21);
		k = d1.popLeft ();
		check ("left/right", d1, "[ ]", k, 22);

		d1 = new CS402Dequeue ();
		d1.pushLeft (11);
		check ("left/right", d1, "[ 11 ]");
		d1.pushRight (21);
		check ("left/right", d1, "[ 11 21 ]");
		d1.pushLeft (12);
		check ("left/right", d1, "[ 12 11 21 ]");
		d1.pushRight (22);
		check ("left/right", d1, "[ 12 11 21 22 ]");
		k = d1.popRight ();
		check ("left/right", d1, "[ 12 11 21 ]", k, 22);
		k = d1.popRight ();
		check ("left/right", d1, "[ 12 11 ]", k, 21);
		k = d1.popRight ();
		check ("left/right", d1, "[ 12 ]", k, 11);
		k = d1.popRight ();
		check ("left/right", d1, "[ ]", k, 12);
		StdOut.println ("Finished push/pop tests");
	}
	////////////////////////////////////////////////////////////////////
	//test exceptions
	////////////////////////////////////////////////////////////////////
	public static void exceptionTests() {
		CS402Dequeue d1;
		d1 = new CS402Dequeue ();
		try {
			d1.popLeft ();
			showError ("Expected exception");
		} catch (NoSuchElementException e) {}
		try {
			d1.popRight ();
			showError ("Expected exception");
		} catch (NoSuchElementException e) {}
		StdOut.println ("Finished exception tests");
	}
	////////////////////////////////////////////////////////////////////
	// concat tests (and more push/pop tests)
	////////////////////////////////////////////////////////////////////
	public static void concatTests() {

		CS402Dequeue d1, d2, d3;

		d1 = new CS402Dequeue ();
		d1.concat (new CS402Dequeue ());
		check ("concat", d1, "[ ]");
		d1.pushLeft (11);
		d1.concat (new CS402Dequeue ());
		check ("concat", d1, "[ 11 ]");

		d1 = new CS402Dequeue ();
		d2 = new CS402Dequeue ();
		d2.pushLeft (11);
		d1.concat (d2);
		check ("concat", d1, "[ 11 ]");

		d1 = new CS402Dequeue ();
		for (int i = 10; i < 15; i++) { d1.pushLeft (i); checkInvariants ("left", d1); }
		for (int i = 20; i < 25; i++) { d1.pushRight (i); checkInvariants ("right", d1); }
		check ("concat", d1, "[ 14 13 12 11 10 20 21 22 23 24 ]");
		d2 = new CS402Dequeue ();
		d1.concat (d2);
		check ("concat", d1, "[ 14 13 12 11 10 20 21 22 23 24 ]");
		check ("concat", d2, "[ ]");

		for (int i = 30; i < 35; i++) { d2.pushLeft (i); checkInvariants ("left", d2); }
		for (int i = 40; i < 45; i++) { d2.pushRight (i); checkInvariants ("right", d2); }
		check ("concat", d2, "[ 34 33 32 31 30 40 41 42 43 44 ]");

		d3 = new CS402Dequeue ();
		d2.concat (d3);
		check ("concat", d2, "[ 34 33 32 31 30 40 41 42 43 44 ]");
		check ("concat", d3, "[ ]");

		d1.concat (d2);
		check ("concat", d1, "[ 14 13 12 11 10 20 21 22 23 24 34 33 32 31 30 40 41 42 43 44 ]");
		check ("concat", d2, "[ ]");
		for (int i = 0; i < 20; i++) { d1.popLeft (); checkInvariants ("left", d1); }
		StdOut.println ("Finished concat tests");
	}

	////////////////////////////////////////////////////////////////////
	// delete tests
	////////////////////////////////////////////////////////////////////
	public static void deleteTests() {

		CS402Dequeue d1, d2, d3;
		double k;
		d1 = new CS402Dequeue ();
		d1.pushLeft (11);
		k = d1.delete (0);
		check ("delete", d1, "[ ]", k, 11);
		for (int i = 10; i < 20; i++) { d1.pushRight (i); checkInvariants ("right", d1); }
		k = d1.delete (0);
		check ("delete", d1, "[ 11 12 13 14 15 16 17 18 19 ]", k, 10);
		k = d1.delete (8);
		check ("delete", d1, "[ 11 12 13 14 15 16 17 18 ]", k, 19);
		k = d1.delete (4);
		check ("delete", d1, "[ 11 12 13 14 16 17 18 ]", k, 15);
		StdOut.println ("Finished delete tests");
	}
	public static void main (String args[]) {
		//Trace.drawStepsOfMethod ("main");
		//Trace.drawStepsOfMethod("pushPopTests");
		//Trace.drawStepsOfMethod("exceptionTests");
		//Trace.drawStepsOfMethod("concatTests");
		//Trace.drawStepsOfMethod("deleteTests");
		//Trace.drawStepsOfMethod("delete");    // add more Traces if you like
		//Trace.run ();
		pushPopTests();
		exceptionTests();
		concatTests();
		deleteTests();

	}

	/**   *********************************** Utility routines   ***************************************
	 * 
	 */
	public CS402Dequeue (String s) {
		String[] nums = s.split (" ");
		for (int i = nums.length-1; i >= 0; i--) {
			try { 
				pushLeft (Double.parseDouble (nums[i]));			
			} catch (NumberFormatException e) {	}
		}
	}
	public String toString () { 
		DecimalFormat format = new DecimalFormat ("#.###");
		StringBuilder result = new StringBuilder ("[ ");
		for (Node x = first; x != null; x = x.next) {
			result.append (format.format (x.item));
			result.append (" ");
		}
		result.append ("]");
		return result.toString ();
	}

	static void showError (String message) {
		Trace.draw ();
		StdOut.println (message);
		//throw new Error (); // stops execution
	}
	public static void checkInvariants (String message, CS402Dequeue that) {
		int N = that.N;
		CS402Dequeue.Node first = that.first;
		CS402Dequeue.Node last = that.last;

		if (N < 0) throw new Error ();
		if (N == 0) {
			if (first != null || last != null) {
				showError (String.format ("%s: Expected first,last == null.", message));
			}
		} else {
			if (first == null || last == null) {
				showError (String.format ("%s: Expected first,last != null.", message));
			}
		}
		if (N > 0) {
			CS402Dequeue.Node prev = null;
			CS402Dequeue.Node current = first;
			for (int i = 0; i < N; i++) {
				if (current == null) {
					showError (String.format ("%s: Expected %d next nodes, but got less.", message, N));
				}
				if (current.prev != prev) { 
					showError (String.format ("%s: Broken prev link.", message));
				}
				prev = current;
				current = current.next;
			}
			if (current != null) {
				showError (String.format ("%s: Expected %d next nodes, but got more.", message, N));
			}
			CS402Dequeue.Node next = null;
			current = last;
			for (int i = 0; i < N; i++) {
				if (current == null) {
					showError (String.format ("%s: Expected %d prev nodes, but got less.", message, N));
				}
				if (current.next != next) {
					showError (String.format ("%s: Broken next link.", message));
				}
				next = current;
				current = current.prev;
			}
			if (current != null) {
				showError (String.format ("%s: Expected %d prev nodes, but got more.", message, N));
			}
		}
	}
	private static void check (String message, CS402Dequeue actual, String expected) {
		checkInvariants (message, actual);
		if (expected != null) {
			if (!expected.equals (actual.toString ())) {
				showError ("Expected \"" + expected + "\", got \"" + actual + "\"");
			}
		}
	}
	private static void check (String message, CS402Dequeue actual, String expected, double dActual, double dExpected) {
		if (dExpected != dActual) {
			showError ("Expected \"" + dExpected + "\", got \"" + dActual + "\"");
		}
		check (message, actual, expected);
	}


}
