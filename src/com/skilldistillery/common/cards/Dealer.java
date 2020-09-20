package com.skilldistillery.common.cards;

import java.util.List;

public class Dealer extends CardPlayer {

	private Deck deck = new Deck();
	

	public Card dealCard() {
		return deck.dealCard();
	}

	public void showDealerCards() {
		for (Card card : hand.getHand()) {
			System.out.println(card);
		}
	}
	
	public Dealer() {
		deck.shuffle();
	}
	
	public void shuffle() {
		deck.shuffle();
	}

	public boolean hit() {
		if (hand.getHandValue() >= 17) {
			return false;
		}
		return true;
	}
	
	public boolean hasBlackJack() {
		return getHandValue() == 21 ? true : false;

	}

	public boolean isBust() {
		return getHandValue() > 21 ? true : false;
	}
}
