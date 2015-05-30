package pokercombination;

public class PokerCombination {

	public static String combination(Card[] cards) {

		boolean isThreeOfAKind = false;

		int countPair = 0;

		// heart, spade, diamond, club
		int[] suitCount = new int[4];

		// "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
		int[] rankCount = new int[13];

		String comb = "";

		if (cards!=null && cards.length == 5) {
			for (Card card : cards) {
				suitCount[card.getSuit()]++;
				rankCount[card.getRank()]++;
			}
			for (int sCount : suitCount) {
				if (sCount == 5) {
					comb = "Flush";
					if (rankCount[0] == 1 && rankCount[12] == 1
							&& rankCount[11] == 1 && rankCount[10] == 1
							&& rankCount[9] == 1) {
						comb = "Royal"+ comb;
					}
				}
			}

			for (int i = rankCount.length; i >= 5; i--) {
				boolean isStraight = true;
				for (int j = i - 5; j < i & isStraight; j++) {
					isStraight = rankCount[j] == 1;
				}
				if (isStraight) {
					comb = "Straight" + comb;
				}
			}

			for (int rCount : rankCount) {
				if (rCount == 4) {
					comb = "Four of a kind";
				} else {
					if (rCount == 3) {
						comb = "Three of a kind";
						isThreeOfAKind = true;
					}

					if (rCount == 2) {
						comb = "Pair";
						countPair++;
					}

				}

				if (countPair == 2) {
					comb = "Two pairs";
				}
				if (isThreeOfAKind && countPair == 1) {
					comb = "Full house";
				}

			}
		}
		if (comb == "") {
			comb = "no combinations";
		}

		return comb;

	}

}
