package modelo;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Curso implements Serializable, Comparable<Curso> {
	//
	// ATRIBUTOS
	//
	private int codigo;
	private String nome;
	private Set<Aluno> conjAlunos;
	private TipoCurso tipo;

	//
	// MÉTODOS
	//
	public Curso(int codigo, String nome, TipoCurso tipo) throws ModeloException {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setTipo(tipo);
		this.conjAlunos = new TreeSet<Aluno>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setTipo(TipoCurso t) throws ModeloException {
		if (!Curso.validarTipoCurso(t))
			throw new ModeloException("Tipo Inválido");
		this.tipo = t;
	}
	
	public TipoCurso getTipo() {
		return tipo;
	}

	public void setCodigo(int codigo) throws ModeloException {
		if (!Curso.validarCodigo(codigo))
			throw new ModeloException("O valor passado para o código do curso é inválido: " + codigo);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModeloException {
		if (!Curso.validarNome(nome))
			throw new ModeloException("O valor passado para o nome é inválido: " + nome);
		this.nome = nome;
	}

	public Set<Aluno> getConjAlunos() {
		return new TreeSet<Aluno>(conjAlunos);
	}

	public void setConjAlunos(Set<Aluno> cas) throws ModeloException  {
		if(!Curso.validarConjAlunos(cas)) 
			throw new ModeloException("O conjunto de alunos é inválido!");
		this.conjAlunos = new TreeSet<Aluno>(cas);
	}

	public void addAluno(Aluno a) throws ModeloException {
		if (!Curso.validarAluno(a))
			throw new ModeloException("Não foi indicado aluno para ser incluído no curso");
		if (!this.conjAlunos.contains(a)) {
			this.conjAlunos.add(a);
			a.setMeuCurso(this);
		}
	}

	public void removeAluno(Aluno a) throws ModeloException {
		if (!Curso.validarAluno(a))
			throw new ModeloException("Não foi indicado aluno para ser excluído do curso");
		if (this.conjAlunos.contains(a)) 
			this.conjAlunos.remove(a);
	}

	public int compareTo(Curso outro) {
		return this.codigo - outro.codigo;
	}
	
	@Override
	public String toString() {
		return codigo + " - " + nome;
	}

	//
	// Métodos de verificação e crítica dos valores
	//
	public static boolean validarCodigo(int codigo) {
		if (codigo > 0 && codigo < 100)
			return true;
		return false;
	}

	public static boolean validarNome(String nome) {
		if (nome != null && nome.length() > 3)
			return true;
		return false;
	}

	public static boolean validarAluno(Aluno a) {
		if (a != null)
			return true;
		return false;
	}

	public static boolean validarConjAlunos(Set<Aluno> cas) {
		if (cas != null)
			return true;
		return false;
	}

	public static boolean validarTipoCurso(TipoCurso t) {
		if (t != null)
			return true;
		return false;
	}
}
