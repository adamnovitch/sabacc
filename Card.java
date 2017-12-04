public class Card
{
	String rank;
	String card_suit;
	int card_val;
	
	public Card () {}
	
	void calcVal()
	{
		switch (rank)
		{
			case "One": card_val = 1; break;
			case "Two": card_val = 2; break;
			case "Three": card_val = 3; break;
			case "Four": card_val = 4; break;
			case "Five": card_val = 5; break;
			case "Six": card_val = 6; break;
			case "Seven": card_val = 7; break;
			case "Eight": card_val = 8; break;
			case "Nine": card_val = 9; break;
			case "Ten": card_val = 10; break;
			case "Eleven": card_val = 11; break;
			case "Commander": card_val = 12; break;
			case "Mistress": card_val = 13; break;
			case "Master": card_val = 14; break;
			case "Ace": card_val = 15; break;
			case "Queen of Air and Darkness": card_val = -2; break;
			case "Endurance": card_val = -8; break;
			case "Balance": card_val = -11; break;
			case "Demise": card_val = -13; break;
			case "Moderation": card_val = -14; break;
			case "The Evil One": card_val = -15; break;
			case "The Star": card_val = -17; break;
			case "The Idiot": card_val = 0; break;
		}
	}
	public Card(CardValue r, CardSuit s)
	{
		rank = r.toString();
		card_suit = s.toString();
		calcVal();
	}
	public Card(Card c)
	{
		rank = c.rank;
		card_suit = c.card_suit;
		card_val = c.card_val;
	}
	public void set(Card c)
	{
		rank = c.rank;
		card_suit = c.card_suit;
		card_val = c.card_val;
	}
	public void print ()
	{
		if (card_suit == "Special") System.out.print(rank);
		else System.out.print(rank + " of " + card_suit);
	}
	public int getValue() { return card_val; }
}
