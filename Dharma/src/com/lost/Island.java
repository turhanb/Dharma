package com.lost;

public class Island {

	private static final double _PERCENT_CHANCE_USER_INPUT_IS_CORRECT = 0.8;

	public static void main(String[] args) {
		int[] numbers = {4, 8, 15, 16, 23, 42};
		int[] userInput = new int[6];
		
		while(resetClock()){
			waitThirtyMinutes();
			readUserInput(userInput);      // Example: array as parameter
			//readUserInputV2(userInput);  // Example: To demonstrate incorrect use as parameter
			//userInput = readUserInputV3(); // Example: array as return value
			if(!compareNumbers(userInput, numbers)){
				hellBreaksLoose();
				break;
			}
		}
	}

	private static boolean compareNumbers(int[] firstArray, int[] secondArray) {
		// An example on how to iterate over array elements, and to compare two arrays
		// Assumes the length of arrays are identical.
		// Returns false if elements in the two arrays do NOT match.
		// Returns true otherwise. 
		
		for(int i = 0; i < firstArray.length; i++){
			if(firstArray[i] != secondArray[i]){
				System.out.println("Numbers are NOT correct!");
				return false;
			}				
		}
		// If the code reaches this point, then user has entered the correct numbers	
		System.out.println("Numbers are correct!");
		return true;
	}

	private static void readUserInput(int[] a) {
		// A stub to simulate user input. It returns true with _PERCENT_CHANCE_USER_INPUT_IS_CORRECT
		// This version accesses the memory space pointed at by the parameter 
		// and makes direct manipulations. In effect, the original array is impacted.
		double n = Math.random();
		if(n < _PERCENT_CHANCE_USER_INPUT_IS_CORRECT){
			a[0] = 4; a[1] = 8; a[2] = 15; a[3] = 16; a[4] = 23; a[5] = 42;
		}else{
			a[0] = 45; a[1] = 85; a[2] = 155; a[3] = 165; a[4] = 235; a[5] = 425;
		}
		
	}

	private static void readUserInputV2(int[] a) {
		// This version creates two new arrays and ASSIGNS one to the parameter passed. 
		// However, due to 'pass-by-value' nature of Java, 
		// the original array variable, hence the original array does NOT change at all
		
		int[] correctNumbers = {4, 8, 15, 16, 23, 42};
		int[] wrongNumbers = {45, 85, 15, 16, 23, 42};
		double n = Math.random();
		
		if(n < _PERCENT_CHANCE_USER_INPUT_IS_CORRECT){
			a = correctNumbers;
		}else{
			a = wrongNumbers;
		}
		
	}

	private static int[] readUserInputV3() {
		// This version also creates two new arrays and RETURNS one as the return value. 
		// As a result, the original array variable points to a new memory space.
		// Access to the original array is lost and it becomes eligible for Garbage collection.
	
		int[] correctNumbers = {4, 8, 15, 16, 23, 42};
		int[] wrongNumbers = {45, 85, 15, 16, 23, 42};
		double n = Math.random();
	
		if(n < _PERCENT_CHANCE_USER_INPUT_IS_CORRECT){
			return correctNumbers;
		}else{
			return wrongNumbers;
		}	
	}

	private static boolean resetClock() {
		// To simulate the clock reset action, always returns true.
		System.out.println("Clock reset!");
		return true;
		
	}

	private static void waitThirtyMinutes() {
		// Just to give the feeling that time has passed. It does not really do anything 
		// other than printing in console.
		
		System.out.println("Another 30 minutes have passed, time to enter the numbers!");;
	
		
	}

	private static void hellBreaksLoose() {
		// (Fortunately) it just prints in the console that bad things are gonna happen.
		System.out.println("RUN FOR YOUR LIFE!");
	}

}
