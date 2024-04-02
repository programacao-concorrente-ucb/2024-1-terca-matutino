package sender_receiver;

public class Main {
	public static void main(String[] args) {
		String[] messages = {
				"primeira mensagem",
				"segunda mensagem",
				"terceira mensagem",
				"END"
		};
		String[] messages2 = {
				"so long",
				"and thanks for all the fish",
				"END"
		};
		Packet packet = new Packet();
		
		Sender sender = new Sender(packet, messages);
		Sender sender2 = new Sender(packet, messages2);

		Receiver receiver = new Receiver(packet, 2);
		
		sender.start();
		sender2.start();

		receiver.start();
	}
}
