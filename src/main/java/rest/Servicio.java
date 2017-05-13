package rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.modelo.*;

@Service
public class Servicio {

    private static Logger log = LoggerFactory.getLogger(Servicio.class);

    private final KieContainer kieContainer;
    public KieSession kieSession;

    //iniciar el servicio y ligarlo con el contenedor de la base de conocimiento
    @Autowired
    public Servicio(KieContainer kieContainer) {
        log.info("Generar nuevo servicio para el sistema educativo adaptativo.");
        this.kieContainer = kieContainer;
        this.kieSession = kieContainer.newKieSession("SesionActual");
        kieSession.fireAllRules();
    }

    //metodo para encontrar un alumno a traves de su matricula
    public Alumno encontrarAlumnoPorMatricula(Alumno alumno_buscado) {    	
        
        // el metodo encontrarAlumnoEnSesion devuelve la lista de todos los alumnos en la memoria
        //de trabajo, es responsabilidad nuestra buscar entre todos para recuperar el de la matricula que
        //buscamo
        List<Alumno> alumno_encontrado = encontrarAlumnoEnSesion(kieSession);
        if(alumno_encontrado!=null){
	        for(Alumno a: alumno_encontrado){
	        	if(a.getMatricula().equalsIgnoreCase(alumno_buscado.getMatricula())){
	        		return a;
	        	}
	        }
    	}
        
        //alumno con mensaje de error 
        return new Alumno(0, "no existe alumno con esa matricula", alumno_buscado.getMatricula(), 0);
    }
    
    
    
  //metodo para encontrar un examen por su id
    public Examen encontrarExamenPorID(Examen examen_buscado) {    	
    	
        List<Examen> examenes = encontrarExamenesEnSesion(kieSession);
        if(examenes!=null){
	        for(Examen e: examenes){
	        	if(e.getId_examen() == (examen_buscado.getId_examen())){
	        		return e;
	        	}
	        }
    	}
        return new Examen(0, null, null, "error no existe examen");
    }
    
  //metodo para encontrar una pregunta por su id
    public Pregunta encontrarPreguntaPorID(Pregunta pregunta_buscada) {    	
    	
        List<Pregunta> preguntas = encontrarPreguntasEnSesion(kieSession);
        if(preguntas!=null){
	        for(Pregunta p: preguntas){
	        	if(p.getId_pregunta() == (pregunta_buscada.getId_pregunta())){
	        		return p;
	        	}
	        }
    	}
        return new Pregunta(0, null, "error no existe la pregunta", 0);
    }
    
    
    //metodo para insertar nuevo alumno
    public void insertarAlumno(Alumno alumno_a_insertar){
        kieSession.insert(alumno_a_insertar);
    }
    
  //metodo para insertar nuevo historial
    public void insertarHistorial(Historial h){
        kieSession.insert(h);
    }
    
    //metodo para insertar nueva respuesta
    public void insertarRespuesta(Respuestas r){
        kieSession.insert(r);
    }
    
    //devolver la lista de alumnos actuales que hay en la sesion activa
    private List<Alumno> encontrarAlumnoEnSesion(KieSession kieSession) {    	
    	imprimirBaseConocimiento(kieSession);        
    	//generacion del filtro global de clases de la base de datos
        ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Alumno.class.equals(object.getClass())) return true;
                if (Alumno.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        //busca todos los objetos de la clase Alumno en el filtro y los agrega a una lista
        List<Alumno> alumnos = new ArrayList<Alumno>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	alumnos.add((Alumno) kieSession.getObject(handle));
        }
        
        //si no hay alumnos en la base devuelve nulo
        if (alumnos.size() == 0) {
            return null;
        }        
        return alumnos;
    }
    
    //funcion para recuperar los historiales de todos los alumnos
    public List<Historial> recuperarHistoriales(KieSession kieSession){
    	ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Historial.class.equals(object.getClass())) return true;
                if (Historial.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        List<Historial> historiales = new ArrayList<Historial>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	historiales.add((Historial) kieSession.getObject(handle));
        }
        if (historiales.size() == 0) {
            return null;
        }        
        return historiales;
    }
    
    //funcion para recuperar las respuestas de todos los alumnos
    public List<Respuestas> recuperarRespuestas(KieSession kieSession){
    	ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Respuestas.class.equals(object.getClass())) return true;
                if (Respuestas.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        List<Respuestas> respuestas = new ArrayList<Respuestas>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	respuestas.add((Respuestas) kieSession.getObject(handle));
        }
        if (respuestas.size() == 0) {
            return null;
        }        
        return respuestas;
    }
    
    
  //devolver la lista de examenes actuales
    public List<Examen> encontrarExamenesEnSesion(KieSession kieSession) {    	
    	imprimirBaseConocimiento(kieSession);        
        ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Examen.class.equals(object.getClass())) return true;
                if (Examen.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        List<Examen> examenes = new ArrayList<Examen>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	examenes.add((Examen) kieSession.getObject(handle));
        }
        if (examenes.size() == 0) {
            return null;
        }        
        return examenes;
    }
    
  //devolver la lista de preguntas actuales
    public  List<Pregunta> encontrarPreguntasEnSesion(KieSession kieSession) {    	
    	imprimirBaseConocimiento(kieSession);        
        ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Pregunta.class.equals(object.getClass())) return true;
                if (Pregunta.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        List<Pregunta> preguntas = new ArrayList<Pregunta>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	preguntas.add((Pregunta) kieSession.getObject(handle));
        }
        if (preguntas.size() == 0) {
            return null;
        }        
        return preguntas;
    }
    
  //devolver la lista de opciones actuales
    public  List<Opcion> encontrarOpcionesEnSesion(KieSession kieSession) {    	
    	imprimirBaseConocimiento(kieSession);        
        ObjectFilter filtro = new ObjectFilter() {
            public boolean accept(Object object) {
                if (Opcion.class.equals(object.getClass())) return true;
                if (Opcion.class.equals(object.getClass().getSuperclass())) return true;
                return false;
            }           
        };        
        List<Opcion> opciones = new ArrayList<Opcion>();
        for (FactHandle handle : kieSession.getFactHandles(filtro)) {
        	opciones.add((Opcion) kieSession.getObject(handle));
        }
        if (opciones.size() == 0) {
            return null;
        }        
        return opciones;
    }
    
    //para motivos de debugging
    public  void imprimirBaseConocimiento(KieSession kieSession) {
        Collection<FactHandle> handlesHechos= kieSession.getFactHandles();
        
        String mensajeAConsola = "\nTodos los hechos en la base de conocimiento en este momento:\n";
        for (FactHandle handle : handlesHechos) {
            mensajeAConsola += "    " + kieSession.getObject(handle) + "\n";
        }
        System.out.println(mensajeAConsola);
    }
    
    
    
    

}
