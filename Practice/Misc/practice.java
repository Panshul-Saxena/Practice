import java.util.Arrays;
import java.util.Scanner;

public class practice{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];

		int countEven = 0;


		for (int i=0; i<n; i++) {
			arr[n-i-1] = sc.nextInt();
			if (arr[n-i-1]%2 == 0) countEven++;
		}

		int evenSum = 0;
		int evenIndex = 0;
		int maxOdd = Integer.MIN_VALUE;

		int[] evenArr = new int[countEven];

		for (int i=0; i<n; i++) {
			if (arr[i]%2 == 0) { 
				evenArr[evenIndex++] = arr[i];
				evenSum += arr[i];
			}
			else maxOdd = Math.max(maxOdd, arr[i]);
		}

		Arrays.sort(evenArr);

		evenIndex = 0;
		for (int i=0; i<n; i++) {
			if (arr[i]%2 == 0) { 
				arr[i] = evenArr[evenIndex++];
			}

		}

		

		System.out.print("Modified array: ");
		for (int num: arr) System.out.print(" "+num);
		System.out.println("\nSum of even numbers: "+evenSum);
		System.out.println("Maximum odd number: "+maxOdd);


	}
}