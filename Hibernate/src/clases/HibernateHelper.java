package clases;
import java.util.HashSet;

import model.Preguntas;
import model.Respuestas;

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
}
