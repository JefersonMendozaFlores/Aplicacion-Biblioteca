package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import entidad.Libro;
import model.LibroModel;
import util.Validaciones;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmRegistroLibro extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTitulo;
	private JTextField txtSerie;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboTipo;
	private JTextField txtAño;
	private JButton btnRegistrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroLibro frame = new FrmRegistroLibro();
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
	public FrmRegistroLibro() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setTitle("Registro de Libro");
		setMaximizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setBounds(100, 100, 443, 369);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Libro");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 11, 283, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(61, 54, 74, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Calendar.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(61, 82, 74, 33);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Bar chart.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(61, 153, 89, 28);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Serie:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/List.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(61, 113, 74, 29);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Pais:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(61, 184, 89, 28);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Task list.gif")));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(61, 215, 89, 28);
		getContentPane().add(lblNewLabel_7);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTitulo.setBounds(144, 57, 187, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Estrategia", "Novela", "Terror", "Comedia", "Suspenso", "Aventura"}));
		cboCategoria.setBounds(193, 155, 138, 22);
		getContentPane().add(cboCategoria);
		
		cboPais = new JComboBox<String>();
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Peru", "Colombia", "Venezuela", "Brazil", "Ecuador", "Chile", "Argentina", "Bolivia"}));
		cboPais.setBounds(193, 186, 138, 22);
		getContentPane().add(cboPais);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Fisico", "Digital"}));
		cboTipo.setBounds(193, 215, 138, 22);
		getContentPane().add(cboTipo);
		
		txtSerie = new JTextField();
		txtSerie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSerie.setBounds(145, 117, 186, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroLibro.class.getResource("/iconos/Add.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(151, 289, 111, 39);
		getContentPane().add(btnRegistrar);
		
		txtAño = new JTextField();
		txtAño.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAño.setBounds(145, 88, 186, 20);
		getContentPane().add(txtAño);
		txtAño.setColumns(10);

	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String titu = txtTitulo.getText();
		String año = txtAño.getText();
		String categ = cboCategoria.getSelectedItem().toString();
		String serie = txtSerie.getText();
		String pais = cboPais.getSelectedItem().toString();
		String tipo = cboTipo.getSelectedItem().toString();
		if (!titu.matches(Validaciones.TEXTO)) {
			mensaje("El Titulo es de 2 o mas caracteres");
		} else if (!año.matches(Validaciones.ANNO)) {
			mensaje("El Año es de 4 Caracteres");
		} else if (cboCategoria.getSelectedIndex() == 0) {
			mensaje("Seleccione Categoria");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione Pais");
		} else if (cboTipo.getSelectedIndex() == 0) {
			mensaje("Seleccione Tipo");
		} else {
			Libro obj = new Libro();
			obj.setTituto(titu);
			obj.setAño(Integer.parseInt(año));
			obj.setCategoria(categ);
			obj.setSerie(serie);
			obj.setPais(pais);
			obj.setTipo(tipo);
			
			LibroModel model = new LibroModel();
			int salida = model.insertaLibro(obj);
			
			if (salida > 0) {
				mensaje("Se registro correctamente. Felicitaciones :)");
			}else {
				mensaje("No se registro correctamente :(");
			}
			
		}
	}
}
