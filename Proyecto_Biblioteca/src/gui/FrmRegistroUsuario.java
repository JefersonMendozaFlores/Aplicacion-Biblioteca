package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import entidad.Usuario;
import model.UsuarioModel;
import util.Conversiones;
import validacion.Validador;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmRegistroUsuario extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JComboBox<String> cboPais;
	private JTextField txtFec_nac;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroUsuario frame = new FrmRegistroUsuario();
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
	public FrmRegistroUsuario() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Registro de Usuario");
		setBounds(100, 100, 455, 432);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 419, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(40, 58, 127, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(40, 89, 127, 24);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(40, 119, 127, 25);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/User.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(40, 288, 127, 24);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Key.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(40, 316, 127, 24);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Open letter.gif")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(40, 153, 127, 24);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Direccion:");
		lblNewLabel_2_1.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Text.gif")));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(40, 181, 127, 24);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pais:");
		lblNewLabel_3_1.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(40, 210, 127, 24);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_5_1.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(40, 242, 154, 24);
		getContentPane().add(lblNewLabel_5_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroUsuario.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(177, 351, 121, 40);
		getContentPane().add(btnRegistrar);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(209, 213, 156, 22);
		getContentPane().add(cboPais);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDireccion.setBounds(209, 185, 156, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setText("");
		txtCorreo.setBounds(209, 157, 156, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setText("");
		txtNombres.setBounds(209, 62, 156, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(209, 93, 156, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setBounds(209, 121, 156, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLogin.setBounds(209, 292, 156, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setBounds(209, 320, 156, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFec_nac.setBounds(209, 246, 156, 20);
		getContentPane().add(txtFec_nac);
		txtFec_nac.setColumns(10);

	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String dni = txtDNI.getText();
		String login = txtLogin.getText();
		String pass = txtPassword.getText();
		String correo = txtCorreo.getText();
		String fecNac = txtFec_nac.getText();
		String direc = txtDireccion.getText();
		String pais = cboPais.getSelectedItem().toString();
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}else if (!apel.matches(Validador.APELLIDO)) {
			mensaje("El Apellido es de 3 a 30 caracteres");
		}else if (!dni.matches(Validador.DNI)) {
			mensaje("Debe contener 8 digitos");
		}else if(!fecNac.matches(Validador.FECHANAC)) {
			mensaje("La fecha de nacimiento debe contener este formato: 2022-12-31");
		}else {
			Usuario obj = new Usuario();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setLogin(login);
			obj.setPassword(pass);
			obj.setCorreo(correo);
			obj.setFec_nac(Conversiones.toFecha(fecNac));
			obj.setDireccion(direc);
			obj.setPais(pais);
			
			UsuarioModel model = new UsuarioModel();
			int salida = model.insertaUsuario(obj);
			
			if (salida > 0) {
				mensaje("Se inserto correctamente");
			}else {
				mensaje("Error en el registro");
			}
			
		}
	}


}
