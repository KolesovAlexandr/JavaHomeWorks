package solitaire;

import java.awt.Graphics;

class TablePile extends MoveCard {
	private int tablePileCardCount = 0;

	TablePile(final int x, final int y, final int c) {
		// initialize the parent class
		super(x, y);
//		tablePileCardCount = c;
		// then initialize our pile of cards
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();
	}

	public boolean canTake(final Card aCard) {
		if (empty()) {
			return aCard.isKing();
		}
		Card topCard = top();
		return (aCard.color() != topCard.color())
				&& (aCard.getRank() == topCard.getRank() - 1);
	}

	public void display(final Graphics g) {
		stackDisplay(g, top());
	}

	public boolean includes(final int tx, final int ty) {
		// don't test bottom of card
		return x <= tx && tx <= x + Card.width && y+(tablePileCardCount-1)*35 <= ty 
				&& ty<=y+Card.height+(tablePileCardCount-1)*35;
	}

	public void select(final int tx, final int ty) {
		if (empty()) {
			return;
		}

		// if face down, then flip
		Card topCard = top();
		if (!topCard.isFaceUp()) {
			topCard.flip();
			return;
		}

		// else see if any suit pile can take card
		super.select(tx, ty);
	}

	

	private int stackDisplay(final Graphics g, final Card aCard) {
		int localy;
		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy,isSelected);
		//isSelected=false;
//		if (getSelectedCard()!=null && aCard==getSelectedCard().top())
//		{
//			getSelectedCard().top();
//			drawSelectCard(g);
//		}
		
		return localy + 35;
	}
	@Override
	public Card pop() {
		tablePileCardCount--;
		return super.pop();
	}
	@Override
	public void addCard(Card aCard) {
		tablePileCardCount++;
		// TODO Auto-generated method stub
		super.addCard(aCard);
	}

}