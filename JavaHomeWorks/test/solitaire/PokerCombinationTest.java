package solitaire;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import com.sun.org.glassfish.gmbal.ParameterNames;

public class PokerCombinationTest {
	private Card[] _input;
	private String _output;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{"", },
		});
	}

	
	public PokerCombinationTest(final Card[] input, final String output) {
		_input = input;
		_output = output;
		
	}
	
	@Test
	public void combinationtest() {
		
		
		assertEquals("", );
	}

}
