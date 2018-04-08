package com.igoroya.codingkatas.april2018.deckofcards;

import java.util.LinkedHashMap;
import java.util.Map;


public class Card implements Comparable <Card>{
	
	public static Map<String, Integer> RANK_VALUE = new LinkedHashMap<>();
			
	static {
		RANK_VALUE.put("A", 1);
		RANK_VALUE.put("2", 2);
		RANK_VALUE.put("3", 3);
		RANK_VALUE.put("4", 4);
		RANK_VALUE.put("5", 5);
		RANK_VALUE.put("6", 6);
		RANK_VALUE.put("7", 7);
		RANK_VALUE.put("8", 8);
		RANK_VALUE.put("9", 9);
		RANK_VALUE.put("10", 10);
		RANK_VALUE.put("J", 11);
		RANK_VALUE.put("Q", 12);
		RANK_VALUE.put("K", 13);
	}
	
	final private String rank;
	final private Suit suit;
	
	public Card(String rank, Suit suit) {
		
		if (RANK_VALUE.containsKey(rank)) {
			this.rank = rank; 
			}
		else {
			throw new IllegalArgumentException("Rank " + rank + " does not exist");
		}
		
		this.suit = suit;
	}
	
	public String getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return "[number=" + rank + ". suit=" + suit.toString() + "]";
	}


	@Override
	public int compareTo(Card other) {
		return RANK_VALUE.get(this.rank) - RANK_VALUE.get(other.getRank());
	}
	
	
}
