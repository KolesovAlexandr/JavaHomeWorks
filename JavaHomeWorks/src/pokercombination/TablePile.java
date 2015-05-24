package pokercombination;

import java.awt.Graphics;

class TablePile extends MoveCard {

	private int tablePileCardCount = 0;

	TablePile(final int x, final int y, final int c) {
		// initialize the parent class
		super(x, y);
		for (int i = 0; i < c; i++) {
			addCard(Solitaire.deckPile.pop());
		}
		// flip topmost card face up
		top().flip();
	}
	public TablePile() {
		super(0,0);
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
		Card topCard = top();
		if (!empty() && !topCard.isFaceUp()) {
			topCard.flip();
			return;
		} else {
		
			if (getSelectedCard()==null && !empty())	{
				setSelectedCard(this);
				notDiscard=true;
				isSelected=true;
			}
			else {
				CardPile selectCardPile = null;
				Card selectCard;
				if (notDiscard) {
					
					selectCardPile = getSelectedCard().popIsFaceUp();
					
					while (selectCardPile.top()!=null)	{
						selectCard = selectCardPile.pop();
						moveCard(selectCard);
						
					}
					
				}	else	{
					selectCard = getSelectedCard().pop();
					moveCard(selectCard);
				}
				
				setSelectedCard(null);
			}
		}
	}

	private int stackDisplay(final Graphics g, final Card aCard) {
		int localy;
		if (aCard == null) {
			return y;
		}
		localy = stackDisplay(g, aCard.link);
		aCard.draw(g, x, localy,isSelected);
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
		super.addCard(aCard);
	}
	
	@Override
	public TablePile popIsFaceUp() {
		
		TablePile cardIsFaceUp = new TablePile();
		while (top()!=null && top().isFaceUp()){
			cardIsFaceUp.addCard(pop());
		}
		return cardIsFaceUp;
	}
}