package programas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtils;

public class Main {
	public static void main(String[] args) {
		  SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
	       Session session = sessionFactory.openSession();
		try {
            Parte1.obtenerDetallesEncuentro(session);  
            Parte1.obtenerDetallesProfesor(session);  
            Parte1.actualizarEncuentro(session);  
			Parte2.ejecutarConsultas(session);
            
        } finally {
            session.close();
        }
		}
	}


