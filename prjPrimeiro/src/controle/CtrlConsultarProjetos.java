package controle;

import modelo.DaoProjeto;
import modelo.Projeto;
import viewer.JanelaConsultarProjetos;

public class CtrlConsultarProjetos {
	
	//
	// ATRIBUTOS
	//

	// Refer�ncia para o Ctrl do Programa
	private CtrlPrograma meuControlador;

	// Refer�ncia para os Ctrls chamados por ele
	private CtrlIncluirProjeto ctrlIncluirProjeto;
	private CtrlAlterarProjeto ctrlAlterarProjeto;
	private CtrlExcluirProjeto ctrlExcluirProjeto;

	// Atributos de controle da navega��o
	private Projeto atual;
	private int posAtual = -1;
	private int numProjetos = 0;

	// Refer�ncia para a Janela com quem ele se comunica
	private JanelaConsultarProjetos jProjeto;

	//
	// M�todos
	//
	public CtrlConsultarProjetos(CtrlPrograma ctrl) {
		this.meuControlador = ctrl;
		jProjeto = new JanelaConsultarProjetos(this);
		DaoProjeto dao = new DaoProjeto();
		if(dao.size() > 0) 
			this.posAtual = 0;
		else 
			this.posAtual = -1;
		this.exibir();
	}

	// M�todos de Exibi��o e Navega��o
	private void exibir() {
		if (posAtual != -1) {
			DaoProjeto dao = new DaoProjeto();
			this.atual = dao.get(posAtual);
			this.numProjetos = dao.size();
			String nome = atual.getNome();
			jProjeto.exibir(nome, posAtual+1, numProjetos);
		} else {
			numProjetos = 0;
			atual = null;
			jProjeto.exibir("", posAtual+1, numProjetos);
		}
	}

	public void exibirPrimeiro() {
		DaoProjeto dao = new DaoProjeto();
		if (dao.size() > 0) 
			posAtual = 0;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirUltimo() {
		DaoProjeto dao = new DaoProjeto();
		if (dao.size() > 0) 
			posAtual = dao.size() - 1;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirAnterior() {
		DaoProjeto dao = new DaoProjeto();
		if (dao.size() > 0) {
			if(posAtual > 0) 
				posAtual--;
		}
		else 
			posAtual = -1;
		exibir();

	}

	public void exibirProximo() {
		DaoProjeto dao = new DaoProjeto();
		if (dao.size() > 0) {
			if(posAtual != dao.size() - 1) 
				posAtual++;
		}
		else
			posAtual = -1;
		exibir();
	}

	// M�todos de chamada e encerramendo das subfuncionalidades
	public void iniciarFuncionalidadeIncluirProjeto() {
		if (this.ctrlIncluirProjeto == null)
			this.ctrlIncluirProjeto = new CtrlIncluirProjeto(this);
	}

	public void encerrarFuncionalidadeIncluirProjeto() {
		this.ctrlIncluirProjeto = null;
		// Se houve inclus�o...
		DaoProjeto dao = new DaoProjeto();
		if(numProjetos < dao.size())
			posAtual = dao.size() - 1;
		exibir();
	}

	public void iniciarFuncionalidadeAlterarProjeto() {
		if (this.ctrlAlterarProjeto == null)
			this.ctrlAlterarProjeto = new CtrlAlterarProjeto(this, atual);
	}

	public void encerrarFuncionalidadeAlterarProjeto() {
		this.ctrlAlterarProjeto = null;
		exibir();
	}

	public void iniciarFuncionalidadeExcluirProjeto() {
		if (this.ctrlExcluirProjeto == null)
			this.ctrlExcluirProjeto = new CtrlExcluirProjeto(this, atual);
	}

	public void encerrarFuncionalidadeExcluirProjeto() {
		this.ctrlExcluirProjeto = null;
		DaoProjeto dao = new DaoProjeto();
		if(dao.size() > 0)
			posAtual = 0;
		else
			posAtual = -1;
		exibir();
	}
	
	public void encerrarFuncionalidade() {
		this.jProjeto.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeConsultarProjetos();
	}
}
