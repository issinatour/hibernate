package clases;
import java.util.HashSet;
import java.util.List;

import model.Preguntas;
import model.Respuestas;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HibernateHelper {

 private SessionFactory sesion;

 public HibernateHelper(){
 sesion = SessionFactoryUtil.getSessionFactory();
 }
 public void addQuestion( String titulo, String categoria,String imagen,int fidPreguntas,String tipo,String consejo){
	 Session session = sesion.openSession();
	 Transaction tx = session.beginTransaction();
	 

	 Preguntas question = new Preguntas(titulo,categoria,imagen,fidPreguntas,tipo,consejo
			 );
	 
	 session.save(question);
	 tx.commit();
	 session.close();
	 }
 
 public void addRespuestas(String respuestas,boolean solucion,int idpregunta){
		
	 Session session = sesion.openSession();
	 Transaction tx = session.beginTransaction();
	 
	 Respuestas respuesta = new Respuestas(respuestas,solucion,idpregunta);
		 
	 
	 session.save(respuesta);
	 tx.commit();
	 session.close();
 }
 
 
 public List<Preguntas> getQuestion(){
		List<Preguntas> questions;
		Session session = sesion.openSession();

		Query query = session.createQuery("from Preguntas");
		questions = query.list();
		session.close();
		
		return questions;

	}
 
 public List<Respuestas> getRespuestas(){
		List<Respuestas> questions;
		Session session = sesion.openSession();

		Query query = session.createQuery("from Respuestas");
		questions = query.list();
		session.close();
		
		return questions;

	}
 
 public Preguntas getLastQuestion(){
		Session session = sesion.openSession();
		
		Query query = session.createQuery("from Preguntas order by idPreguntas DESC");
		query.setMaxResults(1);
		Preguntas last = (Preguntas) query.uniqueResult();
		session.close();

		return last;
		
	}
 public Preguntas getPreguntas(){
		Session session = sesion.openSession();
		
		Query query = session.createQuery("from Preguntas order by idPreguntas DESC");
		Preguntas last = (Preguntas) query.uniqueResult();
		session.close();

		return last;
		
	}
 
 public void  borrarRespuesta(int id){
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Respuestas answer = (Respuestas) session.get(Respuestas.class, (int)id);	
		if(answer!=null){
			session.delete(answer);	
			tx.commit();	
		}
		session.close();
		
	}
 
 public void  borrarPregunta(int id){
	 System.out.println("Borrando id "+id);
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Preguntas answer = (Preguntas) session.get(Preguntas.class, id);	
		if(answer!=null){
			session.delete(answer);	
			tx.commit();
		
		}

		session.close();
	}
 
 

 
 public void updatePreguntas(Preguntas pregunta,int idpregunta ){
     Session session = sesion.openSession();
     Transaction tx = null;
     try{

        tx = session.beginTransaction();
        // seleccinar la pregunta por el id
        Preguntas actualizarmipregunta = (Preguntas)session.get(Preguntas.class, idpregunta); 
        //actualizar pregunta recogida en el row de la tabla
        actualizarmipregunta.setTitulo(pregunta.getTitulo());
        actualizarmipregunta.setCategoria(pregunta.getCategoria());
        actualizarmipregunta.setImagen(pregunta.getImagen());
        actualizarmipregunta.setTipo(pregunta.getTipo());
        actualizarmipregunta.setConsejo(pregunta.getConsejo());
        
        //update and commit cambios
		 session.update(actualizarmipregunta); 
        tx.commit();
     }catch (HibernateException e) {
        if (tx!=null) 
        	tx.rollback();
        e.printStackTrace(); 
     }finally {
        session.close(); 
     }
  }
 
}
