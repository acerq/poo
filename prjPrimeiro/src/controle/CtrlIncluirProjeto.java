package controle;

import java.util.Collection;

import modelo.Aluno;
import modelo.DaoAluno;
import modelo.DaoProjeto;
import modelo.ModeloException;
import modelo.Projeto;
import viewer.JanelaProjeto;

public class CtrlIncluirProjeto {

	private CtrlConsultarProjetos meuControlador;
	private JanelaProjeto         jProjeto;
	
	public CtrlIncluirProjeto(CtrlConsultarProjetos ctrl) {	
		this.meuControlador = ctrl;
		DaoAluno dao = new DaoAluno();
		this.jProjeto = new JanelaProjeto(this, dao.getAll(), "Incluindo Novo Projeto");
	}
	
	public void incluirProjeto(String nome, Collection alunosSelecionados) throws ModeloException {
		Projeto novo = new Projeto(nome);
		for(Object aluno : alunosSelecionados)
			novo.addAluno((Aluno)aluno);
		DaoProjeto dao = new DaoProjeto();
		dao.add(novo);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jProjeto.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeIncluirProjeto();
	}
}
