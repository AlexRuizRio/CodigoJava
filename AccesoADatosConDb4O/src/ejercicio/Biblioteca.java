package ejercicio;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

import modelo.*;

public class Biblioteca {final static String DB4OFILENAME = "Biblioteca.db4o";

public static void main(String[] args) throws ParseException {

	new File(DB4OFILENAME).delete();
	EmbeddedObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	try {
		insertaDatos(db);
		
//		�qu� libros ha prestado "Pablo", "Santos"?
		// Consulta QBE
		
		Prestamo ejemplo = new Prestamo(null, new Lector(2, "2", "Pablo", "Santos", ""), null);
		ObjectSet<Prestamo> resultados = db.queryByExample(ejemplo);

		System.out.println("Libros prestados a Pablo Santos:");
		while (resultados.hasNext()) {
		    Prestamo p = resultados.next();
		    System.out.println("- " + p.getCopia().getLibro().getTitulo());
		}
		
		System.out.println();
		
//		�que lectores no ha devuelto algun prestamo? 
//		Un prestamo no devuelto es el que tiene fecha de devolucion  (ffin) a null
		// Consulta SODA
		
		Query query = db.query();
		query.constrain(Prestamo.class);
		query.descend("ffin").constrain(null);
		ObjectSet<Prestamo> resultprest = query.execute();
		System.out.println("Lectores con préstamos no devueltos:");
		while (resultprest.hasNext()) {
		    Prestamo p = resultprest.next();
		    System.out.println("- " + p.getLector().getNombre() + " " + p.getLector().getApe1() + " " +  p.getLector().getApe2());
		}
		
		System.out.println();
		
//		�qu� lectores tienen o han tenido libros en frances
		// Consulta Nativa
		
		List<Prestamo> resultadosp = db.query(new Predicate<Prestamo>() {
		    public boolean match(Prestamo p) {
		        return p.getCopia().getLibro().getIdioma().equalsIgnoreCase("frances");
		    }
		});
		System.out.println("Lectores que han tenido libros en francés:");
		for (Prestamo p : resultadosp) {
		    System.out.println("- " + p.getLector().getNombre() + " " + p.getLector().getApe1() + " " +  p.getLector().getApe2());
		}
		
		System.out.println();
		
//		lista los datos de todas las copias de un libro: id, estado, titulo, autor, editorial, etc...
		
		//SODA
		
		String tituloBuscado = "REVOLUCION";

		Query query2 = db.query();
		query2.constrain(Copia.class);
		query2.descend("libro").descend("titulo").constrain(tituloBuscado);

		ObjectSet<Copia> copias = query2.execute();

		System.out.println("Copias del libro '" + tituloBuscado + "':");
		for (Copia c : copias) {
		    System.out.println("- ID: " + c.getId() + ", Estado: " + c.getEstado() +
		                       ", Editorial: " + c.getLibro().getEditorial() +
		                       ", Autor: " + c.getLibro().getAutor());
		}

		System.out.println();
		
		//		registra una devolucion de un prestamo pendiente, debes modificar el estado del libro a biblioteca.
		
		int idCopia = 6;
		LocalDate fechaDevolucion = LocalDate.now();

		Query query3 = db.query();
		query3.constrain(Prestamo.class);
		query3.descend("copia").descend("id").constrain(idCopia);

		ObjectSet<Prestamo> prestamos = query3.execute();

		if (!prestamos.isEmpty()) {
		    Prestamo prestamo = prestamos.next();
		    prestamo.setFfin(fechaDevolucion);
		    prestamo.getCopia().setEstado("biblioteca");
		    db.store(prestamo);
		    db.store(prestamo.getCopia());
		    System.out.println("Préstamo devuelto: Copia " + idCopia);
		} else {
		    System.out.println("No se encontró un préstamo pendiente para la copia " + idCopia);
		}

		System.out.println();
		
	} finally {
		db.close();
	}
}

//completa el metodo
//inserta 15 prestamos ten en cuenta las consultas que se piden y asi obtener resultados al aplicarlas.
//
public static void insertaDatos(EmbeddedObjectContainer db) throws ParseException {	
	Lector a1 = new Lector(1, "1", "Juan", "Cornejo", "Lopez");
	Lector a2 = new Lector(2, "2", "Pablo", "Santos", "");
	Lector a3 = new Lector(3, "3", "Dolores", "Ruano", "Go�i");
	Lector a4 = new Lector(4, "4", "Leonor", "Carvajal", "Noguera");
	Lector a5 = new Lector(5, "5", "Catalina", "Sanchez", "Pol");
	Lector a6 = new Lector(6, "6", "Ada", "Cabezas", "Diaz");
	Lector a7 = new Lector(7, "7", "Ruth", "Guerrero", "Sanchez");
	Lector a8 = new Lector(8, "8", "Anton", "Carballo", "Lopez");
	Lector a9 = new Lector(9, "9", "Vicente", "Parrilla", "Godoy");
	Lector a10 = new Lector(10, "10", "Elena", "Diaz", "de la Cruz");
	Lector a11 = new Lector(11, "11", "Carlos", "Ruano", "Guerrero");
	Lector a12 = new Lector(12, "12", "Sandra", "Alvarado", "Arranz");
	Lector a13 = new Lector(13, "13", "Brais", "Blanco", "Rivas");
	Lector a14 = new Lector(14, "14", "Miriam", "Olmedo", "");

//	libros
	Libro l1 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);
	Libro l2 =new Libro("MITOS NORDICOS","ensayo","\r\n"
			+ "BRIDGE", "castellano",2021);

