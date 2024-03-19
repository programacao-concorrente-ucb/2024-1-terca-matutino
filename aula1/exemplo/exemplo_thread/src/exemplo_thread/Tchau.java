package exemplo_thread;

public class Tchau extends Thread {
	private String nome;
	
	public Tchau(String nome) {
		this.nome = nome;
	}
	
	public void run() {
		System.out.println("Tchau, " + this.nome + "!");
	}
}
