package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import classesBase.Integrante;
import negocio.RepositorioIntegrante;

public class RepositorioIntegranteArray implements RepositorioIntegrante, Serializable {
	
	private ArrayList<Integrante> integrantes;
//	private int indice;
	private static RepositorioIntegranteArray instance;

	
	
	public RepositorioIntegranteArray() {
		this.integrantes = new ArrayList<Integrante>();
	}
	
	public static RepositorioIntegranteArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioIntegranteArray lerDoArquivo() {
		RepositorioIntegranteArray instanciaLocal = null;
	    //Criando um arquivo e passando o nome dele	
	    File in = new File("integrante.dat");//criando um arquivo .dat na pasta do projeto
	   
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioIntegranteArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioIntegranteArray();
	    } finally {
	      if (ois != null) {
	        try {
	          ois.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	    return instanciaLocal;
	  }
	
	
	public static void salvarArquivo() {
	    if (!(instance == null)) {
	     
	    File out = new File("integrante.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;
	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance); 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	   }
	} 
	
	@Override
	public void inserir(Integrante integrante) {
		this.integrantes.add(integrante);
	}

	@Override
	public void remover(String nome) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integrante buscarIntegrante(String nome) {
		for (Integrante integrante : this.integrantes) {
			if(integrante.getNome().equals(nome)) {
				return integrante;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Integrante> listar() {
		return this.integrantes;
	}

	@Override
	public void imprimirRepositorio() {
		for(Integrante integrante : this.integrantes) {
			System.out.println(integrante.getNome());
		}

	}

}
