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

import controle.CtrlConsultarAlunos;
import modelo.Aluno;
import modelo.Aluno;
import modelo.DaoAluno;
import modelo.DaoAluno;
import modelo.ModeloException;
import javax.swing.JComboBox;

public class JanelaConsultarAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JLabel lbNumAlunos;
	private JLabel lbPosicaoAtual; 

	private CtrlConsultarAlunos meuControlador;
	private JTextField tfMatr;
	private JTextField tfCurso;
	
	/**
	 * Create the frame.
	 */
	public JanelaConsultarAlunos(CtrlConsultarAlunos ctrl) {
		
		this.meuControlador = ctrl;
		
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoAluno = new JLabel("Nome:");
		lblNomeDoAluno.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNomeDoAluno.setBounds(40, 133, 81, 20);
		contentPane.add(lblNomeDoAluno);

		tfCpf = new JTextField();
		tfCpf.setEditable(false);
		tfCpf.setBounds(111, 54, 207, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);

		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(111, 128, 399, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				meuControlador.iniciarFuncionalidadeIncluirAluno();

				}
		});
		btIncluir.setBounds(32, 271, 115, 29);
		contentPane.add(btIncluir);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.encerrarFuncionalidade();
			}
		});
		btSair.setBounds(473, 271, 115, 29);
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
				
				meuControlador.iniciarFuncionalidadeAlterarAluno();
								
			}
		});
		btAlterar.setBounds(179, 271, 115, 29);
		contentPane.add(btAlterar);
		
		lbNumAlunos = new JLabel("N\u00FAmero de Alunos: 0");
		lbNumAlunos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbNumAlunos.setBounds(428, 39, 160, 20);
		contentPane.add(lbNumAlunos);
		
		lbPosicaoAtual = new JLabel("Posi\u00E7\u00E3o Atual: -1 ");
		lbPosicaoAtual.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbPosicaoAtual.setBounds(428, 60, 160, 20);
		contentPane.add(lbPosicaoAtual);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.iniciarFuncionalidadeExcluirAluno();
			}
		});
		btExcluir.setBounds(326, 271, 115, 29);
		contentPane.add(btExcluir);
		
		JLabel lblNome = new JLabel("Matr:");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNome.setBounds(40, 96, 81, 20);
		contentPane.add(lblNome);
		
		tfMatr = new JTextField();
		tfMatr.setEditable(false);
		tfMatr.setColumns(10);
		tfMatr.setBounds(111, 91, 207, 26);
		contentPane.add(tfMatr);
		
		JLabel lbCurso = new JLabel("Curso:");
		lbCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbCurso.setBounds(40, 170, 81, 20);
		contentPane.add(lbCurso);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(40, 59, 81, 20);
		contentPane.add(lblNewLabel);
		
		tfCurso = new JTextField();
		tfCurso.setEditable(false);
		tfCurso.setBounds(111, 165, 399, 26);
		contentPane.add(tfCurso);
		tfCurso.setColumns(10);
		
		setVisible(true);
	}
	
	public void exibir(String cpf, String matr, String nome, String nomeCurso, int posAtual, int numAlunos) {
		tfCpf.setText(cpf);
		tfMatr.setText(matr);
		tfNome.setText(nome);
		tfCurso.setText(nomeCurso);
		lbNumAlunos.setText("N\u00FAmero de Alunos: " + numAlunos);
		lbPosicaoAtual.setText("Posi\u00E7\u00E3o Atual: " + posAtual);		
	}
}
