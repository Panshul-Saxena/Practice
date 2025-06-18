package Practice.Arrays;

import java.util.Scanner;

public class Sorting {

    private static void bubbleSort(int[] arr, int n) {

        for (int i=n-1; i>0; i--) {
            for ( int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Array after Bubble Sort: ");
        for (int i=0; i<n; i++) System.out.print(arr[i]+", ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-1 for Sample I/P: arr = [3, 6, 2, 1, 4, -1, 5, 0, 5]");
        System.out.println("n for manual I/P array of len n");
        System.out.println("Enter the option: ");
        int n = sc.nextInt();
        int[] arr;

        if (n == -1) {
            arr = new int[]{3, 6, 2, 1, 4, -1, 5, 0, 5};
            n = arr.length;
        } else {
            arr = new int[n];
            for (int i=0; i<n; i++) {
                System.out.println("Enter the element at index "+i+"/"+n+": ");
                arr[i] = sc.nextInt();
            }
        }
        
        System.out.println("Array before sorting: ");
        for (int i=0; i<n; i++) System.out.print(arr[i]+", ");

        bubbleSort(arr, n);
    }
}
