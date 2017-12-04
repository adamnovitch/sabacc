/**
* Adam Novitch
* Sabacc Game App
* v0.1 6/1/2012
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class SabaccApp
{
	public static void main (String[] args)
	{
	//------------------------------------------------------
	//	Sets up # of players and each player's first card
	//------------------------------------------------------
		int players = Integer.parseInt(args[0]);
		Deck myDeck = new Deck();
		myDeck.shuffle_deck();
		Scanner sc = new Scanner(System.in);
		SabaccHand[] roster = new SabaccHand[players];
		int turn = 1;
		int opt;
		Random rn = new Random();
		Card drawphase;
		boolean call = false;
		int outCounter = 0;
		SabaccHand winner;
		
	//------------------------------------------------------
	//	Total Player roster, game, and hand arrays
	//------------------------------------------------------
		for (int i = 0; i < players; i++)
		{
			roster[i] = new SabaccHand(i+1);
		}
		int pot = 0;
		
		ArrayList <SabaccHand> game = new ArrayList(players);
		ArrayList <SabaccHand> hand = new ArrayList(players);
		for (int i = 0; i < players; i++) game.add(roster[i]);
		
	//------------------------------------------------------
	//	Outer loop for filling the hand array with
	//	players still in the game and the ante.
	//------------------------------------------------------
		while (true)
		{
			for (int i = 0; i < game.size(); i++) hand.add(game.get(i));
			for (int i = 0; i < hand.size(); i++)
			{
				hand.get(i).bet(10);
				pot += 10;
			}
			myDeck.drawCard();
			for (int i = 0; i < game.size(); i++) game.get(i).hit(myDeck.drawCard());
			myDeck.drawCard();
			for (int i = 0; i < game.size(); i++) game.get(i).hit(myDeck.drawCard());
			while (true)
			{
				System.out.println("------------------------------------------------------");
				System.out.println("\t\tTURN #" + turn);
				System.out.println("------------------------------------------------------");
				System.out.println("THE BET (Turn #" + turn + ")");
				for (int i = 0; i < game.size(); i++)
				{
					if (!game.get(i).out)
					{
						System.out.print("Player #" + (i+1) + ": ");
						game.get(i).printHand();
						System.out.print("Player #" + (i+1) + ": Bet(1) or Fold(0)? ");
						opt = sc.nextInt();
						if (opt == 0)
						{
							game.get(i).out = true;
							outCounter++;
						}
						else
						{
							game.get(i).bet(10);
							pot += 10;
						}
					}
					System.out.println("");
				}
				//Ends the hand if only one man remains
				if (outCounter == game.size()-1) break;
				
				System.out.println("Pot: " + pot);
				System.out.println("THE SHIFT (Turn #" + turn + ")");
				if(rn.nextInt(6) > 2)
				{
					for (int i = 0; i < game.size(); i++)
					{
						if (!game.get(i).out)
						{
							game.get(i).shift(myDeck.drawCard());
							System.out.print("Player #" + (i+1) + ": ");
							game.get(i).printHand();
						}
					}
				}
				else System.out.println("  No Shift Performed\n");
				if (turn > 3)
				{
					System.out.println("THE CALL (Turn #" + turn + ")");
					for (int i = 0; i < game.size(); i++)
					{
						if (!game.get(i).out && !call)
						{
							System.out.print("Player #" + (i+1) + ": ");
							game.get(i).printHand();
							System.out.println("Player #" + (i+1) + ": Call? Yes(1) or No(0)? ");
							opt = sc.nextInt();
							if (opt == 1) call = true;
						}
					}		
				}
				if (call) break;
				System.out.println("THE DRAW (Turn #" + turn + ")");
				for (int i = 0; i < game.size(); i++)
				{
					if (!game.get(i).out)
					{
						System.out.print("Player #" + (i+1) + ": ");
						game.get(i).printHand();
						drawphase = myDeck.drawCard();
						drawphase.print();
						System.out.print(" (" + drawphase.getValue() + ")\n");
						System.out.println("Player #" + (i+1) + ": Keep(1) or Discard(0)? ");
						opt = sc.nextInt();
						if (opt == 1) game.get(i).hit(drawphase);
					}
				}
				turn++;
			}
			//takes out all who folded
			for (int i = 0; i < hand.size(); i++)
			{
				if (hand.get(i).out)
				{
					hand.get(i).out = false;
					hand.remove(i);
					i--;
				}
			}
			//takes out all who busted
			for (int i = 0; i < hand.size(); i++)
			{
				if (Math.abs(hand.get(i).getValue()) > 23)
				{
					hand.get(i).bet(5);
					hand.remove(i);
					i--;
				}
			}
			turn = 1;
			for (int i = 0; i < game.size(); i++)
			{
				hand.get(i).hand_list.
			}
		}
	}
}
