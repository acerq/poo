package modelo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Data Access Object

public class DaoCurso {
	private static Set<Curso> conjCursos = new TreeSet<Curso>();

	public static void recuperarObjetos(ObjectInputStream ois) throws IOException {
		try {
			conjCursos = (TreeSet<Curso>)ois.readObject();
		} catch (Exception e) {
			System.out.println("Não foi possível recuperar os objetos Aluno");
			conjCursos = new TreeSet<Curso>();
		} 	
	}
	
	public static void salvarObjetos(ObjectOutputStream oos) throws IOException{		
		try {
			oos.writeObject(conjCursos);
		} catch (Exception e) {
			System.out.println("Não foi possível salvar os objetos Aluno");
		}		
	}
	
	public boolean add(Curso c) {
		return conjCursos.add(c);
	}

	public boolean update(Curso c) {
		return conjCursos.add(c);
	}

	public boolean remove(Curso c) {
		return conjCursos.remove(c);
	}

	public Curso get(int pos) {
		List<Curso> lista = new ArrayList<Curso>(conjCursos);
		return lista.get(pos);
	}
	
	public Curso[] getAll() {
		List<Curso> lista = new ArrayList<Curso>(conjCursos);
		return lista.toArray(new Curso[0]);
	}
	
	public int size() {
		return conjCursos.size();
	}
}
