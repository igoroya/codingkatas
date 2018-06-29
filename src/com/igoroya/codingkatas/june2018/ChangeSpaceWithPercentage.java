package com.igoroya.codingkatas.june2018;

/**
 * The class with a helper class that replaces blank spaces with "%"
 * 
 * @author igoroya
 *
 */
public class ChangeSpaceWithPercentage {

  public static String replaceBlanks(String input) {
    String[] words = input.split(" ");
    StringBuilder accumulated = new StringBuilder();
    for (String s : words) {
      accumulated.append(s);
      accumulated.append("%");
    }
    accumulated.deleteCharAt(accumulated.length() - 1);
    return accumulated.toString();
    
  }
  
  public static void replaceAndPrint(String oldText) {
    System.out.println(String.format(
        "%s %s %s %s", "Original string:", oldText, "new:", replaceBlanks(oldText)));
  }
  
  public static void main(String[] args) {
    String word1 = "one";
    String word2 = "one two";
    String word3 = "one two three";
    String word4 = "one two three #@% !@#F";
    replaceAndPrint(word1);
    replaceAndPrint(word2);
    replaceAndPrint(word3);
    replaceAndPrint(word4);
   
    
  }

}
