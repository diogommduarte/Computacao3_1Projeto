
public abstract class  Item {

	static protected int nextID = 1;
	
	protected int idItem; 
	protected String descricao;
	protected int peso;
	protected int esforcoProcesso;
	protected String tipo;
	
	public Item( String descricao, int peso,  String tipo){
		
		idItem = nextID;
		nextID++;
		this.descricao=descricao;
		this.peso=peso;
		
		this.tipo=tipo;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getEsforcoProcesso() {
		return esforcoProcesso;
	}

	public void setEsforcoProcesso(int esforcoProcesso) {
		this.esforcoProcesso = esforcoProcesso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return "Id:" + idItem + " -> " + "Tipo de Item: " + tipo + ", Descrição: " + descricao + "Esforco Processo: " + esforcoProcesso;
		
	}
	
	public abstract int calculaEsforco();
	
	
	
}
