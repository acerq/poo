package controle;

import modelo.Curso;
import modelo.DaoCurso;
import modelo.ModeloException;
import modelo.TipoCurso;
import viewer.JanelaCurso;

public class CtrlIncluirCurso {

	private CtrlConsultarCursos meuControlador;
	private JanelaCurso         jCurso;
	
	public CtrlIncluirCurso(CtrlConsultarCursos ctrl) {	
		this.meuControlador = ctrl;
		this.jCurso = new JanelaCurso(this, TipoCurso.values(), "Incluindo Novo Curso");
	}
	
	public void incluirCurso(int codigo, String nome, Object tipo) throws ModeloException {
		Curso novo = new Curso(codigo, nome, (TipoCurso)tipo);
		DaoCurso dao = new DaoCurso();
		dao.add(novo);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jCurso.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeIncluirCurso();
	}
	
}
