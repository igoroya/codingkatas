package com.igoroya.codingkatas.april2018.deckofcards;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlackJackCard extends Card {

	public static Map<String, Integer> RANK_VALUE = new LinkedHashMap<>();
	
	static {
		RANK_VALUE.put("A", 11);
		RANK_VALUE.put("2", 2);
		RANK_VALUE.put("3", 3);
		RANK_VALUE.put("4", 4);
		RANK_VALUE.put("5", 5);
		RANK_VALUE.put("6", 6);
		RANK_VALUE.put("7", 7);
		RANK_VALUE.put("8", 8);
		RANK_VALUE.put("9", 9);
		RANK_VALUE.put("10", 10);
		RANK_VALUE.put("J", 10);
		RANK_VALUE.put("Q", 10);
		RANK_VALUE.put("K", 10);
	}
	
	
	public BlackJackCard(String rank, Suit suit) {
		super(rank, suit);
	}

}
