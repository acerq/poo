package controle;

import modelo.Curso;
import modelo.DaoCurso;
import modelo.ModeloException;
import modelo.TipoCurso;
import viewer.JanelaCurso;

public class CtrlExcluirCurso {

	private CtrlConsultarCursos meuControlador;
	private Curso 				curso;
	private JanelaCurso         jCurso;
	
	public CtrlExcluirCurso(CtrlConsultarCursos ctrl, Curso cursoParaExclusao) {	
		this.meuControlador = ctrl;
		this.curso = cursoParaExclusao;
		this.jCurso = new JanelaCurso(this, curso.getCodigo(), curso.getNome(), TipoCurso.values(),  "Deseja Excluir este Curso?");
	}
	
	public void excluirCurso(int codigo, String nome, Object tipo) throws ModeloException {
		DaoCurso dao = new DaoCurso();
		dao.remove(curso);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jCurso.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeExcluirCurso();
	}
	
}
