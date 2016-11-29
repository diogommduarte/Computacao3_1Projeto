
public class EventoOneOff implements Evento{
	
	protected Item i;
	protected LinhaProcesso lp;
	protected int timeStep;
	
	

	public EventoOneOff(Item i, LinhaProcesso lp, int timeStep) {
		
		this.i = i;
		this.lp = lp;
		this.timeStep = timeStep;
	}



	public void lancarEvento()
	{
		lp.getPrimeiraMaquina().adicionaItem(i);
	}

}
