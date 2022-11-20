package cibertec;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import forms.FormAlumno;
import forms.FormCurso;
import forms.FormReporte;
import clases.Matricula; 

public class Start extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnReporte;
	private JMenuItem menuAlumno;
	private JMenuItem menuCurso;
	private JMenuItem mntmSalir;
	private JMenuItem mntmRMPendiente;
	private JMenuItem mntmRMVigente;
	private JMenuItem mntmRMCurso;
	
	
	public Start() {
		
		int ANCHO = 750, 
			ALTO = 500;
		
		setResizable(false);
		setTitle("Registro y Matricula de alumnos");
		setIconImage(new ImageIcon("imagenes/icono.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		
		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");  
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuProyecto.add(mnMantenimiento);
		
		menuAlumno = new JMenuItem("Alumno");
		menuAlumno.addActionListener(this);
		mnMantenimiento.add(menuAlumno);
		
		menuCurso = new JMenuItem("Curso");
		menuCurso.addActionListener(this);
		mnMantenimiento.add(menuCurso);
		
		mnRegistro = new JMenu("Registro");
		menuProyecto.add(mnRegistro);
		
		mnReporte = new JMenu("Reporte");
		menuProyecto.add(mnReporte);
		
		mntmRMPendiente = new JMenuItem("Matriculas Pendientes");
		mntmRMPendiente.addActionListener(this);
		mnReporte.add(mntmRMPendiente);
		
		mntmRMVigente = new JMenuItem("Matriculas Vigentes");
		mntmRMVigente.addActionListener(this);
		mnReporte.add(mntmRMVigente);
		
		mntmRMCurso = new JMenuItem("Matriculados por curso");
		mntmRMCurso.addActionListener(this);
		mnReporte.add(mntmRMCurso);
		
		

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Matricula m = new Matricula();
		if (e.getSource() == mntmSalir) {
			System.exit(0); // stop program
			dispose(); // close window
			setVisible(false); // hide window
		}
		// TODO Auto-generated method stub
		if (e.getSource() == menuAlumno) {
			actionPerformedFormAlumno(e);
		}
		if (e.getSource() == menuCurso) {
			actionPerformedFormCurso(e);
		}
		if (e.getSource() == mntmRMPendiente) {
			m.Estado(1);
			actionPerformedFormReporte(e);
		}
		if (e.getSource() == mntmRMVigente) {
			m.Estado(2);
			actionPerformedFormReporte(e);
		}
		if (e.getSource() == mntmRMCurso) {
			m.Estado(3);
			actionPerformedFormReporte(e);
		}
	}
	
	protected void actionPerformedFormAlumno(ActionEvent arg0) {
		FormAlumno dp = new FormAlumno();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	
	protected void actionPerformedFormCurso(ActionEvent arg0) {
		FormCurso dp = new FormCurso();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	
	protected void actionPerformedFormReporte(ActionEvent arg0) {
		FormReporte dp = new FormReporte();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	

}
