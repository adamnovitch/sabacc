import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	ArrayList <Card> dek;
	Card[] temp;
	Card tmp;
	public Deck ()
	{
		dek = new ArrayList <Card> (76);
		temp = new Card[76];
		tmp = new Card();
		CardSuit x = CardSuit.COINS;
		CardValue y = CardValue.ONE;
		String r,s;
		int d = 0;
		for (int j = 0; j < 4; j++)
		{
			switch (j)
			{
				case 0: x = CardSuit.COINS; break;
				case 1: x = CardSuit.FLASKS; break;
				case 2: x = CardSuit.SABRES; break;
				case 3: x = CardSuit.STAVES; break;
			}
			for (int i = 1; i < 16; i++)
			{
				switch (i)
				{
					case 1: y = CardValue.ONE; break;
					case 2: y = CardValue.TWO; break;
					case 3: y = CardValue.THREE; break;
					case 4: y = CardValue.FOUR; break;
					case 5: y = CardValue.FIVE; break;
					case 6: y = CardValue.SIX; break;
					case 7: y = CardValue.SEVEN; break;
					case 8: y = CardValue.EIGHT; break;
					case 9: y = CardValue.NINE; break;
					case 10: y = CardValue.TEN; break;
					case 11: y = CardValue.ELEVEN; break;
					case 12: y = CardValue.COMMANDER; break;
					case 13: y = CardValue.MISTRESS; break;
					case 14: y = CardValue.MASTER; break;
					case 15: y = CardValue.ACE; break;
				}
				temp[d] = new Card(y,x);
				dek.add(temp[d++]);
			}
		}
		for (int k = 0; k < 2; k++)
		{
			temp[d] = new Card(CardValue.QAD,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.END,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.BAL,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.DEM,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.MOD,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.TEO,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.STAR,CardSuit.SPECIAL);
			dek.add(temp[d++]);
			temp[d] = new Card(CardValue.ID,CardSuit.SPECIAL);
			dek.add(temp[d++]);
		}
	}
	public void shuffle_deck ()
	{
		Collections.shuffle(dek);
	}
	public Card drawCard ()
	{
		tmp.set(dek.get(0));
		dek.remove(0);
		return tmp;
	}
}