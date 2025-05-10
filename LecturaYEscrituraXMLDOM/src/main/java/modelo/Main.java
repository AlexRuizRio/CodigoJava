package modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.*;

public class Main {
	 public static void main(String[] args) {
	        try {
	            // 1. Leer XML de entrada
	            File inputFile = new File("escrutinio_municipales_2015.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document inputDoc = dBuilder.parse(inputFile);
	            inputDoc.getDocumentElement().normalize();

	            NodeList municipios = inputDoc.getElementsByTagName("escrutinio_sitio");

	            // 2. Crear nuevo XML (salida)
	            Document outputDoc = dBuilder.newDocument();

	            // Raíz <censo>
	            Element rootElement = outputDoc.createElement("censo");
	            outputDoc.appendChild(rootElement);

	            int totalVotantes = 0;
	            int totalConcejales = 0;
	            float sumaPorcentajesBlanco = 0;

	            // <ayuntamientos>
	            Element ayuntamientosElem = outputDoc.createElement("ayuntamientos");

	            for (int i = 0; i < municipios.getLength(); i++) {
	                Element mun = (Element) municipios.item(i);

	                String ts = mun.getElementsByTagName("ts").item(0).getTextContent();
	                String nombre = mun.getElementsByTagName("nombre_sitio").item(0).getTextContent();
	                int concejales = Integer.parseInt(mun.getElementsByTagName("num_a_elegir").item(0).getTextContent());

	                int contabilizados = Integer.parseInt(((Element) mun.getElementsByTagName("contabilizados").item(0))
	                        .getElementsByTagName("cantidad").item(0).getTextContent());

	                int abstenciones = Integer.parseInt(((Element) mun.getElementsByTagName("abstenciones").item(0))
	                        .getElementsByTagName("cantidad").item(0).getTextContent());

	                int votantes = contabilizados + abstenciones;

	                float porBlanco = Float.parseFloat(((Element) mun.getElementsByTagName("blancos").item(0))
	                        .getElementsByTagName("porcentaje").item(0).getTextContent().replace(",", "."));

	                totalVotantes += votantes;
	                totalConcejales += concejales;
	                sumaPorcentajesBlanco += porBlanco;

	                // Crear <ayuntamiento>
	                Element aytoElem = outputDoc.createElement("ayuntamiento");

	                Element tsElem = outputDoc.createElement("ts");
	                tsElem.appendChild(outputDoc.createTextNode(ts));
	                aytoElem.appendChild(tsElem);

	                Element nombreElem = outputDoc.createElement("nombre");
	                nombreElem.appendChild(outputDoc.createTextNode(nombre));
	                aytoElem.appendChild(nombreElem);

	                Element concejalesElem = outputDoc.createElement("concejales");
	                concejalesElem.appendChild(outputDoc.createTextNode(String.valueOf(concejales)));
	                aytoElem.appendChild(concejalesElem);

	                Element votantesElem = outputDoc.createElement("votantes");
	                votantesElem.appendChild(outputDoc.createTextNode(String.valueOf(votantes)));
	                aytoElem.appendChild(votantesElem);

	                Element blancoElem = outputDoc.createElement("porcentaje_blancos");
	                blancoElem.appendChild(outputDoc.createTextNode(String.format("%.2f", porBlanco)));
	                aytoElem.appendChild(blancoElem);

	                // Añadir ayuntamiento a <ayuntamientos>
	                ayuntamientosElem.appendChild(aytoElem);
	            }

	            float mediaPorcentaje = sumaPorcentajesBlanco / municipios.getLength();

	            // Añadir <titulo>
	            Element titulo = outputDoc.createElement("titulo");
	            titulo.appendChild(outputDoc.createTextNode("Datos censo ayuntamientos Comunidad de Madrid"));
	            rootElement.appendChild(titulo);

	            // Añadir totales
	            Element totalV = outputDoc.createElement("total_votantes");
	            totalV.appendChild(outputDoc.createTextNode(String.valueOf(totalVotantes)));
	            rootElement.appendChild(totalV);

	            Element totalC = outputDoc.createElement("total_concejales");
	            totalC.appendChild(outputDoc.createTextNode(String.valueOf(totalConcejales)));
	            rootElement.appendChild(totalC);

	            Element totalBlanco = outputDoc.createElement("total_porblanco");
	            totalBlanco.appendChild(outputDoc.createTextNode(String.format("%.2f", mediaPorcentaje)));
	            rootElement.appendChild(totalBlanco);

	            // Añadir <ayuntamientos> al root
	            rootElement.appendChild(ayuntamientosElem);

	            // 3. Guardar XML en archivo
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	            DOMSource source = new DOMSource(outputDoc);
	            StreamResult result = new StreamResult(new File("censo.xml"));
	            transformer.transform(source, result);

	            System.out.println("Archivo censo.xml generado correctamente usando solo DOM.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
