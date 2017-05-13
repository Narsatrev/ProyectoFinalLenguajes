package proyecto.modelo;

public class Materia {
	private int id_materia;
	private String nombre;
	private String profesor;
	private String departamento;
	private String periodo;
	private String clave;
	
	public Materia(int id_materia, String nombre, String profesor, String departamento, String periodo, String clave) {
		this.id_materia = id_materia;
		this.nombre = nombre;
		this.profesor = profesor;
		this.departamento = departamento;
		this.periodo = periodo;
		this.clave = clave;
	}
	
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
}

