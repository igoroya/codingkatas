package com.igoroya.codingkatas.april2018;

/**
 * Makes the first 3 letters of each word of a sentence uppercase
 * 
 * @author igoroya
 *
 */
public class MakeSomeUppercase {

	public static void main(String[] args) {

		String sentence = "I had a very good day today in my excursion to the countryside";
		System.out.println("This is the sentence you need to convert");
		System.out.println(sentence);
		System.out.println("Converting sentence");
		System.out.println(getModifiedSentence(sentence));
	}
	
	private static String getModifiedSentence(String sentence) {
		
		StringBuilder newSentence = new StringBuilder();
		String[] words = sentence.split(" ");
		
		for (String word: words) {
			
			int length = word.length();
			String firstPartUppercase = "";
			String secondPartOriginal = "";
			
			if (length > 3) {
				firstPartUppercase = word.substring(0, 3).toUpperCase();
				secondPartOriginal += word.substring(3);
			}
			else
				firstPartUppercase += word.toUpperCase();
				
			String newWord = firstPartUppercase + secondPartOriginal;
			newSentence.append(newWord);
			newSentence.append(" ");
		}
		
		
		
		return newSentence.toString();
		
		
	}

}
