package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
	private Packet packet;
	private String[] messages;
	
	public Sender(Packet packet, 
				  String[] messages) {
		this.packet = packet;
		this.messages = messages;
	}
	
	public void run() {
		for(String message: this.messages) {

			packet.send(message, this.getName());
			
			int randomSec = ThreadLocalRandom.
					current().nextInt(1000, 5000);
			try {
				Thread.sleep(randomSec);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		System.out.println(this.getName() + " encerrada!");
	}
	
}
