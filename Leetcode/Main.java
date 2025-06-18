package Leetcode;
//
//public class Main {
//
//    public static int hcf(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }
//
//    public static int rhcf(int a, int b) {
//        if (b == 0) return a;
//        return rhcf(b, a % b);
//    }
//
//    public static int lcm(int a, int b) {
//        int max = Math.max(a, b);
//        int lcm = max;
//        while (lcm % a != 0 || lcm % b != 0) {
//            lcm += max;
//        }
//        return lcm;
//    }
//
//    public static int rlcm(int a, int b) {
//        return rlcm(Math.max(a, b), a, b);
//    }
//
//    private static int rlcm(int lcm, int a, int b) {
//        if (lcm % a == 0 && lcm % b == 0) return lcm;
//        return rlcm(lcm + Math.max(a, b), a, b);
//    }
//
//    public static boolean isPrime(int n) {
//        if (n <= 1) return false;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) return false;
//        }
//        return true;
//    }
//
//    public static boolean isArmstrong(int n) {
//        int numOfDigits = 0;
//        int temp = n;
//        while (temp != 0) {
//            temp /= 10;
//            numOfDigits++;
//        }
//
//        int sum = 0;
//        temp = n;
//        while (temp != 0) {
//            sum += Math.pow(temp % 10, numOfDigits);
//            temp /= 10;
//        }
//
//        return sum == n;
//    }
//
//    public static boolean isStrong(int n) {
//        int temp = n;
//        int sum = 0;
//        while (temp != 0) {
//            int digit = temp % 10;
//            int fact = 1;
//            for (int i = digit; i >= 2; i--) {
//                fact *= i;
//            }
//            sum += fact;
//            temp /= 10;
//        }
//
//        return sum == n;
//    }
//
//    public static boolean isAutomorphic(int n) {
//        int nSquare = n * n;
//        int temp = n;
//        while (temp > 0) {
//            if (temp % 10 != nSquare % 10) return false;
//            temp /= 10;
//            nSquare /= 10;
//        }
//        return true;
//    }
//
//    public static boolean isAbundant(int n) {
//        int sum = 1;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                if (i != n / i) sum += i + n / i;
//                else sum += i;
//            }
//        }
//        return sum > n;
//    }
//
//    public static int nthFibonacci(int n) {
//        if (n == 0) return 0;
//        else if (n == 1) return 1;
//        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
//    }
//
//    public static void solidStarPattern(int n) {
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++)
//                System.out.print("*");
//            System.out.println();
//        }
//    }
//
//    public static void hollowStarPattern(int n) {
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=n; j++)
//                if (i==1 || i==n || j==1 || j==n  ) System.out.print("*");
//                else System.out.print(" ");
//            System.out.println("");
//        }
//    }
//
//    public static void main(String[] args) {
//        // Test HCF and LCM
//        System.out.println("HCF of 60 and 48: " + hcf(60, 48));
//        System.out.println("Recursive HCF of 60 and 48: " + rhcf(60, 48));
//        System.out.println("LCM of 60 and 48: " + lcm(60, 48));
//        System.out.println("Recursive LCM of 60 and 48: " + rlcm(60, 48));
//
//        // Test Prime, Armstrong, Strong, Automorphic, andAbundant
//        System.out.println("Is 7 prime? " + isPrime(7));
//        System.out.println("Is 153 Armstrong? " + isArmstrong(153));
//        System.out.println("Is 145 Strong? " + isStrong(145));
//        System.out.println("Is 6 Automorphic? " + isAutomorphic(6));
//        System.out.println("Is 12 Abundant? " + isAbundant(12));
//
//        // Test Fibonacci
//        System.out.println("10th Fibonacci number: " + nthFibonacci(10));
//
//        // Test star patterns
//        System.out.println("Solid Star Pattern of 5:");
//        solidStarPattern(5);
//        System.out.println("Hollow Star Pattern of 5:");
//        hollowStarPattern(5);
//    }
//}
import java.util.*;

class Result {
    public static long rearrangeStudents(List<Integer> arrA, List<Integer> arrB) {
        Collections.sort(arrA);
        Collections.sort(arrB);

        List<Integer> excessInA = new ArrayList<>();
        List<Integer> excessInB = new ArrayList<>();
        long totalCost = 0;

        for (int i = 0; i < arrA.size(); i++) {
            if (arrA.get(i) > arrB.get(i)) {
                excessInA.add(arrA.get(i));
                excessInB.add(arrB.get(i));
            } else if (arrA.get(i) < arrB.get(i)) {
                excessInA.add(arrB.get(i));
                excessInB.add(arrA.get(i));
            }
        }

        if (excessInA.size() % 2 != 0) return -1;

        Collections.sort(excessInA);
        Collections.sort(excessInB);

        for (int i = 0; i < excessInA.size() / 2; i++) {
            totalCost += Math.min(excessInA.get(i), excessInB.get(i));
        }

        return totalCost;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> arrA = Arrays.asList(1, 2);
        List<Integer> arrB = Arrays.asList(2, 1);
        long result = Result.rearrangeStudents(arrA, arrB);
        System.out.println(result); // Expected output: 0

        List<Integer> arrA2 = Arrays.asList(4, 2, 2, 21);
        List<Integer> arrB2 = Arrays.asList(1, 4, 1, 2);
        long result2 = Result.rearrangeStudents(arrA2, arrB2);
        System.out.println(result2); // Expected output: 1
    }
}
