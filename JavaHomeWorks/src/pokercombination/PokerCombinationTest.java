package pokercombination;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class PokerCombinationTest {
	
	private int _input;
	private String _output;
	
	@Parameters
	public static List<Object[]> data()	{
		return Arrays.asList(new Object[][]	{
			{1,1}
		}
		);
	}
	
	public PokerCombinationTest(final int input, final String output) {
		
		_input = input;
		_output = output;
	}
	
	

	@Test
	public void test() {
		assertEquals(_output, _input);
	}

}
