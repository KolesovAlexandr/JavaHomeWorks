package pokercombination;

import java.awt.Graphics;

class DiscardPile extends MoveCard {
	
	

	DiscardPile(final int x, final int y) {
		super(x, y);
	}

	public void addCard(final Card aCard) {
		if (!aCard.isFaceUp()) {
			aCard.flip();
		}
		super.addCard(aCard);
	}
	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		super.display(g);
}

	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}
		super.select(tx, ty);
		
	}
}