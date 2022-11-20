package clases;

public class Matricula {

	private int numMatricula;
	private int codAlumno;
	private int codCurso;
	private String fecha;
	private String hora;
	private String estadoMatricula;
	static int formestado;
	
	public Matricula() {
		// TODO Auto-generated constructor stub
	}
	
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora, String estadoMatricula) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		this.estadoMatricula = estadoMatricula;
	}


	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getEstadoMatricula() {
		return estadoMatricula;
	}

	public void setEstadoMatricula(String estadoMatricula) {
		this.estadoMatricula = estadoMatricula;
	}
	
	//---//
	public int Estado(int est) {
		return this.formestado = est;
	}
	
	public String reporte() {
		
		String report = "";
		
		if(formestado == 1) {
			report = "          REPORTE DE MATRICULAS PENDIENTES\n \n"+
					"Codigo de Alumno: "+this.codAlumno + " \n";
					
		}
		else if(formestado == 2) {
			report = "          REPORTE DE MATRICULAS VIGENTES\n \n"+
					"Codigo de Alumno: "+this.codAlumno + " \n";
			
		}
		else if(formestado == 3) {
			report = "         REPORTE DE MATRICULADOS POR CURSO\n \n"+
					"Codigo de Alumno: "+this.codAlumno + " \n";
			
		}
		else {
			report = "FALTAN DATOS";
		}
		return report;
		
	}
	

}
