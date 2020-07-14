package homework;

import stdlib.StdIn;
import stdlib.StdOut;

// Ximan Liu

/*
Enter a floating point number: 
3.5
Enter another floating point number: 
4.2
The sum of the two numbers A + B is 7.7
The difference of the two numbers A - B is -0.7000000000000002
The quotient (first/second) A / B is 0.8333333333333333
The quantity is 192.79056951583615
*/

public class csc402hw1a {
	
	
	public static void main(String[] args) {
		double A, B;
		
		// input
		StdOut.println("Enter a floating point number: ");
		A = StdIn.readDouble();
		StdOut.println("Enter another floating point number: ");
		B = StdIn.readDouble();
		
		// compute properties
		double sum, difference, quotient, quantity;
		
		sum = A + B;
		difference = A - B;
		quotient = A / B;
		quantity = Math.pow(A, B);
		
		// output
		StdOut.println("The sum of the two numbers A + B is " + sum);
		StdOut.println("The difference of the two numbers A - B is " + difference);
		StdOut.println("The quotient (first/second) A / B is " + quotient);
		System.out.println("The quantity is " + quantity);
		
	}

}
