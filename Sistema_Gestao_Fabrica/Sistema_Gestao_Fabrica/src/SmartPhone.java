import java.io.Serializable;

public class SmartPhone extends ItemTecnologico implements Serializable {

	protected int capacidadeMemoria;

	public SmartPhone( String descricao, int peso, String tipo, int cenQuadrados,
			int capacidadeMemoria) {
		super( descricao, peso, tipo, cenQuadrados);
		this.capacidadeMemoria = capacidadeMemoria;
		esforcoProcesso = calculaEsforco();
	}

	public int calculaEsforco() {
		return 1 * capacidadeMemoria + 5 * cenQuadrados;
	}

	public int getCapacidadeMemoria() {
		return capacidadeMemoria;
	}

	public void setCapacidadeMemoria(int capacidadeMemoria) {
		this.capacidadeMemoria = capacidadeMemoria;
	}

}
