
public class EventoRecorrente implements Evento {
	
	static protected int nextID = 1;
	protected int idEventoRecorrente;
	protected Item i;
	protected LinhaProcesso lp;
	protected int timeStep;
	
	
	
	public EventoRecorrente(Item i, LinhaProcesso lp, int timeStep)
	{
		idEventoRecorrente = nextID;
		nextID++;
		this.i=i;
		this.lp=lp;
		this.timeStep=timeStep;
	}

	public int getIdEventoRecorrente() {
		return idEventoRecorrente;
	}

	public void setIdEventoRecorrente(int idEventoRecorrente) {
		this.idEventoRecorrente = idEventoRecorrente;
	}

	public Item getI() {
		return i;
	}

	public void setI(Item i) {
		this.i = i;
	}

	public LinhaProcesso getLp() {
		return lp;
	}

	public void setLp(LinhaProcesso lp) {
		this.lp = lp;
	}

	public int getTimeStep() {
		return timeStep;
	}

	public void setTimeStep(int timeStep) {
		this.timeStep = timeStep;
	}
	
	
	public void lancarEvento()
	{
		lp.getPrimeiraMaquina().adicionaItem(i);
	}
	
	public void print()
	{
		System.out.println("ID: " + idEventoRecorrente + " -> " + "Item: " + getI() + ", LinhaProcesso: " + getLp() + ", TimeStep: " + timeStep);
	}
	

}
