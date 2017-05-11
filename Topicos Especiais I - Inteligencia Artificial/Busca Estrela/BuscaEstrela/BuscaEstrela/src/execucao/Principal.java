package execucao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import controle.LeituraArquivo;
import entidade.Vertice;

public class Principal {

	
	public static void main(String[] args) {
		List<Vertice> listaVertices = new ArrayList<Vertice>();
		List<Vertice> listaHeuristicas = new ArrayList<Vertice>();
		LeituraArquivo lerArq = new LeituraArquivo();
		Scanner ler = new Scanner(System.in);
		
		listaVertices = lerArq.lerArquivo();
		listaHeuristicas = lerArq.lerHeuristica();
	    
		System.out.printf("Informe o nó inicial:");
	    String inicial = ler.nextLine();
		
		System.out.printf("Informe o nó terminal:");
	    String terminal = ler.nextLine();
		
		lerArq.BuscaEstrela(listaVertices, inicial, terminal, listaHeuristicas);
		
	}
	
	
	
	
	
	
	
	
}
