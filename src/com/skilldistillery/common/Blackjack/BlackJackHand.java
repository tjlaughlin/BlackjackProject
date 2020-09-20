package com.skilldistillery.common.Blackjack;

import com.skilldistillery.common.cards.Card;
import com.skilldistillery.common.cards.Hand;

public class BlackJackHand extends Hand {

	public BlackJackHand() {
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public boolean isBlackJack() {
		return getHandValue() == 21 ? true : false;

	}

	public boolean isBust() {
		return getHandValue() > 21 ? true : false;
	}
}