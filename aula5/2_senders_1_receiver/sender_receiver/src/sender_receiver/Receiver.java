package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread {
	private Packet packet;
	private int numSenders;
	public Receiver(Packet packet, int numSenders) {
		this.packet = packet;
		this.numSenders = numSenders;
	}
	
	public void run() {
		while(true) {
			String message = packet.receive();	
			if(message.equals("END")) {
				numSenders--;
				if(numSenders == 0) {
					break;
				}
			}
			
			int randomSec = ThreadLocalRandom.
				current().nextInt(1000, 5000);
			try {
				Thread.sleep(randomSec);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
			
		}
	}
	
}
