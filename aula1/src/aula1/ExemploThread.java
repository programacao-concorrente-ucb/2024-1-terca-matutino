package aula1;

public class ExemploThread {
	 public static void main(String[] args) throws InterruptedException {
		 System.out.println("Dentro da main");
		 Ola ola = new Ola("joao");
		 Ola ola2 = new Ola("maria");

		 Tchau tchau = new Tchau("joao");
		 Tchau tchau2 = new Tchau("maria");
		 Tchau tchau3 = new Tchau("jose");
	
		 
		 ola.start();
		 ola2.start();
		 tchau.start();
		 tchau2.start();
		 tchau3.start();
		 ola.join();
		 ola2.join();
		 tchau.join();
		 tchau2.join();
		 tchau3.join();
		 
		 System.out.println("ACABOU!");
	 }
	 
}
