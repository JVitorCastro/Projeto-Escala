package negocio;

import java.util.ArrayList;

import classesBase.Integrante;

public interface RepositorioIntegrante {
	public void inserir(Integrante integrante);
	public void remover(String nome);
	public Integrante buscarIntegrante(String nome);
	public ArrayList<Integrante> listar();
	public void imprimirRepositorio();
}
