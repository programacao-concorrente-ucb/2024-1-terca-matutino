package socket_server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String mensagem = "Hello world!";
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Aguardando conexão do cliente...");
            Socket socket = servidor.accept();
            ObjectOutputStream saida =
                new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada =
                new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < mensagem.length(); i++) {
            	// mandar mensagem caractere a caractere
                saida.writeObject(String.valueOf(mensagem.charAt(i)));
                // mostrar a resposta do cliente
                System.out.println("Resposta do cliente: " + entrada.readObject());
            }
            saida.writeObject(null);
            entrada.close();
            saida.close();
            socket.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
