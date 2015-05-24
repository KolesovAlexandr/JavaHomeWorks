package pokercombination;

public class UsePokerCombination {
	public static void main(String[] args) {
		PokerCombination pokerCombination = new PokerCombination();
		Card[] card = new Card[5];
		DeckPile pile = new DeckPile(0, 0);
		
		for (int i = 0; i < card.length; i++) {
			card[i] = pile.pop();			
		}		
		
		System.out.println(pokerCombination.combination(card));
		
	}

}
