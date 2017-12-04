public enum CardValue
{
	ONE("One"), TWO("Two"), THREE("Three"), 
	FOUR("Four"), FIVE("Five"), SIX("Six"),	
	SEVEN("Seven"), EIGHT("Eight"), NINE("Nine"), 
	TEN("Ten"), ELEVEN("Eleven"), COMMANDER("Commander"), 
	MISTRESS("Mistress"), MASTER("Master"), ACE("Ace"),
	QAD("Queen of Air and Darkness"), END("Endurance"), 
	BAL("Balance"), DEM("Demise"), MOD("Moderation"), 
	TEO("The Evil One"), STAR("The Star"), ID("The Idiot");
	
	private final String rank;
	CardValue(String r)
	{
		this.rank = r;
	}
	@Override
	public String toString()
	{
		return this.rank;
	}
}