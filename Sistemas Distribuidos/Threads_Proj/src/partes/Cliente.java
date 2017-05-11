package partes;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Cliente extends Conexao {

	public static void main(String[] args) {
		new Cliente();
	}
	
	public Cliente() {
		
		try {
			conectaServidor();
			
			String entrada = JOptionPane.showInputDialog("Informe o intervalo que deseja verificar.");
			
			out.println(entrada);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
