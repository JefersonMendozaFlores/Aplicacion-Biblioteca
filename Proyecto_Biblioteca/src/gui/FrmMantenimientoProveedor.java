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

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmMantenimientoProveedor extends JInternalFrame implements ActionListener, MouseListener {

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
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private int idSeleccionado = -1;
	
	int hoveredRow = -1, hoveredColumn= -1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoProveedor frame = new FrmMantenimientoProveedor();
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
	public FrmMantenimientoProveedor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Proveedor");
		setBounds(100, 100, 1123, 478);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Proveedor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1087, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 54, 88, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 87, 88, 27);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(254, 54, 100, 23);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Brick house.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(254, 84, 100, 23);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Call.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(510, 54, 115, 23);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Correo:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Documents.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(510, 82, 115, 25);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pais:");
		lblNewLabel_7.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(10, 125, 88, 22);
		getContentPane().add(lblNewLabel_7);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(974, 45, 123, 32);
		getContentPane().add(btnRegistrar);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(108, 56, 136, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(108, 91, 136, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setText("");
		txtDNI.setBounds(364, 54, 136, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDireccion.setBounds(364, 84, 136, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTelefono.setBounds(635, 55, 146, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setBounds(635, 84, 146, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(108, 126, 136, 22);
		getContentPane().add(cboPais);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(974, 89, 123, 32);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(974, 132, 123, 32);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 1087, 262);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Direccion", "Telefono", "Correo", "Pais"
			}
		));
		scrollPane.setViewportView(table);
		
		listar();
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	void limpiarCajasTexto() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboPais.setSelectedItem("[Seleccione]");
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
		insertar();
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) {
		actualizar();
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e) {
		eliminar();
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
		buscar();
	}
	
	private void listar() {
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		for (Proveedor x : lista) {
			fila = new Object[] {x.getID(), x.getNombres(), x.getApellidos(), x.getDni(), x.getDireccion(), x.getTelefono(), x.getCorreo(), (x.getPais())};
			dtm.addRow(fila);
		}
	}
	private void insertar() {
		String nom = txtNombres.getText();
		String ape = txtApellidos.getText();
		String dni = txtDNI.getText();
		String dir = txtDireccion.getText();
		String tel = txtTelefono.getText();
		String cor = txtCorreo.getText();
		String pai = cboPais.getSelectedItem().toString();
		
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 2 a 20 caracteres ");
		}else if (!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 2 a 20 caracteres ");
		}else if (!dni.matches(Validaciones.DNI)) {
			mensaje("El dni es de 8 caracteres");
		}else if(!dir.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje ("La direccion tiene que tener numero y letras ");
		}else if (!tel.matches(Validaciones.TELEFONO)) {
			mensaje("El telefono es de 9 caracteres");
		}else if (!cor.matches(Validaciones.CORREO_GMAIL)) {
			mensaje("El correo debe de tener gmail");
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
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se insertó correctamente");
			}else {
				mensaje("Error en el Registro");
			}
		}
	}
	
	private void buscar() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nombre = (String)table.getValueAt(fila, 1);
		String apellido = (String)table.getValueAt(fila, 2);
		String dni = (String)table.getValueAt(fila, 3);
		String direccion = (String)table.getValueAt(fila, 4);
		String telefono = (String)table.getValueAt(fila, 5);
		String correo = (String)table.getValueAt(fila, 6);
		String pais = (String)table.getValueAt(fila, 7);
		
		System.out.println(idSeleccionado +" - " + nombre + " - "+ apellido + " - " + dni + " - " + direccion + " - " + telefono + " - " + correo + " - " + pais);
		
		txtNombres.setText(nombre);
		txtApellidos.setText(apellido);
		txtDNI.setText(dni);
		txtDireccion.setText(direccion);
		txtTelefono.setText(telefono);
		txtCorreo.setText(correo);
		cboPais.setSelectedItem(pais);
	}
	
	private void eliminar() {
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else {
			ProveedorModel model = new ProveedorModel();
			int salida = model.eliminaProveedor(idSeleccionado);
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se eliminó correctamente");
			}else {
				mensaje("Error en la eliminación");
			}
		}
	}
	
	private void actualizar() {
		String nom = txtNombres.getText();
		String ape = txtApellidos.getText();
		String dni = txtDNI.getText();
		String dir = txtDireccion.getText();
		String tel = txtTelefono.getText();
		String cor = txtCorreo.getText();
		String pai = cboPais.getSelectedItem().toString();
		
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else if(!nom.matches(Validaciones.TEXTO)) {
				mensaje("El nombre es de 2 a 20 caracteres ");
		}else if (!ape.matches(Validaciones.TEXTO)) {
				mensaje("El apellido es de 2 a 20 caracteres ");
		}else if (!dni.matches(Validaciones.DNI)) {
				mensaje("El dni es de 8 caracteres");
		}else if(!dir.matches(Validaciones.TEXTO_NUMERO)) {
				mensaje ("La direccion tiene que tener numero y letras ");
		}else if (!tel.matches(Validaciones.TELEFONO)) {
				mensaje("El telefono es de 9 caracteres");
		}else if (!cor.matches(Validaciones.CORREO_GMAIL)) {
				mensaje("El correo debe de tener gmail");
		}else {
			Proveedor obj = new Proveedor();
			obj.setID(idSeleccionado);
			obj.setNombres(nom);
			obj.setApellidos(ape);
			obj.setDni(dni);
			obj.setDireccion(dir);
			obj.setTelefono(tel);
			obj.setCorreo(cor);
			obj.setPais(pai);
			
			ProveedorModel model = new ProveedorModel();
			int salida = model.actualizaProveedor(obj);
			
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se actualizó correctamente");
			}else {
				mensaje("Error en la actualización");
			}
		}
	}
}
