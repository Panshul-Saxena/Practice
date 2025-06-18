package Practice.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {

//    private static void printArray(int[] arr, int n) {
//        for (int i = 0; i < n; i++) {
//            if (i==0) {
//                System.out.print("["+arr[i]+", ");
//            } else if (i==n-1) {
//                System.out.print(arr[i]+"]");
//            } else {
//                System.out.print(arr[i]+", ");
//            }
//        }
//    }

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

        System.out.println(Arrays.toString(arr)+" <- Array after Bubble Sort");
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i=1; i<n; i++) {
            int temp = arr[i];
            for (int j = i-1; j>=0 && temp < arr[j]; j--) {
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }

        System.out.println(Arrays.toString(arr)+" <- Array after Insertion Sort");
    }

    private static void builtInSort(int[] arr, int n) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)+" <- Array after Arrays.sort()");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.MIN_VALUE;
        while (n < -1) {
            System.out.println("-1 for Sample I/P: arr = [3, 6, 2, 1, 4, -1, 5, 0, 5]");
            System.out.println("n for manual I/P array of len n");
            System.out.print("Enter the option: ");
            n = sc.nextInt();
        }
        int[] arr;

        if (n == -1) {
            arr = new int[]{3, 6, 2, 1, 4, -1, 5, 0, 5};
            n = arr.length;
        } else {
            arr = new int[n];
            for (int i=0; i<n; i++) {
                System.out.print("Enter the element at index "+i+"/"+(n-1)+": ");
                arr[i] = sc.nextInt();
            }
        }

        System.out.println("=====================================================");
        System.out.println(Arrays.toString(arr)+" <- Array before sorting");
        System.out.println("=====================================================");

        bubbleSort(arr, n);
        insertionSort(arr, n);
        builtInSort(arr, n);
    }
}
