package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Prestamo {
	public Prestamo(Copia copia, Lector lector, LocalDate finicio) {
		super();
		this.copia = copia;
		this.lector = lector;
		this.finicio = finicio;
	}
	Copia copia;
	Lector lector;
	LocalDate finicio;
	LocalDate ffin;

	@Override
	public String toString() {
		return "Prestamo [copia=" + copia + ", lector=" + lector + ", finicio=" + finicio + ", ffin=" + ffin + "]";
	}
	public Copia getCopia() {
		return copia;
	}
	public void setCopia(Copia copia) {
		this.copia = copia;
	}
	public Lector getLector() {
		return lector;
	}
	public void setLector(Lector lector) {
		this.lector = lector;
	}
	public LocalDate getFinicio() {
		return finicio;
	}
	public void setFinicio(LocalDate finicio) {
		this.finicio = finicio;
	}
	public LocalDate getFfin() {
		return ffin;
	}
	public void setFfin(LocalDate ffin) {
		this.ffin = ffin;
	}
	public Prestamo(Copia copia, Lector lector) {
		super();
		this.copia = copia;
		this.lector = lector;
	}

}
