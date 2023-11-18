import java.util.HashSet;

public class BarajaFra {

	HashSet <String> BarajaFrancesa =new HashSet<>();
	
	void formarBaraja () {
	
	for (int y = 1; y <= 10; y++) {
		BarajaFrancesa.add(y + " de Rombos");
		
	}
	for ( int i = 1; i <= 10; i++) {
		BarajaFrancesa.add(i + " de Corazones");
		
	}
	for (int z = 1; z <= 10; z++) {
		BarajaFrancesa.add(z + " de Picas");
		
	}
	for (int c = 1; c <= 10; c++) {
		BarajaFrancesa.add(c + " de Treboles");
		
	}
	BarajaFrancesa.add("Sota de Rombos");
	BarajaFrancesa.add("Dama de Rombos");
	BarajaFrancesa.add("Rey de Rombos");
	BarajaFrancesa.add("Sota de Corazones");
	BarajaFrancesa.add("Dama de Corazones");
	BarajaFrancesa.add("Rey de Corazones");
	BarajaFrancesa.add("Sota de Picas");
	BarajaFrancesa.add("Caballo de Picas");
	BarajaFrancesa.add("Rey de Picas");
	BarajaFrancesa.add("Sota de Treboles");
	BarajaFrancesa.add("Caballo de Treboles");
	BarajaFrancesa.add("Rey de Treboles");


}
}

