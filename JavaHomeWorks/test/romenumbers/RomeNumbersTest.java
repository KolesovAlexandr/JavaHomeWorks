/**
 * 
 */
package romenumbers;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * @author alexandr
 *
 */

@RunWith(Parameterized.class)
public class RomeNumbersTest {
	private int _input;
	private String _output;
	@Parameters
	public static List<Object[]> data()	{
		return Arrays.asList(new Object[][]	{
				
				{1,"I"},
				{2,"II"},
				{3,"III"},
				{4,"IV"},
				{5,"V"},
				{6,"VI"},
				{7,"VII"},
				{8,"VIII"},
				{9,"IX"},
				{10,"X"},
				{11,"XI"},
				{13,"XIII"},
				{14,"XIV"},
				{15,"XV"},
				{17,"XVII"},
				{19,"XIX"},
				{20,"XX"},
				{21,"XXI"},
				{25,"XXV"},
				{27,"XXVII"},
				{29,"XXIX"},
				{30,"XXX"},
				{45,"XLV"},
				{55,"LV"},
				{65,"LXV"},
				{77,"LXXVII"},
				{88,"LXXXVIII"},
				{99,"XCIX"},
				{100,"C"},
				{115,"a number greater than 100"},
				
					
				
			}
		);
	}




public RomeNumbersTest(int input, final String output) {
		
		_input = input;
		_output = output;
		
	}
	
	

	@Test
	public void test() {
		assertEquals(_output, RomeNumbers.convert(_input));
	}


}
