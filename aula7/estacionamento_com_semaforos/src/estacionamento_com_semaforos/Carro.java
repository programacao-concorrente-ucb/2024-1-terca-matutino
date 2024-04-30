package estacionamento_com_semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private Semaphore estacionamento;

	public Carro(String nome, Semaphore estacionamento) {
		// chamando construtor da classe pai (Thread) passando nome
		super(nome);
		this.estacionamento = estacionamento;
	}
	
	public void run() {
		// checar se estacionamento tem menos de 10 carros
		
		// acquire vai checar se meu semáforo tem pelo menos 1 permissão
		try {
			this.estacionamento.acquire();
			// se tiver menos de 10 carros no estacionamento, eu posso entrar
			System.out.println(this.getName() + " entrou no estacionamento!");
			
			// entrei no estacionamento e fiquei um tempo
			// entre 5 e 10 s
			Thread.sleep(new Random().nextInt(10000) + 5000);
			
			System.out.println(this.getName() + " saiu do estacionamento!");
			
			this.estacionamento.release();
			// saio do estacionamento
		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
	}
}
