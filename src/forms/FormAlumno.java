package forms;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormAlumno extends JDialog {

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
	
	public FormAlumno() {
		setResizable(false);
		setTitle("Mantenimiento | Alumno");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		lblCodAlumno = new JLabel("C\u00F3digo");
		lblCodAlumno.setBounds(10, 10, 110, 23);
		getContentPane().add(lblCodAlumno);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 40, 70, 23);
		getContentPane().add(lblNombres);
	
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 70, 70, 23);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 100, 70, 23);
		getContentPane().add(lblDni);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 130, 70, 23);
		getContentPane().add(lblEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 160, 70, 23);
		getContentPane().add(lblCelular);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setBounds(90, 10, 85, 23);
		getContentPane().add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setBounds(90, 40, 200, 23);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(90, 70, 200, 23);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(90, 100, 200, 23);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);

		txtEdad = new JTextField();
		txtEdad.setBounds(90, 130, 200, 23);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(90, 160, 200, 23);
		getContentPane().add(txtCelular);
		txtCelular.setColumns(10);
	}

}
