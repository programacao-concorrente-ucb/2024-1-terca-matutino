package sender_receiver;

public class Main {
	public static void main(String[] args) {
		String[] messages = {
				"primeira mensagem",
				"segunda mensagem",
				"terceira mensagem",
				"END"
		};

		Packet packet = new Packet();
		
		Sender sender = new Sender(packet, messages);

		Receiver receiver = new Receiver(packet, 2);
		
		sender.start();

		receiver.start();
	}
}
