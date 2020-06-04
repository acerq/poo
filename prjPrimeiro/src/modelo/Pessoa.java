package modelo;

import java.io.Serializable;

abstract public class Pessoa implements Serializable {
	//
	// ATRIBUTOS
	//
	private String cpf;
	private String nome;

	//
	// MÉTODOS
	//
	public Pessoa(String c, String n) throws ModeloException {
		this.setCpf(c);
		this.setNome(n);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String novoCpf) throws ModeloException {
		if (!Pessoa.validarCpf(novoCpf))
			throw new ModeloException("O Cpf informado é inválido: " + novoCpf);
		this.cpf = novoCpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novoNome) throws ModeloException {
		if (!Pessoa.validarNome(novoNome))
			throw new ModeloException("O nome informado é inválido: " + novoNome);
		this.nome = novoNome;
	}

	public String toString() {
		return "Meu nome é " + this.nome;
	}

	public static boolean validarCpf(String cpf) {
		if (cpf == null || cpf.length() != 11)
			return false;
		for (int pos = 0; pos < 11; pos++) {
			char c = cpf.charAt(pos);
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public static boolean validarNome(String nome) {
		if (nome == null || nome.length() < 4)
			return false;
		return true;
	}
}
