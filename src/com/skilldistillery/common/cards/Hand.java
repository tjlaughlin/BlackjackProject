package com.skilldistillery.common.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public abstract int getHandValue();

	public Hand() {
		super();
	}

	public Hand(List<Card> hand) {
		this.hand = hand;
	}

	public void addCardToHand(Card dealtCard) {
		hand.add(dealtCard);
	}

	public List<Card> getPlayerCards() {
		return hand;
	}

	public void setPlayerCards(List<Card> playerCards) {
		this.hand = playerCards;
	}

	public void clearHand() {
		hand.clear();
	}

	public String toString() {
		return "Your hand is: " + hand;

	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	
	
	

}
