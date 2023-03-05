package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import entidad.Alumno;
import model.AlumnoModel;
import util.Conversiones;
import validacion.Validador;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmRegistroAlumno extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtCorreo;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JComboBox<String> cboPais;
	private JButton btnRegistrar;
	private JTextField txtFec_nac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroAlumno frame = new FrmRegistroAlumno();
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
	public FrmRegistroAlumno() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Registro de Alumno");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 517, 435);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Alumno");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 23, 304, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(75, 67, 100, 45);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(75, 112, 100, 33);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(75, 156, 90, 33);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pais:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(75, 239, 90, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Card file.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(75, 200, 90, 28);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(75, 275, 166, 41);
		getContentPane().add(lblNewLabel_6);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(185, 79, 228, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setBounds(185, 202, 228, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(185, 118, 228, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel <String>(new String[] { "[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(185, 240, 228, 22);
		getContentPane().add(cboPais);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setBounds(185, 161, 228, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroAlumno.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(195, 344, 130, 37);
		getContentPane().add(btnRegistrar);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFec_nac.setBounds(251, 288, 162, 20);
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
		String paises = cboPais.getSelectedItem().toString();
		String correo = txtCorreo.getText();
		String fec = txtFec_nac.getText();
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es 3 a mas caracteres");
		}else if(!apel.matches(Validador.APELLIDO)){
			mensaje("El nombre es 3 a mas caracteres");
		} else if (!fec.matches(Validador.FECHANAC)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podria ser: 2000-12-31");
		}else {
			 
			Alumno obj = new Alumno();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setPais(paises);
			obj.setCorreo(correo);
			obj.setFec_Nac(Conversiones.toFecha(fec));
			
			AlumnoModel model = new AlumnoModel();
			int salida = model.insertaAlumno(obj);
			
			if (salida > 0) {
				mensaje("Se registro correctamente. Felicitaciones :)");
			}else {
				mensaje("No se registro correctamente :(");
			}
			
		}
	}
}
