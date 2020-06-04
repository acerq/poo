package modelo;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable, Comparable<Aluno> {
	private int 	matr;
	private Curso 	meuCurso;
	
	public Aluno(String c, String n, int m, Curso cs) throws ModeloException {
		super(c, n);
		this.setMatr(m);
		this.setMeuCurso(cs);
	}

	public int getMatr() {
		return matr;
	}

	public void setMatr(int matr) throws ModeloException {
		if(!Aluno.validarMatr(matr))
			throw new ModeloException("A matrícula informada é inválida: " + matr);
		this.matr = matr;
	}
	
	public Curso getMeuCurso() {
		return meuCurso;
	}

	public void setMeuCurso(Curso meuCurso) throws ModeloException {
		if(!Aluno.validarMeuCurso(meuCurso))
			throw new ModeloException("Não foi informado o curso do aluno");
		// Se eu não atribuí o curso para o aluno, então...
		if(meuCurso != this.meuCurso) {
			// Se o aluno pertencia a outro curso, retiro ele de lá
			if(this.meuCurso != null)
				this.meuCurso.removeAluno(this);
			this.meuCurso = meuCurso;
			meuCurso.addAluno(this);
		}
	}
	
	public int compareTo(Aluno outro) {
		return this.getNome().compareTo(outro.getNome());
	}
	
	public static boolean validarMatr(int matr) {
		if(matr > 0 && matr < 100000)
			return true;
		return false;
	}

	public static boolean validarMeuCurso(Curso cs) {
		if(cs != null)
			return true;
		return false;
	}

	public static String metodoEstatico() {
		return "Executei um método estático!";
	}

}
