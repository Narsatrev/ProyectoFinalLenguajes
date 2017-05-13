package proyecto.modelo;

public class Bloque {
	private int id_bloque;
	private Materia material;
	private String nombre;
			
	public Bloque(int id_bloque, Materia material, String nombre) {
		super();
		this.id_bloque = id_bloque;
		this.material = material;
		this.nombre = nombre;
	}
	public int getId_bloque() {
		return id_bloque;
	}
	public void setId_bloque(int id_bloque) {
		this.id_bloque = id_bloque;
	}
	public Materia getMaterial() {
		return material;
	}
	public void setMaterial(Materia material) {
		this.material = material;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}