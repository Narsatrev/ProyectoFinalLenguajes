package proyecto.modelo;

import java.util.List;

public class ObjetoEmpaquetaExamenPreguntasOpciones {
	 //clase auxiliar para empaquetar el resultado de busqueda de examen con un id en particular
    	private Examen examen;
    	private List<Pregunta> preguntas;
    	private List<Opcion> opciones;
    	
    	public ObjetoEmpaquetaExamenPreguntasOpciones(Examen e, List<Pregunta> lp, List<Opcion> o){
    		this.examen=e;
    		this.preguntas=lp;
    		this.opciones=o;
    	}

		public Examen getExamen() {
			return examen;
		}

		public void setExamen(Examen examen) {
			this.examen = examen;
		}

		public List<Pregunta> getPreguntas() {
			return preguntas;
		}

		public void setPreguntas(List<Pregunta> preguntas) {
			this.preguntas = preguntas;
		}

		public List<Opcion> getOpciones() {
			return opciones;
		}

		public void setOpciones(List<Opcion> opciones) {
			this.opciones = opciones;
		}

	
	
}
