package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.CtrlAlterarCurso;
import controle.CtrlExcluirCurso;
import controle.CtrlIncluirCurso;
import modelo.ModeloException;

public class JanelaCurso extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JLabel lbMensagem;
	private JComboBox cbTipoCurso;

	private CtrlIncluirCurso ctrlIncluir;
	private CtrlAlterarCurso ctrlAlterar;
	private CtrlExcluirCurso ctrlExcluir;

	/**
	 * Create the frame.
	 */
	public JanelaCurso(CtrlIncluirCurso ctrl, Collection tipos, String msg) {
		this(msg, "", "", tipos);
		this.ctrlIncluir = ctrl;
	}

	public JanelaCurso(CtrlAlterarCurso ctrl, int codigo, String nome, Collection tipos, String msg) {
		this(msg, Integer.toString(codigo), nome, tipos);
		this.ctrlAlterar = ctrl;
	}

	public JanelaCurso(CtrlExcluirCurso ctrl, int codigo, String nome, Collection tipos, String msg) {
		this(msg, Integer.toString(codigo), nome, tipos);
		this.ctrlExcluir = ctrl;
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
	}

	/**
	 * @wbp.parser.constructor
	 */
	private JanelaCurso(String msg, String codigo, String nome, Collection tipos) {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo do Curso:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 84, 139, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNomeDoCurso = new JLabel("Nome do Curso:");
		lblNomeDoCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNomeDoCurso.setBounds(31, 126, 139, 20);
		contentPane.add(lblNomeDoCurso);

		tfCodigo = new JTextField(codigo);
		tfCodigo.setBounds(160, 79, 146, 26);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		tfNome = new JTextField(nome);
		tfNome.setBounds(160, 121, 399, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String aux = tfCodigo.getText();
				String nome = tfNome.getText();
				Object tipo = cbTipoCurso.getSelectedItem();
				int codigo;

				try {
					codigo = Integer.parseInt(aux);
				} catch (NumberFormatException excecao) {
					JOptionPane.showMessageDialog(null, "O código passado é inválido: " + aux);
					return;
				}

				try {
					if (ctrlIncluir != null)
						ctrlIncluir.incluirCurso(codigo, nome, tipo);
					else if (ctrlAlterar != null)
						ctrlAlterar.alterarCurso(codigo, nome, tipo);
					else if (ctrlExcluir != null)
						ctrlExcluir.excluirCurso(codigo, nome, tipo);
				} catch (ModeloException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btOk.setBounds(112, 226, 115, 29);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ctrlIncluir != null)
					ctrlIncluir.encerrarFuncionalidade();
				else if (ctrlAlterar != null)
					ctrlAlterar.encerrarFuncionalidade();
				else if (ctrlExcluir != null)
					ctrlExcluir.encerrarFuncionalidade();

			}
		});
		btCancelar.setBounds(374, 226, 115, 29);
		contentPane.add(btCancelar);

		lbMensagem = new JLabel(msg);
		lbMensagem.setFont(new Font("Calibri", Font.BOLD, 26));
		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbMensagem.setBounds(31, 16, 528, 29);
		contentPane.add(lbMensagem);

		JLabel lblTipoDoCurso = new JLabel("Tipo do Curso:");
		lblTipoDoCurso.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblTipoDoCurso.setBounds(31, 173, 139, 20);
		contentPane.add(lblTipoDoCurso);

		cbTipoCurso = new JComboBox(tipos.toArray());
		cbTipoCurso.setBounds(160, 168, 399, 26);
		contentPane.add(cbTipoCurso);

		setVisible(true);
	}
}
