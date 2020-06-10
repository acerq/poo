package controle;

import java.util.Collection;

import modelo.Aluno;
import modelo.DaoAluno;
import modelo.DaoProjeto;
import modelo.ModeloException;
import modelo.Projeto;
import viewer.JanelaProjeto;

public class CtrlAlterarProjeto {

	private CtrlConsultarProjetos meuControlador;
	private Projeto               projeto;
	private JanelaProjeto         jProjeto;
	
	public CtrlAlterarProjeto(CtrlConsultarProjetos ctrl, Projeto projetoParaAlterar) {	
		this.meuControlador = ctrl;
		this.projeto = projetoParaAlterar;
		DaoAluno dao = new DaoAluno();
		this.jProjeto = new JanelaProjeto(this, projeto.getNome(), projeto.getConjAlunos(), dao.getAll(), "Alterar Projeto");
	}
	
	public void alterarProjeto(String nome, Collection alunosSelecionados) throws ModeloException {
		this.projeto.setNome(nome);
		// Retiro todos os alunos que estavam no projeto
		for(Aluno a : projeto.getConjAlunos())
			a.removeProjeto(projeto);
		// Reinsiro os alunos que foram indicados 
		for(Object aluno : alunosSelecionados)
			projeto.addAluno((Aluno)aluno);
		DaoProjeto dao = new DaoProjeto();
		dao.update(projeto);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jProjeto.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeAlterarProjeto();
	}
}
