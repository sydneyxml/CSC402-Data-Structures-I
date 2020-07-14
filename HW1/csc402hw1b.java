package homework;

import stdlib.StdIn;
import stdlib.StdOut;

// Ximan Liu

/*
Enter a positive integer: 
8
4
2
1
Run 3
3.0
*/

public class csc402hw1b {

	
	public static void main(String[] args) {
		
		int N;
		
		StdOut.println("Enter a positive integer: ");
		N = StdIn.readInt();
		
		divide(N);
		System.out.println((Math.log(N))/(Math.log(2)));
		
}
	public static int divide(int N) {
		int count = 0;	

		while(N > 1) {
			N = (int)(N/2);
			StdOut.println(N);
			count++;	
	} StdOut.println("Run " + count);
		return N;
}
	
}