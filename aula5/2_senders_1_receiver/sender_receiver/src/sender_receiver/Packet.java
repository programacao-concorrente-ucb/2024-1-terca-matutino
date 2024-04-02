package sender_receiver;

public class Packet {
	private String message;
	private Boolean isSending = true;
	
	public String getMessage() {
		return this.message;
	}
	
	public synchronized void send(String message, String threadName) {
		while(!this.isSending) {
			try {
				System.out.println(String.format("%s esperando mensagem \"%s\" ser recebida...", threadName, this.message));
				wait();
			} catch(InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}

		this.message = message;
		System.out.println(String.format("Mensagem \"%s\" enviada pela %s", this.message, threadName));

		this.isSending = false;
		notify();
	}
	
	public synchronized String receive(){
		while(this.isSending) {
			try {
				System.out.println("esperando mensagem ser enviada...");
				wait();
			} catch(InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		
		System.out.println("Mensagem recebida: " + this.message);

		this.isSending = true;
		notifyAll();
		return this.message;
	}
}
