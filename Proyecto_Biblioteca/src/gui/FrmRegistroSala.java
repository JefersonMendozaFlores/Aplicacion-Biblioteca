package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import entidad.Sala;
import model.SalaModel;
import util.Validaciones;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class FrmRegistroSala extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JTextField txtRecursos;
	private JButton btnRegistrar;
	private JComboBox<String> cboSede;
	private JTextField txtNumAlu;
	private JTextField txtPiso;
	private JCheckBox CheckEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroSala frame = new FrmRegistroSala();
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
	public FrmRegistroSala() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Sala");
		setBounds(100, 100, 491, 394);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Sala");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.ITALIC, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 455, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero:");
		lblNewLabel_1.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Text.gif")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(90, 55, 89, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Piso:");
		lblNewLabel_2.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Statistics.gif")));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(90, 91, 89, 26);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de alumnos:");
		lblNewLabel_3.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Application form.gif")));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(90, 125, 159, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Recursos:");
		lblNewLabel_4.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Box.gif")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(90, 157, 103, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Sede:");
		lblNewLabel_6.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Globe.gif")));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(90, 188, 77, 34);
		getContentPane().add(lblNewLabel_6);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumero.setBounds(236, 57, 159, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		
		txtRecursos = new JTextField();
		txtRecursos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRecursos.setBounds(203, 159, 192, 20);
		getContentPane().add(txtRecursos);
		txtRecursos.setColumns(10);
		
		cboSede = new JComboBox<String>();
		cboSede.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboSede.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Independencia", "Breña", "Mira Flores", "Bella Vista", "Chorrillos", "Los Olivos"}));
		cboSede.setBounds(259, 194, 136, 22);
		getContentPane().add(cboSede);
		
		CheckEstado = new JCheckBox(":Estado");
		CheckEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CheckEstado.setBounds(259, 237, 136, 23);
		getContentPane().add(CheckEstado);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Add.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(193, 319, 122, 34);
		getContentPane().add(btnRegistrar);
		
		txtNumAlu = new JTextField();
		txtNumAlu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumAlu.setBounds(259, 128, 136, 20);
		getContentPane().add(txtNumAlu);
		txtNumAlu.setColumns(10);
		
		txtPiso = new JTextField();
		txtPiso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPiso.setBounds(236, 94, 159, 20);
		getContentPane().add(txtPiso);
		txtPiso.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estado:");
		lblNewLabel_5.setIcon(new ImageIcon(FrmRegistroSala.class.getResource("/iconos/Diagram.gif")));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(90, 231, 77, 34);
		getContentPane().add(lblNewLabel_5);

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
		String num = txtNumero.getText();
		String piso = txtPiso.getText();
		String numalu = txtNumAlu.getText();
		String recur = txtRecursos.getText();
		boolean estado = CheckEstado.isSelected();
		String sede = cboSede.getSelectedItem().toString();
		
		if(!num.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("El NÚMERO DE SALA debe ser de 1 a 3 caracteres");
		}else if(!numalu.matches(Validaciones.ALUMNOS)) {
			mensaje("El NÚMERO ALUMNOS debe de ser de 2 a 90 caracteres");
		}else if(!recur.matches(Validaciones.TEXTO)) {
			mensaje("El RECURSOS es de 2 a 15 caracteres");
		}else if(cboSede.getSelectedIndex() == 0) {
			mensaje("Selecione la SEDE");	
		}else {	
			Sala obj = new Sala();
			obj.setNumero(num);
			obj.setPiso(piso);
			obj.setNumero(numalu);
			obj.setRecursos(recur);
			obj.setEstado(getIntegerEstado(estado));
			obj.setSede(sede);
			
			SalaModel model = new SalaModel();
			int salida = model.insertaSala(obj);
			
			if(salida > 0) {
				mensaje("Se Registro Correctamente");
			}else {
				mensaje("No se logro Registrar");
			}	
		}
	}
	/*
	private String getFormatoEstado(int estado) {
		return estado == 1? "true":"false";
	}
	
	private boolean getBooleanEstado(String estado) {
		return estado == "Activo"? true:false;
	}
	*/
	private int getIntegerEstado(boolean estado) {
		return estado? 1:0;
	}
}
