package jugueteria;

import java.util.Random;

public class Elfos implements Runnable{
	private final int id;
	private final int maxjuguetes;
    private static final Random ran = new Random();
	private static final String[] tipos = {"muñeco", "vehiculo", "arma", "pelota"};

	
	public Elfos (int id, int maxjuguetes)
	{
		this.id = id;
		this.maxjuguetes = maxjuguetes;
	}
	
	public void run () {
		int contador = 0;
		while (contador <= maxjuguetes) {
			try {
				Jugueteria.semHuecosEstan.acquire();
				String tipo = tipos[ran.nextInt(tipos.length)];
				int jugueteid = Jugueteria.getNextId();
				Juguete Njuguete = new Juguete (jugueteid, tipo);
				
				Thread.sleep(1000, ran.nextInt(3000));
				synchronized (Jugueteria.estanteria) {
					Jugueteria.estanteria.add(Njuguete);
					System.out.println("El elfo numero " + id + " deposito en la estanteria una " + Njuguete.getTipo());
				}
				Jugueteria.semJugueteDis.release();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("El elfo numero" + id + "creo todos sus juguetes");
	}
}

