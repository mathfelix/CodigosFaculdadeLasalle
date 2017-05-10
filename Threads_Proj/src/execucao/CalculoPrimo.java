package execucao;

import java.util.ArrayList;

public class CalculoPrimo implements Runnable {

	private Integer n1;
	private Integer n2;


	@Override
	public void run() {
		numerosPrimos(n1, n2);
		System.out.println("Fim");
		
	}
	
	public ArrayList<Integer> numerosPrimos(Integer n1, Integer n2){
	    ArrayList<Integer> arrayPrimos = new ArrayList<>();
	    for (int i = n1; i <= n2; i++){
	        if(ePrimo(i) && i != 1 && i != 0) 
	        {
	        	arrayPrimos.add(i);
	            System.out.println(i + " é primo");
	        }
	    }
	    return arrayPrimos;
	} 


	private boolean ePrimo(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
	public Integer getN1() {
		return n1;
	}


	public void setN1(Integer n1) {
		this.n1 = n1;
	}


	public Integer getN2() {
		return n2;
	}


	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	
}
