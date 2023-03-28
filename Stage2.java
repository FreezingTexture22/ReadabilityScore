package ReadabilityScore;

import java.util.Scanner;

public class Stage2 {
	static double numberOfSentences = 0;
	static double numberOfWords = 0;
	static double averageSentenceLength = 0;
	static double averageNumberOfWords = 0;
	static String[] array;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// get input and make an array, split by spaces
		array = in.nextLine().split(" ");

//		System.out.println("Number of sentences: " + countNumberOfSentences());
//		System.out.println("Number of words: " + countNumberOfWords());
//		System.out.println("Average words in sentence: " + getAverageNumberOfWords());

		countNumberOfSentences();
		countNumberOfWords();
		getAverageNumberOfWords();

		if (averageNumberOfWords <= 10) {
			System.out.println("EASY");
		} else {
			System.out.println("HARD");
		}

	}

	// count number of sentences ('!', '.', '?' - or last word without them)
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

		return numberOfSentences;
	}

	// count number of words
	static double countNumberOfWords() {
		numberOfWords = array.length;
		return numberOfWords;
	}

	// get average number of words per sentence
	static double getAverageNumberOfWords() {
		averageNumberOfWords = numberOfWords / numberOfSentences;
		return averageNumberOfWords;
	}

}
