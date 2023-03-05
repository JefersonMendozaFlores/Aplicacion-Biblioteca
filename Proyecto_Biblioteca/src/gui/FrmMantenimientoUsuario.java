package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Usuario;
import model.UsuarioModel;
import util.Conversiones;
import validacion.Validador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmMantenimientoUsuario extends JInternalFrame implements ActionListener, MouseListener {

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
	private JTable table;
	private JTextField txtFec_nac;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	int idSeleccionado = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoUsuario frame = new FrmMantenimientoUsuario();
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
	public FrmMantenimientoUsuario() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Mantenimiento de Usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1220, 584);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Usuario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1184, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setBounds(10, 61, 100, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setBounds(10, 102, 100, 27);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setBounds(10, 140, 100, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Login:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/User.gif")));
		lblNewLabel_4.setBounds(264, 143, 124, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Key.gif")));
		lblNewLabel_5.setBounds(574, 143, 98, 23);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Open folder.gif")));
		lblNewLabel_1_1.setBounds(264, 61, 124, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Direccion:");
		lblNewLabel_2_1.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Brick house.gif")));
		lblNewLabel_2_1.setBounds(574, 61, 98, 30);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pais:");
		lblNewLabel_3_1.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_3_1.setBounds(574, 106, 98, 23);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_5_1.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_5_1.setBounds(261, 105, 161, 24);
		getContentPane().add(lblNewLabel_5_1);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Add.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(1072, 48, 122, 36);
		getContentPane().add(btnRegistrar);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(682, 104, 161, 22);
		getContentPane().add(cboPais);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(682, 66, 161, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setBounds(416, 66, 148, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setText("");
		txtNombres.setBounds(120, 66, 134, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(120, 105, 134, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(120, 143, 134, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(415, 143, 149, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(682, 143, 161, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Edit.gif")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(1072, 89, 122, 36);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoUsuario.class.getResource("/iconos/Delete.gif")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(1072, 130, 122, 36);
		getContentPane().add(btnEliminar);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setBounds(416, 105, 148, 20);
		getContentPane().add(txtFec_nac);
		txtFec_nac.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 1184, 354);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apelllidos", "DNI", "Login", "Password", "Correo", "Fecha de Nacimiento", "Direccion", "Pais"
			}
		));
		scrollPane.setViewportView(table);
		
		lista();
	}
	
	void limpiarCajasTexto() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtLogin.setText("");
		txtPassword.setText("");
		txtCorreo.setText("");
		txtFec_nac.setText("");
		txtDireccion.setText("");		
		cboPais.setSelectedItem("[Seleccione]");
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		inserta();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualiza();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		elimina();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTableJTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTableJTable(MouseEvent e) {
		busca();
	}
	
	private void lista() {
		UsuarioModel model = new UsuarioModel();
		List<Usuario> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		for (Usuario x : lista) {
			fila = new Object [] {x.getID(),x.getNombres(),x.getApellidos(),x.getDni(),x.getLogin(),x.getPassword(),x.getCorreo(),x.getFec_nac(),x.getDireccion(),x.getPais()};
			dtm.addRow(fila);
		}		
	}
	
	private void inserta() {
		
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String dni = txtDNI.getText();
		String us = txtLogin.getText();
		String pass = txtPassword.getText();
		String correo = txtCorreo.getText();
		String fechaNa = txtFec_nac.getText();
		String direc = txtDireccion.getText();
		String pais = cboPais.getSelectedItem().toString();
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}else if (!apel.matches(Validador.APELLIDO)) {
			mensaje("El Apellido es de 3 a 30 caracteres");
		}else if (!dni.matches(Validador.DNI)) {
			mensaje("Debe contener 8 digitos");
		}else if(!fechaNa.matches(Validador.FECHANAC)) {
			mensaje("La fecha de nacimiento debe contener este formato: 2022-12-31");
		}else {
			Usuario obj = new Usuario();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setLogin(us);
			obj.setPassword(pass);
			obj.setCorreo(correo);
			obj.setFec_nac(Conversiones.toFecha(fechaNa));
			obj.setDireccion(direc);
			obj.setPais(pais);
			
			UsuarioModel model = new UsuarioModel();
			
			int salida = model.insertaUsuario(obj);
			
			if (salida>0 ) {
				lista();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se inserto correctamente");
			}else {
				mensaje("Error en el registro");
			}
			
		}
	}
	
	private void busca() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nombre = (String)table.getValueAt(fila, 1);
		String apellido = (String)table.getValueAt(fila, 2);
		String dni = (String)table.getValueAt(fila,3);
		String usuario = (String)table.getValueAt(fila,4);
		String contrasena = (String)table.getValueAt(fila,5);
		String correo = (String)table.getValueAt(fila,6);
		Date fech = (Date)table.getValueAt(fila, 7);
		String direc = (String)table.getValueAt(fila,8);
		String pais = (String)table.getValueAt(fila,9);
		
		System.out.println(idSeleccionado +"- "+nombre+"- "+apellido+"- "+dni+"- "+usuario+"- "+contrasena+"- "+correo+"- "+fech+"- "+direc+"- "+pais);
		txtNombres.setText(nombre);
		txtApellidos.setText(apellido);
		txtDNI.setText(dni);
		txtLogin.setText(usuario);
		txtPassword.setText(contrasena);
		txtCorreo.setText(correo);
		txtFec_nac.setText(String.valueOf(fech));
		txtDireccion.setText(direc);	
		cboPais.setSelectedItem(pais);
	}
	
	private void elimina() {
		if (idSeleccionado ==-1) {
			mensaje("Selecciona Una Fila");
		} else {
			UsuarioModel model = new UsuarioModel();
			
			int salida = model.eliminaUsuario(idSeleccionado);
			
			if (salida>0 ) {
				lista();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se elimin� correctamente");
			}else {
				mensaje("Error en la eliminaci�n");
			}
		}
		
	}
	
	private void actualiza() {	
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String dni = txtDNI.getText();
		String us = txtLogin.getText();
		String pass = txtPassword.getText();
		String correo = txtCorreo.getText();
		String fechaNa = txtFec_nac.getText();
		String direc = txtDireccion.getText();
		String pais = cboPais.getSelectedItem().toString();
		
		if (idSeleccionado==-1){
			mensaje("Seleccione una fila ");
		}
		
		else if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es de 3 a 30 caracteres");
		}else if (!apel.matches(Validador.APELLIDO)) {
			mensaje("El Apellido es de 3 a 30 caracteres");
		}else if (!dni.matches(Validador.DNI)) {
			mensaje("Debe contener 8 digitos");
		}else if(!fechaNa.matches(Validador.FECHANAC)) {
			mensaje("La fecha de nacimiento debe contener este formato: 2022-12-31");
		}else {
			Usuario obj = new Usuario();
			obj.setID(idSeleccionado);
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setLogin(us);
			obj.setPassword(pass);
			obj.setCorreo(correo);
			obj.setFec_nac(Conversiones.toFecha(fechaNa));
			obj.setDireccion(direc);
			obj.setPais(pais);
			
			UsuarioModel model = new UsuarioModel();
			
			int salida = model.actualizaUsuario(obj);
			
			if (salida>0 ) {
				lista();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se Actualizo Correctamente");
			}else {
				mensaje("�Error en el registro !");
			}
		
		}
	}
	
	
}
