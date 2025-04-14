package jugueteria;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Semaphore;

public class Jugueteria {
	public static final Semaphore semJugueteDis = new Semaphore (7, true);
	public static final List<Juguete> estanteria = Collections.synchronizedList(new ArrayList<>());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
