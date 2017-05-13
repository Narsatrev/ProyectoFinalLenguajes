package proyecto.modelo;

public class Historial {

	private Examen examen;
	private Alumno alumno;
	private int aciertos;
	private int falsos;
	private int version;

	public Historial(Examen examen, Alumno alumno, Integer aciertos, Integer falsos, Integer version) {
		super();
		this.examen = examen;
		this.alumno = alumno;
		this.aciertos = aciertos;
		this.falsos = falsos;
		this.version = version;
	}

	public void setExamen(Examen examen) {this.examen = examen;}
	public void setAlumno(Alumno alumno) {this.alumno = alumno;}
	public void setAciertos(int aciertos) {this.aciertos = aciertos;}
	public void setFalsos(int falsos) {this.falsos = falsos;}
	public void setVersion(int version) {this.version = version;}

	public Examen getExamen() {return examen;}
	public Alumno getAlumno() {return alumno;}
	public int getAciertos() {return aciertos;}
	public int getFalsos() {return falsos;}
	public int getVersion() {return version;}

}
