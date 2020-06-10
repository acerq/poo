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

import controle.CtrlConsultarProjetos;
import modelo.Aluno;
import modelo.Projeto;
import modelo.DaoAluno;
import modelo.DaoProjeto;
import modelo.ModeloException;

public class JanelaConsultarProjetos extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JLabel lbNumProjetos;
	private JLabel lbPosicaoAtual; 

	private CtrlConsultarProjetos meuControlador;
	
	/**
	 * Create the frame.
	 */
	public JanelaConsultarProjetos(CtrlConsultarProjetos ctrl) {
		
		this.meuControlador = ctrl;
		
		setTitle("Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto:");
		lblNomeDoProjeto.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNomeDoProjeto.setBounds(45, 116, 139, 20);
		contentPane.add(lblNomeDoProjeto);

		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(174, 111, 399, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				meuControlador.iniciarFuncionalidadeIncluirProjeto();

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
				
				meuControlador.iniciarFuncionalidadeAlterarProjeto();
								
			}
		});
		btAlterar.setBounds(179, 284, 115, 29);
		contentPane.add(btAlterar);
		
		lbNumProjetos = new JLabel("N\u00FAmero de Projetos: 0");
		lbNumProjetos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbNumProjetos.setBounds(354, 16, 160, 20);
		contentPane.add(lbNumProjetos);
		
		lbPosicaoAtual = new JLabel("Posi\u00E7\u00E3o Atual: -1 ");
		lbPosicaoAtual.setFont(new Font("Calibri", Font.PLAIN, 16));
		lbPosicaoAtual.setBounds(354, 37, 160, 20);
		contentPane.add(lbPosicaoAtual);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				meuControlador.iniciarFuncionalidadeExcluirProjeto();
			}
		});
		btExcluir.setBounds(326, 284, 115, 29);
		contentPane.add(btExcluir);
		
		setVisible(true);
	}
	
	public void exibir(String nome, int posAtual, int numProjetos) {
		tfNome.setText(nome);
		lbNumProjetos.setText("N\u00FAmero de Projetos: " + numProjetos);
		lbPosicaoAtual.setText("Posi\u00E7\u00E3o Atual: " + posAtual);		
	}
}
