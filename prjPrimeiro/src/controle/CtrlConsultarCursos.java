package controle;

import modelo.Curso;
import modelo.DaoCurso;
import modelo.TipoCurso;
import viewer.JanelaConsultarCursos;

public class CtrlConsultarCursos {
	
	//
	// ATRIBUTOS
	//

	// Referência para o Ctrl do Programa
	private CtrlPrograma meuControlador;

	// Referência para os Ctrls chamados por ele
	private CtrlIncluirCurso ctrlIncluirCurso;
	private CtrlAlterarCurso ctrlAlterarCurso;
	private CtrlExcluirCurso ctrlExcluirCurso;

	// Atributos de controle da navegação
	private Curso atual;
	private int posAtual = -1;
	private int numCursos = 0;

	// Referência para a Janela com quem ele se comunica
	private JanelaConsultarCursos jCurso;

	//
	// Métodos
	//
	public CtrlConsultarCursos(CtrlPrograma ctrl) {
		this.meuControlador = ctrl;
		jCurso = new JanelaConsultarCursos(this);
		DaoCurso dao = new DaoCurso();
		if(dao.size() > 0) 
			this.posAtual = 0;
		else 
			this.posAtual = -1;
		this.exibir();
	}

	// Métodos de Exibição e Navegação
	private void exibir() {
		if (posAtual != -1) {
			DaoCurso dao = new DaoCurso();
			this.atual = dao.get(posAtual);
			this.numCursos = dao.size();
			String codigo = Integer.toString(atual.getCodigo());
			String nome = atual.getNome();
			String tipo = atual.getTipo().toString();
			jCurso.exibir(codigo, nome, tipo, posAtual+1, numCursos);
		} else {
			numCursos = 0;
			atual = null;
			jCurso.exibir("", "", "", posAtual+1, numCursos);
		}
	}

	public void exibirPrimeiro() {
		DaoCurso dao = new DaoCurso();
		if (dao.size() > 0) 
			posAtual = 0;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirUltimo() {
		DaoCurso dao = new DaoCurso();
		if (dao.size() > 0) 
			posAtual = dao.size() - 1;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirAnterior() {
		DaoCurso dao = new DaoCurso();
		if (dao.size() > 0) {
			if(posAtual > 0) 
				posAtual--;
		}
		else 
			posAtual = -1;
		exibir();

	}

	public void exibirProximo() {
		DaoCurso dao = new DaoCurso();
		if (dao.size() > 0) {
			if(posAtual != dao.size() - 1) 
				posAtual++;
		}
		else
			posAtual = -1;
		exibir();
	}

	// Métodos de chamada e encerramendo das subfuncionalidades
	public void iniciarFuncionalidadeIncluirCurso() {
		if (this.ctrlIncluirCurso == null)
			this.ctrlIncluirCurso = new CtrlIncluirCurso(this);
	}

	public void encerrarFuncionalidadeIncluirCurso() {
		this.ctrlIncluirCurso = null;
		// Se houve inclusão...
		DaoCurso dao = new DaoCurso();
		if(numCursos < dao.size())
			posAtual = dao.size() - 1;
		exibir();
	}

	public void iniciarFuncionalidadeAlterarCurso() {
		if (this.ctrlAlterarCurso == null)
			this.ctrlAlterarCurso = new CtrlAlterarCurso(this, atual);
	}

	public void encerrarFuncionalidadeAlterarCurso() {
		this.ctrlAlterarCurso = null;
		exibir();
	}

	public void iniciarFuncionalidadeExcluirCurso() {
		if (this.ctrlExcluirCurso == null)
			this.ctrlExcluirCurso = new CtrlExcluirCurso(this, atual);
	}

	public void encerrarFuncionalidadeExcluirCurso() {
		this.ctrlExcluirCurso = null;
		DaoCurso dao = new DaoCurso();
		if(dao.size() > 0)
			posAtual = 0;
		else
			posAtual = -1;
		exibir();
	}
	
	public void encerrarFuncionalidade() {
		this.jCurso.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeConsultarCursos();
	}
}
