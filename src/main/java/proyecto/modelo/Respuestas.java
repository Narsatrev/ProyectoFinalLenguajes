package proyecto.modelo;

public class Respuestas {

    private Historial historial;
    private Pregunta pregunta;
    private String respuesta;
    private long tiempo;

    public Respuestas(Historial historial, Pregunta pregunta, String respuesta, long tiempo){
        this.historial = historial;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.tiempo = tiempo;
    }

    public Historial getHistorial() {return historial;}
    public void setHistorial(Historial historial) {this.historial = historial;}
    public Pregunta getPregunta() {return pregunta;}

    public void setPregunta(Pregunta pregunta) {this.pregunta = pregunta; }
    public String getRespuesta() {return respuesta;}
    public void setRespuesta(String respuesta) {this.respuesta = respuesta;}

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}
    
    
}
