package partes;


import conexao.Conexao;
import execucao.CalculoPrimo;

public class Servidor extends Conexao {

	public static void main(String[] args) {
		new Servidor();
	}
	
	public Servidor() {
		
		try {
			conectaCliente();
			
			String[] array;
			String entrada = in.readLine();
			array = entrada.split(", ");
			Integer n1 = Integer.parseInt(array[0]);
			Integer n2 = Integer.parseInt(array[1]);
			Integer intervalo = n2-n1;
			
			CalculoPrimo calc1 = new CalculoPrimo();
			calc1.setN1(n1);
			double valor = intervalo*0.25;
			int partInteira = (int) valor;
			calc1.setN2(n1+partInteira);
			
			CalculoPrimo calc2 = new CalculoPrimo();
			calc2.setN1(n1+partInteira+1);
			double valor1 = intervalo*0.50;
			int partInteira1 = (int) valor1;
			calc2.setN2(n1+partInteira1);
			
			CalculoPrimo calc3 = new CalculoPrimo();
			calc3.setN1(n1+partInteira1+1);
			double valor2 = intervalo*0.75;
			int partInteira2 = (int) valor2;
			calc3.setN2(n1+partInteira2);
			
			CalculoPrimo calc4 = new CalculoPrimo();
			calc4.setN1(n1+partInteira2+1);
			calc4.setN2(n2);
			
			Thread ter1 = new Thread(calc1);
			Thread ter2 = new Thread(calc2);
			Thread ter3 = new Thread(calc3);
			Thread ter4 = new Thread(calc4);
			
			ter1.start();
			ter2.start();
			ter3.start();
			ter4.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
}
