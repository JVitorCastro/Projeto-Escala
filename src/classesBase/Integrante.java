package classesBase;

import java.io.Serializable;
import java.util.ArrayList;

public class Integrante implements Serializable {
	private String nome;
	private int prioridade;
	private char horarios;
	private ArrayList<Integer> dias_folga;
	
	public Integrante(String nome, char horarios) {
		this.nome = nome;
		this.prioridade = 0;
		this.horarios = horarios;
		this.dias_folga = new ArrayList<Integer>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public char getHorarios() {
		return horarios;
	}

	public void setHorarios(char horarios) {
		this.horarios = horarios;
	}

	public ArrayList<Integer> getDias_folga() {
		return dias_folga;
	}	
	
}
