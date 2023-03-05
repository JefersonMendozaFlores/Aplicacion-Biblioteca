package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmConsultaProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTable table;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProveedor frame = new FrmConsultaProveedor();
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
	public FrmConsultaProveedor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Consulta de Proveedor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1060, 527);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta proveedor por nombres y apellidos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1024, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setBounds(10, 57, 110, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setBounds(264, 57, 110, 30);
		getContentPane().add(lblNewLabel_2);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(118, 62, 124, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(374, 62, 124, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setIcon(new ImageIcon(FrmConsultaProveedor.class.getResource("/iconos/Search.gif")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(910, 61, 124, 33);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 1024, 381);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "DNI", "Direccion", "Telefono", "Correo", "Pais", "Fecha de Registro"
			}
		));
		scrollPane.setViewportView(table);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultarJButton(e);
		}
	}
	protected void actionPerformedBtnConsultarJButton(ActionEvent e) {
		String nombre = txtNombres.getText();
		String apellido = txtApellidos.getText();
		
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lstProveedor = model.ConsultaPorNombreApellido(nombre, apellido);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Proveedor x : lstProveedor) {
			fila = new Object[] {x.getID(),x.getNombres() , x.getApellidos(), x.getDni(), x.getDireccion(), x.getTelefono(), x.getCorreo(), x.getPais(), x.getFec_reg()};
			dtm.addRow(fila);
		}
	}
}