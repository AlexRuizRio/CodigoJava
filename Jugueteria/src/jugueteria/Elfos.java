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
		while (contador < maxjuguetes) {
			try {
				Jugueteria.semHuecosEstan.acquire();
				String tipo = tipos[ran.nextInt(tipos.length)];
				int jugueteid = Jugueteria.getNextId();
				Juguete Njuguete = new Juguete (jugueteid, tipo);
				
				synchronized (Jugueteria.estanteria) {
					Thread.sleep(1000, ran.nextInt(3000));
					Jugueteria.estanteria.add(Njuguete);
					Jugueteria.semJugueteDis.release();
					System.out.println("El elfo numero " + id + " deposito en la estanteria una " + Njuguete.getTipo());
					contador++;
					System.out.println("ESTANTERÍA ACTUAL: " + Jugueteria.estanteria.size());
				}

			}catch (Exception e) {
				System.out.println("fallo en niños malos");
				e.printStackTrace();
			}
		}
		System.out.println("El elfo numero " + id + " creo TODOS sus juguetes");
	}
}

