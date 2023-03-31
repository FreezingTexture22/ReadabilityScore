package ReadabilityScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stage4 {
	static String[] array;
	static double numberOfWords;
	static double numberOfSentences;
	static double numberOfCharacters;
	static double theScore;
	static String characters = "";
	static StringBuilder sb = new StringBuilder("");
	
	static double syllablesTotal = 0;
	static double polysyllablesTotal = 0;
	
	
	
	
	
	public static void main(String[] args) {
		inputFile();
		
		for (String ss : array) {
			countSyllables(ss);
		}
		
	}
	
	static void inputFile() {

		String pathToFile = "file3.txt";
		File file = new File(pathToFile);

		try (Scanner scanner = new Scanner(file)) {
			// if file has multiple lines - concatenate them together
				
			while (scanner.hasNextLine()) {
				sb = sb.append(scanner.nextLine());
			}
			
			// print the imported text
			System.out.println("The text is:");
			System.out.println(sb.toString());
			
			// make array from concatenated string
			array = sb.toString().split(" ");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found: " + pathToFile);
		
		}
		
	}
	
	// count Syllables AND Polysyllables
	static double countSyllables(String s) {
		double syllables = 0;
		double polysyllables = 0;
		s = s.toLowerCase();
		System.out.println(s);
		
		// check if word has syllables except last character
		for (int i = 1; i < s.length(); i++) {
			
			if (s.charAt(i-1) == 'a' || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'i' || s.charAt(i-1) == 'o' || s.charAt(i-1) == 'u' || s.charAt(i-1) == 'y') {				
				
				//check if next char is NOT syllable
				if ((s.charAt(i) != 'a' || s.charAt(i) != 'e' || s.charAt(i) != 'i' || s.charAt(i) != 'o' || s.charAt(i) != 'y')) {
					
					syllables++; // add counter
					i++; // skip next char
				
				}						
			}			
		}
		
		// check if last character is syllable
		if (s.charAt(s.length()-1) == 'a' || s.charAt(s.length()-1) == 'i' || s.charAt(s.length()-1) == 'o' || s.charAt(s.length()-1) == 'u' || s.charAt(s.length()-1) == 'y') {
			syllables++;
		}
		
		if (syllables == 0) {
			syllables++;
		}
		
		if (syllables > 1) {
			polysyllables++;
		}
		
		System.out.println("syllables = " + syllables);
		System.out.println("polysyllables = " + polysyllables);
		
		syllablesTotal = syllablesTotal + syllables;
		polysyllablesTotal = polysyllablesTotal + polysyllables;
		
		System.out.println("syllablesTotal = " + syllablesTotal);
		System.out.println("polysyllablesTotal = " + polysyllablesTotal);
		
		
		return syllables;
		
		
	}
}
