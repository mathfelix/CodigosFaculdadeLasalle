package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Conexao {

	List<File> listaArquivos = new ArrayList<File>();
 
	public static void main(String[] args) {
	        new Servidor();
	}
	
	public Servidor() {
		
	    try {
	    	conectaCliente();
	            
	        String entrada = in.readLine();   
	        
	        while (!entrada.equals("5")) {
	            
	            switch (entrada) {
		            case "1":
						String op1[] = null;
					    String linha = in.readLine();
					    op1 = linha.split(", "); 
					    carregarArquivo(op1[0], op1[1]);
						break;
						      
					case "2":
						String op2[] = null;
					    String linha2 = in.readLine();
					    op2 = linha2.split(", "); 
					    escreverArquivos(op2);
						break;
						 
					case "3":
						descarregarLista();
						out.println("Arquivos Descarregados!");
						break;
					
					case "4":
						String nome = in.readLine();
						capturarBytes(nome);
						break;
						           
					default:
						System.out.println("Esperando mensagem...");
			            entrada = null;
			            entrada = in.readLine();
						break;
	            }
	            
	             System.out.println("Esperando mensagem...");
	             entrada = null;
	             entrada = in.readLine();
	             
	        }            
 
	        out.close();
	        in.close();
	        //clientSocket.close();
	        s.close();
	        ss.close();
	
	        } catch (IOException ex) {
	            System.err.println("error " + ex);
	        }
	
	}
	    
	private void carregarArquivo(String nome, String caminho) {
		String url = caminho+nome;
	    
		try {
			File arquivo = new File(url);
			BufferedReader br = new BufferedReader(new FileReader(url));
			
			listaArquivos.add(arquivo);
			
			for (File file : listaArquivos) {
				System.out.println(file.getName());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void escreverArquivos(String[] op2) throws IOException {
		
		File arquivo = null;
		
		for (int i = 0; i < op2.length; i++) {
			
			if((i % 2 == 0) || (i == 0)){
				
				for(File file : listaArquivos){
		            if(file.getName().equals(op2[i])){
		                arquivo = file;
		                
		            }
		        }
		        
				Integer miliInt = Integer.parseInt(op2[i+1]);
				long mili = miliInt.longValue();
				long tempo = 0;
				long inicio = 0;
				long fim = 0;
				Integer j=0;
		        
				while (tempo <= mili) {

					try {
						inicio = System.currentTimeMillis();
						
						InputStream in = new FileInputStream(arquivo.getAbsolutePath());
					    OutputStream out = new FileOutputStream("C:/Users/Matheus/Desktop/exemplo/"+j+arquivo.getName());
						
					    byte[] buf = new byte[1024];
				        int len;
				        
				        while ((len = in.read(buf)) > 0) {
				            out.write(buf, 0, len);
				        }
				        
				        in.close();
				        out.close();
				        
				        
				        fim = System.currentTimeMillis();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					tempo += (fim-inicio);
					j++;
					System.out.println(tempo);
				}
				
			}
			
		}
		op2 = null;
        
	}
	
	private void descarregarLista() {
		
		try {
			listaArquivos.clear();
			
			for (File file : listaArquivos) {
				System.out.println(file.getName());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void capturarBytes(String nome) {
		
		Socket sockServer = null;
		FileOutputStream fos = null;
		InputStream is = null;
		   
	     try {
	    	 sockServer = new Socket("127.0.0.1", 13267);
	    	 is = sockServer.getInputStream();
	    	 
	    	 fos = new FileOutputStream(new File("C:/Users/Matheus/Desktop/exemplo/isso/"+nome));
	    	 System.out.println("Arquivo Local Criado C:/Users/Matheus/Desktop/exemplo/isso/"+nome);
	    	 
	    	 byte[] cbuffer = new byte[1024];
	    	 int bytesRead;
	    	 	 	    	 
	    	 System.out.println("Recebendo arquivo...");
	    	 while ((bytesRead = is.read(cbuffer)) != -1) {
	    	     fos.write(cbuffer, 0, bytesRead);
	    	     fos.flush();
	    	 }
	    	 
	    	 System.out.println("Arquivo recebido!");

	    	 is.close();
	    	 fos.close();
	    	 sockServer.close();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
 
}