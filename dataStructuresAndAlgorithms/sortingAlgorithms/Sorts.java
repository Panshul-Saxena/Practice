package dataStructuresAndAlgorithms.sortingAlgorithms;

import java.util.Arrays;

public class Sorts {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for ( int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i-1; j > -1 && temp < arr[j]; j--) {
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0, j = 0;

        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                combined[index++] = arr1[i++];
            } else {
                combined[index++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            combined[index++] = arr1[i++];
        }

        while (j < arr2.length) {
            combined[index++] = arr2[j++];
        }

        return combined;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int pivot(int[] arr, int pivot, int end) {
        int swapIndex = pivot;

        for (int i = pivot+1; i <= end; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, ++swapIndex, i);
            }
        }

        swap(arr, pivot, swapIndex);
        return swapIndex;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIndex = pivot(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{6, 1, 2, 5, 4, 3, 8, 7, 10, 9};

//        bubbleSort(arr1);
        selectionSort(arr1);
//        insertionSort(arr1);
//        System.out.println(Arrays.toString(mergeSort(arr1)));
//        quickSort(arr1, 0, arr1.length - 1);

        System.out.println(Arrays.toString(arr1));
    }
}
