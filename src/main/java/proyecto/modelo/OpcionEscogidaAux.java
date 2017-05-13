package proyecto.modelo;

public class OpcionEscogidaAux {
	
	private Opcion opcion;
	private Alumno alumno;
	public OpcionEscogidaAux(Opcion opcion, Alumno alumno) {
		super();
		this.opcion = opcion;
		this.alumno = alumno;
	}
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
