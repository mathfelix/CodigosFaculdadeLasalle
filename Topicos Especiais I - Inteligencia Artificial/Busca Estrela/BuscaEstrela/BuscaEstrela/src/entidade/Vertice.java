package entidade;

import java.util.List;

public class Vertice implements Comparable<Vertice> {

	private String nome;
	private Integer custo;
	private List<Vertice> filhos;
	private Integer heuristica;
	
	public Integer getHeuristica() {
		return heuristica;
	}

	public void setHeuristica(Integer heuristica) {
		this.heuristica = heuristica;
	}

	public Vertice() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCusto() {
		return custo;
	}
	public void setCusto(Integer custo) {
		this.custo = custo;
	}
	public List<Vertice> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<Vertice> filhos) {
		this.filhos = filhos;
	}
	
	@Override
	public String toString() {
		return "Vertice [nome=" + nome + ", custo=" + custo + ", filhos=" + filhos + "]";
	}

	@Override
	public int compareTo(Vertice outroVertice) {
		
		if (this.custo > outroVertice.getCusto()) {
	         return 1;
	    }
	    if (this.custo < outroVertice.getCusto()) {
	         return -1;
	    }
	    return 0;

	}
	

	
}
