package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import classesBase.Escala;
import negocio.RepositorioEscala;

public class RepositorioEscalaArray implements RepositorioEscala, Serializable {
	private ArrayList<Escala> escalas;
	private static RepositorioEscalaArray instance;
	

	public RepositorioEscalaArray() {
		this.escalas = new ArrayList<Escala>();
	}
	
	public static RepositorioEscalaArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioEscalaArray lerDoArquivo() {
		RepositorioEscalaArray instanciaLocal = null;
	    //Criando um arquivo e passando o nome dele	
	    File in = new File("escalas.dat");//criando um arquivo .dat na pasta do projeto
	   
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioEscalaArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioEscalaArray();
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
	     
	    File out = new File("escalas.dat");
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
	public void imprimirEscala() {
		for(Escala escala : this.escalas) {
			System.out.println(escala.getData());
			System.out.println(escala.getIntegrantes_manha().toString());			
			System.out.println(escala.getIntegrantes_noite().toString());			
		}

	}

	@Override
	public void inserirEscala(Escala escala) {
		this.escalas.add(escala);
		
	}

	@Override
	public Escala buscarEscala(Date data) {
		for (Escala escala : this.escalas) {
			if(escala.getData().equals(data)) {
				return escala;
			}
		}
		return null;
	}

	@Override
	public void removerEscala(Date data) {
		for (Escala escala : this.escalas) {
			if(escala.getData().equals(data)) {
				this.escalas.remove(escala);
			}
		}
	}

	@Override
	public ArrayList<Escala> listarEscala() {
		return this.escalas;
	}

}
