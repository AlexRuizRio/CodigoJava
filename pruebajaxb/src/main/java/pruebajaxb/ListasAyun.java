package pruebajaxb;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

public class ListasAyun {
	private ArrayList<Ayuntamiento> ayun;
	
	public ListasAyun() {}
	
	public ArrayList<Ayuntamiento> getListAyun() {
		return ayun;
	}
	
    @XmlElementWrapper(name = "ayuntamientos")
    @XmlElement(name = "ayuntamiento")
	public void setListAyun(ArrayList<Ayuntamiento> ayun) {
		this.ayun = ayun;
	}
}
