package proyecto.modelo;

public class PreguntaActualAux {
	private int id_pregunta;
	private int id_alumno;
	
	public PreguntaActualAux(int id_pregunta, int id_alumno) {
		super();
		this.id_pregunta = id_pregunta;
		this.id_alumno = id_alumno;
	}
	
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	
}
