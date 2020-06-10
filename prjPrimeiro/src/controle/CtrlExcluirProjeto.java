package controle;

import java.util.Collection;

import modelo.DaoAluno;
import modelo.DaoProjeto;
import modelo.ModeloException;
import modelo.Projeto;
import viewer.JanelaProjeto;

public class CtrlExcluirProjeto {

	private CtrlConsultarProjetos meuControlador;
	private Projeto 			  projeto;
	private JanelaProjeto         jProjeto;
	
	public CtrlExcluirProjeto(CtrlConsultarProjetos ctrl, Projeto projetoParaExclusao) {	
		this.meuControlador = ctrl;
		this.projeto = projetoParaExclusao;
		DaoAluno dao = new DaoAluno();
		this.jProjeto = new JanelaProjeto(this, projeto.getNome(), projeto.getConjAlunos(), dao.getAll(), "Deseja Excluir este Projeto?");
	}
	
	public void excluirProjeto(String nome, Collection alunosDoProjeto) throws ModeloException {
		DaoProjeto dao = new DaoProjeto();
		dao.remove(projeto);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jProjeto.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeExcluirProjeto();
	}
}
