package homework;

import stdlib.StdIn;
import stdlib.StdOut;

// Ximan Liu

/*
Enter an integer: 
5
M: 1
Sum(M): 1
M(M+1)/2: 1
M: 2
Sum(M): 3
M(M+1)/2: 3
M: 3
Sum(M): 6
M(M+1)/2: 6
M: 4
Sum(M): 10
M(M+1)/2: 10
M: 5
Sum(M): 15
M(M+1)/2: 15
*/

public class csc402hw1d {
	

	public static void main (String[] args) {
		
		int N;
		int M;
		int value;
		
		StdOut.println("Enter an integer: ");
		N = StdIn.readInt();
		
		for(M = 1; M <= N; M++) {
			StdOut.println("M: " + M);
			sumInts(N);
			StdOut.println("Sum(M): " + sumInts(M));
			value = (M + 1)* M / 2;
			StdOut.println("M(M+1)/2: " + value);
		}
	}
		
	
	public static int sumInts(int N) {
		
		int result = 0;
		
		for (int i = 1; i <= N; i++) {
			result += sum1(i);
	}
		return result;
	}
	
	public static int sum1(int i) {
		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}
	}

