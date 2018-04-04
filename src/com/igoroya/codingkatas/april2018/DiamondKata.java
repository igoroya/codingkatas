package com.igoroya.codingkatas.april2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Creates a diamond from letter A in the upper and lower vertices
 * to a user-selected letter in the horizontal vertices
 * 
 * Example: INPUT 'C'
 *      __A__
 *      _B_B_
 *      C___C 
 *      _B_B_
 *      __A__
 * 
 * @author igoroya
 *
 */
public class DiamondKata {

	public static void main(String[] args) {
	
		char letter = getLetter();
		
		if(!isValidChar(letter)) {
			System.out.println("Invalid input: "+letter);
			return;
		}
			
		int charnum = getCharNum(letter);
		char[][] chars = createCharArray(2*charnum + 1);
		
		createDiamond(letter, chars);
		printChars(chars);		
	}

	private static char getLetter() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert a letter A-Z");
		scanner.useDelimiter("");
		char letter = scanner.next().charAt(0);
		scanner.close();
		return letter;
	}
	
	private static void createDiamond(char firstLetter, char[][] chars) {
		char nextLetter = firstLetter;
		int charnum = getCharNum(nextLetter);
		
		do {
			putLetter(nextLetter, chars, charnum);
			nextLetter = getNextLetter(nextLetter);
		}
		while(getCharNum(nextLetter) >= 0);
		
		}
	
	private static char getNextLetter(char previousLetter) {
		int newLetterVal = (int)previousLetter -1;
		return (char)newLetterVal;
	}
	
	private static void putLetter(char letter, char[][] chars, int maxCharNum) {
		int number = getCharNum(letter);
		int size = chars[0].length;
		
		int charPosition1 = size/2 - number;
		int charPosition2 = size/2 + number;
		int charRow1 = number;
		int charRow2 = size - number - 1;
		
		chars[charRow1][charPosition1] = letter;
		chars[charRow1][charPosition2] = letter;
		chars[charRow2][charPosition1] = letter;
		chars[charRow2][charPosition2] = letter;
	}
	
	private static void printChars(char[][] chars) {
		for (char[] row: chars) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	private static char[][] createCharArray(int size) {
		char[][] mychar = new char[size][size];		
		
		for (char[] row: mychar) {
			Arrays.fill(row, '_');
		}

		return mychar;		
	}
	
	private static boolean isValidChar(char c) {
		if( ((int)c < (int)'A') || ((int)c > (int)'Z'))
			return false;	
		else
			return true;
	}
	
	private static int getCharNum(char c) {
		int numEquivalent = (int)c - (int)'A';
		return numEquivalent;
	}
}
