package lesson150420.patterns.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import lesson150420.patterns.command.Calculator.Command;

public class UseCalculator {
	
	public static boolean isNumber(String str){
        Pattern p = Pattern.compile("(^0$)|(^[1-9]([0-9])*)$");
        Matcher m = p.matcher(str);
        return m.find();
    }

	public static void main(final String[] args) {
		System.out.println("start");

		Scanner tmp = new Scanner(System.in);
		String[] str = tmp.nextLine().split(" ");
		Calculator calc = new Calculator();
		List<Calculator.Command> list = new ArrayList<>();
		
		for (int i = 0; i < str.length; i++) {
			if (!isNumber(str[i]))	{
				switch (str[i]) {
				case "Plus":
					if(i < str.length - 1 && isNumber(str[i+1])) {
						 list.add(calc.new Plus(new Integer(str[i+1])));
						i++;						
					}	else {
						list.add(calc.new Plus(0));
					}				
					break;
				case "Minus":
					if(i < str.length-1 && isNumber(str[i+1])) {
						list.add(calc.new Minus(new Integer(str[i+1])));
						i++;						
					}	else {
						list.add(calc.new Minus(0));
					}
					break;
					
				case "Get":
					list.add(calc.new Get());
					break;
				
				case "Clear":
					list.add(calc.new Clear());
					break;
				default:
					break;
				}
			}
		}
		
		for (Command command : list) {
			command.execute();			
		}
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (Command command : list) {
//					command.execute();
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//
//			}
//		}).start();
	}
}
				
		
		
		
		

//		final List<Calculator.Command> list = Arrays.asList(calc.new Plus(10),
//				calc.new Minus(20), calc.new Get(), calc.new Clear(),
//				calc.new Get());
//
//		Collections.reverse(list);
//
//		
//		System.out.println("finish");
//
//	}
//}

