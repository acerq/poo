package controle;

import modelo.Aluno;
import modelo.DaoAluno;
import viewer.JanelaConsultarAlunos;

/**
 * Controlador da Funcionalidade de Consulta aos Alunos
 * @author aless
 *
 */
public class CtrlConsultarAlunos {
	
	//
	// ATRIBUTOS
	//

	/**
	 *  Referência para o Ctrl do Programa
	 */
	private CtrlPrograma meuControlador;

	/**
	 * Referência para os Ctrls chamados por ele
	 */
	private CtrlIncluirAluno ctrlIncluirAluno;
	private CtrlAlterarAluno ctrlAlterarAluno;
	private CtrlExcluirAluno ctrlExcluirAluno;

	// Atributos de controle da navegação
	private Aluno atual;
	private int posAtual = -1;
	private int numAlunos = 0;

	// Referência para a Janela com quem ele se comunica
	private JanelaConsultarAlunos jAluno;

	//
	// Métodos
	//
	public CtrlConsultarAlunos(CtrlPrograma ctrl) {
		this.meuControlador = ctrl;
		this.jAluno = new JanelaConsultarAlunos(this);
		DaoAluno dao = new DaoAluno();
		if(dao.size() > 0) 
			this.posAtual = 0;
		else 
			this.posAtual = -1;
		this.exibir();
	}

	// Métodos de Exibição e Navegação
	private void exibir() {
		if (posAtual != -1) {
			DaoAluno dao = new DaoAluno();
			this.atual = dao.get(posAtual);
			this.numAlunos = dao.size();
			String cpf = atual.getCpf();
			String matr = Integer.toString(atual. getMatr());
			String nome = atual.getNome();
			String nomeCurso = atual.getMeuCurso().toString();
			jAluno.exibir(cpf, matr, nome, nomeCurso, posAtual+1, numAlunos);
		} else {
			numAlunos = 0;
			atual = null;
			jAluno.exibir("", "", "", "", posAtual+1, numAlunos);
		}
	}

	public void exibirPrimeiro() {
		DaoAluno dao = new DaoAluno();
		if (dao.size() > 0) 
			posAtual = 0;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirUltimo() {
		DaoAluno dao = new DaoAluno();
		if (dao.size() > 0) 
			posAtual = dao.size() - 1;
		else 
			posAtual = -1;
		exibir();
	}

	public void exibirAnterior() {
		DaoAluno dao = new DaoAluno();
		if (dao.size() > 0) {
			if(posAtual > 0) 
				posAtual--;
		}
		else 
			posAtual = -1;
		exibir();

	}

	public void exibirProximo() {
		DaoAluno dao = new DaoAluno();
		if (dao.size() > 0) {
			if(posAtual != dao.size() - 1) 
				posAtual++;
		}
		else
			posAtual = -1;
		exibir();
	}

	// Métodos de chamada e encerramendo das subfuncionalidades
	public void iniciarFuncionalidadeIncluirAluno() {
		if (this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
	}

	public void encerrarFuncionalidadeIncluirAluno() {
		this.ctrlIncluirAluno = null;
		// Se houve inclusão...
		DaoAluno dao = new DaoAluno();
		if(numAlunos < dao.size())
			posAtual = dao.size() - 1;
		exibir();
	}

	public void iniciarFuncionalidadeAlterarAluno() {
		if (this.ctrlAlterarAluno == null)
			this.ctrlAlterarAluno = new CtrlAlterarAluno(this, atual);
	}

	public void encerrarFuncionalidadeAlterarAluno() {
		this.ctrlAlterarAluno = null;
		exibir();
	}

	public void iniciarFuncionalidadeExcluirAluno() {
		if (this.ctrlExcluirAluno == null)
			this.ctrlExcluirAluno = new CtrlExcluirAluno(this, atual);
	}

	public void encerrarFuncionalidadeExcluirAluno() {
		this.ctrlExcluirAluno = null;
		DaoAluno dao = new DaoAluno();
		if(dao.size() > 0)
			posAtual = 0;
		else
			posAtual = -1;
		exibir();
	}
	
	public void encerrarFuncionalidade() {
		this.jAluno.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeConsultarAlunos();
	}
}
