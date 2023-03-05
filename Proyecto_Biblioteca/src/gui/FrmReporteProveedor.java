package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import entidad.Proveedor;
import model.ProveedorModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmReporteProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JPanel panel;
	private JButton btnFiltrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteProveedor frame = new FrmReporteProveedor();
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
	public FrmReporteProveedor() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Reporte de Proveedor");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1050, 705);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte de Proveedor");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1014, 46);
		getContentPane().add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(136, 73, 147, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmReporteProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(32, 69, 94, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmReporteProveedor.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(342, 69, 105, 28);
		getContentPane().add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(457, 73, 159, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 108, 1014, 556);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setIcon(new ImageIcon(FrmReporteProveedor.class.getResource("/iconos/Print preview.gif")));
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(919, 58, 105, 39);
		getContentPane().add(btnFiltrar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String nombre = txtNombres.getText();
		String apellido = txtApellidos.getText();
		
		ProveedorModel model = new ProveedorModel();
		List<Proveedor> lstAlumno = model.ReportProveedor(nombre, apellido);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstAlumno);
		String jasper = "ReporteProv.jasper";	
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer JRViewer = new JRViewer(print);
		
		panel.removeAll();
		panel.add(JRViewer);
		panel.repaint();
		panel.revalidate();
	}
}
