import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class strings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		ArrayList<String> list = new ArrayList<>(Arrays.asList(s.split(",")));
		int n = list.size();

		for (int i=0; i<n;i++) {
			if (list.get(i).length() < 4) {
				list.remove(i--);
				n--;
			} else {
				list.set(i, list.get(i).toLowerCase());
			}
		}

		Collections.sort(list);

		System.out.println("Filtered and sorted: ");
		for (int i=0; i<list.size()-1; i++) System.out.print(list.get(i) +",");
		System.out.print(list.get(list.size()-1));
	}
}