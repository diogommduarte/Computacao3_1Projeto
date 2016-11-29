import java.io.Serializable;
import java.util.ArrayList;

public class Fabrica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nomeFabrica;
	protected int numSemana = 1;
	protected int timeStep = 0;
	protected int totalTimeStep = 0;

	ArrayList<Fabrica> fabrica;
	ArrayList<LinhaProcesso> linhaProcesso;
	ArrayList<Empregados> engenheiros;
	ArrayList<Empregados> naoengenheiros;
	ArrayList<Utilizador> utilizador;
	ArrayList<Item> item;
	ArrayList<Empregados> limpeza;
	ArrayList<Maquina> maquina;
	ArrayList<EventoRecorrente> listaEventosRecorrentes;

	public Fabrica(String nomeFabrica, int numSemana, int timeStep) {
		this.nomeFabrica = nomeFabrica;
		this.numSemana = numSemana;
		this.timeStep = timeStep;

		linhaProcesso = new ArrayList<LinhaProcesso>();
		fabrica = new ArrayList<Fabrica>();
		engenheiros = new ArrayList<Empregados>();
		naoengenheiros = new ArrayList<Empregados>();
		utilizador = new ArrayList<Utilizador>();
		item = new ArrayList<Item>();
		limpeza = new ArrayList<Empregados>();
		maquina = new ArrayList<Maquina>();
		listaEventosRecorrentes = new ArrayList<EventoRecorrente>();
		
	}
	
	
public int[] getNumSemanaTimeStep(int newTimeStep){
		
	totalTimeStep += newTimeStep;
	int[] temp = new int[2];
		
	temp[0] = (int)(totalTimeStep/1000 + 1);
	temp[1] = totalTimeStep - ((temp[0] - 1) * 1000);

		return temp;
		
	}


public void adicionaMaquina(Maquina m) {

	maquina.add(m);

}

public void printMaquina() {

	for (int i = 0; i < maquina.size(); i++) {
		maquina.get(i).print();
	}

}


public void printEventoRecorrente() {

	for (int i = 0; i < listaEventosRecorrentes.size(); i++) {
		listaEventosRecorrentes.get(i).print();
	}

}


	public void adicionaLimpeza(Empregados e) {

		limpeza.add(e);

	}

	public void printLimpeza() {

		for (int i = 0; i < limpeza.size(); i++) {
			limpeza.get(i).print();
		}

	}
	
	
	
	public void adicionaItem(Item i) {

		item.add(i);

	}

	public void printItem() {

		for (int i = 0; i < item.size(); i++) {
			System.out.println(item.get(i).toString());
		}

	}
	public void adicionaUtilizador(Utilizador l) {

		utilizador.add(l);

	}
	
	public void printUtilizador() {

		for (int i = 0; i < utilizador.size(); i++) {
			utilizador.get(i).print();
		}

	}

	public void adicionaLinhaProcesso(LinhaProcesso l) {

		linhaProcesso.add(l);

	}

	public void printLinhaProcesso() {

		for (int i = 0; i < linhaProcesso.size(); i++) {
			System.out.println(linhaProcesso.get(i).toString());
		}

	}
	
	public void adicionaEngenheiros(Empregados e)
	{
		engenheiros.add(e);
	}
	
	
	
	public void adicionaNaoEngenheiros(Empregados ne)
	{
		naoengenheiros.add(ne);
	}
	
	public void printEngenheiros() {

		for (int i = 0; i < engenheiros.size(); i++) {
			engenheiros.get(i).print();
		}

	}
	
	public void printNaoEngenheiros() {

		for (int i = 0; i < naoengenheiros.size(); i++) {
			naoengenheiros.get(i).print();
		}

	}
	
	public void adicionaFabrica(Fabrica f) {

		fabrica.add(f);

	}

	public void printFabrica() {

		for (int i = 0; i < fabrica.size(); i++) {
			fabrica.get(i).print();
		}

	}
	
	

	public String getNomeFabrica() {
		return nomeFabrica;
	}

	public void setNomeFabrica(String nomeFabrica) {
		this.nomeFabrica = nomeFabrica;
	}

	public int getNumSemana() {
		return numSemana;
	}

	public void setNumSemana(int numSemana) {
		this.numSemana = numSemana;
	}

	public int getTimeStep() {
		return timeStep;
	}

	public void setTimeStep(int timeStep) {
		this.timeStep = timeStep;
	}

	public void print() {

		System.out.println("Nome da Fábrica: " + nomeFabrica);
		System.out.println("Semana de Trabalho: " + numSemana);
		System.out.println("TimeStep: " + timeStep);
	}
	


}
