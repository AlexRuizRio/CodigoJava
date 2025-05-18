package pruebajaxb;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.persistence.internal.oxm.schema.model.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) {
		try {
			ListasAyun ListAyun = new ListasAyun();
			ArrayList<Ayuntamiento> ListaDeAyuntamiento = new ArrayList<Ayuntamiento>();
			File file = new File("escrutinio_municipales_2015.xml");
			DocumentBuilderFactory Dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Dbuilder = Dbfactory.newDocumentBuilder();
			Document doc = Dbuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList nodos = doc.getElementsByTagName("escrutinio_sitio");
			for (int x = 0; x < nodos.getLength(); x++) {
				Element elem = (Element) nodos.item(x);
				String ts = elem.getElementsByTagName("ts").item(0).getTextContent();
				String nombre = elem.getElementsByTagName("nombre_sitio").item(0).getTextContent();
				int concejales = Integer.parseInt(elem.getElementsByTagName("num_a_elegir").item(0).getTextContent());
				Ayuntamiento ayun = new Ayuntamiento(nombre, ts, concejales);
				ListaDeAyuntamiento.add(ayun);
			}
			ListAyun.setListAyun(ListaDeAyuntamiento);
			JAXBContext context = JAXBContext.newInstance(ListasAyun.class);
			Marshaller mashaller = context.createMarshaller();
			File nuevo = new File("nuevo.xml");
			mashaller.marshal(ListAyun, nuevo);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
