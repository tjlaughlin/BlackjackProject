package com.skilldistillery.common.cards;

import java.util.Scanner;

import com.skilldistillery.common.Blackjack.BlackJackHand;

public class CardPlayer {

	protected BlackJackHand hand = new BlackJackHand();

	public CardPlayer() {
	}

	public boolean hit(Scanner scanner) {
		if (scanner.nextLine().equals("Y")) {
			return true;
		}
		return false;
	}

	public boolean hasBlackJack() {
		return getHandValue() == 21 ? true : false;

	}

	public boolean isBust() {
		return getHandValue() > 21 ? true : false;
	}

	public void addCardToHand(Card card) {
		hand.addCardToHand(card);

	}

	public void showPlayerCards() {
		for (Card card : hand.getHand()) {
			System.out.println(card);
		}
	}

	public int getHandValue() {
		return hand.getHandValue();

	}
}
