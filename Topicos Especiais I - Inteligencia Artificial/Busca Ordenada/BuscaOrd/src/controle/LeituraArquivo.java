package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import entidade.Vertice;

public class LeituraArquivo {

	
	public List<Vertice> lerArquivo(){
		
		
		List<Vertice> listaVertices = new ArrayList<>();
		Scanner ler = new Scanner(System.in);
		 
	    System.out.printf("Informe o nome de arquivo texto:\n");
	    String nome = ler.nextLine();
	 
	    try {
	    	FileReader arq = new FileReader(nome);
	    	BufferedReader lerArq = new BufferedReader(arq);
	 
	    	String linha = lerArq.readLine(); 
	      
	    	while (linha != null) {
	    		
	    		String[] vetPartes = linha.split(";");
	        
	    		Vertice vertice = new Vertice();
	    		vertice.setNome(vetPartes[0]);
	    	
	    		List<Vertice> listaFilhos = new ArrayList<>();
	    		Vertice verticeFilho = null;
	    		for (int j = 1; j < vetPartes.length; j += 2) {
		   		
	    			verticeFilho = new Vertice();
	    			verticeFilho.setNome(vetPartes[j]);
	    			verticeFilho.setCusto(Integer.parseInt(vetPartes[j+1]));
	    			listaFilhos.add(verticeFilho);
						
	    		}
	    		vertice.setFilhos(listaFilhos); 
	    		listaVertices.add(vertice);
			   
	    		vetPartes = null;
			    	        
	    		linha = lerArq.readLine(); // lê da segunda até a última linha
	    	
	    	}
	 
	    	arq.close();
	    	
	    	System.out.println(" ");
	    	for (int i = 0; i < listaVertices.size(); i++) {
				System.out.println("Pai: "+listaVertices.get(i).getNome()+" Filhos: "+listaVertices.get(i).getFilhos());
			}
	    	
	    	return listaVertices;
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
	        return null;
	    }
	
	}
	
	public void BuscaOrdenada(List<Vertice> listaVertice, String inicial, String terminal)
    {
        
        List<Vertice> listaFechados = new ArrayList<Vertice>();
        List<Vertice> listaAbertos = new ArrayList<Vertice>();
        
        Vertice vet = null; 
        for (int i = 0; i < listaVertice.size(); i++) {
			if (listaVertice.get(i).getNome().equals(inicial)) {
				
				listaVertice.get(i).setCusto(0);
				listaAbertos.add(listaVertice.get(i));
				
			}
		}
        
        
        while (!(listaAbertos.get(0).getNome().equals(terminal))) {

        	if(listaAbertos.isEmpty()){
            	System.out.println("Fracasso!");
            }
        	
            listaFechados.add(listaAbertos.get(0));

            for (Vertice item : listaAbertos.get(0).getFilhos())
            {
                Vertice filho2 = item;
                
                Vertice filho = new Vertice();
                filho.setNome(filho2.getNome());
                
                for (int i = 0; i < listaVertice.size(); i++) {
					if (filho.getNome().equals(listaVertice.get(i).getNome())) {
						filho.setFilhos(listaVertice.get(i).getFilhos());
					}
				}

                filho.setCusto(filho2.getCusto());
                filho.setCusto(listaAbertos.get(0).getCusto() + filho.getCusto());

                if (!listaAbertos.contains(filho) && (!listaFechados.contains(filho))){
                    listaAbertos.add(filho);
                }
                
                if (listaFechados.contains(filho)) {
					break;
				}

                if (listaAbertos.contains(filho))
                {
                    for (int j = 0; j < listaAbertos.size(); j++)
                    {
                        if (listaAbertos.get(j).getNome().equals(filho.getNome()))
                        {
                            if ((listaAbertos.get(j).getCusto() > filho.getCusto()) && (listaAbertos.get(j).getNome().equals(filho.getNome())))
                            {
                                
                            	listaAbertos.remove(j);
                            	listaAbertos.set(j, filho);
                            }
                            else if ((listaAbertos.get(j).getCusto() <= filho.getCusto()) && (listaAbertos.get(j).getNome().equals(filho.getNome())))
                            {
                            	break;
                            }
                        }
                    }
                }
            }

            Collections.sort(listaAbertos);
            listaAbertos.remove(0);
            
        }
        
        System.out.println("Nó encontrado! " + listaAbertos.get(0).getNome() + " Custo: " +listaAbertos.get(0).getCusto());
		
    }
	
}
