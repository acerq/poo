package controle;

import java.util.List;

import modelo.Aluno;
import modelo.Curso;
import modelo.DaoAluno;
import modelo.DaoCurso;
import modelo.ModeloException;
import viewer.JanelaAluno;

public class CtrlExcluirAluno {

	private CtrlConsultarAlunos meuControlador;
	private Aluno 				aluno;
	private JanelaAluno         jAluno;
	
	public CtrlExcluirAluno(CtrlConsultarAlunos ctrl, Aluno alunoParaExclusao) {	
		this.meuControlador = ctrl;
		this.aluno = alunoParaExclusao;
		DaoCurso daoCurso = new DaoCurso();
		List<Curso> todosCursos = daoCurso.getAll();
		this.jAluno = new JanelaAluno(this, "Deseja Excluir este Aluno?", aluno.getCpf(), aluno.getNome(), aluno.getMatr(), aluno.getMeuCurso(), todosCursos);
	}
	
	public void excluirAluno(String cpf, String nome, int matr, Object selecionado) throws ModeloException {
		DaoAluno dao = new DaoAluno();
		dao.remove(aluno);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jAluno.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeExcluirAluno();
	}
	
}
