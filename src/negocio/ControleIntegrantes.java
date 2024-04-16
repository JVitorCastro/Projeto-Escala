package negocio;

import java.util.ArrayList;

import classesBase.Integrante;
import dados.RepositorioIntegranteArray;

public class ControleIntegrantes {
	private RepositorioIntegrante integrantes;

	public ControleIntegrantes() {
		this.integrantes = RepositorioIntegranteArray.getInstance();
	}
	
	public ArrayList<Integrante> listar(){
		return this.integrantes.listar();
	}
	
	public void inserir(Integrante integrante) {
		if(this.integrantes.buscarIntegrante(integrante.getNome()) == null) {
			this.integrantes.inserir(integrante);
			RepositorioIntegranteArray.salvarArquivo();
		}
	}
	
	public void remover(String nome) {
		if(this.integrantes.buscarIntegrante(nome) != null) {
			this.integrantes.remover(nome);
			RepositorioIntegranteArray.salvarArquivo();
		}
	}
	
	public Integrante buscarIntegrante(String nome) {
		if(this.integrantes.buscarIntegrante(nome) != null) {
			return this.integrantes.buscarIntegrante(nome);
		}
		return null;
	}
	
	public void imprimirRepositorio() {
		this.integrantes.imprimirRepositorio();
	}
	
}
