import java.io.Serializable;

public class ArrozBranco extends ItemBiologico implements Serializable {

	public ArrozBranco(String descricao, int peso,  String tipo) {
		super( descricao, peso,  tipo);
		esforcoProcesso = calculaEsforco();
	}
	
	public int calculaEsforco() {
		return 10*peso;
	}
	

}
