public enum CardSuit
{
	COINS("Coins"), FLASKS("Flasks"), SABRES("Sabres"), STAVES("Staves"), SPECIAL("Special");
	
	private final String suit;
	CardSuit(String s)
	{
		this.suit = s;
	}
	@Override
	public String toString()
	{
		return this.suit;
	}
}