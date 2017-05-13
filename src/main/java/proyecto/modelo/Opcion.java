package proyecto.modelo;

public class Opcion {
	private int id_opcion;
	private int numero;
	private Pregunta pregunta;
	private String descripcion;
	private boolean es_correcta;	
	
	public Opcion(int id_opcion, Pregunta pregunta, String descripcion, boolean es_correcta, int numero) {
		super();
		this.id_opcion = id_opcion;
		this.pregunta = pregunta;
		this.descripcion = descripcion;
		this.es_correcta = es_correcta;
		this.numero=numero;
	}
	
	public int getId_opcion() {
		return id_opcion;
	}
	public void setId_opcion(int id_opcion) {
		this.id_opcion = id_opcion;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEs_correcta() {
		return es_correcta;
	}
	public void setEs_correcta(boolean es_correcta) {
		this.es_correcta = es_correcta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
