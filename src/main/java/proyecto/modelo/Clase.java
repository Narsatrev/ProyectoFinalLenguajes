package proyecto.modelo;

public class Clase {
	private int id_clase;
	private Bloque bloque;
	private String tema;
	public Clase(int id_clase, Bloque bloque, String tema) {
		super();
		this.id_clase = id_clase;
		this.bloque = bloque;
		this.tema = tema;
	}
	public int getId_clase() {
		return id_clase;
	}
	public void setId_clase(int id_clase) {
		this.id_clase = id_clase;
	}
	public Bloque getBloque() {
		return bloque;
	}
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
}
