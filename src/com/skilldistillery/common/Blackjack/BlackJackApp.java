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

	}

	public void run() {
		String playGame = "";
		boolean keepGoing = true;
		dealer.shuffle();

//		need to put the entire game in a loop
//		create a playgame variable, if playgame variable is equal to yes that the loop starts
//		add this into the end of each loop so when the game ends they are asked if they want to play
//		if yes then the loop starts over again 
		System.out.println("Would you like to play Black Jack? Y/N ");
		playGame = kb.next();
		
	if (playGame.equals("Y"))	{
		
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
			System.out.println("would you like to play again? Y/N");
			playGame = kb.nextLine();
		}
		while (player1.getHandValue() < 21 && keepGoing) {
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
				keepGoing = false;

			}
			if (player1.isBust()) {
				System.out.println("you have busted :( ");
				keepGoing = false;
			}
			
			if (userChoice.equals("N")) {
				if (dealer.getHandValue() > player1.getHandValue()) {
					System.out.println("the Dealer has won with");
					dealer.showDealerCards();
					System.out.println("While you had");
					player1.showPlayerCards();
					keepGoing = false;
					
				} 
				else if (dealer.getHandValue() < player1.getHandValue() && dealer.hit() != true) {
					System.out.println("Player1 has won the game! ");
					player1.showPlayerCards();
					System.out.println("Dealer had ");
					dealer.showDealerCards();
					keepGoing = false;
				}
				if (dealer.getHandValue() == player1.getHandValue() && dealer.hit() != true && keepGoing == true) {
					System.out.println("push, players had the same valued cards");
					keepGoing = false;
				}
				if (dealer.hasBlackJack()) {
					System.out.println("Dealer has a black jack!!");
					System.out.println("Player 1 has lost");
					keepGoing = false;
				}

				if (dealer.getHandValue() <= 17 && keepGoing == true) {
					dealer.addCardToHand(dealer.dealCard());
					System.out.println("the dealer now has: ");
					dealer.showDealerCards();
					 
					if (dealer.isBust()) {
						System.out.println("The dealer has busted you won");
						keepGoing = false;
					}
					if (dealer.getHandValue() > player1.getHandValue() && keepGoing ==true) {
						System.out.println("the Dealer has won with");
						dealer.showDealerCards();
						System.out.println("While you had");
						player1.showPlayerCards();
						keepGoing = false;
						
					} 

					if (dealer.getHandValue() <= 17 && keepGoing == true) {
						dealer.addCardToHand(dealer.dealCard());
						System.out.println("the dealer now has: ");
						dealer.showDealerCards();
						if (dealer.isBust()) {
							System.out.println("The dealer has busted you won");
							keepGoing = false;
						}
						

						while (dealer.getHandValue() <= 17 || dealer.getHandValue() > 17 && keepGoing == true) {
							dealer.addCardToHand(dealer.dealCard());
							System.out.println("the dealer now has: ");
							dealer.showDealerCards();

							if (dealer.isBust()) {
								System.out.println("The dealer has busted you won");
								keepGoing = false;
							} else if (dealer.getHandValue() < player1.getHandValue() && dealer.getHandValue() <= 17) {
								System.out.println("PLayer1 has won the game! ");
								player1.showPlayerCards();
								keepGoing = false;
							}
							if (dealer.getHandValue() == player1.getHandValue()) {
								System.out.println("push, players had the same valued cards");
								keepGoing = false;
							}
							if (dealer.hasBlackJack()) {
								System.out.println("Dealer has a black jack!!");
								System.out.println("Player 1 has lost");
								keepGoing = false;
							}
						}

					}
				}

			}
		}


	}
	else {
		System.out.println("Okay, goodbye!");
	}
	}
}
