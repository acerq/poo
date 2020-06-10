package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Data Access Object

public class DaoAluno {
	private static Set<Aluno> conjAlunos = new TreeSet<Aluno>();

	public static void recuperarObjetos(ObjectInputStream ois) throws IOException {
		try {
			conjAlunos = (TreeSet<Aluno>)ois.readObject();
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar os objetos Aluno");
			conjAlunos = new TreeSet<Aluno>();
		} 	
	}
	
	public static void salvarObjetos(ObjectOutputStream oos) throws IOException{		
		try {
			oos.writeObject(conjAlunos);
		} catch (Exception e) {
			System.out.println("Não foi possível salvar os objetos Aluno");
		}		
	}
	
	public boolean add(Aluno c) {
		return conjAlunos.add(c);
	}

	public boolean update(Aluno c) {
		return conjAlunos.add(c);
	}

	public boolean remove(Aluno c) {
		return conjAlunos.remove(c);
	}

	public Aluno get(int pos) {
		List<Aluno> lista = new ArrayList<Aluno>(conjAlunos);
		return lista.get(pos);
	}
	
	public List<Aluno> getAll() {
		return new ArrayList<Aluno>(conjAlunos);
	}
	
	public int size() {
		return conjAlunos.size();
	}
}
