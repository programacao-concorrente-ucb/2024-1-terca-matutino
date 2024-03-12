package aula1;

public class Ola extends Thread {
	private String nome;
	
	public Ola(String nome) {
		this.nome = nome;
	}
	
	public void run() {
		//System.out.println("Thread sendo executada: " + Thread.currentThread());

		System.out.println("Ola, " + this.nome + "!");
	}
}
