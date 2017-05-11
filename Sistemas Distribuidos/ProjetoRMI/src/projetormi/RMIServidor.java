/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetormi;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maycon Klopper
 */
public class RMIServidor implements Servidor
{
    List<File> listaArquivos = new ArrayList<File>();
    
    @Override
    public void carregarArquivo(String nome, String caminho) throws RemoteException 
    {
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

    @Override
    public void escreverArquivos(String[] op2) throws RemoteException 
    {
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
					    OutputStream out = new FileOutputStream("C:\\Users\\maycon Klopper\\Documents"+j+arquivo.getName());
						
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

    @Override
    public void descarregarLista() throws RemoteException 
    {
        try 
        {
            listaArquivos.clear();
			
            for (File file : listaArquivos) 
            {
		System.out.println(file.getName());
            }	
	} 
        catch (Exception e) 
        {
            e.printStackTrace();
	}
    }

    @Override
    public void capturaBytes(String nome, byte[] cbuffer) throws RemoteException 
    {
        File sourceFile = new File("C:/Users/maycon Klopper/Documents/" + nome);
        FileOutputStream file = null;
        try 
        {
            file = new FileOutputStream(sourceFile);
        } 
        catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
         BufferedOutputStream output = new BufferedOutputStream(file); 
        try 
        {
            output.flush();
            output.write(cbuffer, 0, cbuffer.length); 
            output.flush();
            output.close();
            file.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
    
}
