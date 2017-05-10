package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {

	PrintWriter out = null;
    BufferedReader in = null;
    Socket s = null;
    ServerSocket ss = null;
	
	public void conectaServidor() throws IOException {
		s = new Socket("127.0.0.1", 49500);
		out = new PrintWriter(s.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}
	
	public void conectaCliente() throws IOException {
		
		ss = new ServerSocket(49500);
	    System.out.println("Esperando conexao...");
	    s = ss.accept();
	    System.out.println("Conectado");
	    out = new PrintWriter(s.getOutputStream(), true);
	    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    System.out.println("Esperando mensagem...");
		
	}
	

	public ServerSocket getSs() {
		return ss;
	}

	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	
}
