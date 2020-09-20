package com.skilldistillery.common.Blackjack;

import java.util.Scanner;

import com.skilldistillery.common.cards.CardPlayer;
import com.skilldistillery.common.cards.Dealer;
import com.skilldistillery.common.cards.Hand;

public class BlackJackApp {

	Dealer dealer = new Dealer();
	CardPlayer player1 = new CardPlayer();
	BlackJackHand dealersHand = new BlackJackHand();
	BlackJackHand player1Hand = new BlackJackHand();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp ba = new BlackJackApp();
		ba.run();
//Create a dealer
//create a player 
//tell the dealer to shuffle the deck
//dealer deals one card face up to the player
//card is added to the players hand 		
//dealer is dealt a card to themselves face down		
//card is added to dealers hand
//dealer.addCard		
//dealer deals another card to player face up		
//player adds card to hand	
//Dealer deals a card face up to themselves	
//		sysout dealers card value
//dealer adds card to their hand
//dealer asks player if they want to hit
//player responds yes or no
//if the user said hit me: 
//		dealer deals them another card and the card is added to the players hand		
//when player they dont want another hit 	
//and the dealer reveals the sum of their cards
//ask the dealer if they want to hit
//if they have to hit the dealer deals themselves another card
//card is added to the dealers hand	
//whoever is closest to 21 without busting wins the game		

	}

	public void run() {
		dealer.shuffle();

		player1.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());
		System.out.println("The dealers hand is: ");
		System.out.print("one card face down and a ");
		dealer.showDealerCards();
		player1.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());
		System.out.println("Player 1, your hand is: ");
		player1.showPlayerCards();

		if (player1.hasBlackJack()) {
			System.out.println("Black Jack!!!!");
			System.out.println("Would you like to play again? Y/N");
			String playAgain = kb.next();

		}

		while (player1.getHandValue() < 21) {

			System.out.println("Would you like to hit? Y/N ");
			String userChoice = kb.next();
			if (userChoice.equals("Y")) {
				player1.addCardToHand(dealer.dealCard());
				player1.showPlayerCards();
			}
			if (player1.hasBlackJack()) {
				System.out.println("Player 1, you got a black jack!!!");
				System.out.println("the dealer had: ");
				dealer.showDealerCards();

			}
			if (player1.isBust()) {
				System.out.println("you have busted :( ");
				System.out.println("Would you ike to play again? Y/N");
//			need to add all of this into a giant loop
			}
			if (dealer.hasBlackJack()) {
				System.out.println("Black Jack!! Dealer Wins!!");
			}
			if (userChoice.equals("N")) {
				dealer.showDealerCards();
				
				while (dealer.hit() == true) {
				
				
				if (dealer.getHandValue() > player1.getHandValue()) {
					System.out.println("the Dealer has won with");
					dealer.showDealerCards();
					System.out.println("While you had");
					player1.showPlayerCards();
				} else if (dealer.getHandValue() < player1.getHandValue()) {
					System.out.println("PLayer1 has won the game! ");
					player1.showPlayerCards();
				}

			}
			}

		}
	}

//	Maybe make 2 methods, one for yes and one for no
//	or maybe methods that call on each other based on whether the dealer wins or the player wins 

//	
//	

//	public void runDealer() {
//		boolean keepGoing = true;
//		System.out.println("You have chosen to stand, it is now the dealers turn");
//		dealer.showDealerCards();
//
//		while (dealer.hit() == true) {
//			do {
//
//				dealer.addCardToHand(dealer.dealCard());
//				dealer.showDealerCards();
//				
//				if (dealer.hasBlackJack()) {
//					System.out.println("Black Jack!! Dealer Wins!!");
//					keepGoing = false;
//				}
//				if (dealer.isBust()) {
//					dealer.showDealerCards();
//					System.out.println("the dealer has busted, you win!");
//					keepGoing = false;
//				}
//				if (dealer.getHandValue() > player1.getHandValue()) {
//					System.out.println("the Dealer has won with");
//					dealer.showDealerCards();
//					System.out.println("While you had");
//					player1.showPlayerCards();
//					keepGoing = false;
//				} else if (dealer.getHandValue() < player1.getHandValue()) {
//					System.out.println("PLayer1 has won the game! ");
//					player1.showPlayerCards();
//					keepGoing = false;
//				}
//
//			} while (keepGoing);
//		}
//
//	}
}
