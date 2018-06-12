package com.igoroya.codingkatas.june2018;

/**
 * Coding interview question: invert the order of a csv text (string)
 * in such a way that the 1st words are the last. The word itself should 
 * maintain its order  
 * 
 * @author igoroya
 *
 */
public class ReordedCsv {

  public static String reorder(String text) {
    String[] words = text.split(";");
    StringBuilder newText = new StringBuilder();
    for (int i = words.length - 1; i > 0 ; i--) {
      newText.append(words[i]);
      newText.append(";");
    }
    // Take out the extra last ";"
    newText.deleteCharAt(newText.length() -1);
    return newText.toString();
  }
  
  public static void reorderLowLevel(char[] text) {
    // Assume 'split' does not exists and that I do not have strings 
    char[] newText = new char[text.length];
    
    
    int wordLenth = 0;
    int newTextPointer = 0;
    for (int i = text.length - 1; i >= 0 ; i--) {  
      if(text[i] == ';') {
        //System.out.print(" -sep- ");
        for (int j = 0; j <= wordLenth; j++) {
          int posAtNew = newTextPointer + j;
          int posAtOld = i - wordLenth + j; 
          newText[posAtNew] = text[posAtOld];
        }
        newText[newTextPointer + wordLenth + 1] = ';';
        
        //here insert at beginning
        newTextPointer = newTextPointer + wordLenth + 1;//+1 because the ";"
        wordLenth = 0;
      }
      else { 
        wordLenth++;
        //System.out.print(text[i] + " ");
        }
      //newText.append(words[i]);
      //newText.append(";");
    }
    System.out.println("");
    //print new text
    for (int i = 0; i < newText.length - 1 ; i++) {
      System.out.print(newText[i]);
    }
  }
  
  
  public static void main(String[] args) {
    String originalText = "Hello;I;am;Igor;from;Bergara";
    System.out.println("Original Text:" + originalText);
    String invertedText = ReordedCsv.reorder(originalText);
    System.out.println("Reordered Text: " + invertedText);    
    ReordedCsv.reorderLowLevel(originalText.toCharArray());
    
  }

}
