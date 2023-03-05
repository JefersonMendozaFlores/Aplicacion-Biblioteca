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

import entidad.Sala;
import model.SalaModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmConsultaSala extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JTextField txtSede;
	private JTable table;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaSala frame = new FrmConsultaSala();
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
	public FrmConsultaSala() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta de Sala");
		setBounds(100, 100, 1050, 504);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta sala por numero y sede\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1014, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmConsultaSala.class.getResource("/iconos/Numbered list.gif")));
		lblNewLabel_1.setBounds(10, 57, 95, 28);
		getContentPane().add(lblNewLabel_1);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumero.setBounds(102, 61, 149, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sede:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmConsultaSala.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_2.setBounds(261, 57, 93, 28);
		getContentPane().add(lblNewLabel_2);
		
		txtSede = new JTextField();
		txtSede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSede.setBounds(338, 61, 157, 20);
		getContentPane().add(txtSede);
		txtSede.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultar.setIcon(new ImageIcon(FrmConsultaSala.class.getResource("/iconos/Search.gif")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(913, 57, 111, 32);
		getContentPane().add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1014, 363);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Numero", "Piso", "Numero de Alumnos", "Recursos", "Estado", "Fecha de Registro", "Sede"
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
		String numero = txtNumero.getText();
		String sede = txtSede.getText();
		
		SalaModel model = new SalaModel();
		List<Sala> lstSala = model.ConsultaPorNumeroSede(numero, sede);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for (Sala x : lstSala) {
			fila = new Object[] {x.getID(),x.getNumero(), x.getPiso() , x.getNumAlumnos(), x.getRecursos(), x.getEstado(), x.getFec_reg(), x.getSede()};
			dtm.addRow(fila);
		}
	}
}
