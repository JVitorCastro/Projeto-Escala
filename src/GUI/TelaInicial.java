package GUI;

import java.util.Date;
import java.util.GregorianCalendar;

import classesBase.Integrante;
import dados.RepositorioIntegranteArray;
import negocio.ControleIntegrantes;

public class TelaInicial {

	public static void main(String[] args) {
		ControleIntegrantes controle = new ControleIntegrantes();
		Integrante joao = new Integrante("Joao", 'M');
		
		
		System.out.println(joao);
		controle.inserir(joao);
		controle.imprimirRepositorio();
		
		GregorianCalendar x = new GregorianCalendar();
		x.set(x.DAY_OF_MONTH, 1);
		System.out.println(x);
		System.out.println(x.get(x.DAY_OF_WEEK));
		
		Date date = x.getTime();
		System.out.println(date);
	}

}
