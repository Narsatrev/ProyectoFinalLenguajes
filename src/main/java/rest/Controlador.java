package rest;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proyecto.modelo.*;

@RestController
public class Controlador {

	private static Logger log = LoggerFactory.getLogger(Controlador.class);

	private final Servicio servicioEducacionAdapatativa;

	@Autowired
	public Controlador(Servicio servicio) {
		this.servicioEducacionAdapatativa = servicio;
	}


	//mapeo del rest para buscar un alumno por id
	@RequestMapping(value = "/api/alumno/buscar", 
			method = RequestMethod.GET,
			produces = "application/json")

	public Alumno buscarAlumno(
			@RequestParam(required = true) String matricula)
	{
		Alumno alumno_buscado= new Alumno(0, "", matricula, 0);        
		Alumno alumno_encontrado = servicioEducacionAdapatativa.encontrarAlumnoPorMatricula(alumno_buscado);
		return alumno_encontrado;
	}
	

	//mapeo del rest para responder un examen
	@RequestMapping(value = "/api/examen/responder", 
			method = RequestMethod.GET,
			produces = "application/json")

	//los examenes pueden tener hasta 10 preguntas
	public String contestarExamen(
			@RequestParam(required = true) String preg0,
			@RequestParam(required = true) String preg1,
			@RequestParam(required = false) String preg2,
			@RequestParam(required = false) String preg3,
			@RequestParam(required = false) String preg4,
			@RequestParam(required = false) String preg5,
			@RequestParam(required = false) String preg6,
			@RequestParam(required = false) String preg7,
			@RequestParam(required = false) String preg8,
			@RequestParam(required = false) String preg9,
			@RequestParam(required = true) String matricula,
			@RequestParam(required = true) long tiempo)
	{		
		List<String> preguntas = new ArrayList<String>();
		
		preguntas.add(preg0); preguntas.add(preg1);
		preguntas.add(preg2); preguntas.add(preg3);
		preguntas.add(preg4); preguntas.add(preg5);		
		preguntas.add(preg6); preguntas.add(preg7);		
		preguntas.add(preg8); preguntas.add(preg9);
		
		
		int aciertos=0;
		int falsos=0;
		for(String s: preguntas){
			if(s!=null){
				if(s.split("_")[3]=="1"){
					aciertos++;
				}else{
					falsos++;
				}
			}
		}

		int id_examen_preguntas = Integer.parseInt(preg0.split("_")[0]);
		//buscar el examen al que pertenecian las preguntas
		Examen e = servicioEducacionAdapatativa.encontrarExamenPorID(new Examen(id_examen_preguntas,null,null,""));
		//buscar alumno que resolvio el examen
		Alumno a = servicioEducacionAdapatativa.encontrarAlumnoPorMatricula(new Alumno(0, "",matricula, 0));
		//generar nuevo historial
		Historial h = new Historial(e, a, aciertos, falsos, 1);
		
		servicioEducacionAdapatativa.insertarHistorial(h);
		
		for(String s: preguntas){
			if(s!=null){
				int id_pregunta_buscada= Integer.parseInt(s.split("_")[1]);
				Pregunta p = servicioEducacionAdapatativa.encontrarPreguntaPorID(new Pregunta(id_pregunta_buscada, null, null, 0));
				String id_opcion_buscada= (s.split("_")[2]);
				Respuestas r = new Respuestas(h, p, id_opcion_buscada, tiempo);
				servicioEducacionAdapatativa.insertarRespuesta(r);
			}
		}
		
		return "insertado ok";
	}


	//mapeo del rest para insertar un alumno
	@RequestMapping(value = "/api/alumno/insertar", 
			method = RequestMethod.GET,
			produces = "application/json")

	public String insertarAlumno(
			@RequestParam(required = true) int id,
			@RequestParam(required = true) String nombre,
			@RequestParam(required = true) String matricula,
			@RequestParam(required = true) int avance)
	{
		Alumno alumno_insertar= new Alumno(id, nombre, matricula, avance);        
		servicioEducacionAdapatativa.insertarAlumno(alumno_insertar);
		return "insertado ok";
	}

	@RequestMapping(value = "api/examen/buscar",
			method = RequestMethod.GET,
			produces = "application/json")

	//mapeo del rest para buscar un examen por id
	public ObjetoEmpaquetaExamenPreguntasOpciones buscarExamen(@RequestParam(required = true) int id){

		List<Examen> examenes = new ArrayList<Examen>();

		examenes = servicioEducacionAdapatativa.encontrarExamenesEnSesion(
				servicioEducacionAdapatativa.kieSession);

		if(examenes == null){
			ObjetoEmpaquetaExamenPreguntasOpciones error = new ObjetoEmpaquetaExamenPreguntasOpciones(new Examen(0, null, null, "examen no existe"), null, null);
			return error;
		}

		System.out.println(examenes.toString());

		Examen examen_buscado= null;

		for(Examen e: examenes){
			if(e.getId_examen()==id){
				examen_buscado=e;
				break;
			}
		}

		if(examen_buscado == null){
			ObjetoEmpaquetaExamenPreguntasOpciones error = new ObjetoEmpaquetaExamenPreguntasOpciones(new Examen(0, null, null, "examen no existe"), null, null);
			return error;
		}

		List<Pregunta> lista_preguntas_completa = servicioEducacionAdapatativa.encontrarPreguntasEnSesion(
				servicioEducacionAdapatativa.kieSession);

		List<Pregunta> lista_preguntas_examen_encontrado= new ArrayList<Pregunta>();
		for(Pregunta p: lista_preguntas_completa){
			if(p.getExamen().getId_examen() == examen_buscado.getId_examen()){
				lista_preguntas_examen_encontrado.add(p);        		
			}
		}

		List<Opcion> lista_opciones_completa = servicioEducacionAdapatativa.encontrarOpcionesEnSesion(
				servicioEducacionAdapatativa.kieSession);

		List<Opcion> lista_opciones_buscadas = new ArrayList<Opcion>(); 
		for(Pregunta p: lista_preguntas_examen_encontrado){
			for(Opcion o: lista_opciones_completa){
				if(o.getPregunta().getId_pregunta() == p.getId_pregunta()){
					lista_opciones_buscadas.add(o);
				}
			}
		}


		ObjetoEmpaquetaExamenPreguntasOpciones z = new ObjetoEmpaquetaExamenPreguntasOpciones(
				examen_buscado,
				lista_preguntas_examen_encontrado,
				lista_opciones_buscadas);

		return z;
	}
	
	//mapeo del rest para recuperar todos los historiales de los alumnos
	@RequestMapping(value = "/api/examen/historiales", 
			method = RequestMethod.GET,
			produces = "application/json")

	public List<Historial> recuperarHistoriales(){
		        
		List<Historial> hs= servicioEducacionAdapatativa.recuperarHistoriales(servicioEducacionAdapatativa.kieSession);
		return hs;
	}
	
	//mapeo del rest para recuperar todos las respuestas de los alumnos
	@RequestMapping(value = "/api/examen/respuestas", 
			method = RequestMethod.GET,
			produces = "application/json")

	public List<Respuestas> recuperarRespuestas(){		        
		List<Respuestas> rs= servicioEducacionAdapatativa.recuperarRespuestas(servicioEducacionAdapatativa.kieSession);
		return rs;
	}


}
