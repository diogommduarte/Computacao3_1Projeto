
public abstract class ItemTecnologico extends Item  {

	protected int cenQuadrados;
	
	public ItemTecnologico( String descricao, int peso,   String tipo, int cenQuadrados) {
		super( descricao, peso,  tipo);
		this.cenQuadrados=cenQuadrados;
		
	}

	public int getCenQuadrados() {
		return cenQuadrados;
	}
	
	public void setCenQuadrados(int cenQuadrados) {
		this.cenQuadrados = cenQuadrados;
	}
}
