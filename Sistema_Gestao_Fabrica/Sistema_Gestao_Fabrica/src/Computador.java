import java.io.Serializable;

public class Computador extends ItemTecnologico implements Serializable {

	public Computador( String descricao, int peso, String tipo, int cenQuadrados) {
		super( descricao, peso, tipo, cenQuadrados);
		esforcoProcesso = calculaEsforco();
	}
	
	public int calculaEsforco() {
		return (10*cenQuadrados + 20*peso);
	}

}
