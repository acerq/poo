package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.CtrlConsultarCursos;
import modelo.Aluno;
import modelo.Curso;
import modelo.DaoAluno;
import modelo.DaoCurso;
import modelo.ModeloException;

public class JanelaConsultarCursos extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JLabel lbNumCursos;
	private JLabel lbPosicaoAtual; 

	private CtrlConsultarCursos meuControlador;
	private JTextField tfTipo;
	
	/**
	 * Create the frame.
	 */
	public JanelaConsultarCursos(CtrlConsultarCursos ctrl) {
		
		this.meuControlador = ctrl;
		
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo do Curso:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(45, 74, 139, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNomeDoCurso = new JLabel("Nome do Curso:");
		lblNomeDoCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNomeDoCurso.setBounds(45, 116, 139, 20);
		contentPane.add(lblNomeDoCurso);

		tfCodigo = new JTextField();
		tfCodigo.setEditable(false);
		tfCodigo.setBounds(174, 69, 146, 26);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(174, 111, 399, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				meuControlador.iniciarFuncionalidadeIncluirCurso();

				}
		});
		btIncluir.setBounds(32, 284, 115, 29);
		contentPane.add(btIncluir);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.encerrarFuncionalidade();
			}
		});
		btSair.setBounds(473, 284, 115, 29);
		contentPane.add(btSair);
		
		JButton btPrimeiro = new JButton("Primeiro");
		btPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.exibirPrimeiro();
				
			}
		});
		btPrimeiro.setBounds(32, 226, 115, 29);
		contentPane.add(btPrimeiro);
		
		JButton btUltimo = new JButton("\u00DAltimo");
		btUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.exibirUltimo();
				
			}
		});
		btUltimo.setBounds(473, 226, 115, 29);
		contentPane.add(btUltimo);
		
		JButton btAnterior = new JButton("Anterior");
		btAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				meuControlador.exibirAnterior();
			}
		});
		btAnterior.setBounds(179, 226, 115, 29);
		contentPane.add(btAnterior);
		
		JButton btProximo = new JButton("Pr\u00F3ximo");
		btProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				meuControlador.exibirProximo();
				
			}
		});
		btProximo.setBounds(326, 226, 115, 29);
		contentPane.add(btProximo);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.iniciarFuncionalidadeAlterarCurso();
								
			}
		});
		btAlterar.setBounds(179, 284, 115, 29);
		contentPane.add(btAlterar);
		
		lbNumCursos = new JLabel("N\u00FAmero de Cursos: 0");
		lbNumCursos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbNumCursos.setBounds(354, 16, 160, 20);
		contentPane.add(lbNumCursos);
		
		lbPosicaoAtual = new JLabel("Posi\u00E7\u00E3o Atual: -1 ");
		lbPosicaoAtual.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbPosicaoAtual.setBounds(354, 37, 160, 20);
		contentPane.add(lbPosicaoAtual);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.iniciarFuncionalidadeExcluirCurso();
			}
		});
		btExcluir.setBounds(326, 284, 115, 29);
		contentPane.add(btExcluir);
		
		JLabel lblTipoDoCurso = new JLabel("Tipo do Curso:");
		lblTipoDoCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTipoDoCurso.setBounds(45, 169, 139, 20);
		contentPane.add(lblTipoDoCurso);
		
		tfTipo = new JTextField();
		tfTipo.setEditable(false);
		tfTipo.setColumns(10);
		tfTipo.setBounds(174, 164, 399, 26);
		contentPane.add(tfTipo);
		
		setVisible(true);
	}
	
	public void exibir(String codigo, String nome, String tipo, int posAtual, int numCursos) {
		tfCodigo.setText(codigo);
		tfNome.setText(nome);
		tfTipo.setText(tipo.toString());
		lbNumCursos.setText("N\u00FAmero de Cursos: " + numCursos);
		lbPosicaoAtual.setText("Posi\u00E7\u00E3o Atual: " + posAtual);		
	}
}
