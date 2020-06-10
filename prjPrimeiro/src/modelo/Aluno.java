package modelo;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Aluno extends Pessoa implements Serializable, Comparable<Aluno> {
	private int matr;
	private Curso meuCurso;
	private Set<Projeto> meusProjetos;

	public Aluno(String c, String n, int m, Curso cs) throws ModeloException {
		super(c, n);
		this.setMatr(m);
		this.setMeuCurso(cs);
		this.meusProjetos = new TreeSet<Projeto>();
	}

	public int getMatr() {
		return matr;
	}

	public void setMatr(int matr) throws ModeloException {
		if (!Aluno.validarMatr(matr))
			throw new ModeloException("A matrícula informada é inválida: " + matr);
		this.matr = matr;
	}

	public Curso getMeuCurso() {
		return meuCurso;
	}

	public void setMeuCurso(Curso meuCurso) throws ModeloException {
		if (!Aluno.validarMeuCurso(meuCurso))
			throw new ModeloException("Não foi informado o curso do aluno");
		// Se eu não atribuí o curso para o aluno, então...
		if (meuCurso != this.meuCurso) {
			// Se o aluno pertencia a outro curso, retiro ele de lá
			if (this.meuCurso != null)
				this.meuCurso.removeAluno(this);
			this.meuCurso = meuCurso;
			meuCurso.addAluno(this);
		}
	}

	public Set<Projeto> getMeusProjetos() {
		return new TreeSet<Projeto>(meusProjetos);
	}

	public void setMeusProjetos(Set<Projeto> mps) throws ModeloException {
		if (!Aluno.validarMeusProjetos(mps))
			throw new ModeloException("O conjunto de projetos é inválido!");
		this.meusProjetos = new TreeSet<Projeto>(mps);
	}

	public void addProjeto(Projeto p) throws ModeloException {
		if (!Aluno.validarProjeto(p))
			throw new ModeloException("Não foi indicado projeto para ser associado ao aluno");
		if (!this.meusProjetos.contains(p)) {
			this.meusProjetos.add(p);
			p.addAluno(this);
		}
	}

	public void removeProjeto(Projeto p) throws ModeloException {
		if (!Aluno.validarProjeto(p))
			throw new ModeloException("Não foi indicado projeto para ser excluído do aluno");
		if (this.meusProjetos.contains(p)) {
			this.meusProjetos.remove(p);
			p.removeAluno(this);
		}
	}

	public int compareTo(Aluno outro) {
		return this.getNome().compareTo(outro.getNome());
	}

	public String toString() {
		return this.matr + "-" + this.getNome();
	}

	public static boolean validarMatr(int matr) {
		if (matr > 0 && matr < 100000)
			return true;
		return false;
	}

	public static boolean validarMeuCurso(Curso cs) {
		if (cs != null)
			return true;
		return false;
	}

	public static boolean validarProjeto(Projeto p) {
		if (p != null)
			return true;
		return false;
	}

	public static boolean validarMeusProjetos(Set<Projeto> p) {
		if (p != null)
			return true;
		return false;
	}
}
