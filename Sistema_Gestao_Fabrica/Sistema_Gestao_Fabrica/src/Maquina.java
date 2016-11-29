import java.io.Serializable;
import java.util.ArrayList;

public class Maquina implements Serializable {

	static protected int nextID = 1;

	protected int idMaquina;
	protected int capacidadeProcesso;
	protected boolean temLP = false;
	ArrayList<Item> itemsMaquina;
	 
	
	

	public Maquina(int capacidadeProcesso) {

		idMaquina = nextID;
		nextID++;
		this.capacidadeProcesso = capacidadeProcesso;
		
		itemsMaquina = new ArrayList<Item>();
		
		
	}
	
	
	

	public boolean isTemLP() {
		return temLP;
	}




	public void setTemLP(boolean temLP) {
		this.temLP = temLP;
	}




	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public int getCapacidadeProcesso() {
		return capacidadeProcesso;
	}

	public void setCapacidadeProcesso(int capacidadeProcesso) {
		this.capacidadeProcesso = capacidadeProcesso;
	}
	
	public void adicionaItem(Item i){
		itemsMaquina.add(i);
	}
	
	public void print(){
		System.out.println("ID Máquina: " + idMaquina);
		System.out.println("Capacidade Processo: " + capacidadeProcesso);
	}

}
