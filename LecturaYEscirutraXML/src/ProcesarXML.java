import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ProcesarXML {

	public static void main(String[] args) {
        try {
            // Configuración para SAX
            ManejadorSAX manejadorSAX = new ManejadorSAX();
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("estudiantes.xml"), manejadorSAX);

            // Obtener la lista de estudiantes del manejador SAX
            ListaEstudiantes listaEstudiantes = manejadorSAX.getListaEstudiantes();

            // Crear el archivo con DOM
            crearArchivoDOM(listaEstudiantes, "alumnos.xml");

        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
	private static void crearArchivoDOM(ListaEstudiantes listaEstudiantes, String nombreArchivo)
            throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // Crear el documento DOM
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("lista_alumnos");
        doc.appendChild(rootElement);

        // Obtener la lista de estudiantes
        List<Estudiante> estudiantes = listaEstudiantes.getEstudiantes();

        // Verificar si hay estudiantes antes de crear elementos
        if (!estudiantes.isEmpty()) {
            // Recorrer la lista de estudiantes y agregar elementos <estudiante>
            for (Estudiante estudiante : estudiantes) {
                Element estudianteElement = doc.createElement("estudiante");
                rootElement.appendChild(estudianteElement);

                Element nombreElement = doc.createElement("nombre");
                nombreElement.appendChild(doc.createTextNode(estudiante.getNombre()));
                estudianteElement.appendChild(nombreElement);

                Element apellidoElement = doc.createElement("apellido");
                apellidoElement.appendChild(doc.createTextNode(estudiante.getApellido()));
                estudianteElement.appendChild(apellidoElement);
            }
        }

        // Transformar el documento DOM a un archivo XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nombreArchivo));

        transformer.transform(source, result);
        System.out.println("Archivo " + nombreArchivo + " creado exitosamente.");
    }
}


