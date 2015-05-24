package pokercombination;

public class MoveCard extends CardPile {
	
	static CardPile selectedPile;
	static boolean isSelected;
	static boolean notDiscard;

	MoveCard(int xl, int yl) {
		super(xl, yl);
	}
	
	public void select(final int tx, final int ty) {
		
		if (!top().isFaceUp()) {
			top().flip();
		} else {
		
			if (getSelectedCard()==null)	{
				setSelectedCard(this);
				notDiscard = false;
				isSelected=true;
			}
			else {
				Card selectCard = getSelectedCard().pop(); 
				moveCard(selectCard);
				setSelectedCard(null);
			}
		}
	}

	void moveCard(Card selectCard) {
		if (canTake(selectCard))	{
			addCard(selectCard);
		}
		else	{
			getSelectedCard().addCard(selectCard);				
			}
	}


}
