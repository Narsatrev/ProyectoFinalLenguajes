package proyecto.modelo;

public class Pregunta {
	private int id_pregunta;
	private Examen examen;
	private String descripcion;
	private int nivel_dificultad;
	
	
	public Pregunta(int id_pregunta, Examen examen, String descripcion, int nivel_dificultad) {
		super();
		this.id_pregunta = id_pregunta;
		this.examen = examen;
		this.descripcion = descripcion;
		this.nivel_dificultad = nivel_dificultad;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public Examen getExamen() {
		return examen;
	}
	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNivel_dificultad() {
		return nivel_dificultad;
	}
	public void setNivel_dificultad(int nivel_dificultad) {
		this.nivel_dificultad = nivel_dificultad;
	}
	
	
	
	
}
