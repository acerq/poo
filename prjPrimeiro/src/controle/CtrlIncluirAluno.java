package controle;

import modelo.Aluno;
import modelo.Curso;
import modelo.DaoAluno;
import modelo.DaoCurso;
import modelo.ModeloException;
import viewer.JanelaAluno;

public class CtrlIncluirAluno {

	private CtrlConsultarAlunos meuControlador;
	private JanelaAluno jAluno;

	public CtrlIncluirAluno(CtrlConsultarAlunos ctrl) {
		this.meuControlador = ctrl;
		DaoCurso daoCurso = new DaoCurso();
		Curso[] cursos = daoCurso.getAll();
		this.jAluno = new JanelaAluno(this, "Incluindo Novo Aluno", cursos);
	}

	public void incluirAluno(String cpf, String nome, int matr, Object curso) throws ModeloException {
		Aluno novo = new Aluno(cpf, nome, matr, (Curso) curso);
		DaoAluno dao = new DaoAluno();
		dao.add(novo);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jAluno.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeIncluirAluno();
	}

}
