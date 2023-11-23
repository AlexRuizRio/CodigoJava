import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            // Cargar el documento XML de entrada
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("escrutinio_municipales_2015.xml"));

            // Crear objeto DatosCenso para almacenar los datos
            DatosCenso datosCenso = new DatosCenso();

            // Leer y procesar los elementos necesarios utilizando DOM
            NodeList ayuntamientoNodes = document.getElementsByTagName("nombre_sitio");

            for (int i = 0; i < ayuntamientoNodes.getLength(); i++) {
                Element ayuntamientoElement = (Element) ayuntamientoNodes.item(i);

                // Crear objeto Ayuntamiento y asignar valores
                Ayuntamiento ayuntamiento = new Ayuntamiento();
                ayuntamiento.setNombre(ayuntamientoElement.getElementsByTagName("nombre").item(0).getTextContent());
                // Otros campos de Ayuntamiento

                // Agregar el Ayuntamiento a la lista de ayuntamientos en DatosCenso
                datosCenso.getAyuntamientos().add(ayuntamiento);
            }

            // Operación de Marshall para crear el fichero de salida
            marshalToXML(datosCenso, "censo.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void marshalToXML(DatosCenso datosCenso, String fileName) {
        try {
            // Crear contexto JAXB y marshaller
            JAXBContext context = JAXBContext.newInstance(DatosCenso.class);
            Marshaller marshaller = context.createMarshaller();

            // Configurar la salida con formato legible
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Escribir el objeto DatosCenso en el fichero XML
            marshaller.marshal(datosCenso, new File(fileName));

            System.out.println("Operación de Marshall completada con éxito. El archivo " + fileName + " ha sido creado.");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    private static void handleException(Exception e) {
        // Manejar la excepción de alguna manera (imprimir mensaje, registrar, etc.)
        System.err.println("Se ha producido un error: " + e.getMessage());
        e.printStackTrace();
    }
}