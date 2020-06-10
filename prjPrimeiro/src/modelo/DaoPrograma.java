package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DaoPrograma {

	public static void recuperarObjetos() {
		try {
			FileInputStream fis = new FileInputStream("objetos.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			DaoAluno.recuperarObjetos(ois);
			DaoCurso.recuperarObjetos(ois);
			DaoProjeto.recuperarObjetos(ois);
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void salvarObjetos() {
		try {
			FileOutputStream fos = new FileOutputStream("objetos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			DaoAluno.salvarObjetos(oos);
			DaoCurso.salvarObjetos(oos);
			DaoProjeto.salvarObjetos(oos);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
