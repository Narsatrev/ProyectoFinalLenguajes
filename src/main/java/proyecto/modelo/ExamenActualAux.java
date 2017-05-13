package proyecto.modelo;

public class ExamenActualAux {
	private String nombre;
	private int id_examen;
	private int id_alumno;
	public ExamenActualAux(String nombre, int id_examen, int id_alumno) {

		this.nombre = nombre;
		this.id_examen = id_examen;
		this.id_alumno= id_alumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId_examen() {
		return id_examen;
	}
	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}
	
	
}
