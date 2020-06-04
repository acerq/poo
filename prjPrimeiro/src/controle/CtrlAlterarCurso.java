package controle;

import modelo.Curso;
import modelo.DaoCurso;
import modelo.ModeloException;
import modelo.TipoCurso;
import viewer.JanelaCurso;

public class CtrlAlterarCurso {

	private CtrlConsultarCursos meuControlador;
	private Curso curso;
	private JanelaCurso         jCurso;
	
	public CtrlAlterarCurso(CtrlConsultarCursos ctrl, Curso cursoParaAlterar) {	
		this.meuControlador = ctrl;
		this.curso = cursoParaAlterar;
		this.jCurso = new JanelaCurso(this, curso.getCodigo(), curso.getNome(), TipoCurso.values(), "Alterar Curso");
	}
	
	public void alterarCurso(int codigo, String nome, Object tipo) throws ModeloException {
		this.curso.setCodigo(codigo);
		this.curso.setNome(nome);
		this.curso.setTipo((TipoCurso)tipo);
		DaoCurso dao = new DaoCurso();
		dao.update(curso);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jCurso.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeAlterarCurso();
	}
	
}
