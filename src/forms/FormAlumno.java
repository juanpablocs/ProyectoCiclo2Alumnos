package forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import clases.Alumno;

public class FormAlumno extends JDialog implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblNombres;
	private JLabel lblApellidos;

	private JLabel lblCodAlumno;

	private JTextField txtCodigoAlumno;

	private JTextField txtNombres;

	private JTextField txtApellidos;

	private JLabel lblDni;

	private JLabel lblEdad;

	private JLabel lblCelular;

	private JTextField txtDni;

	private JTextField txtEdad;

	private JTextField txtCelular;

	private JTable tblAlumno;

	private JScrollPane scrollPane;

	private DefaultTableModel modelo;

	private JButton btnNuevo;

	private JButton btnGuardar;

	private JButton btnModificar;

	private JButton btnEliminar;

	private ArregloAlumnos alumnos = new ArregloAlumnos();
	
	public FormAlumno() {
		setResizable(false);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		int top = 10;
		int topHeight = 27;
		lblCodAlumno = new JLabel("C\u00F3digo");
		lblCodAlumno.setBounds(10, top, 110, 23);
		getContentPane().add(lblCodAlumno);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, top+=topHeight, 70, 23);
		getContentPane().add(lblNombres);
	
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, top+=topHeight, 70, 23);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, top+=topHeight, 70, 23);
		getContentPane().add(lblDni);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, top+=topHeight, 70, 23);
		getContentPane().add(lblEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, top+=topHeight, 70, 23);
		getContentPane().add(lblCelular);
		
		top = 10;
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setBounds(90, top, 95, 23);
		txtCodigoAlumno.setEditable(false);
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setBounds(90, top+=topHeight, 200, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(90, top+=topHeight, 200, 23);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(90, top+=topHeight, 200, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(90, top+=topHeight, 200, 23);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(90, top+=topHeight, 200, 23);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.addMouseListener(this);
		btnGuardar.setForeground(Color.BLUE);
		btnGuardar.setBounds(195, 10, 100, 23);
		btnGuardar.setEnabled(false);
		getContentPane().add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.addMouseListener(this);
		btnNuevo.setForeground(Color.BLUE);
		btnNuevo.setBounds(535, 10, 150, 23);
		getContentPane().add(btnNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setBounds(535, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setBounds(535, 60, 150, 23);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, top+=topHeight+10, 675, 175);
		getContentPane().add(scrollPane);
		
		tblAlumno = new JTable();
		tblAlumno.addKeyListener(this);
		tblAlumno.addMouseListener(this);
		tblAlumno.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumno);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EDAD");
		modelo.addColumn("CELULAR");
		modelo.addColumn("ESTADO");
		
		tblAlumno.setModel(modelo);
		
//		add default
		alumnos.adicionar(new Alumno(1000, "Juan", "Chullo", "44848933", 30, 980742802, 0));
		alumnos.adicionar(new Alumno(1001, "Tiago", "Batista", "44848933", 30, 980742802, 0));
		alumnos.adicionar(new Alumno(1002, "Rosario", "Vilca", "44848933", 30, 980742802, 0));
		alumnos.adicionar(new Alumno(1003, "Dante", "Yucra", "44848933", 30, 980742802, 0));
		
		
		listar();
		
	}
	
	void listar() {
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblAlumno.getSelectedRow();
		if (modelo.getRowCount() == alumnos.tamaño() - 1)
			posFila = alumnos.tamaño() - 1;
		if (posFila == alumnos.tamaño())
			posFila --;
		modelo.setRowCount(0);
		for (int i=0; i<alumnos.tamaño(); i++) {
			Alumno al = alumnos.obtener(i);
			Object[] fila = { al.getCodAlumno(),
					          al.getNombres(),
					          al.getApellidos(),
					          al.getDni(), 
					          al.getEdad(), 
					          al.getCelular(),
					          al.getEstado(), 
					         };
			modelo.addRow(fila);
		}
		if (alumnos.tamaño() > 0)
			tblAlumno.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	protected void actionPerformedBtnNuevo() {
		btnGuardar.setEnabled(true);
		btnNuevo.setEnabled(false);
		btnModificar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtCodigoAlumno.setText(""+alumnos.nuevoCodigo());
		txtNombres.requestFocus();
	}
	
	protected void actionPerformedBtnModificar() {
		btnGuardar.setEnabled(true);
		btnNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
		txtNombres.requestFocus();
		if (alumnos.tamaño() == 0) {
			btnGuardar.setEnabled(false);
			habilitarEntradas(false);
//			mensaje("No existen pacientes");	
		}
		else {
			editarFila();
			btnGuardar.setEnabled(true);
			habilitarEntradas(true);
			txtNombres.requestFocus();
		}
	}
	
	protected void actionPerformedBtnGuardar() {
		int codAlumno = Integer.parseInt(txtCodigoAlumno.getText().trim());
		String nombreAlumno = txtNombres.getText().trim();
		String apellidoAlumno = txtApellidos.getText().trim();
		String dniAlumno = txtDni.getText().trim();
		int edadAlumno = Integer.parseInt(txtEdad.getText().trim());
		int celularAlumno = Integer.parseInt(txtCelular.getText().trim());
//		add data
		if(!btnNuevo.isEnabled()) {
			alumnos.adicionar(new Alumno(
				codAlumno,
				nombreAlumno,
				apellidoAlumno,
				dniAlumno,
				edadAlumno,
				celularAlumno,
				0
			));
			btnNuevo.setEnabled(true);
		}
		
//		edit data
		if(!btnModificar.isEnabled()) {
			Alumno p = alumnos.buscar(codAlumno);
			p.setNombres(nombreAlumno);
			p.setApellidos(apellidoAlumno);
			p.setDni(dniAlumno);
			p.setEdad(edadAlumno);
			p.setCelular(celularAlumno);

			btnModificar.setEnabled(true);
		}
		btnGuardar.setEnabled(false);
		listar();
		habilitarEntradas(false);
	}
	
	void disabledBtnNuevo() {
		txtCodigoAlumno.setEnabled(false);
		btnGuardar.setEnabled(false);
	}
	
	void habilitarEntradas(boolean sino) {
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtCelular.setEditable(sino);
		txtDni.setEditable(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnGuardar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	
	protected void mouseClickedTblAlumno() {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	void editarFila() {
		if (alumnos.tamaño() == 0)
			limpieza();
		else {
			disabledBtnNuevo();
			Alumno p = alumnos.obtener(tblAlumno.getSelectedRow());
			txtCodigoAlumno.setText("" + p.getCodAlumno());
			txtNombres.setText(p.getNombres());
			txtApellidos.setText(p.getApellidos());
			txtCelular.setText(""+p.getCelular());
			txtEdad.setText(""+p.getEdad());
			txtDni.setText(p.getDni());
		}
	}
	
	void limpieza() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtCelular.setText("");
		txtEdad.setText("");
		txtDni.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo();
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar();
		}
		
		if(e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tblAlumno) {
			mouseClickedTblAlumno();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();		
	}

}
