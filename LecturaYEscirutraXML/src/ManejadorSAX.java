import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class ManejadorSAX extends DefaultHandler {
    private ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
    private Estudiante estudiante;
    private StringBuilder contenido;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        contenido = new StringBuilder();
        if (qName.equalsIgnoreCase("estudiante")) {
            estudiante = new Estudiante();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        contenido.append(new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("nombre")) {
            estudiante.setNombre(contenido.toString().trim());
        } else if (qName.equalsIgnoreCase("apellidos")) {
            estudiante.setApellido(contenido.toString().trim());
        } else if (qName.equalsIgnoreCase("estudiante")) {
            listaEstudiantes.agregarEstudiante(estudiante);
        }
    }

    public ListaEstudiantes getListaEstudiantes() {
        return listaEstudiantes;
    }
}