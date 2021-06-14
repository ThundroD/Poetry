package poetry;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;

public class Poetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declare file and print writer
		File output;
		PrintWriter writer;
		//Create EcodedPoem
		try {
		// make new file and create a new print writer
		output = new File("encodedPoem.txt"); 
		writer = new PrintWriter(output); 
		//declare scanner and which file to scan
		File x=new File("poem.txt"); 
		Scanner sc=new Scanner(x); 
		//Initate while loop, which scans line, applies method, ConvertToUni then prints in new file
			while(sc.hasNextLine()) {
				String line = sc.nextLine(); 
				line = convertToUni(line);
				writer.println(line); 
			}
		//close scanner and writer
		sc.close(); 
		writer.close(); 
		}
		//catch, if if file not found give statement
		catch (FileNotFoundException e){ 
			System.out.println("Error: Cannot access file");
		}
		
		//Capital Vowels Poem
		File Vowelput;
		PrintWriter writing;
		
		try {
		//create new file Capital vowels  and create new Print Writer
			Vowelput = new File("capitalVowels.txt"); 
			writing = new PrintWriter(Vowelput); 
		//declare a the scanner and what file it's scanning	
			File y=new File("encodedPoem.txt");
			Scanner sc=new Scanner(y); 
		//Initiate while loop which scans while there is a next line, uses method, then prints in new file
				while(sc.hasNextLine()) { 
					String vowel = sc.nextLine(); 
					vowel = capitalVowel(vowel); 
					writing.println(vowel); 
				}
		//close scanner and writer
			sc.close(); 
			writing.close(); 
			}
		 //catch, if if file not found give statement
			catch (FileNotFoundException e){
				System.out.println("Error: Cannot access file");
			}
	
		//Reverse Poem
		File reversePut;
		PrintWriter reverseWrite;
				
			try {
				//Create new file reversePoem and create new PrintWriter variable
				reversePut = new File("reversePoem.txt"); 
				reverseWrite = new PrintWriter(reversePut); 
				//declare variables scanner and what to scan		
				File z = new File("capitalVowels.txt"); 
				Scanner sc = new Scanner(z); 
				//Initiate while loop to scan lines, use reverseCape method and print in new file
				while(sc.hasNextLine()) { 
					String reverse = sc.nextLine();
					reverse = reverseCap(reverse);
					reverseWrite.println(reverse); 
						}
				//close writer and scanner
				sc.close(); 
				reverseWrite.close(); 
					}
			//catch, if if file not found give statement
				catch (FileNotFoundException e){ 
					System.out.println("Error: Cannot access file");
					}
		
	}
	//Methods
	
	//Method for encodedPoem.txt: Create original poem to cipher by moving letters 15 places
	public static String convertToUni(String str) {
		//declare variables
		int uniCode;
		int [] uniArray = new int [str.length()];
		//Initiate for loop to apply char codes to each character
			for(int i = 0; i < str.length(); i ++) {
				uniCode = (Character.codePointAt(str, i));
		//if statement to find move char codes 15 places
				if(uniCode >= 65 && uniCode <= 90) {
					uniArray[i] = (((uniCode - 65 + 15) % 26) + 65);
				}
				else if(uniCode >= 97 && uniCode <= 122) {
					uniArray[i] = (((uniCode - 97 + 15) % 26) + 97);
				}
				else if(uniCode == 32) {
					uniArray[i] = 32;
				}
				else {
					uniArray[i] = uniCode;
				}
			}
			//return the codes back as a string
			String secretMessage = secretMessage(uniArray);
			return secretMessage;
		}
		//Method to return ascii code back to string
		public static String secretMessage(int [] uniCodeArr) {

	        return new String (uniCodeArr, 0, uniCodeArr.length);
	        }
		
		//Method for capitalVowels.txt: Creates all vowels Capital
		public static String capitalVowel(String str) {
			//variables
			int uniCode;
			int [] uniArray = new int [str.length()];
			//Initiate for loop for find character codes
				for(int i = 0; i < str.length(); i ++) {
					uniCode = (Character.codePointAt(str, i));
			//if a vowel is lower case create it upper case, if not a vowel keep 
					if(uniCode == 97 || uniCode == 101 || uniCode == 105 || uniCode == 111 || uniCode == 117) {
						uniArray[i] = (uniCode - 32);
					}
					else {
						uniArray[i] = uniCode;
					}
				}
			//turn ascii code back to string	
				String secretVowel = secretMessage(uniArray);
				return secretVowel;
			}
			
			
			//Method for ReversePoem.txt: Creates reverse lines and capitals back to normal 
			public static String reverseCap(String str) {
				
				//Reverse String
				
				//variables
				String[] words = str.split(" ");
				String reversedString = "";
				//Initiate for loop to reverse words to find all characters
				for(int i = 0; i < words.length; i ++) { 
					String word = words[i]; 
				    String reverseWord = "";
				    //Initiate for loop to reverse words
					for (int j = word.length()-1; j >= 0; j--){ 
				        reverseWord = reverseWord + word.charAt(j);
				     }
					
				     reversedString = reversedString + reverseWord + " ";
				 }
				 
				//Change Capital vowels to lowerCase
				int lowerCaseVowels;
				int [] vowelsLowArray = new int [reversedString.length()];
				
				for (int k = 0; k < reversedString.length();k++) {
					lowerCaseVowels = Character.codePointAt(reversedString, k);
					//if vowel is lower case +32 to be upper case
					if(lowerCaseVowels == 65 || lowerCaseVowels == 69 || lowerCaseVowels == 73 || lowerCaseVowels == 79 || lowerCaseVowels == 85) {
						vowelsLowArray[k] = (lowerCaseVowels + 32);
					}
					//if anything else keep the same
					else {
						vowelsLowArray[k] = lowerCaseVowels;
					}
				
				}
				//convert to unicode to a string so we can use it as a string
				String reverseUniCodeStr = secretMessage(vowelsLowArray);
				
				//Set String back to original text
				//variables
				int reverseUniCode;
				int [] reverseUniArray = new int[reverseUniCodeStr.length()];
				//Initiate for loop to find all ascii codes of chars
				for(int y = 0; y < reverseUniCodeStr.length(); y ++) {
					reverseUniCode = Character.codePointAt(reverseUniCodeStr, y);
					//if statement to move ascii back 15 places to original text
					if(reverseUniCode >= 65 && reverseUniCode <= 79) {
						reverseUniArray[y] = (reverseUniCode - 15) + 26;
					}
					else if(reverseUniCode >= 80 && reverseUniCode <= 90) {
						reverseUniArray[y] = reverseUniCode - 15;
					}
					else if (reverseUniCode >= 97 && reverseUniCode <= 111) {
						reverseUniArray[y] = (reverseUniCode - 15) + 26;
					}
					else if (reverseUniCode >= 112 && reverseUniCode <= 122) {
						reverseUniArray[y] = reverseUniCode - 15;
					}
					else {
						reverseUniArray[y] = reverseUniCode;
					}
					
						
				}
				//return a reversed version of original text
				String originalReversed = secretMessage(reverseUniArray);
				return originalReversed;
			}

	} //end of class


