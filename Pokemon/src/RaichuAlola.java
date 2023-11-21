public class RaichuAlola extends Pikachu implements Entrenador {
	


	public void Luchar() {
		
		vida = vida - 1;
		if(vida<0) {
			vida = 0;
		}
		
	}
	public void Entrenar() {
		energia = energia + 1;
	}
	public void Volar() {
		energia = energia - 1;
		if(energia<0) {
			energia = 0;
		}
		
	}
	public RaichuAlola(int vidaIn, int energiaIn, String tipoIn) {
		vida=vidaIn;
		energia=energiaIn;
		tipo = tipoIn;
	}
}