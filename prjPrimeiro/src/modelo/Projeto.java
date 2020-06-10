package modelo;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Projeto implements Serializable, Comparable<Projeto>{
	
	private String       nome;
	private Set<Aluno>   conjAlunos;
	
	public Projeto(String nome) throws ModeloException {
		super();
		this.setNome(nome);
		this.conjAlunos = new TreeSet<Aluno>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novoNome) throws ModeloException {
		if (!Projeto.validarNome(novoNome))
			throw new ModeloException("O nome informado é inválido: " + novoNome);
		this.nome = novoNome;
	}

	public Set<Aluno> getConjAlunos() {
		return new TreeSet<Aluno>(conjAlunos);
	}

	public void setConjAlunos(Set<Aluno> cas) throws ModeloException  {
		if(!Projeto.validarConjAlunos(cas)) 
			throw new ModeloException("O conjunto de alunos é inválido!");
		this.conjAlunos = new TreeSet<Aluno>(cas);
	}

	public void addAluno(Aluno a) throws ModeloException {
		if (!Projeto.validarAluno(a))
			throw new ModeloException("Não foi indicado aluno para ser associado ao projeto");
		if (!this.conjAlunos.contains(a)) {
			this.conjAlunos.add(a);
			a.addProjeto(this);
		}
	}

	public void removeAluno(Aluno a) throws ModeloException {
		if (!Projeto.validarAluno(a))
			throw new ModeloException("Não foi indicado aluno para ser excluído do projeto");
		if(this.conjAlunos.contains(a)) { 
			this.conjAlunos.remove(a);
			a.removeProjeto(this);
		}
	}

	public static boolean validarNome(String nome) {
		if (nome == null || nome.length() < 8)
			return false;
		return true;
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

	@Override
	public String toString() {
		return "Projeto " + nome + " - Qtde de Alunos: " + this.conjAlunos.size();
	}

	public int compareTo(Projeto outro) {
		return this.getNome().compareTo(outro.getNome());
	}
}
