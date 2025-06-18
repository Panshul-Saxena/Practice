import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.print("Cleaned list:");
        for (int num : list) System.out.print(" " + num);
        System.out.println();

        int sum = 0;
        for (int num : list) sum += num; 
        int avg = (list.size() > 0) ? sum / list.size() : 0;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : list) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        System.out.println("Average: " + avg);
        System.out.println("Second largest: " + secondMax);
    }
}
