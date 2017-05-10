/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetormi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author maycon Klopper
 */
public class RMICliente 
{
    public static void main(String args[]) 
    {
        try {
            //busca uma referencia para o registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            //lista todas as chaves que estao no registry
            String keys[] = registry.list();
            for (int i = 0; i < keys.length; i++) {
                System.out.println("objeto["+i+"]="+keys[i]);
            }

            //se existir pelo menos uma chave tenta fazer o lookup
            if (keys.length > 0) {
                //faz o lookup para conseguir uma referencia ao objeto remoto
                Servidor s = (Servidor) registry.lookup("servidor");
                String entrada = JOptionPane
					.showInputDialog("Escolha uma opcao:\n" + 
										"1- Carregar Arquivo\n" + 
										"2- Escrever Arquivo\n"	+ 
										"3- Descarregar arquivos\n" +
										"4- Enviar bytes\n" +
										"5- Ecerrar Execucao");

			while (!entrada.equalsIgnoreCase("5")) {
				
				
				switch (entrada) {
					case "1":
						String op1 = JOptionPane
							.showInputDialog("Informe o nome e o caminho do arquivo. [Nome Arquivo], [Caminho Arquivo]");
						String array1[] = op1.split(", "); 
                                                s.carregarArquivo(array1[0], array1[1]);
                                                break;
		
					case "2":
						String op2 = JOptionPane
							.showInputDialog("Informe o nome e a quantidade de milissegundos. [Nome], [Milissegundos]");
						String array2[] = op2.split(", "); 
                                                s.escreverArquivos(array2);
                                                break;
					
					case "3":
						s.descarregarLista();
						break;
						
					case "4":
						String url = JOptionPane.showInputDialog("Entre com o caminho do arquivo.");
				        File file = new File(url);
                                        String nome = file.getName();
                                        byte[] cbuffer = enviarBytes(file);
				        s.capturaBytes(nome, cbuffer);
						break;
						
					default:
						entrada = JOptionPane
						.showInputDialog("Escolha uma opcao:\n" + 
											"1- Carregar Arquivo\n" + 
											"2- Escrever Arquivo\n"	+ 
											"3- Descarregar arquivos\n" +
											"4- Enviar bytes\n" +
											"5- Ecerrar Execucao");
						break;
				}
	
				entrada = JOptionPane
						.showInputDialog("Escolha uma opcao:\n" + 
											"1- Carregar Arquivo\n" + 
											"2- Escrever Arquivo\n"	+  
											"3- Descarregar arquivos\n" +
											"4- Enviar bytes\n" +
											"5- Ecerrar Execucao");
			
				
			}
                        registry.unbind("servidor");
                //usa o objeto remoto para executar o metodo 
                //System.out.println(s.processou(5));
                //aqui, apenas como exemplo estamos removendo a referencia do registry
                //isso NAO deve ser feito do lado cliente
                //registry.unbind("servidor");
            } else {
                //se nao existirem objetos no array de chaves e porque o servidor nao esta
                //no registry
                System.out.println("Nao existem objetos no RMIRegistry");
            }
        } catch (Exception e) {
            System.err.println("erro:");
            e.printStackTrace();
        }
    }
    
    private static byte[] enviarBytes(File file) 
    {
        int len = (int)file.length();  
        byte[] sendBuf = new byte[len];
        FileInputStream inFile = null;
        try 
        {
         inFile = new FileInputStream(file);         
         inFile.read(sendBuf, 0, len);  
        } 
        catch (FileNotFoundException fnfex) 
        { 
            fnfex.printStackTrace();
        } 
        catch (IOException ioex) 
        {
            ioex.printStackTrace();
        }
        return sendBuf;
    }
}