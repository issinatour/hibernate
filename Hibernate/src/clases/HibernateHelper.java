package clases;
import java.util.HashSet;
import java.util.List;

import model.Preguntas;
import model.Respuestas;

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
}
