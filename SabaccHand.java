import java.util.ArrayList;
import java.util.Random;

public class SabaccHand
{
	int i_d;
	int credit;
	boolean out;
	
	ArrayList <Card> hand_list;
	
	Card[] myHand = new Card[52];
	int value = 0;
	int hand_index = 0;
	
	public SabaccHand (int playnum)
	{
		i_d = playnum;
		credit = 1000;
		out = false;
		hand_list = new ArrayList(52);
	}
	void hit(Card c)
	{
		myHand[hand_index] = new Card(c);
		hand_list.add(myHand[hand_index++]);
	}
	int getValue()
	{
		value = 0;
		if (hand_list.size() > 0) {
			for (int i = 0; i < hand_list.size(); i++) value += hand_list.get(i).card_val;
		}
		return value;
	}
	void shift(Card c)
	{
		int q;
		Random r = new Random();
		q = r.nextInt(hand_list.size());
		myHand[hand_index] = new Card(c);
		hand_list.remove(q);
		hand_list.add(myHand[hand_index++]);
	}
	void bet (int b) { credit -= b; }
	void winHand (int prize) { credit += prize; }
	void printHand ()
	{
		System.out.print(this.getValue() + " <");
		for (int i = 0; i < hand_list.size()-1; i++)
		{
			hand_list.get(i).print();
			System.out.print(", ");
		}
		hand_list.get(hand_list.size()-1).print();
		System.out.print(">\n\n");
	}
}