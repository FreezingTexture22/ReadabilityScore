package ReadabilityScore;

import java.util.Scanner;

public class Stage2 {
	static int numberOfSentences = 0;
	static int averageSentenceLength = 0;
	static String[] array;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//get input and make an array, split by spaces
		array = in.nextLine().split(" ");
		
		System.out.println(countNumberOfSentences());
		
	}
	
	//count number of sentences ('!', '.', '?' - or last word without them)  
	static int countNumberOfSentences() {
		for(String i : array) {
			if(i.matches("\\D*[!]") || i.matches("\\D*[.]") || i.matches("\\D*[?]") ) {
				numberOfSentences++;
				
			}
		}
		
		if (array[array.length-1].matches("^\\D*[^!]") && array[array.length-1].matches("^\\D*[^.]") && array[array.length-1].matches("^\\D*[^?]")) {
			numberOfSentences++;
			
		}
		
		return numberOfSentences;
	}
	
}
