package producer_consumer;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	static private Integer MAX_CAPACITY = 10;
	private Queue<Integer> buffer;
	private ReentrantLock lock;
	private Condition allowAdding;
	private Condition allowRemoval;
	
	public Buffer(Queue<Integer> buffer, 
				  ReentrantLock lock) {
		this.buffer = buffer;
		this.lock = lock;
		this.allowAdding = lock.newCondition();
		this.allowRemoval = lock.newCondition();
	}
	
	public void add(Integer product) {
		this.lock.lock();
		// se meu buffer tá lotado, eu espero
		try {
			while(this.buffer.size() == MAX_CAPACITY) {
				// esperando...
				try {
					this.allowAdding.await();
				} catch (InterruptedException e) {
					System.out.println("Thread interrompida!");
				}
			}
			System.out.println("Adicionando produto: " + product);
			this.buffer.add(product);
			this.allowRemoval.signalAll();

		} finally {
			this.lock.unlock();
		}
	
	}
	
	public void remove() {
		this.lock.lock();

		try {
			// se meu buffer tá vazio, eu espero
			while(this.buffer.size() == 0) {
				// esperando...
				try {
					this.allowRemoval.await();
				} catch (InterruptedException e) {
					System.out.println("Thread interrompida!");
				}
			}

			Integer product = this.buffer.remove();
			System.out.println("Removendo produto: " + product);

			this.allowAdding.signalAll();
		} finally {
			this.lock.unlock();
		}

	}
}
