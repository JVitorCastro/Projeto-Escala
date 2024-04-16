package negocio;

import java.util.ArrayList;
import java.util.Date;

import classesBase.Escala;

public interface RepositorioEscala {
	public void inserirEscala(Escala escala);
	public void removerEscala(Date data);
	public Escala buscarEscala(Date data);
	public ArrayList<Escala> listarEscala();
	public void imprimirEscala();
}
