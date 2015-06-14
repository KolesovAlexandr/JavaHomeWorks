package romenumbers;

public class RomeNumbers {
	static public String convert(int number) {
		// if (number == 1) {
		// return "I";
		// }
		String rn = "";
		int units = number % 10;
		switch (units) {
		case 1:
			rn = rn + "I";
			break;
		case 2:
			rn = rn + "II";
			break;
		case 3:
			rn = rn + "III";
			break;
		case 4:
			rn = rn + "IV";
			break;
		case 5:
			rn = rn + "V";
			break;
		case 6:
			rn = rn + "VI";
			break;
		case 7:
			rn = rn + "VII";
			break;
		case 8:
			rn = rn + "VIII";
			break;
		case 9:
			rn = rn + "IX";
			break;
		// case 10:
		// return "X";
		// case 11:
		// return "XI";
		default:
			break;
		}
		// if (number/10 == 1)
		// {
		// rn = "X"+rn;
		// }
		// if (number/10 == 2)
		// {
		// rn = "XX"+rn;
		// }

		switch (number / 10) {
		case 1:
			rn = "X" + rn;
			break;
		case 2:
			rn = "XX" + rn;
			break;
		case 3:
			rn = "XXX" + rn;
			break;
		case 4:
			rn = "XL" + rn;
			break;
		case 5:
			rn = "L" + rn;
			break;
		case 6:
			rn = "LX" + rn;
			break;
		case 7:
			rn = "LXX" + rn;
			break;
		case 8:
			rn = "LXXX" + rn;
			break;
		case 9:
			rn = "XC" + rn;
			break;
		case 10:
			rn = "C" + rn;
			break;

		default:
			break;
		}
		if (number > 100) {
			rn = "a number greater than 100";
		}
		return rn;
	}
}