	Libro l3 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);

	Libro l4 =new Libro("SUPERVIVIR. VUELVE AL ORIGEN Y RECUPERA TU SALUD","Medicina divulgativa","GRIJALBO", 
			"castellano",2020);

	Libro l5 =new Libro("REVOLUCION","novela historica","ALFAGUARA", "castellano",2022);


	Libro l6 =new Libro("LA AUTOPISTA LINCOLN","novela contemporanea","SALAMANDRA", "castellano",2022);
	Libro l7 =new Libro("LOS ABRAZOS LENTOS","novela contemporanea","SUMA", "castellano",2021);

	Libro l8 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);

	Libro l9 =new Libro("NOSTALGIA MILENIAL: SOBREVIVIR�","humor","RANDOM COMICS", "castellano",2018);
	Libro l10 =new Libro("THE LAST CHAIRLIFT","novela contemporanea","SIMON & SCHUSTER UK ", "ingles",2019);
	Libro l11 =new Libro("IT ENDS WITH US","novela contemporanea","SIMON & SCHUSTER UK", "ingles",2022);
	Libro l12 =new Libro(" Hamlet","teatro","Oberon Books", "ingles",2018);
	Libro l13 =new Libro("King Lear","teatro","Oberon Books", "ingles",2019);
	Libro l14 =new Libro("Les Pr�cieuses ridicules","teatro","Les Editions Bilboquet", "frances",2018, "Moli�re");
	Libro l15 =new Libro("Cyrano de Bergerac","teatro","ANACROUSE editions", "frances",2018, "Moli�re");
	Libro l16 =new Libro("Les Mis�rables","novela","Les Editions Bilboquet", "frances",2019, "Victor Hugo");	
	Libro l17 =new Libro("Les Feuilles d'automne","poesia","ANACROUSE editions", "frances",2019, "Moli�re");
//copias
	Copia c1 = new Copia(1,"biblioteca", l1);
	Copia c2 = new Copia(2,"biblioteca", l1);
	Copia c3 = new Copia(3,"biblioteca", l1);
	Copia c4 = new Copia(4,"biblioteca", l2);
	Copia c5 = new Copia(5,"biblioteca", l2);
	Copia c6 = new Copia(6,"biblioteca", l3);
	Copia c7 = new Copia(7,"biblioteca", l4);
	Copia c8 = new Copia(8,"biblioteca", l5);
	Copia c9 = new Copia(9,"biblioteca", l6);
	Copia c10 = new Copia(10,"biblioteca", l7);
	Copia c11= new Copia(11,"biblioteca", l7);
	Copia c12= new Copia(12,"biblioteca", l7);
	Copia c13= new Copia(13,"biblioteca", l8);
	Copia c14= new Copia(14,"biblioteca", l8);
	Copia c15= new Copia(15,"biblioteca", l9);
	Copia c16= new Copia(16,"biblioteca", l10);
	Copia c17= new Copia(17,"biblioteca", l11);
	Copia c18=new Copia(18,"biblioteca", l11);
	Copia c19= new Copia(19,"biblioteca", l12);
	Copia c20=new Copia(20,"biblioteca", l13);
	Copia c21 =new Copia(21,"biblioteca", l13);
	Copia c22 = new Copia(22,"biblioteca", l13);
	Copia c23 = new Copia(23,"biblioteca", l13);
	Copia c24 = new Copia(24,"biblioteca", l14);
	Copia c25 = new Copia(25,"biblioteca", l15);
	Copia c26 = new Copia(26,"biblioteca", l15);
	Copia c27 = new Copia(27,"biblioteca", l16);
	Copia c28 = new Copia(28,"biblioteca", l16);
	Copia c29 = new Copia(29,"biblioteca", l17);
	Copia c30 = new Copia(30,"biblioteca", l17);
