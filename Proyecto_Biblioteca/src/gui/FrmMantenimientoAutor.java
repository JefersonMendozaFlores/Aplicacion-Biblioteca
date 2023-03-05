package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entidad.Autor;
import model.AutorModel;
import util.Conversiones;
import validacion.Validador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmMantenimientoAutor extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboGrado;
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
					FrmMantenimientoAutor frame = new FrmMantenimientoAutor();
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
	public FrmMantenimientoAutor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Autor");
		setBounds(100, 100, 1249, 572);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Autor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1213, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 80, 96, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 121, 96, 31);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(506, 80, 160, 33);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Grado:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Statistics.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(270, 80, 85, 30);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pais:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(270, 121, 85, 31);
		getContentPane().add(lblNewLabel_5);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(116, 84, 138, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(116, 125, 138, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboGrado.setModel(new DefaultComboBoxModel <String>(new String[] {"[Seleccione]", "Autor", "Licenciado", "Dcotorado", "Superior"}));
		cboGrado.setBounds(365, 84, 119, 22);
		getContentPane().add(cboGrado);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel <String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(365, 125, 119, 22);
		getContentPane().add(cboPais);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(1099, 55, 124, 30);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(1099, 96, 124, 35);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoAutor.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(1099, 142, 124, 32);
		getContentPane().add(btnEliminar);
		
		txtFec_nac = new JTextField();
		txtFec_nac.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFec_nac.setBounds(676, 85, 154, 20);
		getContentPane().add(txtFec_nac);
		txtFec_nac.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 1213, 346);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nombres", "Apellidos", "Fecha Nacimiento", "Pais", "Grado"
				}
			));
		
		scrollPane.setViewportView(table);
		
		listar();
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	void limpiarCajasTexto() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtFec_nac.setText("");
		cboPais.setSelectedItem("[Seleccione]");
		cboGrado.setSelectedItem("[Seleccione]");
		
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
	
	private void listar(){
		AutorModel model = new AutorModel();
		List<Autor> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		for (Autor x : lista) {
			fila = new  Object[] { x.getID(), x.getNombres(), x.getApellidos(), x.getFec_nac(), x.getPais(), x.getGrado()};
			dtm.addRow(fila);
		}
	}
	
	private void insertar(){
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String fech = txtFec_nac.getText();
		String paises = cboPais.getSelectedItem().toString();
		String grad = cboGrado.getSelectedItem().toString();
		
		if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es 3 a mas caracteres");
		}else if(!apel.matches(Validador.APELLIDO)){
			mensaje("El nombre es 3 a mas caracteres");
		}else if (!fech.matches(Validador.FECHANAC)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podria ser: 2022-12-31");
		}else {
			 
			Autor obj = new Autor();
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setFec_nac(Conversiones.toFecha(fech));
			obj.setPais(paises);
			obj.setGrado(grad);
			
			AutorModel model = new AutorModel();
			int salida = model.insertaAutor(obj);
			
			if (salida > 0) {
				idSeleccionado = -1;
				listar(); 
				limpiarCajasTexto();
				mensaje("Se registró correctamente. Felicitaciones");
			}else {
				mensaje("No se registró correctamente");
			}	
		}
	}
	
	private void buscar(){
        int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nombre = (String)table.getValueAt(fila, 1);
		String apellido = (String)table.getValueAt(fila, 2);
		Date fecha =  (Date)table.getValueAt(fila, 3);
		String pais = (String)table.getValueAt(fila, 4);
		String grado = (String)table.getValueAt(fila, 5);
		
		System.out.println(idSeleccionado +" - " + nombre + " - " + apellido + " - " + fecha + " - " + pais + " - " + grado);
		
		txtNombres.setText(nombre);
		txtApellidos.setText(apellido);
		txtFec_nac.setText(String.valueOf(fecha));
		cboPais.setSelectedItem(pais);
		cboGrado.setSelectedItem(grado);
	}
	
	private void actualizar(){
		String nom = txtNombres.getText();
		String apel = txtApellidos.getText();
		String fech = txtFec_nac.getText();
		String paises = cboPais.getSelectedItem().toString();
		String grad = cboGrado.getSelectedItem().toString();
		
		if (idSeleccionado == -1){
			mensaje("Seleccione la fila");
		}else if (!nom.matches(Validador.NOMBRE)) {
			mensaje("El nombre es 3 a mas caracteres");
		}else if(!apel.matches(Validador.APELLIDO)){
			mensaje("El apellido es 3 a mas caracteres");
		}else if (!fech.matches(Validador.FECHANAC)) {
			mensaje("La fecha es YYYY-MM-DD /Un ejemplo podría ser: 2022-12-31");
		}else {
			Autor obj = new Autor();
			obj.setID(idSeleccionado);
			obj.setNombres(nom);
			obj.setApellidos(apel);
			obj.setFec_nac(Conversiones.toFecha(fech));
			obj.setPais(paises);
			obj.setGrado(grad);
			
			AutorModel model = new AutorModel();
			int salida = model.actualizaAutor(obj);
			
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se actualizó correctamente, Felicitaciones");
			}else {
				mensaje("Error en la Actualización");
			}	
		}
	}
	
	private void eliminar(){
		if (idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else {
			AutorModel model = new AutorModel();
			int salida = model.eliminaAutor(idSeleccionado);
			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se eliminó correctamente, Felicitaciones");
			}else {
				mensaje("Error en la eliminación");}
	        }
    }
	
}
