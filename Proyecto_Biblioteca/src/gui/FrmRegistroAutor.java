package gui;

import java.awt.EventQueue;

import validacion.Validador;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import entidad.Autor;
import model.AutorModel;
import util.Conversiones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmRegistroAutor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboGrado;
	private JButton btnRegistrar;
	private JTextField txtFec_nac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroAutor frame = new FrmRegistroAutor();
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
	public FrmRegistroAutor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		getContentPane().setForeground(new Color(0, 0, 0));
		setTitle("Registro de Autor");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 474, 402);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Autor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 438, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setBounds(66, 63, 80, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setBounds(66, 105, 80, 31);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_3.setBounds(66, 231, 156, 30);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Grado:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Text.gif")));
		lblNewLabel_4.setBounds(66, 148, 80, 30);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pais:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_5.setBounds(66, 189, 80, 31);
		getContentPane().add(lblNewLabel_5);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(173, 68, 195, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(173, 110, 195, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel <String>(new String[] {"[Seleccione]", "Autor", "Licenciado", "Dcotorado", "Superior"}));
		cboGrado.setBounds(170, 152, 198, 22);
		getContentPane().add(cboGrado);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel <String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(170, 194, 198, 22);
		getContentPane().add(cboPais);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroAutor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(163, 306, 113, 38);
		getContentPane().add(btnRegistrar);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setBounds(232, 236, 136, 20);
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
		String fec = txtFec_nac.getText();
		String paises = cboPais.getSelectedItem().toString();
		String grad = cboGrado.getSelectedItem().toString();
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es 3 a mas caracteres");
		}else if(!apel.matches(Validador.APELLIDO)){
			mensaje("El nombre es 3 a mas caracteres");
		} else if (!fec.matches(Validador.FECHANAC)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podria ser: 2000-12-31");
		}else {
			 
			Autor obj = new Autor();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setFec_nac(Conversiones.toFecha(fec));
			obj.setPais(paises);
			obj.setGrado(grad);
			
			AutorModel model = new AutorModel();
			int salida = model.insertaAutor(obj);
			
			if (salida > 0) {
				mensaje("Se registro correctamente. Felicitaciones :)");
			}else {
				mensaje("No se registro correctamente :(");
			}
			
		}
	}
}
