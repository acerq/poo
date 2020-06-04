package controle;

import modelo.DaoPrograma;
import viewer.JanelaConsultarCursos;
import viewer.JanelaPrincipal;

public class CtrlPrograma {

	private JanelaPrincipal jPrincipal; 
	
	private CtrlConsultarCursos ctrlConsultarCursos;
	private CtrlConsultarAlunos ctrlConsultarAlunos;
	
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}

	public CtrlPrograma() {
		DaoPrograma.recuperarObjetos();
		jPrincipal = new JanelaPrincipal(this);
	}
	
	public void iniciarFuncionalidadeConsultarCursos() {		
		if(this.ctrlConsultarCursos == null)
			this.ctrlConsultarCursos = new CtrlConsultarCursos(this);
	}

	public void encerrarFuncionalidadeConsultarCursos() {		
		this.ctrlConsultarCursos = null;
	}

	public void iniciarFuncionalidadeConsultarAlunos() {
		if(this.ctrlConsultarAlunos == null)
			this.ctrlConsultarAlunos = new CtrlConsultarAlunos(this);
	}

	public void encerrarFuncionalidadeConsultarAlunos() {		
		this.ctrlConsultarAlunos = null;
	}

	public void salvarDados() {
		DaoPrograma.salvarObjetos();
	}

	public void encerrarPrograma() {
		System.exit(0);
	}
}

