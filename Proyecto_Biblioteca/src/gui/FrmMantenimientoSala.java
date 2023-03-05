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

import entidad.Sala;
import model.SalaModel;
import util.Validaciones;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmMantenimientoSala extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JTextField txtRecursos;
	private JButton btnRegistrar;
	private JComboBox<String> cboSede;
	private JTable table;
	private JTextField txtPiso;
	private JTextField txtNumAlu;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JCheckBox chkEstado;
	
	private int idSeleccionado = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoSala frame = new FrmMantenimientoSala();
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
	public FrmMantenimientoSala() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Mantenimiento de Sala");
		setBounds(100, 100, 1220, 521);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Sala");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1184, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 56, 195, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Piso:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Diagram.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 92, 195, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de alumnos:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Card file.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 128, 195, 27);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Recursos:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Box.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(348, 56, 107, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Sede:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(348, 92, 107, 22);
		getContentPane().add(lblNewLabel_6);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumero.setBounds(215, 61, 123, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtRecursos = new JTextField();
		txtRecursos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRecursos.setBounds(465, 59, 162, 20);
		getContentPane().add(txtRecursos);
		txtRecursos.setColumns(10);
		
		cboSede = new JComboBox<String>();
		cboSede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboSede.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Independencia", "Breña", "Mira Flores", "Bella Vista", "Chorrillos", "Los Olivos"}));
		cboSede.setBounds(465, 94, 162, 22);
		getContentPane().add(cboSede);
		
		txtPiso = new JTextField();
		txtPiso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPiso.setBounds(215, 97, 123, 20);
		getContentPane().add(txtPiso);
		txtPiso.setColumns(10);
		
		txtNumAlu = new JTextField();
		txtNumAlu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumAlu.setText("");
		txtNumAlu.setBounds(215, 138, 123, 20);
		getContentPane().add(txtNumAlu);
		txtNumAlu.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estado:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Task list.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(348, 133, 107, 25);
		getContentPane().add(lblNewLabel_5);
		
		chkEstado = new JCheckBox("ESTADO");
		chkEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chkEstado.setHorizontalAlignment(SwingConstants.CENTER);
		chkEstado.setBounds(465, 135, 162, 23);
		getContentPane().add(chkEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(1077, 56, 117, 31);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(1077, 93, 117, 34);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(1077, 133, 117, 31);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 1184, 291);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Numero", "Piso", "Numero de Alumnos", "Recursos", "Estado", "Sede"
			}
		));
		scrollPane.setViewportView(table);
		
		lista();
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	void limpiarCajasTexto() {
		txtNumero.setText("");
		txtPiso.setText("");
		txtNumAlu.setText("");
		txtRecursos.setText("");
		cboSede.setSelectedItem("[Seleccione]");
		
		//txtNumero.requestFocus();
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
	
	private void lista() {
		SalaModel model = new SalaModel();
		List<Sala> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		
		for (Sala x : lista) {
			fila = new Object[]{ x.getID(), x.getNumero(), x.getPiso(), x.getNumAlumnos(),x.getRecursos(), getFormatEstado(x.getEstado()), x.getSede()};
			dtm.addRow(fila);
		}
	}
	private void insertar() {
		String sal = txtNumero.getText();
		String pis = txtPiso.getText();
		String nua = txtNumAlu.getText();
		String rec = txtRecursos.getText();
		boolean estado = chkEstado.isSelected();
		String sed = cboSede.getSelectedItem().toString();
		
		if(!sal.matches(Validaciones.TEXTO_NUMERO)) {	
			mensaje("El Número de sala debe ser de 1 a 3 caracteres");
		}else if(!nua.matches(Validaciones.ALUMNOS)) {
			mensaje("El Número alumnos debe de ser de 2 a 90 caracteres");
		}else if(!rec.matches(Validaciones.TEXTO)) {
			mensaje("El curso es de 2 a 15 caracteres");
		}else if (cboSede.getSelectedIndex() == 0 ) {
			mensaje("Seleccione una sede");
		}else {			
			Sala obj = new Sala();
			obj.setNumero(sal);
			obj.setPiso(pis);
			obj.setNumAlumnos(nua);
			obj.setRecursos(rec);
			obj.setEstado(getIntegerEstado(estado)); 
			obj.setSede(sed);	
			
		SalaModel model = new SalaModel();
		int salida = model.insertaSala(obj);
		
		if(salida > 0) {
			idSeleccionado = -1;
			lista();
			limpiarCajasTexto();
			mensaje("Se registró correctamente");
		}else {
			mensaje("Esta fallando");
			}	
		}
	}
	private void buscar() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String numero = (String)table.getValueAt(fila, 1);
		String piso = (String)table.getValueAt(fila, 2);
		String numeroA = (String)table.getValueAt(fila, 3);
		String recursos = (String)table.getValueAt(fila, 4);
		String estado =(String)table.getValueAt(fila, 5);
		String sede = (String)table.getValueAt(fila, 6);
		
		System.out.println(idSeleccionado +" - " + numero + " - "+ piso + " - " + numeroA + " - " + recursos + " - " + estado + " - " +  sede);
		
		txtNumero.setText(numero);
		txtPiso.setText(piso);	
		txtNumAlu.setText(numeroA);
		txtRecursos.setText(recursos);
		chkEstado.setSelected(getBooleanEstado(estado));
		cboSede.setSelectedItem(sede);
	}
	private void eliminar() {
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		}else {
			SalaModel model = new SalaModel();
			int salida = model.eliminaSala(idSeleccionado);
			if (salida > 0) {
				lista();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se eliminó Correctamente");
			}else {
				mensaje("Esta fallando el sistema");
			}
		}	
	}
	private void actualizar() {
		String num = txtNumero.getText();
		String pis = txtPiso.getText();
		String nua = txtNumAlu.getText();
		String rec = txtRecursos.getText();
		boolean estado = chkEstado.isSelected();
		String sed = cboSede.getSelectedItem().toString();
			
		if(idSeleccionado == -1) {	
			mensaje("Seleccione una fila");
		}else if(!num.matches(Validaciones.TEXTO_NUMERO)) {	
			mensaje("El Número de sala debe ser de 1 a 3 caracteres");
		}else if(!nua.matches(Validaciones.ALUMNOS)) {
			mensaje("El Número Alumnos debe de ser de 2 a 90 caracteres");
		}else if(!rec.matches(Validaciones.TEXTO)) {
			mensaje("El Recurso es de 2 a 15 caracteres");
		}else if (cboSede.getSelectedIndex() == 0 ) {
			mensaje("Seleccione una sede");
		}else {
		
		Sala obj = new Sala();
		obj.setID(idSeleccionado);
		obj.setNumero(num);
		obj.setPiso(pis);
		obj.setNumAlumnos(nua);
		obj.setRecursos(rec);
		obj.setSede(sed);
		obj.setEstado(getIntegerEstado(estado)); 
		
		SalaModel model = new SalaModel();
		int salida = model.actualizaSala(obj);
		
		if(salida > 0) {
			lista();
			idSeleccionado = -1;		
			limpiarCajasTexto();
			mensaje("Se Registró Correctamente");
		}else {
			mensaje("Esta fallando el sitema");
			}	
		}
	}	

	private String getFormatEstado(int estado) {
		return estado == 1 ? "Activo" : "Inactivo"; 
	}
	private int getIntegerEstado(boolean estado) {
		return estado ? 1 : 0;
	}
	
	private boolean getBooleanEstado(String estado) {
		return estado == "Activo" ? true : false;
	
	}
}
