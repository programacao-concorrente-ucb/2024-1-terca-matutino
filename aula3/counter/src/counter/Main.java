package counter;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			Counter counter = new Counter(0);

			Incrementer inc = new Incrementer(counter);
			Incrementer inc1 = new Incrementer(counter);

			
			inc.start();
			inc1.start();

			
			inc.join();
			inc1.join();

			
			if(counter.getValue() != 2) {
				System.out.println("Valor do contador: " + counter.getValue());

				break;
			}
		}

		

	}

}
