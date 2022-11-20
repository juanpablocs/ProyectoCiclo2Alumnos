package arreglos;

import clases.Alumno;

import java.util.ArrayList;

public class ArregloAlumnos {

	private ArrayList <Alumno> alumno;
	
	//  Constructor
	public ArregloAlumnos() {
		alumno = new ArrayList <Alumno>();
		
	}

	public void adicionar(Alumno x) {
		alumno.add(x);
	}
	public int tamaño() {
		return alumno.size();
	}
	public Alumno obtener(int i) {
		return alumno.get(i);
	}
	public Alumno buscar(int codigoAlumno) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodAlumno() == codigoAlumno)
				return obtener(i);
		return null;
	}
	public void eliminar(Alumno x) {
		alumno.remove(x);
	}
	public int nuevoCodigo() {
		if (tamaño() == 0)
			return 20001;
		else
			return obtener(tamaño()-1).getCodAlumno() + 1;
	}
	
}