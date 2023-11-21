public abstract class Pikachu {

	int energia;
	int vida;
	String tipo;	
	
	
	public String toString () {
		
		return "Soy un "+ tipo + ". Mi nivel de energía es : " + energia + " y mi nivel de vida es "+ vida + ".";
	}
	protected abstract void Luchar();
}
