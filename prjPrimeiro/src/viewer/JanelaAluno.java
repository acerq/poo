package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.CtrlAlterarAluno;
import controle.CtrlExcluirAluno;
import controle.CtrlIncluirAluno;
import modelo.Aluno;
import modelo.DaoAluno;
import modelo.ModeloException;
import javax.swing.SwingConstants;

public class JanelaAluno extends JFrame {
	// Declaração de uma constante

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfMatr;
	private JComboBox cbCurso;

	private JLabel lbMensagem;

	private CtrlIncluirAluno ctrlIncluir;
	private CtrlAlterarAluno ctrlAlterar;
	private CtrlExcluirAluno ctrlExcluir;
	
	/**
	 * Create the frame.
	 */
	public JanelaAluno(CtrlIncluirAluno ctrl, String msg, Object[] cursos) {
		this(msg, "", "", "", null, cursos);
		this.ctrlIncluir = ctrl;
	}
	
	public JanelaAluno(CtrlAlterarAluno ctrl, String msg, String cpf, String nome, int matr, Object selecionado, Object[] cursos) {
		this(msg, cpf, nome, Integer.toString(matr), selecionado, cursos);
		this.ctrlAlterar = ctrl;
	}
	
	public JanelaAluno(CtrlExcluirAluno ctrl, String msg, String cpf, String nome, int matr, Object selecionado, Object[] cursos) {
		this(msg, cpf, nome, Integer.toString(matr), selecionado, cursos);
		this.ctrlExcluir = ctrl;
		tfCpf.setEditable(false);
		tfNome.setEditable(false);
		tfMatr.setEditable(false);
		cbCurso.setEditable(false);
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public JanelaAluno(String msg, String cpf, String nome, String matr, Object selecionado, Object[] cursos) {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbMensagem = new JLabel(msg);
		lbMensagem.setFont(new Font("Calibri", Font.BOLD, 24));
		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbMensagem.setBounds(26, 16, 383, 20);
		contentPane.add(lbMensagem);

		JLabel lblNewLabel = new JLabel("CPF: ");
		lblNewLabel.setBounds(26, 63, 69, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome: ");
		lblNewLabel_1.setBounds(26, 170, 69, 20);
		contentPane.add(lblNewLabel_1);

		tfCpf = new JTextField(cpf);
		tfCpf.setBounds(94, 60, 231, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);

		tfNome = new JTextField(nome);
		tfNome.setBounds(94, 167, 297, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String cpf = tfCpf.getText();
				String aux = tfMatr.getText();
				String nome = tfNome.getText();
				Object selecionado = cbCurso.getSelectedItem();
				int matr;

				try {
					matr = Integer.parseInt(aux);
				} catch (NumberFormatException excecao) {
					JOptionPane.showMessageDialog(null, "A matrícula passada é inválida: " + aux);
					return;
				}

				try {
					if (ctrlIncluir != null)
						ctrlIncluir.incluirAluno(cpf, nome, matr, selecionado);
					else if (ctrlAlterar != null)
						ctrlAlterar.alterarAluno(cpf, nome, matr, selecionado);
					else if (ctrlExcluir != null)
						ctrlExcluir.excluirAluno(cpf, nome, matr, selecionado);
				} catch (ModeloException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}


			}

		});
		btOk.setFont(new Font("Calibri", Font.PLAIN, 16));
		btOk.setBounds(65, 279, 115, 29);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
		btCancelar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btCancelar.setBounds(245, 279, 115, 29);
		contentPane.add(btCancelar);

		JLabel lblMatrcula = new JLabel("Matr:");
		lblMatrcula.setBounds(26, 115, 69, 20);
		contentPane.add(lblMatrcula);

		tfMatr = new JTextField(matr);
		tfMatr.setColumns(10);
		tfMatr.setBounds(94, 112, 231, 26);
		contentPane.add(tfMatr);
		
		cbCurso = new JComboBox(cursos);
		cbCurso.setBounds(94, 218, 297, 26);
		contentPane.add(cbCurso);
		cbCurso.setSelectedItem(selecionado);
		
		JLabel lblNewLabel_2 = new JLabel("Curso:");
		lblNewLabel_2.setBounds(26, 221, 69, 20);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
	}
}
