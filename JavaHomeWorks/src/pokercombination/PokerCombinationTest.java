package pokercombination;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class PokerCombinationTest {
	
	private static final Card[] ROYALFLUSH = {
		new Card(0, 0),
		new Card(0, 12),
		new Card(0, 11),
		new Card(0, 10),
		new Card(0, 9),
		};
	
	private static final Card[] STRAIGHTFLUSH = {
		new Card(0, 12),
		new Card(0, 11),
		new Card(0, 10),
		new Card(0, 9),
		new Card(0, 8),
		};
	private static final Card[] FOUROFKIND = {
		new Card(0, 1),
		new Card(1, 1),
		new Card(2, 1),
		new Card(3, 1),
		new Card(0, 3),
		};
	private static final Card[] FULLHOUSE = {
		new Card(0, 1),
		new Card(1, 1),
		new Card(2, 1),
		new Card(0, 2),
		new Card(1, 2),
		};
	private static final Card[] FLUSH = {
		new Card(0, 1),
		new Card(0, 2),
		new Card(0, 3),
		new Card(0, 4),
		new Card(0, 7),
		};
	private static final Card[] STRAIGHT = {
		new Card(0, 0),
		new Card(1, 1),
		new Card(2, 2),
		new Card(3, 3),
		new Card(0, 4),
		};
	private static final Card[] THREEOFAKIND = {
		new Card(0, 3),
		new Card(1, 3),
		new Card(2, 3),
		new Card(3, 7),
		new Card(0, 9),
		};
	private static final Card[] TWOPAIRS = {
		new Card(0, 1),
		new Card(1, 1),
		new Card(2, 2),
		new Card(3, 2),
		new Card(0, 0),
		};
	private static final Card[] ONEPAIR = {
		new Card(0, 1),
		new Card(1, 1),
		new Card(2, 3),
		new Card(3, 5),
		new Card(0, 7),
		};

	private static final Card[] NOCOMBINATION = {
		new Card(0, 1),
		new Card(1, 3),
		new Card(2, 4),
		new Card(3, 7),
		new Card(0, 9),
		};

	private static final Card[] ERRORLENGTH = {
		new Card(0, 1),
		new Card(1, 3),
		new Card(2, 4),
		new Card(3, 7),
		};

	private static final Card[] NULL = null;
	
	private Card[] _input;
	private String _output;
	
	@Parameters
	public static List<Object[]> data()	{
		return Arrays.asList(new Object[][]	{
			{ROYALFLUSH,"RoyalFlush"},
			{STRAIGHTFLUSH, "StraightFlush"},
			{FOUROFKIND, "Four of a kind"},
			{FULLHOUSE, "Full house"},
			{FLUSH, "Flush"},
			{STRAIGHT, "Straight"},
			{THREEOFAKIND, "Three of a kind"},
			{TWOPAIRS, "Two pairs"},
			{ONEPAIR, "Pair"},
			{NOCOMBINATION, "no combinations"},
			{ERRORLENGTH , "no combinations"},
			{NULL , "no combinations"},
			
			
			}
		);
	}
	
	public PokerCombinationTest(final Card[] input, final String output) {
		
		_input = input;
		_output = output;
	}
	
	

	@Test
	public void test() {
		assertEquals(_output, PokerCombination.combination(_input));
	}

}
