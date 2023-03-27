package ReadabilityScore;

import java.util.Scanner;

public class Stage1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		
		System.out.println(s.length());
		
		if (s.length() <= 100) {
			System.out.println("EASY");
		} else {
			System.out.println("HARD");
		}

	}
}
