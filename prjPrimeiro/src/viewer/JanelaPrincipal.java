package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CtrlPrograma;
import modelo.DaoAluno;
import modelo.DaoCurso;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private CtrlPrograma meuControlador;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma ctrl) {

		this.meuControlador = ctrl;

		setTitle("Sistema de Cursos e Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btCurso = new JButton("Consultar Cursos");
		btCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ctrl.iniciarFuncionalidadeConsultarCursos();

			}
		});
		btCurso.setBounds(93, 34, 243, 29);
		contentPane.add(btCurso);

		JButton btAluno = new JButton("Consultar Alunos");
		btAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ctrl.iniciarFuncionalidadeConsultarAlunos();

			}
		});
		btAluno.setBounds(93, 97, 243, 29);
		contentPane.add(btAluno);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ctrl.salvarDados();

			}
		});
		btSalvar.setBounds(93, 160, 243, 29);
		contentPane.add(btSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ctrl.encerrarPrograma();
				
			}
		});
		btnSair.setBounds(93, 223, 243, 29);
		contentPane.add(btnSair);

		setVisible(true);
	}
}
