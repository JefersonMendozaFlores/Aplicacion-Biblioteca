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

import entidad.Libro;
import model.LibroModel;
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

public class FrmMantenimientoLibro extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtSerie;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboTipo;
	private JTable table;
	private JTextField txtA�o;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private int idSeleccionado = -1;

	int hoveredRow = -1, hoveredColumn = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoLibro frame = new FrmMantenimientoLibro();
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
	public FrmMantenimientoLibro() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Libro");
		setBounds(100, 100, 1016, 524);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Mantenimiento de Libro");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 980, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 59, 92, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 97, 92, 35);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Diagram.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(247, 97, 89, 35);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serie:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Text.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(247, 59, 89, 26);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Pais:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(495, 97, 80, 35);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Statistics.gif")));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(495, 59, 80, 26);
		getContentPane().add(lblNewLabel_7);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitulo.setBounds(112, 62, 116, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Estrategia", "Novela", "Terror", "Comedia", "Suspenso", "Aventura"}));
		cboCategoria.setBounds(346, 103, 139, 22);
		getContentPane().add(cboCategoria);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(585, 103, 139, 22);
		getContentPane().add(cboPais);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Fisico", "Digital"}));
		cboTipo.setBounds(585, 63, 139, 22);
		getContentPane().add(cboTipo);
		
		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSerie.setBounds(346, 62, 139, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Add.gif")));
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(871, 41, 119, 38);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Edit.gif")));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(871, 88, 119, 37);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoLibro.class.getResource("/iconos/Delete.gif")));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(871, 132, 119, 35);
		getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 980, 311);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "A\u00F1o", "Categoria", "Serie", "Pais", "Tipo"
			}
		));
		scrollPane.setViewportView(table);
		
		txtA�o = new JTextField();
		txtA�o.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtA�o.setBounds(112, 104, 116, 20);
		getContentPane().add(txtA�o);
		txtA�o.setColumns(10);
		
		listar();
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtTitulo.setText("");
		txtA�o.setText("");
		cboCategoria.setSelectedItem("[seleccione]");
		txtSerie.setText("");
		cboPais.setSelectedItem("[seleccione]");
		cboTipo.setSelectedItem("[seleccione]");
		txtTitulo.requestFocus();
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
		LibroModel model = new LibroModel();
		List<Libro> lista = model.listaTodos();

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);

		Object[] fila = null;
		for (Libro x : lista) {
			fila = new Object[] { x.getID(), x.getTituto(), x.getA�o(), x.getCategoria(),
					x.getSerie(), x.getPais(), x.getTipo() };
			dtm.addRow(fila);
		}
	}

	private void insertar() {
		
		String titu = txtTitulo.getText();
		String anio = txtA�o.getText();
		String cate = cboCategoria.getSelectedItem().toString();
		String seri = txtSerie.getText();
		String pais = cboPais.getSelectedItem().toString();
		String tipo = cboTipo.getSelectedItem().toString();
		
		if (!titu.matches(Validaciones.TEXTO)) {
			mensaje("El Titulo es de 2 o mas caracteres");
		} else if (!anio.matches(Validaciones.ANNO)) {
			mensaje("El A�o es de 4 Caracteres");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione Categoria");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione Pais");
		} else if (cboTipo.getSelectedIndex() == 0) {
			mensaje("Seleccione Tipo");
		} else {
			Libro obj = new Libro();
			obj.setTituto(titu);
			obj.setA�o(Integer.parseInt(anio));
			obj.setCategoria(cate);
			obj.setSerie(seri);
			obj.setPais(pais);
			obj.setTipo(tipo);
			LibroModel model = new LibroModel();
			int salida = model.insertaLibro(obj);

			if (salida > 0) {
				listar();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se insert� correctamente");
			} else {
				mensaje("Error en el Registro");
			}

		}
	}

	private void buscar() {
		int fila = table.getSelectedRow();

		idSeleccionado = (Integer) table.getValueAt(fila, 0);
		String titulo = (String) table.getValueAt(fila, 1);
		Integer anio = (Integer) table.getValueAt(fila, 2);
		String cate = (String)table.getValueAt(fila, 3);
		String serie = (String) table.getValueAt(fila, 4);
		String pais = (String)table.getValueAt(fila, 5);
		String tipo = (String)table.getValueAt(fila, 6);
		

		System.out.println(idSeleccionado + " - " + titulo + " - " + anio+ " - " +cate +"-" + serie+ "-" + pais+ "-" +tipo);

		txtTitulo.setText(titulo);
		txtA�o.setText(String.valueOf(anio));
		cboCategoria.setSelectedItem(cate);
		txtSerie.setText(serie);
		cboPais.setSelectedItem(pais);
		cboTipo.setSelectedItem(tipo);
	}

	private void eliminar() {
		if (idSeleccionado == -1) {
			mensaje("Seleccione una Fila");
		} else {
			LibroModel model = new LibroModel();
			int salida = model.eliminaLibro(idSeleccionado);

			if (salida > 0) {
				listar();
				idSeleccionado = -1;
				limpiarCajasTexto();
				mensaje("Se elimin� correctamente");
			} else {
				mensaje("Error en la eliminaci�n");
			}
		}
	}

	private void actualizar() {
		String titu = txtTitulo.getText();
		String anio = txtA�o.getText();
		String cate = cboCategoria.getSelectedItem().toString();
		String seri = txtSerie.getText();
		String pais = cboPais.getSelectedItem().toString();
		String tipo = cboTipo.getSelectedItem().toString();
		
		if (!titu.matches(Validaciones.TEXTO)) {
			mensaje("El T�tulo es de 2 o mas caracteres");
		} else if (!anio.matches(Validaciones.ANNO)) {
			mensaje("El A�o es de 4 Caracteres");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione Categoria");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione Pais");
		} else if (cboTipo.getSelectedIndex() == 0) {
			mensaje("Seleccione Tipo");			
		} else {
			Libro obj = new Libro();
			obj.setID(idSeleccionado);
			obj.setTituto(titu);
			obj.setA�o(Integer.parseInt(anio));
			obj.setCategoria(cate);
			obj.setSerie(seri);
			obj.setPais(pais);
			obj.setTipo(tipo);
			LibroModel model = new LibroModel();
			int salida = model.actualizaLibro(obj);
			
			if (salida > 0) {
				listar();
				limpiarCajasTexto();
				idSeleccionado = -1;
				mensaje("Se actualiz� correctamente");
			} else {
				mensaje("Error en la actualizaci�n");
			}

		}
	}
	
}
