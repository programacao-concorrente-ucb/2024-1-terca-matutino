package counter_with_locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private Integer value;
	private ReentrantLock lock;
	
	public Counter(Integer value, ReentrantLock lock) {
		this.value = value;
		this.lock = lock;
	}
	
	// método increment deve ter acesso exclusivo, i.e., exclusão mútua
//	public void increment() {
//		this.lock.lock();
//		// daqui para baixo é região de acesso exclusivo
//		try {
//			this.value++;
//		} finally {
//			// liberando região de acesso exclusivo
//			this.lock.unlock();
//		}
//	}
	
	// método increment deve ter acesso exclusivo, i.e., exclusão mútua
	public void increment() {
		boolean lockIsAcquired = false;
		try {
			lockIsAcquired = this.lock.tryLock(4, TimeUnit.SECONDS);
		} catch(InterruptedException e) {
			System.out.println("Erro ao tentar adquirir lock!");
		}
		
		if(lockIsAcquired) {
			// daqui para baixo é região de acesso exclusivo
			this.value++;
			
			try {
				// coloca thread para dormir 3 s
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida!");
			}
			
			this.lock.unlock();
			// liberação da região de acesso exclusivo
		} else {
			System.out.println("Thread não conseguiu acesso ao lock!!!");
		}
		
	}
	
	public Integer getValue() {
		return this.value;
	}
}
