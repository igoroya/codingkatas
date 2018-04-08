package com.igoroya.codingkatas.april2018.deckofcards;

public class PlayCards {

	public static void main(String[] args) {
		Deck deck = Deck.getStandardDeck();
		System.out.println(deck);
		
		Deck blackjackDeck = Deck.getBlackJackDeck();
		System.out.println(blackjackDeck);
	}

}
