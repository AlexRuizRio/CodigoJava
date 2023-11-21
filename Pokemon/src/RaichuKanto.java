public class RaichuKanto extends Pikachu {
	
	public RaichuKanto (int vidaIn, int energiaIn, String tipoIn) {
		
		vida =vidaIn;
		energia =energiaIn;
		tipo = tipoIn;
	}
	
	public void Luchar() {
		vida = vida - 2;
		if(vida<0) {
			vida = 0;
		}
	}
	public void Entrenar() {
		energia= energia + 1;
		if(energia<0) {
			energia = 0;
		}
	}
}
