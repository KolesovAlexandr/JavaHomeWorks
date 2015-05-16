package solitaire;

public class MoveCard extends CardPile {
	
	static CardPile selectedPile;
	static boolean isSelected;
	static boolean notDiscard;

	MoveCard(int xl, int yl) {
		super(xl, yl);
		// TODO Auto-generated constructor stub
	}
//	boolean isNotDiscard()	{
//		return false;
//		}
	
	public void select(final int tx, final int ty) {
		//Card topCard = top();
		
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
				
//				CardPile selectCard = getSelectedCard().popIsFaceUp();
				if (canTake(selectCard))	{
					addCard(selectCard);
				}
				else {
					getSelectedCard().addCard(selectCard);				}
				setSelectedCard(null);
			}
		}
		
		
		
		
//		for (int i = 0; i < 4; i++) {
//			if (Solitaire.suitPile[i].canTake(topCard)) {
//				Solitaire.suitPile[i].addCard(topCard);
//				return;
//			}
//		}
//		// else see if any other table pile can take card
//		for (int i = 0; i < 7; i++) {
//			if (Solitaire.tableau[i].canTake(topCard)) {
//				Solitaire.tableau[i].addCard(topCard);
//				return;
//			}
//		}
//		// else put it back on our pile
//		addCard(topCard);
	}


}
