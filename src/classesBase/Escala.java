package classesBase;

import java.util.ArrayList;
import java.util.Date;

public class Escala {
	private ArrayList<Integrante> integrantes_manha;
	private ArrayList<Integrante> integrantes_noite;
	private Date data;
	
	public Escala() {
		this.integrantes_manha = new ArrayList<Integrante>();
		this.integrantes_noite = new ArrayList<Integrante>();
		this.data = new Date();
	}

	public ArrayList<Integrante> getIntegrantes_manha() {
		return this.integrantes_manha;
	}

	public void inserirIntegrantes_manha(Integrante integrante) {
		this.integrantes_manha.add(integrante);
	}

	public ArrayList<Integrante> getIntegrantes_noite() {
		return integrantes_noite;
	}

	public void inserirIntegrantes_noite(Integrante integrante) {
		this.integrantes_noite.add(integrante);
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	
	
}
