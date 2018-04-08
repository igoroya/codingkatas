package com.igoroya.codingkatas.april2018.deckofcards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	final List<Card> cards;
	
	private Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public static Deck getStandardDeck() {
		List<Card> cards = new ArrayList<>(); 
		
		for (Suit suit : Suit.values()) {
			for (String rank : Card.RANK_VALUE.keySet()) {
				cards.add(new Card(rank, suit));
			}
		}
		
		return new Deck(cards);
	}
	
	
	public static Deck getBlackJackDeck() {
		List<Card> cards = new ArrayList<>(); 
		
		for (Suit suit : Suit.values()) {
			for (String rank : BlackJackCard.RANK_VALUE.keySet()) {
				cards.add(new BlackJackCard(rank, suit));
			}
		}
		return new Deck(cards);
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		
		for (Card card : cards) {
			out.append(card.toString());
			out.append("\n");
		}
		return out.toString();
	}
}
