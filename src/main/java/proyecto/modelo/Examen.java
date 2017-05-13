package proyecto.modelo;

public class Examen {
	
	private int id_examen;
	private Bloque bloque;
	private Materia materia;
	private String nombre;
	
	
	public Examen(int id_examen, Bloque bloque, Materia materia, String nombre) {
		super();
		this.id_examen = id_examen;
		this.bloque = bloque;
		this.materia = materia;
		this.nombre = nombre;
	}
	
	public int getId_examen() {
		return id_examen;
	}
	public void setId_examen(int id_examen) {
		this.id_examen = id_examen;
	}
	public Bloque getBloque() {
		return bloque;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
