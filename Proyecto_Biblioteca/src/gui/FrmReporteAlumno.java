package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entidad.Alumno;
import model.AlumnoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmReporteAlumno extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JButton btnFiltrar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteAlumno frame = new FrmReporteAlumno();
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
	public FrmReporteAlumno() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Reporte de Alumno");
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 1050, 705);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE DE ALUMNO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1014, 42);
		getContentPane().add(lblNewLabel);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombres.setBounds(140, 59, 156, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmReporteAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_1.setBounds(30, 55, 100, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmReporteAlumno.class.getResource("/iconos/Boy.gif")));
		lblNewLabel_2.setBounds(356, 55, 107, 29);
		getContentPane().add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidos.setBounds(473, 59, 145, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFiltrar.setIcon(new ImageIcon(FrmReporteAlumno.class.getResource("/iconos/Print preview.gif")));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(917, 53, 107, 32);
		getContentPane().add(btnFiltrar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 90, 1014, 574);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));

	}
	
	/*
	 
	AYUDAS:
	1. LOS CAMPOS DE LA ENTIDAD SE RECOMIENDA ESTAR EN MINUSCULAS Y SIN SIGNOS
	2. AL MOMENTOS DE CREAR LOS FIELS EN EL JASPER REPORT SE RECOMIENDA PONER EL MISMO NOMBRE DE LOS CAMPOS CREADOS EN LA ENTIDAD
	3. LOS SQL.DATE NO PUEDEN SER TRAIDOS POR EL JASPER REPORT
	 
	*/
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String nombre = txtNombres.getText();
		String apellido = txtApellidos.getText();
		
		AlumnoModel model = new AlumnoModel();
		List<Alumno> lstAlumno = model.ReporteAlumno(nombre, apellido);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstAlumno);
		String jasper = "ReporteAlu.jasper";	
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer JRViewer = new JRViewer(print);
		
		panel.removeAll();
		panel.add(JRViewer);
		panel.repaint();
		panel.revalidate();
	}
}