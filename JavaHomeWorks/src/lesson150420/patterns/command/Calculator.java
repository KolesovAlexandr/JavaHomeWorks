package lesson150420.patterns.command;

public class Calculator {

	// TODO
	//  java Calculator 10 plus 20 plus 100 minus 30 get
	
	
	abstract class Command {
		public void execute() {
			realExecute();
			System.out.println(total);
		}

		abstract void realExecute();
	}
	
	public class Plus extends Command {
		
		int _value;

		Plus(final int value) {
			_value = value;
		}
		
		@Override
		void realExecute() {
			total += _value;
		}
	}
	
	public class Minus extends Plus {
		Minus(final int value) {
			super(-value);
		}
	}
	
	public class Clear extends Command {

		@Override
		void realExecute() {
			total = 0;
		}
		
	}
	
	public class Get extends Command {

		@Override
		void realExecute() {
			// do nothing
		}

	}
	
	int total = 0;
		

}
