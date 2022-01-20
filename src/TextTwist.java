import java.util.Arrays;

public class TextTwist {

	public static void main(String[] args) {
		/*
		 * Array of words guessed with the 6 letters of the original word
		 * 		Assumptions:
		 * 			- No duplicates
		 * 			- All lower case
		 */
		String[] arr = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}; 
		String word = "tossed";		//6-Letter word
		
		int points = totalPoints(arr, word);
		
		System.out.println(points);
	}
	
	/*
	 * Checks if guessed word is possible 
	 * using the original word's letters.
	 * 
	 * Awards points for each successful guess
	 * based on the length of the guessed word.
	 */
	public static int totalPoints(String[] arr, String word) {
		int points = 0;
		int wordLength = 0;
		boolean[] characterUsed = new boolean[6];
		int matchCount = 0;
		int attemptedPointsAdded = 0;
		
		for (String answer : arr){
			wordLength = answer.length();
			Arrays.fill(characterUsed, false);
			matchCount = 0;
			
			switch(wordLength) {	//Determines number of points for attempted word
				case 3:			
					attemptedPointsAdded = 1;
					break;
				case 4:
					attemptedPointsAdded = 2;
					break;
				case 5:
					attemptedPointsAdded = 3;
					break;
				case 6:
					attemptedPointsAdded = 54;
					break;
				default:
					attemptedPointsAdded = 0;
					break;
			}
			
			for(int i = 0; i < wordLength; i++) { //Iterates through guessed word and compares
												  //if the expected character exists
				for(int j = 0; j < 6; j++) {
					if(answer.charAt(i) == word.charAt(j) && !characterUsed[j]) { // Characters match and each
						characterUsed[j] = true;								  // character can only be used once
						matchCount++;
						break;
					}
				}
			}
			if(matchCount == wordLength) {			//Successfully created a word
				points += attemptedPointsAdded;
			}
			
		}
		
		return points;
	}

}
