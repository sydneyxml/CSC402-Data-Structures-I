package homework;

import stdlib.StdIn;
import stdlib.StdOut;

// Ximan Liu

/*
Enter your GPA: 
4.0
Enter your GPA: 
3.7
Enter your GPA: 
2.9
Enter your GPA: 
3.5
Enter your GPA: 
-1
4
14.1
3.525
*/

public class csc402hw1c {

	
	public static void main (String[] args) {
		
		double G, avg = 0, sum = 0;
		int num = 0;
		
		while (true) {
			StdOut.println("Enter your GPA: ");
			G = StdIn.readDouble();
			if (G < 0) {
				break;
			}
			num++;
			sum+=G;
			avg = sum / num;
		}
			
		StdOut.println("The number of valid GPAs entered: " + num);
		StdOut.println("The sum of the GPAs: " + sum);
		StdOut.println("The average GPA: " + avg);			
	}

}
