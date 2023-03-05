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
import javax.swing.JTextField;
import javax.swing.JComboBox;

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmRegistrosProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JComboBox<String> cboPais;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrosProveedor frame = new FrmRegistrosProveedor();
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
	public FrmRegistrosProveedor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Registro de Proveedor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 436, 419);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Proveedor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 400, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(70, 62, 97, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(70, 103, 97, 27);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(70, 141, 80, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Notes.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(70, 254, 97, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Call.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(70, 178, 97, 30);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Correo:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Open letter.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(70, 219, 97, 24);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pais:");
		lblNewLabel_7.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(70, 287, 80, 30);
		getContentPane().add(lblNewLabel_7);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistrosProveedor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(157, 341, 124, 37);
		getContentPane().add(btnRegistrar);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(177, 67, 166, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(177, 106, 166, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setText("");
		txtDNI.setBounds(177, 144, 166, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDireccion.setBounds(177, 256, 166, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTelefono.setBounds(177, 183, 166, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setBounds(177, 221, 166, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(177, 291, 166, 22);
		getContentPane().add(cboPais);

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
		String ape = txtApellidos.getText();
		String dni = txtDNI.getText();
		String dir = txtDireccion.getText();
		String tel = txtTelefono.getText();
		String cor = txtCorreo.getText();
		String pai = cboPais.getSelectedItem().toString();
		
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres");
		}else if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres");
		}else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI es de 0 a 8 caracteres");
//		}else if (!cor.matches(Validaciones.CORREO_GMAIL)) {
//			mensaje("El correo es de 2 a 20 caracteres");
		}else if (cboPais.getSelectedIndex()==0) {
			mensaje("Selecione el pais");
		}else {
			Proveedor obj = new Proveedor();
			obj.setNombres(nom);
			obj.setApellidos(ape);
			obj.setDni(dni);
			obj.setDireccion(dir);
			obj.setTelefono(tel);
			obj.setCorreo(cor);
			obj.setPais(pai);
			
			ProveedorModel model = new ProveedorModel();
			int salida = model.insertaProveedor(obj);
			if(salida > 0) {
				mensaje("Se inserto correctamente");
			}else {
				mensaje("Error en el registro");
			}
		}
	}
	
}
