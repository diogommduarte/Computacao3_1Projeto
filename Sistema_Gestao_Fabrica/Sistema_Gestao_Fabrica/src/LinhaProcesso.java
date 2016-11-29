import java.io.Serializable;
import java.util.ArrayList;

public class LinhaProcesso implements Serializable {

	
	private static final long serialVersionUID = 1L;

	static protected int nextID = 1;

	protected int idLinha;
	protected int numMaquinas;
	protected int capacidadeProcesso;
	protected int contadorEsforco;

	protected ArrayList<Maquina> maquinasLinhaProcesso;

	public LinhaProcesso(int numMaquinas, int capacidadeProcesso, int contadorEsforco) {

		idLinha = nextID;
		nextID++;

		this.capacidadeProcesso = capacidadeProcesso;
		this.contadorEsforco = contadorEsforco;
		this.numMaquinas = numMaquinas;
		
		maquinasLinhaProcesso = new ArrayList<Maquina>();

	}
	
	public void adicionaMaquinasLinhaProcesso(Maquina m) {

		maquinasLinhaProcesso.add(m);

	}

	

	public int getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(int idLinha) {
		this.idLinha = idLinha;
	}

	public int getNumMaquinas() {
		return numMaquinas;
	}

	public void setNumMaquinas(int numMaquinas) {
		this.numMaquinas = numMaquinas;
	}

	public int getCapacidadeProcesso() {
		return capacidadeProcesso;
	}

	public void setCapacidadeProcesso(int capacidadeProcesso) {
		this.capacidadeProcesso = capacidadeProcesso;
	}

	public int getContadorEsforco() {
		return contadorEsforco;
	}

	public void setContadorEsforco(int contadorEsforco) {
		this.contadorEsforco = contadorEsforco;
	}
	
public Maquina getPrimeiraMaquina() {
		
		return maquinasLinhaProcesso.get(0);
	}

	public String toString() {

		return "ID Linha de Processo: " + idLinha + "Número de Máquinas: " + numMaquinas ;
		
	}



	

}
