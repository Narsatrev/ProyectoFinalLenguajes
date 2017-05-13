package proyecto.modelo;

public class Alumno {
	private int id_alumno;
	private String nombre;
	private String matricula;
	private int avance;
	
	public Alumno(int id_alumno, String nombre, String matricula, int avance) {
		super();
		this.id_alumno = id_alumno;
		this.nombre = nombre;
		this.matricula = matricula;
		this.avance = avance;
	}
	
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAvance() {
		return avance;
	}
	public void setAvance(int avance) {
		this.avance = avance;
	}
}
