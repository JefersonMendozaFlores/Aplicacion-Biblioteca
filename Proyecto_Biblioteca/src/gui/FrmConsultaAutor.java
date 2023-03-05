package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Autor;
import model.AutorModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmConsultaAutor extends JInternalFrame implements ActionListener {

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
					FrmConsultaAutor frame = new FrmConsultaAutor();
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
	public FrmConsultaAutor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Autor");
		setBounds(100, 100, 915, 495);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta autor por nombre y apellido\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 879, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setBounds(10, 60, 97, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaAutor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setBounds(277, 61, 105, 29);
		getContentPane().add(lblNewLabel_2);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(117, 65, 111, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(404, 65, 105, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setIcon(new ImageIcon(FrmConsultaAutor.class.getResource("/iconos/Search.gif")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(769, 60, 120, 34);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 879, 349);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombres", "Apellidos", "Fecha Nacimiento", "Fecha Registro", "Pais", "Grado"
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
		
		AutorModel model = new AutorModel();
		List<Autor> lstAutor = model.ConsultaPorNombreApellido(nombre, apellido);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Autor x : lstAutor) {
			fila = new Object[] {x.getID(),x.getNombres() , x.getApellidos(), x.getFec_nac(), x.getFec_reg(), x.getPais(), x.getGrado()};
			dtm.addRow(fila);
		}
	}
}
