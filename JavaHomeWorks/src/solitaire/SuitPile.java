package solitaire;

class SuitPile extends CardPile {

	SuitPile(final int x, final int y) {
		super(x, y);
	}

	public boolean canTake(final Card aCard) {
		if (empty()) {
			return aCard.isAce();
		}
		Card topCard = top();
		return (aCard.getSuit() == topCard.getSuit())
				&& (aCard.getRank() == 1 + topCard.getRank());
	}
	@Override
	public void select(int tx, int ty) {
		if (getSelectedCard()!=null){Card selectCard = getSelectedCard().pop(); 
			if (canTake(selectCard))	{
				addCard(selectCard);
			}
			else {
				getSelectedCard().addCard(selectCard);
				setSelectedCard(null);
			}
		}
	}
}