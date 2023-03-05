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

import entidad.Libro;
import model.LibroModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmConsultaLibro extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTable table;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaLibro frame = new FrmConsultaLibro();
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
	public FrmConsultaLibro() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Consulta de Libro");
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 1050, 548);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta libro por titulo y categoria");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1014, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_1.setBounds(10, 64, 85, 31);
		getContentPane().add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitulo.setBounds(105, 69, 193, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Control panel.gif")));
		lblNewLabel_2.setBounds(332, 62, 116, 33);
		getContentPane().add(lblNewLabel_2);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCategoria.setBounds(458, 69, 157, 20);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setIcon(new ImageIcon(FrmConsultaLibro.class.getResource("/iconos/Search.gif")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(896, 59, 128, 36);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 1014, 401);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "A\u00F1o", "Categoria", "Serie", "Fecha de Registro", "Pais", "Tipo"
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
		String titulo = txtTitulo.getText();
		String categoria = txtCategoria.getText();
		
		LibroModel model = new LibroModel();
		List<Libro> lstLibro = model.ConsultaPorTituloCategoria(titulo, categoria);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Libro x : lstLibro) {
			fila = new Object[] {x.getID(),x.getTituto() , x.getA�o(), x.getCategoria(), x.getSerie(), x.getFec_reg(), x.getPais(), x.getTipo()};
			dtm.addRow(fila);
		}
	}	
}
