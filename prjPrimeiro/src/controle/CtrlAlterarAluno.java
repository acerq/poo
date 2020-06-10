package controle;

import java.util.List;

import modelo.Aluno;
import modelo.Curso;
import modelo.DaoAluno;
import modelo.DaoCurso;
import modelo.ModeloException;
import viewer.JanelaAluno;

public class CtrlAlterarAluno {

	private CtrlConsultarAlunos meuControlador;
	private Aluno aluno;
	private JanelaAluno         jAluno;
	
	public CtrlAlterarAluno(CtrlConsultarAlunos ctrl, Aluno alunoParaAlterar) {	
		this.meuControlador = ctrl;
		this.aluno = alunoParaAlterar;
		DaoCurso daoCurso = new DaoCurso();
		List<Curso> todosCursos = daoCurso.getAll();
		this.jAluno = new JanelaAluno(this, "Alterando Aluno", aluno.getCpf(), aluno.getNome(), aluno.getMatr(), aluno.getMeuCurso(), todosCursos);
	}
	
	public void alterarAluno(String cpf, String nome, int matr, Object selecionado) throws ModeloException {
		this.aluno.setCpf(cpf);
		this.aluno.setMatr(matr);
		this.aluno.setNome(nome);
		this.aluno.setMeuCurso((Curso)selecionado);
		DaoAluno dao = new DaoAluno();
		dao.update(aluno);
		this.encerrarFuncionalidade();
	}

	public void encerrarFuncionalidade() {
		this.jAluno.setVisible(false);
		this.meuControlador.encerrarFuncionalidadeAlterarAluno();
	}
	
}
