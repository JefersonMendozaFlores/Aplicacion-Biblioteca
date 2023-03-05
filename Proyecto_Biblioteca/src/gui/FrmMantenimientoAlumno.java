package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import model.AlumnoModel;
import util.Conversiones;
import util.Validaciones;
import validacion.Validador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.util.List;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;



public class FrmMantenimientoAlumno extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtCorreo;
	private JTextField txtApellidos;
	private JTextField txtDNI;
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
					FrmMantenimientoAlumno frame = new FrmMantenimientoAlumno();
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
	public FrmMantenimientoAlumno() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Alumno");
		setBounds(100, 100, 1136, 619);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Alumno");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1100, 41);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 75, 97, 32);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 132, 97, 32);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(265, 75, 70, 32);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pais:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(615, 134, 94, 30);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Correo");
		lblNewLabel_5.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Open letter.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(265, 134, 70, 30);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(558, 75, 168, 31);
		getContentPane().add(lblNewLabel_6);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(117, 81, 121, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setBounds(364, 138, 168, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(117, 138, 121, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel <String>(new String[] { "[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(736, 137, 147, 22);
		getContentPane().add(cboPais);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDNI.setBounds(364, 81, 168, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFec_nac.setBounds(736, 81, 147, 20);
		getContentPane().add(txtFec_nac);
		txtFec_nac.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(989, 63, 121, 32);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(989, 115, 121, 32);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoAlumno.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(989, 164, 121, 32);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 1100, 371);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Pais", "Correo", "Fecha de Nacimiento"
			}
		));
		scrollPane.setViewportView(table);
	
		listar();
	}
	
	void mensaje (String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	void limpiarCajasdeTexto(){
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		cboPais.setSelectedItem("=1");
		txtCorreo.setText("");
		txtFec_nac.setText("");	
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
		AlumnoModel model = new AlumnoModel();
		List<Alumno> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		for (Alumno x : lista) {
			fila = new  Object[] { x.getID(), x.getNombres(), x.getApellidos(),x.getDni(), x.getPais(), x.getCorreo(), x.getFec_Nac()};
			dtm.addRow(fila);}
	}
	private void insertar() {
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String dni = txtDNI.getText();
		String pais = cboPais.getSelectedItem().toString();
		String correo = txtCorreo.getText();
		String fech = txtFec_nac.getText();
		
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es 3 a mas caracteres");
		}else if(!apel.matches(Validador.APELLIDO)){
			mensaje("El nombre es 3 a mas caracteres");
		}else if (!dni.matches(Validador.DNI)){
			mensaje("El DNI es de 8 caracteres");
		}else if (cboPais.getSelectedIndex() == 0 ) {
			mensaje("Seleccione un país");
		}else if (!correo.matches(Validador.CORREO_GMAIL)) {
			mensaje("Inserte un correo valido");
		}else if (!fech.matches(Validador.FECHANAC)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podria ser: 2022-12-31");
		}else {
			 
			Alumno obj = new Alumno();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setPais(pais);
			obj.setCorreo(correo);
			obj.setFec_Nac(Conversiones.toFecha(fech));
			
			
			AlumnoModel model = new AlumnoModel();
			int salida = model.insertaAlumno(obj);
			
			if (salida > 0) {
				idSeleccionado = -1;
				listar(); 
				limpiarCajasdeTexto();
				mensaje("Se registró correctamente. Buen trabajo");
			}else {
				mensaje("No se registró correctamente, intenté de nuevo");
			}	
		}
	}
	private void buscar() {
		
		int fila = table.getSelectedRow();

		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nom = (String)table.getValueAt(fila, 1);
		String ape = (String)table.getValueAt(fila, 2);
		String dni = (String)table.getValueAt(fila, 3);
		String pais = (String)table.getValueAt(fila, 4);
		String correo =(String)table.getValueAt(fila, 5);
		Date fech = (Date)table.getValueAt(fila, 6);

		System.out.println(idSeleccionado +" - " + nom + " - "+ ape + " - " + dni + " - " + pais + " - " + correo + " - " + fech);

		txtNombres.setText(nom);
		txtApellidos.setText(ape);	
		txtDNI.setText(dni);
		cboPais.setSelectedItem(pais);
		txtCorreo.setText(correo);
		txtFec_nac.setText(String.valueOf(fech));
				
	}
	private void actualizar() {
		
			
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String dni = txtDNI.getText();
		String pais = cboPais.getSelectedItem().toString();
		String correo = txtCorreo.getText();
		String fech = txtFec_nac.getText();
		
		if(idSeleccionado == -1) {	
			mensaje("Seleccione una fila");
		}else if(!nom.matches(Validaciones.TEXTO)) {	
			mensaje("El Nombre debe ser de 3 a 30 caracteres");
		}else if (!apel.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido debe ser de 3 a 30 caracteres");
		}else if(!dni.matches(Validaciones.DNI)) {
			mensaje("El DNI tiene 8 caracteres");
		}else if(cboPais.getSelectedIndex() == 0 ){
			mensaje("Seleccione un país");
		}else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Ingrese un correo valido");
		}else if (!fech.matches(Validaciones.FECHA)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podria ser: 2022-12-31");
		}	else {

			Alumno obj = new Alumno();
			obj.setID(idSeleccionado);
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setDni(dni);
			obj.setPais(pais);
			obj.setCorreo(correo);
			obj.setFec_Nac(Conversiones.toFecha(fech)); 

		AlumnoModel model = new AlumnoModel();
		int alumno = model.actualizaAlumno(obj);

		if(alumno > 0) {
			listar();
			idSeleccionado = -1;		
			limpiarCajasdeTexto();
			mensaje("Se Registro Correctamente");
		}else {
			mensaje("Esta fallando el sitema");
		}	
	 }
		
		
	}
	private void eliminar() {
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else {
			AlumnoModel model = new AlumnoModel();
			int salida = model.eliminaAlumno(idSeleccionado);
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasdeTexto();
				mensaje("Se elimino Correctamente");
			}else {
				mensaje("Esta fallando el sistema");
			}
		}	
	}

}
