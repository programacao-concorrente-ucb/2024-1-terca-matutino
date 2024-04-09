package producer_consumer;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	
	public Producer(Buffer buffer, String name) {
		super(name);
		this.buffer = buffer;
	}
	
	public void run() {
		// produzir entre 1 e 5 produtos
		int numProdutos = new Random().nextInt(5) + 1;
		System.out.println(this.getName() + " produziu " + numProdutos);
		for(int i = 0;i < numProdutos;i++) {
			this.produce();
		}
		System.out.println(this.getName() + " terminou a produção.");
	}
	
	public void produce() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		this.buffer.add(new Random().nextInt(100));
	}
}
