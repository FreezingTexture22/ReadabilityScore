package ReadabilityScore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stage3 {
	static String[] array;
	static double numberOfWords;
	static double numberOfSentences;
	static double numberOfCharacters;
	static double theScore;
	static String characters = "";
	static StringBuilder sb = new StringBuilder("");
//	static pathToFile;

	public static void main(String[] args) {
		//pathToFile = args[0];
		inputFile();
		countNumberOfWords();
		countNumberOfSentences();
		countNumberOfCharacters();
		countTheScore();
		
	}

	// input file, and print result: "The text is: \n"
	// Notice, that the text can contain multiple lines, not just a single line
	// like in the previous stages. You should analyze all the lines.
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

	// count number of words
	// This is just an array length
	static double countNumberOfWords() {

		numberOfWords = array.length;
		System.out.println();
		System.out.println("Words: " + (int) numberOfWords);
		return numberOfWords;
	}

	// count number of sentences, the can end with ".", "!", "?"
	// or " " in the end of text only.
	static double countNumberOfSentences() {
		for (String i : array) {
			if (i.matches(".*[!]") || i.matches(".*[.]") || i.matches(".*[?]")) {
				numberOfSentences++;

			}
		}

		if (array[array.length - 1].matches("^.*[^!]") && array[array.length - 1].matches("^.*[^.]")
				&& array[array.length - 1].matches("^.*[^?]")) {
			numberOfSentences++;

		}
		
		System.out.println("Sentences: " + (int) numberOfSentences);
		return numberOfSentences;
		
	}

	// count number of characters (without spaces)
	// The number of characters is any visible symbol
	// (so, in the real text it's everything except space, newline "\n" and tab "\t").
	static double countNumberOfCharacters() {
		characters = sb.toString();
		characters = characters
				.replace(" ", "")
				.replace("\\n", "")
				.replace("\\t", "");
		
		numberOfCharacters = characters.length();
		System.out.println("Characters: " + (int) numberOfCharacters);
		return numberOfCharacters;
	}

	// count the score (round the formula result) and print out recommendations
	// formula - https://en.wikipedia.org/wiki/Automated_readability_index
	static void countTheScore() {
		
		theScore = (4.71*(numberOfCharacters / numberOfWords)) + (0.5 * (numberOfWords / numberOfSentences)) - 21.43;
//		theScore = Math.ceil(theScore);
		int roundedScore =  (int) Math.ceil(theScore);
		System.out.printf("The score is: %.2f", theScore);
		System.out.println();		
		
		String age = (4 + roundedScore) + "-" + (5 + roundedScore);		
		System.out.printf("This text should be understood by %s year-olds.", age);
		
		
	}
}
