package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Data Access Object

public class DaoProjeto {
	private static Set<Projeto> conjProjetos = new TreeSet<Projeto>();

	public static void recuperarObjetos(ObjectInputStream ois) throws IOException {
		try {
			conjProjetos = (TreeSet<Projeto>)ois.readObject();
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar os objetos Projeto");
			conjProjetos = new TreeSet<Projeto>();
		} 	
	}
	
	public static void salvarObjetos(ObjectOutputStream oos) throws IOException{		
		try {
			oos.writeObject(conjProjetos);
		} catch (Exception e) {
			System.out.println("Não foi possível salvar os objetos Projeto");
		}		
	}
	
	public boolean add(Projeto c) {
		return conjProjetos.add(c);
	}

	public boolean update(Projeto c) {
		return conjProjetos.add(c);
	}

	public boolean remove(Projeto c) {
		return conjProjetos.remove(c);
	}

	public Projeto get(int pos) {
		List<Projeto> lista = new ArrayList<Projeto>(conjProjetos);
		return lista.get(pos);
	}
	
	public Projeto[] getAll() {
		List<Projeto> lista = new ArrayList<Projeto>(conjProjetos);
		return lista.toArray(new Projeto[0]);
	}
	
	public int size() {
		return conjProjetos.size();
	}
}
