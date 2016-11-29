import java.io.Serializable;

public class ArrozTorrado extends ItemBiologico implements Serializable {

	public ArrozTorrado( String descricao, int peso,  String tipo) {
		super( descricao, peso,  tipo);
		esforcoProcesso = calculaEsforco();
		
	}
	
	public int calculaEsforco() {
		return 20*peso;
	}

}
