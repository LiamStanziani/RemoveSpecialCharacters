/* RemoveSpecialCharacters.cs
* Assignment 4
* Revision History
* Liam Stanziani, 2022.12.13: Created
* Liam Stanziani, 2022.12.13: Added code
* Liam Stanziani, 2020.12.15: Debugging complete
* Liam Stanziani, 2020.12.15: Comments added
*
*/

package Assignment4.LiamStanziani;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RemoveSpecialCharacters {
	
	/**
	* Declaring class variables
	*/
	public static ArrayList<String> removedSpecialCharacters = new ArrayList<String>();
	public static ArrayList<String> lengthOfWords = new ArrayList<String>();
	public static Integer maxLength = 0;
	public static ArrayList<String> allCounts = new ArrayList<String>();
	
	/**
	* reads the file inputed by the user, outputs all of the lines to the screen, then it removes all of
	* the special characters from the file and outputs the updated file, then it checks every value
	* inside of a list that has all of the lengths and adds them to a list that shows a count on how many 
	* words there are that are equal to the same amount of letters, up to the max length of any word 
	* in the updated file
	* @param The command-line arguments as an array of string
	*/	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your file name: ");
		
		String inputStr = input.nextLine();
	
		try {
			Scanner fullFile = new Scanner(new File(inputStr));
			
			System.out.println("------------------------");
			System.out.println("Words from file");
			System.out.println("------------------------");
			
			while (fullFile.hasNext()) {
				String currentLine = fullFile.nextLine();
				System.out.println(currentLine);
					
				String updatedLine = currentLine.replaceAll("[0-9-&,./']", "");
				Integer updatedLength = updatedLine.length();
				String updatedLengthStr = updatedLength.toString();
				
				if (updatedLength > maxLength) {
					maxLength = updatedLength;
				}
				
				try {
					if (updatedLine == "")
					{
						
					}
					else
					{
						removedSpecialCharacters.add(updatedLine);
						lengthOfWords.add(updatedLengthStr);
					}
				}
				catch(NoSuchElementException ex) {
					
				}
			}
			
			System.out.println("---------------------------------------------");
			System.out.println("Words after removing special characters");
			System.out.println("---------------------------------------------");
			
			for (String word : removedSpecialCharacters) {
				System.out.println(word);
			}
			
			System.out.println("----------------------------------");
			System.out.println("Length -- number of words");
			System.out.println("----------------------------------");
			
			for (Integer i = 1; i <= maxLength; i++) {
				Integer count = 0;
				allCounts.add(i + " letters -- 0 words");
				
				for (String length : lengthOfWords) {
					if (i.toString().equals(length)) {
						allCounts.set(i - 1, i + " letters -- " + ++count + " words");
					}
				}
			}
			
			for (String counts : allCounts) {
				System.out.println(counts);
			}
		}
		catch(FileNotFoundException ex) {
				System.out.println("Error: Error in the file Open: " + inputStr + " (The system cannot find the file specified)");
				return;
		}
	}
}
