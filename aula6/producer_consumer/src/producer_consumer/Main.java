package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	private static Integer NUM_PRODUCERS = 3;
	private static Integer NUM_CONSUMERS = 2;

		
	public static void main(String[] args) {
		Queue<Integer> fila = new LinkedList<Integer>();
		ReentrantLock lock = new ReentrantLock();
		Buffer produtos = new Buffer(fila, lock);
		
		for(int i = 0;i < NUM_PRODUCERS;i++) {
			new Producer(produtos, "produtor " + (i + 1)).start();
		}

		for(int i = 0;i < NUM_CONSUMERS;i++) {
			new Consumer(produtos, "consumidor " + (i + 1)).start();
		}
		
	}

}
