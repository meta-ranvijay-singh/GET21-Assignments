package ObjectsAndCollections_Q2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	/*
	 * Method to count the unique character in the passed string
	 * 
	 * @param inputString
	 * 
	 * @return count number of unique characters
	 */
	public static int uniqueCharacters(String inputString) {
		int count = 0;

		// Loop for scanning a character from starting to end until a duplicate
		// found
		for (int i = 0; i < inputString.length(); ++i) {
			char inputCharacter = inputString.charAt(i);
			boolean flag = false;
			for (int j = 0; j < inputString.length(); ++j) {
				if (i != j && inputString.charAt(j) == inputCharacter) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				++count;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> previousInputs = new HashMap<String, Integer>();

		String inputString, choice;
		int uniqueCount;

		do {
			System.out.print("Enter String :");
			inputString = in.nextLine();

			if (previousInputs.containsKey(inputString)) {
				uniqueCount = previousInputs.get(inputString);
			} else {
				uniqueCount = uniqueCharacters(inputString);
				previousInputs.put(inputString, uniqueCount);
			}

			System.out.println("No. of unique characters : " + uniqueCount);

			System.out.print("Want to try more?(Y/N) : ");
			choice = in.nextLine();
		} while ("Y".equals(choice) || "y".equals(choice));

		in.close();
	}

}
