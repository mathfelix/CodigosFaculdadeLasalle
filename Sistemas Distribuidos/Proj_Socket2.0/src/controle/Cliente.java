package controle;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente extends Conexao {

	public static void main(String[] args) {
		new Cliente();
	}

	public Cliente() {
		
		try {
			
			conectaServidor();

			String entrada = JOptionPane
					.showInputDialog("Escolha uma opção:\n" + 
										"1- Carregar Arquivo\n" + 
										"2- Escrever Arquivo\n"	+ 
										"3- Descarregar arquivos\n" +
										"4- Enviar bytes\n" +
										"5- Ecerrar Execução");

			while (!entrada.equalsIgnoreCase("5")) {
				
				
				switch (entrada) {
					case "1":
						out.println("1");
						String op1 = JOptionPane
							.showInputDialog("Informe o nome e o caminho do arquivo. [Nome Arquivo], [Caminho Arquivo]");
						out.println(op1);
						break;
		
					case "2":
						out.println("2");
						String op2 = JOptionPane
							.showInputDialog("Informe o nome e a quantidade de milissegundos. [Nome], [Milissegundos]");
						out.println(op2);
						break;
					
					case "3":
						out.println("3");
						String saida = in.readLine();
						JOptionPane.showMessageDialog(null, saida);
						break;
						
					case "4":
						String url = JOptionPane.showInputDialog("Entre com o caminho do arquivo.");
				        File file = new File(url);
				        String nome = file.getName();
						out.println("4");
				        out.println(nome);
				        enviarBytes(url);
						break;
						
					default:
						entrada = JOptionPane
						.showInputDialog("Escolha uma opção:\n" + 
											"1- Carregar Arquivo\n" + 
											"2- Escrever Arquivo\n"	+ 
											"3- Descarregar arquivos\n" +
											"4- Enviar bytes\n" +
											"5- Ecerrar Execução");
						break;
				}
	
				entrada = JOptionPane
						.showInputDialog("Escolha uma opção:\n" + 
											"1- Carregar Arquivo\n" + 
											"2- Escrever Arquivo\n"	+  
											"3- Descarregar arquivos\n" +
											"4- Enviar bytes\n" +
											"5- Ecerrar Execução");
			
				
			}
	
			out.println("5");
	
			out.close();
			in.close();
			s.close();

		} catch (UnknownHostException ex) {
			System.err.println("error " + ex);
		} catch (IOException ex) {
			System.err.println("error " + ex);
		}

	}
	
	
	private void enviarBytes(String url) {
		OutputStream socketOut = null;
		ServerSocket servsock = null;
		FileInputStream fileIn = null;
		
		try {
			servsock = new ServerSocket(13267);
			Socket sock = servsock.accept();
			
			byte[] cbuffer = new byte[1024];
			int bytesRead;
				 
			File file = new File(url);
			fileIn = new FileInputStream(file);
			System.out.println("Lendo arquivo...");
			
			socketOut = sock.getOutputStream();
			
			System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
			    socketOut.write(cbuffer, 0, bytesRead);
			    socketOut.flush();
			}
				 
			System.out.println("Arquivo Enviado!");
			
			fileIn.close();
			sock.close();
			servsock.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}