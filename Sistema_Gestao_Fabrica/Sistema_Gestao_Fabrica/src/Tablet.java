import java.io.Serializable;

public class Tablet extends ItemTecnologico implements Serializable {

	public Tablet( String descricao, int peso, String tipo, int cenQuadrados) {
		super( descricao, peso, tipo, cenQuadrados);
		esforcoProcesso = calculaEsforco();
	}
	
	public int calculaEsforco() {
		return 10*cenQuadrados;
	}
	
	

}
