package proyecto.modelo;

public class Contenido {
	private int id_contenido;
	private Clase clase;
	private String tipo;
	private String url_contenido;
	private String contenido_texto;
	
	
	
	public Contenido(int id_contenido, Clase clase, String tipo, String url_contenido, String contenido_texto) {
		super();
		this.id_contenido = id_contenido;
		this.clase = clase;
		this.tipo = tipo;
		this.url_contenido = url_contenido;
		this.contenido_texto = contenido_texto;
	}
	public int getId_contenido() {
		return id_contenido;
	}
	public void setId_contenido(int id_contenido) {
		this.id_contenido = id_contenido;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUrl_contenido() {
		return url_contenido;
	}
	public void setUrl_contenido(String url_contenido) {
		this.url_contenido = url_contenido;
	}
	public String getContenido_texto() {
		return contenido_texto;
	}
	public void setContenido_texto(String contenido_texto) {
		this.contenido_texto = contenido_texto;
	}
	
	
}