//	prestamos completar
// 	incluye prestamos no devueltos
//	ten en cuenta que al registrar un prestamo no devuelto debes cambiar el estado del libro a prestado
	 Prestamo p1 = new Prestamo(c1, a1, LocalDate.of(2023, 1, 10));
	    p1.setFfin(LocalDate.of(2023, 1, 20)); // Devuelto

	    Prestamo p2 = new Prestamo(c2, a2, LocalDate.of(2023, 2, 15)); // No devuelto
	    c2.setEstado("prestado");

	    Prestamo p3 = new Prestamo(c3, a3, LocalDate.of(2023, 3, 1));
	    p3.setFfin(LocalDate.of(2023, 3, 10)); // Devuelto

	    Prestamo p4 = new Prestamo(c4, a4, LocalDate.of(2023, 3, 5)); // No devuelto
	    c4.setEstado("prestado");

	    Prestamo p5 = new Prestamo(c5, a5, LocalDate.of(2023, 3, 10));
	    p5.setFfin(LocalDate.of(2023, 3, 20)); // Devuelto

	    Prestamo p6 = new Prestamo(c6, a6, LocalDate.of(2023, 3, 15)); // No devuelto
	    c6.setEstado("prestado");

	    Prestamo p7 = new Prestamo(c7, a7, LocalDate.of(2023, 3, 20));
	    p7.setFfin(LocalDate.of(2023, 3, 30)); // Devuelto

	    Prestamo p8 = new Prestamo(c8, a8, LocalDate.of(2023, 3, 25)); // No devuelto
	    c8.setEstado("prestado");

	    Prestamo p9 = new Prestamo(c9, a9, LocalDate.of(2023, 4, 1));
	    p9.setFfin(LocalDate.of(2023, 4, 10)); // Devuelto

	    Prestamo p10 = new Prestamo(c10, a10, LocalDate.of(2023, 4, 5)); // No devuelto
	    c10.setEstado("prestado");

	    Prestamo p11 = new Prestamo(c11, a11, LocalDate.of(2023, 4, 10));
	    p11.setFfin(LocalDate.of(2023, 4, 20)); // Devuelto

	    Prestamo p12 = new Prestamo(c12, a12, LocalDate.of(2023, 4, 15)); // No devuelto
	    c12.setEstado("prestado");

	    Prestamo p13 = new Prestamo(c13, a13, LocalDate.of(2023, 4, 20));
	    p13.setFfin(LocalDate.of(2023, 4, 30)); // Devuelto

	    Prestamo p14 = new Prestamo(c14, a14, LocalDate.of(2023, 4, 25)); // No devuelto
	    c14.setEstado("prestado");

	    Prestamo p15 = new Prestamo(c15, a1, LocalDate.of(2023, 5, 1));
	    p15.setFfin(LocalDate.of(2023, 5, 10)); // Devuelto

	Copia[] copias = {
		    c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,
		    c11, c12, c13, c14, c15, c16, c17, c18, c19, c20,
		    c21, c22, c23, c24, c25, c26, c27, c28, c29, c30
		};
	Prestamo[] prestamos = {
		    p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
		    p11, p12, p13, p14, p15
		};

		for (Copia c : copias) {
		    try {
		        db.store(c);
		    } catch (Exception e) {
		        System.out.println("No se pudo agregar la copia con ID: " + c.getId());
		        e.printStackTrace(); // Muestra el error para depuración
		    }
		}
		for (Prestamo p : prestamos) {
		    try {
		        db.store(p);
		    } catch (Exception e) {
		        System.out.println("No se pudo agregar el préstamo con Copia ID: " + p.getCopia().getId());
		        e.printStackTrace(); // Muestra el error para depuración
		    }
		}
		Lector[] lectores = {
			    a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
			    a11, a12, a13, a14
			};

			for (Lector l : lectores) {
			    try {
			    	if (!db.ext().isClosed()) {
			    	    db.store(l);
			    	} else {
			    	    System.out.println("Base de datos cerrada, no se puede almacenar: " + l.getNsocio());
			    	}
			    } catch (Exception e) {
			        System.out.println("No se pudo agregar el lector con NSocio: " + l.getNsocio());
			        e.printStackTrace(); // Muestra el error para depuración
			    }
			}
			
			Libro[] libros = {
			    l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,
			    l11, l12, l13, l14, l15, l16, l17
			};

			for (Libro libro : libros) {
			    try {
			        db.store(libro);
			    } catch (Exception e) {
			        System.out.println("No se pudo agregar el libro: " + libro.getTitulo());
			        e.printStackTrace(); // Muestra el error para depuración
			    }
			}
			

//	
}
}
