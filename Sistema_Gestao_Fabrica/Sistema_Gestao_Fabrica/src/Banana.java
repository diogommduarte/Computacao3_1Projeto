import java.io.Serializable;

public class Banana extends ItemBiologico implements Serializable {
	
	protected int comprimento;

	public Banana( String descricao, int peso, String tipo, int comprimento) {
		super( descricao, peso,  tipo);
		this.comprimento = comprimento;
		esforcoProcesso = calculaEsforco();
	}
	
	public int calculaEsforco() {
		return 5*comprimento;
	}
	
	
}
