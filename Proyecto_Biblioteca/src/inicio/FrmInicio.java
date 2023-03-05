package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.FrmConsultaAlumno;
import gui.FrmConsultaAutor;
import gui.FrmConsultaLibro;
import gui.FrmConsultaProveedor;
import gui.FrmConsultaSala;
import gui.FrmConsultaUsuario;
import gui.FrmMantenimientoAlumno;
import gui.FrmMantenimientoAutor;
import gui.FrmMantenimientoLibro;
import gui.FrmMantenimientoProveedor;
import gui.FrmMantenimientoSala;
import gui.FrmMantenimientoUsuario;
import gui.FrmRegistroAlumno;
import gui.FrmRegistroAutor;
import gui.FrmRegistroLibro;
import gui.FrmRegistroSala;
import gui.FrmRegistroUsuario;
import gui.FrmRegistrosProveedor;
import gui.FrmReporteAlumno;
import gui.FrmReporteLibro;
import gui.FrmReporteProveedor;

import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmInicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnConsulta;
	private JMenuItem mntmConAlumno;
	private JMenuItem mntmRegAlumno;
	private JMenuItem mntmConAutor;
	private JMenuItem mntmConLibro;
	private JMenuItem mntmConSala;
	private JMenuItem mntmConUsuario;
	private JMenuItem mntmConProveedor;
	private JMenuItem mntmRegAutor;
	private JMenuItem mntmRegLibro;
	private JMenuItem mntmRegSala;
	private JMenuItem mntmRegUsuario;
	private JMenuItem mntmRegProveedor;
	private JMenuItem mntmManAlumno;
	private JMenuItem mntmManAutor;
	private JMenuItem mntmManLibro;
	private JMenuItem mntmManSala;
	private JMenuItem mntmManUsuario;
	private JMenuItem mntmManProveedor;
	private JMenuItem mntmRepAlumno;		//
	private JMenuItem mntmRepLibro;			//
	private JMenuItem mntmRepProveedor;		//
	
	
	// --- PASO 1
	// --- CREAR FORMULARIO DE 
	
	// --- CONSULTAS
	private FrmConsultaAlumno frmConAlumno = new FrmConsultaAlumno();
	private FrmConsultaAutor frmConAutor = new FrmConsultaAutor();
	private FrmConsultaLibro frmConLibro = new FrmConsultaLibro();
	private FrmConsultaSala frmConSala = new FrmConsultaSala();
	private FrmConsultaUsuario frmConUsuario = new FrmConsultaUsuario();
	private FrmConsultaProveedor frmConProveedor = new FrmConsultaProveedor();
	
	// --- REGISTROS
	private FrmRegistroAlumno frmRegAlumno = new FrmRegistroAlumno();
	private FrmRegistroAutor frmRegAutor = new FrmRegistroAutor();
	private FrmRegistroLibro frmRegLibro = new FrmRegistroLibro();
	private FrmRegistroSala frmRegSala = new FrmRegistroSala();
	private FrmRegistroUsuario frmRegUsuario = new FrmRegistroUsuario();
	private FrmRegistrosProveedor frmRegProveedor = new FrmRegistrosProveedor();

	// --- MANTENIMIENTO
	private FrmMantenimientoAlumno frmManAlumno = new FrmMantenimientoAlumno();
	private FrmMantenimientoAutor frmManAutor = new FrmMantenimientoAutor();
	private FrmMantenimientoLibro frmManLibro = new FrmMantenimientoLibro();
	private FrmMantenimientoSala frmManSala = new FrmMantenimientoSala();
	private FrmMantenimientoUsuario frmManUsuario = new FrmMantenimientoUsuario();
	private FrmMantenimientoProveedor frmManProveedor = new FrmMantenimientoProveedor();
	
	// --- REPORTES
	private FrmReporteAlumno frmRepAlumno = new FrmReporteAlumno();
	private FrmReporteLibro frmRepLibro = new FrmReporteLibro();
	private FrmReporteProveedor frmRepProveedor = new FrmReporteProveedor();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// --- ASPECTOS PARA LA GUI
					
					//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
					
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					FrmInicio frame = new FrmInicio();
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
	public FrmInicio() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Sistema de Gestion de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnConsulta = new JMenu("Consultas");
		mnConsulta.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/Search.gif")));
		menuBar.add(mnConsulta);
		
		mntmConAlumno = new JMenuItem("Consulta de Alumno");
		mntmConAlumno.addActionListener(this);
		mnConsulta.add(mntmConAlumno);
		
		mntmConAutor = new JMenuItem("Consulta de Autor");
		mntmConAutor.addActionListener(this);
		mnConsulta.add(mntmConAutor);
		
		mntmConLibro = new JMenuItem("Consulta de Libro");
		mntmConLibro.addActionListener(this);
		mnConsulta.add(mntmConLibro);
		
		mntmConSala = new JMenuItem("Consulta de Sala");
		mntmConSala.addActionListener(this);
		mnConsulta.add(mntmConSala);
		
		mntmConUsuario = new JMenuItem("Consulta de Usuario");
		mntmConUsuario.addActionListener(this);
		mnConsulta.add(mntmConUsuario);
		
		mntmConProveedor = new JMenuItem("Consulta de Proveedor");
		mntmConProveedor.addActionListener(this);
		mnConsulta.add(mntmConProveedor);
		
		JMenu mnRegistro = new JMenu("Registros");
		mnRegistro.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/Add.gif")));
		menuBar.add(mnRegistro);
		
		mntmRegAlumno = new JMenuItem("Regsitro de Alumno");
		mntmRegAlumno.addActionListener(this);
		mnRegistro.add(mntmRegAlumno);
		
		mntmRegAutor = new JMenuItem("Registro de Autor");
		mntmRegAutor.addActionListener(this);
		mnRegistro.add(mntmRegAutor);
		
		mntmRegLibro = new JMenuItem("Registro de Libro");
		mntmRegLibro.addActionListener(this);
		mnRegistro.add(mntmRegLibro);
		
		mntmRegSala = new JMenuItem("Registro de Sala");
		mntmRegSala.addActionListener(this);
		mnRegistro.add(mntmRegSala);
		
		mntmRegUsuario = new JMenuItem("Registro de Usuario");
		mntmRegUsuario.addActionListener(this);
		mnRegistro.add(mntmRegUsuario);
		
		mntmRegProveedor = new JMenuItem("Registro de Proveedor");
		mntmRegProveedor.addActionListener(this);
		mnRegistro.add(mntmRegProveedor);
		
		JMenu mnMantenimiento = new JMenu("Mantenimientos");
		mnMantenimiento.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/Edit.gif")));
		menuBar.add(mnMantenimiento);
		
		mntmManAlumno = new JMenuItem("Mantenimiento de Alumno");
		mntmManAlumno.addActionListener(this);
		mnMantenimiento.add(mntmManAlumno);
		
		mntmManAutor = new JMenuItem("Mantenimiento de Autor");
		mntmManAutor.addActionListener(this);
		mnMantenimiento.add(mntmManAutor);
		
		mntmManLibro = new JMenuItem("Mantenimiento de Libro");
		mntmManLibro.addActionListener(this);
		mnMantenimiento.add(mntmManLibro);
		
		mntmManSala = new JMenuItem("Mantenimiento de Sala");
		mntmManSala.addActionListener(this);
		mnMantenimiento.add(mntmManSala);
		
		mntmManUsuario = new JMenuItem("Mantenimiento de Usuario");
		mntmManUsuario.addActionListener(this);
		mnMantenimiento.add(mntmManUsuario);
		
		mntmManProveedor = new JMenuItem("Mantenimiento de Proveedor");
		mntmManProveedor.addActionListener(this);
		mnMantenimiento.add(mntmManProveedor);
		
		JMenu mnReporte = new JMenu("Reportes");
		mnReporte.setIcon(new ImageIcon(FrmInicio.class.getResource("/iconos/Box.gif")));
		menuBar.add(mnReporte);
		
		mntmRepAlumno = new JMenuItem("Reporte de Alumno");
		mntmRepAlumno.addActionListener(this);
		mnReporte.add(mntmRepAlumno);
		
		mntmRepLibro = new JMenuItem("Reporte de Libro");
		mntmRepLibro.addActionListener(this);
		mnReporte.add(mntmRepLibro);
		
		mntmRepProveedor = new JMenuItem("Reporte de Proveedor");
		mntmRepProveedor.addActionListener(this);
		mnReporte.add(mntmRepProveedor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		
		// --- PASO 2
		// --- AÑADIMOS LOS FORMULARIOS
		
		// --- CONSULTA
		desktopPane.add(frmConAlumno);
		desktopPane.add(frmConAutor);
		desktopPane.add(frmConLibro);
		desktopPane.add(frmConSala);
		desktopPane.add(frmConUsuario);
		desktopPane.add(frmConProveedor);
		
		// --- REGISTROS
		desktopPane.add(frmRegAlumno);
		desktopPane.add(frmRegAutor);
		desktopPane.add(frmRegLibro);
		desktopPane.add(frmRegSala);
		desktopPane.add(frmRegUsuario);
		desktopPane.add(frmRegProveedor);
		
		// --- MANTENIMIENTOS
		desktopPane.add(frmManAlumno);
		desktopPane.add(frmManAutor);
		desktopPane.add(frmManLibro);
		desktopPane.add(frmManSala);
		desktopPane.add(frmManUsuario);
		desktopPane.add(frmManProveedor);
		
		// --- REPORTES
		desktopPane.add(frmRepAlumno);
		desktopPane.add(frmRepLibro);
		desktopPane.add(frmRepProveedor);
		
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmRepProveedor) {
			actionPerformedMntmRepProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmRepLibro) {
			actionPerformedMntmRepLibroJMenuItem(e);
		}
		if (e.getSource() == mntmRepAlumno) {
			actionPerformedMntmRepAlumnoJMenuItem(e);
		}
		if (e.getSource() == mntmManProveedor) {
			actionPerformedMntmManProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmManUsuario) {
			actionPerformedMntmManUsuarioJMenuItem(e);
		}
		if (e.getSource() == mntmManSala) {
			actionPerformedMntmManSalaJMenuItem(e);
		}
		if (e.getSource() == mntmManLibro) {
			actionPerformedMntmManLibroJMenuItem(e);
		}
		if (e.getSource() == mntmManAutor) {
			actionPerformedMntmManAutorJMenuItem(e);
		}
		if (e.getSource() == mntmManAlumno) {
			actionPerformedMntmManAlumnoJMenuItem(e);
		}
		if (e.getSource() == mntmRegProveedor) {
			actionPerformedMntmRegProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmRegUsuario) {
			actionPerformedMntmRegUsuarioJMenuItem(e);
		}
		if (e.getSource() == mntmRegSala) {
			actionPerformedMntmRegSalaJMenuItem(e);
		}
		if (e.getSource() == mntmRegLibro) {
			actionPerformedMntmRegLibroJMenuItem(e);
		}
		if (e.getSource() == mntmRegAutor) {
			actionPerformedMntmRegAutorJMenuItem(e);
		}
		if (e.getSource() == mntmConProveedor) {
			actionPerformedMntmConProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmConUsuario) {
			actionPerformedMntmConUsuarioJMenuItem(e);
		}
		if (e.getSource() == mntmConSala) {
			actionPerformedMntmConSalaJMenuItem(e);
		}
		if (e.getSource() == mntmConLibro) {
			actionPerformedMntmConLibroJMenuItem(e);
		}
		if (e.getSource() == mntmConAutor) {
			actionPerformedMntmConAutorJMenuItem(e);
		}
		if (e.getSource() == mntmRegAlumno) {
			actionPerformedMntmRegAlumnoJMenuItem(e);
		}
		if (e.getSource() == mntmConAlumno) {
			actionPerformedMntmConAlumnoJMenuItem(e);
		}
	}
	
	// --- BOTONES
	
	// --- CONSULTAS
	protected void actionPerformedMntmConAlumnoJMenuItem(ActionEvent e) {
		// --- PASO 3
		// --- HACERLO VISIBLE
		frmConAlumno.setVisible(true);
	}
	protected void actionPerformedMntmConAutorJMenuItem(ActionEvent e) {
		frmConAutor.setVisible(true);
	}
	protected void actionPerformedMntmConLibroJMenuItem(ActionEvent e) {
		frmConLibro.setVisible(true);
	}
	protected void actionPerformedMntmConSalaJMenuItem(ActionEvent e) {
		frmConSala.setVisible(true);
	}
	protected void actionPerformedMntmConUsuarioJMenuItem(ActionEvent e) {
		frmConUsuario.setVisible(true);
	}
	protected void actionPerformedMntmConProveedorJMenuItem(ActionEvent e) {
		frmConProveedor.setVisible(true);
	}
	
	
	// --- REGISTROS
	protected void actionPerformedMntmRegAlumnoJMenuItem(ActionEvent e) {
		frmRegAlumno.setVisible(true);
	}
	protected void actionPerformedMntmRegAutorJMenuItem(ActionEvent e) {
		frmRegAutor.setVisible(true);
	}
	protected void actionPerformedMntmRegLibroJMenuItem(ActionEvent e) {
		frmRegLibro.setVisible(true);
	}
	protected void actionPerformedMntmRegSalaJMenuItem(ActionEvent e) {
		frmRegSala.setVisible(true);
	}
	protected void actionPerformedMntmRegUsuarioJMenuItem(ActionEvent e) {
		frmRegUsuario.setVisible(true);
	}
	protected void actionPerformedMntmRegProveedorJMenuItem(ActionEvent e) {
		frmRegProveedor.setVisible(true);
	}
	
	
 	// --- MANTENIMIENTOS
	protected void actionPerformedMntmManAlumnoJMenuItem(ActionEvent e) {
		frmManAlumno.setVisible(true);
	}
	protected void actionPerformedMntmManAutorJMenuItem(ActionEvent e) {
		frmManAutor.setVisible(true);
	}
	protected void actionPerformedMntmManLibroJMenuItem(ActionEvent e) {
		frmManLibro.setVisible(true);
	}
	protected void actionPerformedMntmManSalaJMenuItem(ActionEvent e) {
		frmManSala.setVisible(true);
	}
	protected void actionPerformedMntmManUsuarioJMenuItem(ActionEvent e) {
		frmManUsuario.setVisible(true);
	}
	protected void actionPerformedMntmManProveedorJMenuItem(ActionEvent e) {
		frmManProveedor.setVisible(true);
	}
	
	
	// --- REPORTES
	protected void actionPerformedMntmRepAlumnoJMenuItem(ActionEvent e) {
		frmRepAlumno.setVisible(true);
	}
	protected void actionPerformedMntmRepLibroJMenuItem(ActionEvent e) {
		frmRepLibro.setVisible(true);
	}
	protected void actionPerformedMntmRepProveedorJMenuItem(ActionEvent e) {
		frmRepProveedor.setVisible(true);
	}
}
