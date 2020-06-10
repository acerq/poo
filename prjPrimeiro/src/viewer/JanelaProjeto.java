package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.CtrlAlterarProjeto;
import controle.CtrlExcluirProjeto;
import controle.CtrlIncluirProjeto;
import modelo.ModeloException;

public class JanelaProjeto extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JLabel lbMensagem;
	private JList lstAlunos;

	private CtrlIncluirProjeto ctrlIncluir;
	private CtrlAlterarProjeto ctrlAlterar;
	private CtrlExcluirProjeto ctrlExcluir;

	/**
	 * Create the frame.
	 */
	public JanelaProjeto(CtrlIncluirProjeto ctrl, Collection todosAlunos, String msg) {
		this(msg, todosAlunos, "", null);
		this.ctrlIncluir = ctrl;
	}

	public JanelaProjeto(CtrlAlterarProjeto ctrl, String nome, Collection alunosDoProjeto, Collection todosAlunos, String msg) {
		this(msg, todosAlunos, nome, alunosDoProjeto);
		this.ctrlAlterar = ctrl;
	}

	public JanelaProjeto(CtrlExcluirProjeto ctrl, String nome, Collection alunosDoProjeto, Collection todosAlunos, String msg) {
		this(msg, todosAlunos, nome, alunosDoProjeto);
		this.ctrlExcluir = ctrl;
		tfNome.setEditable(false);
	}

	/**
	 * @wbp.parser.constructor
	 */
	private JanelaProjeto(String msg, Collection<Object> todosAlunos, String nome, Collection<Object> alunosDoProjeto) {
		setTitle("Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeDoProjeto = new JLabel("Nome do Projeto:");
		lblNomeDoProjeto.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNomeDoProjeto.setBounds(41, 66, 139, 20);
		contentPane.add(lblNomeDoProjeto);

		tfNome = new JTextField(nome);
		tfNome.setBounds(170, 61, 399, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = tfNome.getText();
				Collection alunosSelecionados = lstAlunos.getSelectedValuesList();
				
				try {
					if (ctrlIncluir != null)
						ctrlIncluir.incluirProjeto(nome, alunosSelecionados);
					else if (ctrlAlterar != null)
						ctrlAlterar.alterarProjeto(nome, alunosSelecionados);
					else if (ctrlExcluir != null)
						ctrlExcluir.excluirProjeto(nome, alunosSelecionados);
				} catch (ModeloException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btOk.setBounds(106, 273, 115, 29);
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
		btCancelar.setBounds(391, 273, 115, 29);
		contentPane.add(btCancelar);

		lbMensagem = new JLabel(msg);
		lbMensagem.setFont(new Font("Calibri", Font.BOLD, 26));
		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lbMensagem.setBounds(31, 16, 528, 29);
		contentPane.add(lbMensagem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 118, 536, 127);
		contentPane.add(scrollPane);
		
		// Adicionando os Alunos no JList. Não esquecer da declaração do JList como atributo da classe 
		lstAlunos = new JList();
		lstAlunos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(lstAlunos);
		DefaultListModel dlm = new DefaultListModel();
		int[] indicesSelecionados = new int[alunosDoProjeto.size()];
		int i = 0;
		int pos = 0;
		for(Object aluno : todosAlunos) {
			dlm.addElement(aluno);
			// Se o aluno pertence ao projeto, coloco no array de índices a serem marcados no JList
			if(alunosDoProjeto.contains(aluno))
				indicesSelecionados[pos++] = i;
			i++;
		}
		lstAlunos.setModel(dlm);
		lstAlunos.setSelectedIndices(indicesSelecionados);
		setVisible(true);
	}
}
