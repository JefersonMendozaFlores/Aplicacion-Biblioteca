package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidad.Libro;
import model.LibroModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmReporteLibro extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JButton btnFiltrar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteLibro frame = new FrmReporteLibro();
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
	public FrmReporteLibro() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Reporte de Libro");
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 1050, 705);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPORTE DE LIBRO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 1014, 45);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Reporte", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 90, 1014, 574);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitulo.setBounds(104, 59, 144, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCategoria.setBounds(370, 59, 130, 20);
		getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setIcon(new ImageIcon(FrmReporteLibro.class.getResource("/iconos/List.gif")));
		lblNewLabel_1.setBounds(10, 55, 84, 30);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon(FrmReporteLibro.class.getResource("/iconos/Card file.gif")));
		lblNewLabel_2.setBounds(275, 55, 97, 30);
		getContentPane().add(lblNewLabel_2);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFiltrar.setIcon(new ImageIcon(FrmReporteLibro.class.getResource("/iconos/Print preview.gif")));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(927, 53, 97, 33);
		getContentPane().add(btnFiltrar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrarJButton(e);
		}
	}
	protected void actionPerformedBtnFiltrarJButton(ActionEvent e) {
		String titulo = txtTitulo.getText();
		String categoria = txtCategoria.getText();
		
		LibroModel model = new LibroModel();
		List<Libro> lstLibro = model.ReporteLibro(titulo, categoria);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstLibro);
		String jasper = "Reporte.jasper";	
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer JRViewer = new JRViewer(print);
		
		panel.removeAll();
		panel.add(JRViewer);
		panel.repaint();
		panel.revalidate();
	}
}
