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

import entidad.Usuario;
import model.UsuarioModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmConsultaUsuario extends JInternalFrame implements ActionListener {

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
					FrmConsultaUsuario frame = new FrmConsultaUsuario();
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
	public FrmConsultaUsuario() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Consulta de Usuario");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 1239, 531);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta usuario por nombres y apellidos");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1197, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 62, 95, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaUsuario.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(274, 62, 106, 31);
		getContentPane().add(lblNewLabel_2);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(125, 67, 138, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(390, 67, 146, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(FrmConsultaUsuario.class.getResource("/iconos/Search.gif")));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(1095, 58, 112, 35);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 1197, 373);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apelllidos", "DNI", "Login", "Password", "Correo", "Fecha de Registro", "Fecha de Nacimiento", "Direccion", "Pais"
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
		
		UsuarioModel model = new UsuarioModel();
		List<Usuario> lstUsuario = model.ConsultaPorNombreApellido(nombre, apellido);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Usuario x : lstUsuario) {
			fila = new Object[] {x.getID(),x.getNombres() , x.getApellidos(), x.getDni(), x.getLogin(), x.getPassword(), x.getCorreo(), x.getFec_reg(), x.getFec_nac(), x.getDireccion(), x.getPais()};
			dtm.addRow(fila);
		}
	}
}
