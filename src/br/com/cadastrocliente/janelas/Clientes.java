package br.com.cadastrocliente.janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.com.cadastrocliente.banco.DAO;
import br.com.cadastrocliente.dominio.Estado;
import br.com.cadastrocliente.enums.Sexo;
import br.com.cadastrocliente.enums.Status;
import br.com.cadastrocliente.enums.TiposLogradouro;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtMae;
	private JTextField txtPai;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField textField_5;
	private JTextField txtCep;
	private JTextField txtPontoDeReferencia;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientes() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setBounds(21, 11, 177, 14);
		lblDadosPessoais.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDadosPessoais.setBackground(Color.WHITE);
		contentPane.add(lblDadosPessoais);
		
		JPanel pnlDadosPessoais = new JPanel();
		pnlDadosPessoais.setBounds(10, 36, 707, 159);
		pnlDadosPessoais.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(pnlDadosPessoais);
		pnlDadosPessoais.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do cliente:");
		lblNome.setBounds(10, 11, 122, 14);
		pnlDadosPessoais.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 27, 349, 20);
		pnlDadosPessoais.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(369, 11, 48, 14);
		pnlDadosPessoais.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(538, 11, 48, 14);
		pnlDadosPessoais.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(538, 27, 159, 20);
		pnlDadosPessoais.add(txtRg);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 58, 48, 14);
		pnlDadosPessoais.add(lblSexo);
		
		JComboBox comboSexo = new JComboBox();
		
		//COMBOBOX
		for(Object x : Sexo.values()) {
			comboSexo.addItem(x);
		}
		comboSexo.setBounds(10, 75, 180, 22);
		pnlDadosPessoais.add(comboSexo);
		
		JLabel lblMae = new JLabel("Nome da M\u00E3e:");
		lblMae.setBounds(10, 108, 96, 14);
		pnlDadosPessoais.add(lblMae);
		
		txtMae = new JTextField();
		txtMae.setBounds(10, 128, 349, 20);
		pnlDadosPessoais.add(txtMae);
		txtMae.setColumns(10);
		
		txtPai = new JTextField();
		txtPai.setColumns(10);
		txtPai.setBounds(369, 128, 328, 20);
		pnlDadosPessoais.add(txtPai);
		
		JLabel lblPai = new JLabel("Nome do Pai:");
		lblPai.setBounds(369, 108, 96, 14);
		pnlDadosPessoais.add(lblPai);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(200, 58, 136, 14);
		pnlDadosPessoais.add(lblDataDeNascimento);
		
		//Ponto e traço data
		MaskFormatter dataNasc=null;
		try {
			dataNasc= new MaskFormatter("##/##/####");
		} catch (Exception e) {e.printStackTrace();}
		
		JFormattedTextField txtData = new JFormattedTextField(dataNasc);
		txtData.setBounds(200, 76, 159, 20);
		pnlDadosPessoais.add(txtData);
		
		//Ponto e traço data
		MaskFormatter cpf=null;
		try {
				cpf= new MaskFormatter("###.###.###-##");
		} catch (Exception e) {e.printStackTrace();}
		
		
		JFormattedTextField txtCpf = new JFormattedTextField(cpf);
		txtCpf.setBounds(369, 27, 159, 20);
		pnlDadosPessoais.add(txtCpf);
		
		JPanel pnlContatos = new JPanel();
		pnlContatos.setBounds(10, 231, 707, 57);
		pnlContatos.setLayout(null);
		pnlContatos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(pnlContatos);
		
		JLabel lblTelefone = new JLabel("Telefone fixo: ");
		lblTelefone.setBounds(10, 11, 89, 14);
		pnlContatos.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(380, 27, 317, 20);
		pnlContatos.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 27, 175, 20);
		pnlContatos.add(textField_1);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(195, 11, 56, 14);
		pnlContatos.add(lblCelular);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(380, 11, 48, 14);
		pnlContatos.add(lblEmail);
		
		
		JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(10, 27, 175, 19);
		pnlContatos.add(txtTelefone);
		
		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setBounds(21, 206, 177, 14);
		lblContatos.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblContatos.setBackground(Color.WHITE);
		contentPane.add(lblContatos);
		
		JPanel pnlEndereco = new JPanel();
		pnlEndereco.setBounds(10, 324, 707, 153);
		pnlEndereco.setLayout(null);
		pnlEndereco.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(pnlEndereco);
		
		JLabel lblTipoDeLogradouro = new JLabel("Tipo de Logradouro:");
		lblTipoDeLogradouro.setBounds(10, 11, 124, 14);
		pnlEndereco.add(lblTipoDeLogradouro);
		
		JComboBox comboLogradouro = new JComboBox();
		//ComboBOX
		for(Object t: TiposLogradouro.values()) {
			comboLogradouro.addItem(t);
		}
		
		comboLogradouro.setBounds(10, 29, 165, 22);
		pnlEndereco.add(comboLogradouro);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(185, 11, 91, 14);
		pnlEndereco.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(185, 30, 226, 20);
		pnlEndereco.add(txtLogradouro);
		txtLogradouro.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(421, 11, 54, 14);
		pnlEndereco.add(lblNumero);
		
		JLabel label = new JLabel("");
		label.setBounds(459, 118, 48, 14);
		pnlEndereco.add(label);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(421, 30, 134, 20);
		pnlEndereco.add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(565, 30, 134, 20);
		pnlEndereco.add(txtComplemento);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(565, 11, 99, 14);
		pnlEndereco.add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 62, 48, 14);
		pnlEndereco.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(10, 77, 302, 20);
		pnlEndereco.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(322, 62, 48, 14);
		pnlEndereco.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(485, 77, 214, 20);
		pnlEndereco.add(textField_5);
		
		//Estados
		DAO dao = new DAO();
		//Pega os dados do MySQL
		JComboBox comboEstado = new JComboBox();
		
		for(Estado e : dao.todos()) {
			comboEstado.addItem(e.getNome());
			
		}
		comboEstado.setBounds(322, 76, 153, 22);
		pnlEndereco.add(comboEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(485, 62, 48, 14);
		pnlEndereco.add(lblCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 108, 48, 14);
		pnlEndereco.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(10, 124, 140, 20);
		pnlEndereco.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblPontoDeReferencia = new JLabel("Ponto de refer\u00EAncia:");
		lblPontoDeReferencia.setBounds(160, 108, 140, 14);
		pnlEndereco.add(lblPontoDeReferencia);
		
		txtPontoDeReferencia = new JTextField();
		txtPontoDeReferencia.setBounds(160, 124, 539, 20);
		pnlEndereco.add(txtPontoDeReferencia);
		txtPontoDeReferencia.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(21, 299, 177, 14);
		lblEndereco.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEndereco.setBackground(Color.WHITE);
		contentPane.add(lblEndereco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 596, 702, 106);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setBounds(21, 488, 177, 14);
		lblOutros.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblOutros.setBackground(Color.WHITE);
		contentPane.add(lblOutros);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 508, 707, 52);
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		
		JLabel lblPginaDeInternet = new JLabel("P\u00E1gina de Internet:");
		lblPginaDeInternet.setBounds(10, 11, 122, 14);
		panel.add(lblPginaDeInternet);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 27, 415, 20);
		panel.add(textField_3);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(435, 11, 56, 14);
		panel.add(lblStatus);
		
		JLabel lblDataCadastro = new JLabel("Data Cadastro:");
		lblDataCadastro.setBounds(576, 11, 105, 14);
		panel.add(lblDataCadastro);
		
		JComboBox comboStatus = new JComboBox();
		
		//ComboBOX
		for(Object s: Status.values()) {
			comboStatus.addItem(s);
		}
		
		comboStatus.setBounds(435, 26, 130, 22);
		panel.add(comboStatus);
		
		//Ponto e traço data
		MaskFormatter dataCad=null;
		try {
				dataCad= new MaskFormatter("##/##/####");
		} catch (Exception e) {e.printStackTrace();}
		
		JFormattedTextField txtDataCadastro = new JFormattedTextField(dataCad);
		txtDataCadastro.setBounds(576, 27, 121, 20);
		panel.add(txtDataCadastro);
		
		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setBounds(21, 571, 177, 14);
		lblObservao.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblObservao.setBackground(Color.WHITE);
		contentPane.add(lblObservao);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarCliente.setBounds(10, 704, 702, 23);
		contentPane.add(btnCadastrarCliente);
	}
}
