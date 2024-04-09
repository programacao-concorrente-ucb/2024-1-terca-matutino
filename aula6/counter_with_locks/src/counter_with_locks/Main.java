package counter_with_locks;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		
		//while(true) {
			Counter counter = new Counter(0, lock);

			Incrementer inc = new Incrementer(counter);
			Incrementer inc1 = new Incrementer(counter);
			Incrementer inc2 = new Incrementer(counter);
			Incrementer inc3 = new Incrementer(counter);

			
			inc.start();
			inc1.start();
			inc2.start();
			inc3.start();
			
			inc.join();
			inc1.join();
			inc2.join();
			inc3.join();
			
			if(counter.getValue() != 4) {
				System.out.println("Valor do contador: " + counter.getValue());

				//break;
			}
		//}

		

	}

}
