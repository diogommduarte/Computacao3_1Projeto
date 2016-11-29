import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;

public class Main {

	public static void writeObjectToFile(Object object, String filename) {
		try {
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename));
			ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
			objectOutput.writeObject(object);
			objectOutput.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	public static Object readObjectFromFile(String filename) {
		Object object = null;
		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(filename));
			ObjectInput objectInput = new ObjectInputStream(inputStream);
			object = objectInput.readObject();
			objectInput.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return object;
	}

	static String nomeFabrica;
	static int numSemana, timeStep;
	static boolean haEngenheiros = false;
	static Scanner a = new Scanner(System.in);

	static Fabrica fabrica = new Fabrica(nomeFabrica, 0, 0);

	public static void main(String[] args) {

		entrar();

	}

	public static void entrar() {

		String username;
		String password;
		System.out.println("*******Area de Login*******");
		System.out.println("Username: "); 
		username = a.nextLine();
		System.out.println("Password: ");
		password = a.nextLine();

		Entrar entrar = new Entrar(username, password);

		Object fileUtilizadores = readObjectFromFile("Utilizador.obj");

		Utilizador lista = (Utilizador) fileUtilizadores; 

		//Utilizador var = lista;

		if ((entrar.getUser().equals("admin") && entrar.getPassword().equals("admin"))
				|| (lista.getUser().equals(username) && lista.getPassword().equals(
						password)))
		{
			System.out.println("Login efectuado com sucesso!!");
			
			System.out.println("\n*******Insira o nome da fábrica*******");
			nomeFabrica = a.nextLine();
		}
		
		

		else {
			System.out.println("Erro no login, tente novamente");
			entrar();
		}
		
		sistema();

		a.close();

	}

	public static void sistema() {

		String username;
		String password;
		int voltarinserirutilizador;
		int inserirLinhaProcesso;
		int numMaquinasLinhaProcesso;
		String nomeEmpregado;
		String tipoEmpregado;
		double salarioEmpregado;
		String descricaoItem;
		int pesoItem;
		int esforcoProcessoItem;
		String tipoItem;
		int capacidadeMemoriaItemTec;
		int cenQuadradosItemTec;
		int comprimentoItem;
		int idApagarItem;
		int idApagarEmpregado;
		int voltarInserirTimeStep;
		int capacidadeProcessoMaquina;
		int repeteaddMaquina;
		int idItemEvento;
		int idApagarEventoRecorrente;

		System.out.println("\t\t\tMenu da " + nomeFabrica);
		System.out.println("1-Deseja registar ou apagar algum utilizador?");
		System.out.println("2-Inserir ou apagar item");
		System.out.println("3-Inserir ou apagar máquina");
		System.out.println("4-Inserir ou apagar linha de processo");
		System.out.println("5-Inserir ou apagar evento");
		System.out.println("6-Inserir ou apagar empregado");
		System.out.println("7-Avançar Time-Steps");
		System.out.println("8-Ver o estado corrente da fábrica");
		System.out.println("9-Ver o número total de items processados pela fábrica");
		System.out.println("10-Ver número de items processados pela fábrica numa dada semana");
		System.out.println("11-Ver informações sobre empregados");
		System.out.println("12-Ver salários anuais dos empregados");
		System.out.println("13-Ver estatisticas da fábrica");

		int escolherSwitch = a.nextInt();

		switch (escolherSwitch) {

		case 1:
			
			System.out.println("Deseja inserir ou apagar um Utilizador?\n1 - Inserir\n 2 - Apagar");
			int inserirouapagar = a.nextInt();
			
			if(inserirouapagar == 1)
			{
			
			do {
				a.nextLine();
				System.out.println("Username: ");
				username = a.nextLine();
				System.out.println("Password: ");
				password = a.nextLine();

				Utilizador utilizador = new Utilizador(username, password);

				System.out.println("Utilizador adicionado com sucesso");

				writeObjectToFile(utilizador, "Utilizador.obj");
				

				fabrica.utilizador.add(utilizador);
				

				System.out.println("Deseja inserir outro utilizador?");
				System.out.println("1 - Sim\n2 - Não");
				voltarinserirutilizador = a.nextInt();

			} while (voltarinserirutilizador == 1);

			sistema();

			}
			
			else if(inserirouapagar == 2){
				
				System.out.println("Lista de Utilizadores: ");
				fabrica.printUtilizador();

				System.out.println("Qual o nome do Utilizador que quer apagar?");
				String nomeApagarUtilizador = a.next();

				for (int i = 0; i < fabrica.utilizador.size(); i++) {
					if (fabrica.utilizador.get(i).getUser().equals(nomeApagarUtilizador) ) {
						fabrica.utilizador.remove(i);
						
						System.out.println("Utilizador apagado com sucesso!!");
						break;
					}
					
					
				}

				fabrica.printUtilizador();

				sistema();
				
			}
			
			else{
				System.out.println("Não inseriu um número correto, tente novamente apartir do menu!!");
				
				sistema();
			}
			
			
			
			break;

		
		  case 4:
		  
			  
			  
		  do {
		  
		  
		  System.out.println("Deseja inserir ou apagar uma linha de processo");
		  System.out.println("1- Insirir Linha de Processo\n2- Apagar Linha de Processo\n Clique noutro nº para sair!");
		  inserirLinhaProcesso = a.nextInt();
		  if (inserirLinhaProcesso == 1) {
		  
			  int capacidadeEsforcoLinhaProcesso = 0;
				int contadorEsforcoLinhaProcesso = 0;
		
		  System.out.println("Insira o número de máquinas desta linha de processo");
		  numMaquinasLinhaProcesso = a.nextInt(); 
		  
		  LinhaProcesso linhaprocesso = new LinhaProcesso(numMaquinasLinhaProcesso,
                  capacidadeEsforcoLinhaProcesso, contadorEsforcoLinhaProcesso);
		  
		  fabrica.linhaProcesso.add(linhaprocesso); 
		  
		  int numMaquinasLinhaProcessoAInserir = numMaquinasLinhaProcesso; 
		  int idInsereMaquinaLP;
		  
		  
			  do{
			  System.out.println("Insire o ID da maquina que queres adicionar a linha de processo");
			  for(int i = 0; i < fabrica.maquina.size(); i++){
				  if(fabrica.maquina.get(i).isTemLP() == false)
				  {
					  fabrica.maquina.get(i).print();
				  }
			  }
			  idInsereMaquinaLP = a.nextInt();
			  
			  numMaquinasLinhaProcessoAInserir--;
			  
			  if(fabrica.maquina.isEmpty()){
				  System.out.println("Insira primeiro máquinas no sistema!!");
				  
				  sistema();
			  }
			  
			  linhaprocesso.adicionaMaquinasLinhaProcesso(fabrica.maquina.get(idInsereMaquinaLP-1));
			  
			  fabrica.maquina.get(idInsereMaquinaLP-1).setTemLP(true);
			  
			 
			  
			  }while(numMaquinasLinhaProcessoAInserir > 0);
		  
			
			  
			  
			  for(int i = 0; i <  linhaprocesso.maquinasLinhaProcesso.size();i++){
				  
				  capacidadeEsforcoLinhaProcesso += linhaprocesso.maquinasLinhaProcesso.get(i).getCapacidadeProcesso();
				  
				  
				  for(int s = 0; s < linhaprocesso.maquinasLinhaProcesso.get(i).itemsMaquina.size(); s++){
					  contadorEsforcoLinhaProcesso += linhaprocesso.maquinasLinhaProcesso.get(i).itemsMaquina.get(s).getEsforcoProcesso();
				  }
			  }
			  
		System.out.println("Linha de Processo adicionada com sucesso");
		System.out.println("Capacidade Esforço da Linhas de Processo: " + capacidadeEsforcoLinhaProcesso);
		System.out.println("Contador Esforço da Linhas de Processo: " + contadorEsforcoLinhaProcesso);
		  writeObjectToFile(linhaprocesso, "LinhaProcesso.obj");
		  
		  
		  
		  }
		  
		  else if (inserirLinhaProcesso == 2) {//apagar linha processo
		  
			  System.out.println("Lista de Linhas de Processo: ");
				fabrica.printLinhaProcesso();

				System.out.println("Qual o ID da Linha de Processo que quer apagar?");
				
				int idApagarLP = a.nextInt();
				
				for (int i = 0; i < fabrica.linhaProcesso.size(); i++) {
					if (fabrica.linhaProcesso.get(i).getIdLinha() == idApagarLP) {
						fabrica.linhaProcesso.remove(i);
						break;
					}
				}

				fabrica.printLinhaProcesso();

				sistema();
			  
			  
			  
		  }
		  
		  
		  
		  
		  } while (inserirLinhaProcesso == 1 || inserirLinhaProcesso == 2 );
		  
		  sistema();
		  
		  break;
		 

		case 3: // INSeRIR OU APAGAR MÁQUINA

			System.out.println("Deseja inserir ou apagar uma Máquina?");
			System.out.println("1-Inserir Máquina\n2-Apagar Máquina");

			int escolheraddMaquina = a.nextInt();

			switch (escolheraddMaquina) {

			case 1: // inserir maquina

				do {
					System.out.println("Insira a capacidade de produção da máquina!!");
					capacidadeProcessoMaquina = a.nextInt();

					Maquina maquina = new Maquina(capacidadeProcessoMaquina);

					writeObjectToFile(maquina, "Maquina.obj");

					fabrica.maquina.add(maquina);

					System.out.println("Deseja inserir outra Máquina?\n1-Sim\n2-Não ");
					repeteaddMaquina = a.nextInt();
				} while (repeteaddMaquina == 1);

				sistema();

				break;

			case 2: // apagar maquina

				System.out.println("Lista de Máquinas: ");
				fabrica.printMaquina();

				System.out.println("Qual o ID da Máquina que quer apagar?");
				int idApagarMaquina = a.nextInt();

				for (int i = 0; i < fabrica.maquina.size(); i++) {
					if (fabrica.maquina.get(i).getIdMaquina() == idApagarMaquina) {
						fabrica.maquina.remove(i);
						break;
					}
				}

				fabrica.printMaquina();

				sistema();

				break;

			}

			break;

		case 2: // INSeRIR OU APAGAR ITEM

			System.out.println("Deseja inserir ou apagar um item?");
			System.out.println("1-Inserir Item\n2-Apagar Item");

			int escolheraddItem = a.nextInt();

			switch (escolheraddItem) {

			case 1: // Inserir item

				System.out.println("Deseja inserir um Item biológico ou tecnológico?(biologico ou tecnologico)");
				tipoItem = a.next();

				int repeteItem;

				if (tipoItem.equals("tecnologico")) {
					System.out.println(
							"Deseja inserir que tipo de item tecnologico?\n1-Smart Phone\n2-Tablet\n3-Computador");

					int escolheritemtec = a.nextInt();

					switch (escolheritemtec) {
					case 1: // adicionar smartphone
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();
							System.out.println("Insira os centimetros quadrados no Item");
							cenQuadradosItemTec = a.nextInt();
							System.out.println("Insira a capacidade de memória do Item");
							capacidadeMemoriaItemTec = a.nextInt();

							Item itemSP = new SmartPhone(descricaoItem, pesoItem, tipoItem, cenQuadradosItemTec,
									capacidadeMemoriaItemTec);

							esforcoProcessoItem = itemSP.calculaEsforco();

							 System.out.println("SmartPhone adicionado com sucesso!!\n");

							writeObjectToFile(itemSP, "Items.obj");

							fabrica.item.add(itemSP);
							// fabrica.printItem();
							System.out.println("Deseja inserir outro SmartPhone?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();

							// item.add(itemSP);
							// Maquina.adicionaItem(itemSP);
							// guardar no arraylist item e num documento obj
						} while (repeteItem == 1);

						sistema();

						break;

					case 2: // adicionar tablet
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();
							System.out.println("Insira os centimetros quadrados no Item");
							cenQuadradosItemTec = a.nextInt();

							Item itemT = new Tablet(descricaoItem, pesoItem, tipoItem, cenQuadradosItemTec);

							esforcoProcessoItem = itemT.calculaEsforco();
							
							 System.out.println("Tablet adicionado com sucesso!!\n");

							writeObjectToFile(itemT, "Items.obj");
							fabrica.item.add(itemT);
							// fabrica.printItem();
							System.out.println("Deseja inserir outro Tablet?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();
						} while (repeteItem == 1);

						sistema();

						break;

					case 3: // adicionar computador
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();
							System.out.println("Insira os centimetros quadrados no Item");
							cenQuadradosItemTec = a.nextInt();

							Item itemC = new Computador(descricaoItem, pesoItem, tipoItem, cenQuadradosItemTec);

							esforcoProcessoItem = itemC.calculaEsforco();
							
							 System.out.println("Computador adicionado com sucesso!!\n");

							writeObjectToFile(itemC, "Items.obj");
							fabrica.item.add(itemC);
							// fabrica.printItem();
							System.out.println("Deseja inserir outro Computador?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();

						} while (repeteItem == 1);

						sistema();

						break;
					}

				}

				else if (tipoItem.equals("biologico")) {
					System.out.println(
							"Deseja inserir que tipo de item biologico?\n1-Arroz Branco\n2-Arroz Torrado\n3-Banana");

					int escolheritembio = a.nextInt();

					switch (escolheritembio) {

					case 1: // adicionar Arroz Branco
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();

							Item itemAB = new ArrozBranco(descricaoItem, pesoItem, tipoItem);

							esforcoProcessoItem = itemAB.calculaEsforco();
							
							 System.out.println("Arroz Branco adicionado com sucesso!!\n");

							writeObjectToFile(itemAB, "Items.obj");
							fabrica.item.add(itemAB);
							// fabrica.printItem();
							System.out.println("Deseja inserir mais Arroz Branco?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();
						} while (repeteItem == 1);

						sistema();

						break;

					case 2: // adicionar Arroz Torrado
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();

							Item itemAT = new ArrozTorrado(descricaoItem, pesoItem, tipoItem);

							esforcoProcessoItem = itemAT.calculaEsforco();
							
							 System.out.println("Arroz Torrado adicionado com sucesso!!\n");

							writeObjectToFile(itemAT, "Items.obj");
							fabrica.item.add(itemAT);
							// fabrica.printItem();
							System.out.println("Deseja inserir mais Arroz Torrado?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();

						} while (repeteItem == 1);

						sistema();

						break;

					case 3: // adicionar Banana
						do {
							a.nextLine();
							System.out.println("Descrição do Item");
							descricaoItem = a.nextLine();
							System.out.println("Insira o peso do Item");
							pesoItem = a.nextInt();
							System.out.println("Insira o comprimento do Item");
							comprimentoItem = a.nextInt();

							Item itemB = new Banana(descricaoItem, pesoItem, tipoItem, comprimentoItem);

							esforcoProcessoItem = itemB.calculaEsforco();
							
							 System.out.println("Banana adicionada com sucesso!!\n");
							
							writeObjectToFile(itemB, "Items.obj");
							fabrica.item.add(itemB);
							// fabrica.printItem();
							System.out.println("Deseja inserir mais Bananas?\n1-Sim\n2-Não ");
							repeteItem = a.nextInt();

						} while (repeteItem == 1);

						sistema();

						break;

					}

				}

				else {
					System.out.println("Não inseriu o tipo correctamente, tente novamente!");
					sistema();
				}

				break;

			case 2: // apagar item
				System.out.println("Lista de Items: ");
				fabrica.printItem();

				System.out.println("Qual o ID do item que quer apagar?");
				idApagarItem = a.nextInt();

				for (int i = 0; i < fabrica.item.size(); i++) {
					if (fabrica.item.get(i).getIdItem() == idApagarItem) {
						fabrica.item.remove(i);
						break;
					}
				}

				fabrica.printItem();

				sistema();

				break;

			}

			break;

		case 5: // INSeRIR OU APAGAR EVENTO

			System.out.println("Deseja inserir ou apagar um evento?");
			System.out.println("1-Inserir evento\n2-Apagar eventoRecorrente");

			int escolherOpcaoEvento = a.nextInt();

			if (escolherOpcaoEvento == 1) {

				fabrica.printItem();
				System.out.println("Qual o ID do item que quer criar o evento?");
				idItemEvento = a.nextInt();
				Item criarItem = null;
				for (int i = 0; i < fabrica.item.size(); i++) {

					if (fabrica.item.get(i).getIdItem() == idItemEvento) {
						criarItem = fabrica.item.get(i);
					}

				}

				System.out.println("Lista de linhas de processo: ");

				fabrica.printLinhaProcesso();
				System.out.println("Indique o ID da linha de processo onde quer criar o evento");

				int idLinhaProcessoEvento = a.nextInt();

				LinhaProcesso indicarLP = null;

				for (int i = 0; i < fabrica.linhaProcesso.size(); i++) {

					if (fabrica.linhaProcesso.get(i).getIdLinha() == idLinhaProcessoEvento) {
						indicarLP = fabrica.linhaProcesso.get(i);
					}

				}

				int timeStep;

				do {
					System.out.println(
							"Indique a que TimeStep por semana quer iniciar o evento? (Valor entre 0 e 1000): ");
					timeStep = a.nextInt();

				} while (timeStep < 0 || timeStep > 1000);

				System.out.println("Qual o tipo de evento que quer criar?");
				System.out.println("1 - Evento Recorrente\n2 - Evento OneOff");

				int escolherEvento = a.nextInt();

				if (escolherEvento == 1) {

					Evento ER = new EventoRecorrente(criarItem, indicarLP, timeStep);
					ER.lancarEvento();

					fabrica.listaEventosRecorrentes.add((EventoRecorrente) ER);
					
					System.out.println("Evento Recorrente criado com sucesso!");
					
					sistema();

				}

				else if (escolherEvento == 2) {
					Evento EOF = new EventoOneOff(criarItem, indicarLP, timeStep);
					EOF.lancarEvento();
				}

			}

			else if (escolherOpcaoEvento == 2) {
				System.out.println("Lista de Eventos Recorrentes: ");
				fabrica.printEventoRecorrente();
				System.out.println("Qual o ID do Evento Recorrente que quer apagar?");
				idApagarEventoRecorrente = a.nextInt();
				for (int i = 0; i < fabrica.listaEventosRecorrentes.size(); i++) {
					if (fabrica.listaEventosRecorrentes.get(i).getIdEventoRecorrente() == idApagarEventoRecorrente) {
						fabrica.listaEventosRecorrentes.remove(i);
						System.out.println("Evento Recorrente apagado com sucesso!");
						break;
					}
				}

				fabrica.printEventoRecorrente();

				sistema();

			}

			break;

		case 6:

			System.out.println("Deseja inserir ou apagar um empregado?");
			System.out.println("1-Inserir empregado\n2-Apagar empregado");

			int escolheraddEmpregado = a.nextInt();
			double minimoEngenheiro = 0;

			switch (escolheraddEmpregado) {

			case 1:// adicionar empregado

				a.nextLine();
				System.out.println("Insira o nome do empregado");
				nomeEmpregado = a.nextLine();
				System.out.println("Insira o tipo de empregado, (Engenheiro, NaoEngenheiro, Limpeza)");
				tipoEmpregado = a.nextLine();
				System.out.println("Insira o salario do empregado");
				salarioEmpregado = a.nextDouble();

				Empregados empregados;
				double salarioAnual = 0;

				if (tipoEmpregado.equals("Engenheiro") && salarioEmpregado >= 2500) {

					empregados = new Empregados(nomeEmpregado, tipoEmpregado, salarioEmpregado, salarioAnual);

					fabrica.engenheiros.add(empregados);

					writeObjectToFile(empregados, "Empregados.obj");

					haEngenheiros = true;

					System.out.println("Adicionou um Engenheiro com sucesso!!");

					sistema();
				}

				else if (tipoEmpregado.equals("Engenheiro") && salarioEmpregado < 2500) {
					System.out.println("Nao adicionou um Engenheiro com sucesso!!");

					sistema();
				}

				if (haEngenheiros == true) {
					minimoEngenheiro = fabrica.engenheiros.get(0).getSalario();
				}

				for (int i = 0; i < fabrica.engenheiros.size(); i++) {

					if (fabrica.engenheiros.get(i).getSalario() < minimoEngenheiro) {
						minimoEngenheiro = fabrica.engenheiros.get(i).getSalario();

					}

				}

				if (tipoEmpregado.equals("NaoEngenheiro")) {
					if (minimoEngenheiro == 0 || minimoEngenheiro > salarioEmpregado) {
						empregados = new Empregados(nomeEmpregado, tipoEmpregado, salarioEmpregado, salarioAnual);

						fabrica.naoengenheiros.add(empregados);
						writeObjectToFile(empregados, "Empregados.obj");

						System.out.println("Adicionou um NaoEngenheiro com sucesso!!");
						sistema();
					} else if (minimoEngenheiro < salarioEmpregado) {
						System.out.println("Nao adicionou um NaoEngenheiro com sucesso!!");

						sistema();
					}

				}

				if (tipoEmpregado.equals("Limpeza") && salarioEmpregado <= 1000) {

					empregados = new Empregados(nomeEmpregado, tipoEmpregado, salarioEmpregado, salarioAnual);
					fabrica.limpeza.add(empregados);
					writeObjectToFile(empregados, "Empregados.obj");

					System.out.println("Adicionou uma empregada da Limpeza com sucesso!!");
					sistema();

				}

				else if (tipoEmpregado.equals("Limpeza") && salarioEmpregado > 1000) {
					System.out.println("Nao adicionou uma empregada da Limpeza com sucesso!!");

					sistema();
				}

				sistema();

				break;

			case 2:// remover empregado

				System.out.println("Lista de Empregados: ");
				fabrica.printEngenheiros();
				fabrica.printNaoEngenheiros();
				fabrica.printLimpeza();

				System.out.println("Qual o ID do Empregado que quer apagar?");
				idApagarEmpregado = a.nextInt();

				for (int i = 0; i < fabrica.engenheiros.size(); i++) {
					if (fabrica.engenheiros.get(i).getIdEmpregados() == idApagarEmpregado) {
						fabrica.engenheiros.remove(i);
						System.out.println("Empregado removido com sucesso!");
						break;
					}
				}

				for (int i = 0; i < fabrica.naoengenheiros.size(); i++) {
					if (fabrica.naoengenheiros.get(i).getIdEmpregados() == idApagarEmpregado) {
						fabrica.naoengenheiros.remove(i);
						System.out.println("Empregado removido com sucesso!");
						break;
					}
				}

				for (int i = 0; i < fabrica.limpeza.size(); i++) {
					if (fabrica.limpeza.get(i).getIdEmpregados() == idApagarEmpregado) {
						fabrica.limpeza.remove(i);
						System.out.println("Empregado removido com sucesso!");
						break;
					}
				}

				// fabrica.printEngenheiros();
				// fabrica.printNaoEngenheiros();
				// fabrica.printLimpeza();

				sistema();

				break;

			}

			break;

		case 13: // VER ESTATISTICAS DA FÁBRICA
			
			//Neste case, teremos de mostar ao utilizador as estatísticas da fabrica: o numero total de empregados, 
			//o total de empregados por categoria, o total de maquinas, linhas de processo e items. 
			//Para isso temos de imprimir o tamanho de cada ArrayList criado para a consola.
			
			break;

		case 8: // VER ESTADO CORRENTE DA FÁBRICA
			
			//Neste case, a consola terá de mostra o estado de cada máquina. Para isso precisamos de saber qual o 
			//item que está a ser processado nessa maquina. E precisamos de saber os items que estão na fila de 
			//espera d uma determinada maquina, através do ArrayList<Item> itemsMaquina que é criado em sempre que 
			//instanciamos um objeto da classe Maquina.
			//Por sua vez também precisamos de ir ao ArrayList das linhas de processo e imprimir o total de maquinas 
			//existentes em cada linha de processo e por sua vez, o estado de cada maquina, tal como foi referido no 
			//paragrafo anterior.

			
			fabrica.printLinhaProcesso();
			
			break;

		case 9: // VER O NÚMERO TOTAL DE ITEMS PROCESSADOS PELA FÁBRICA
			
			//O objetivo aqui será a consola mostrar o numero total de items processados e para isso temos de ir a 
			//cada maquina de cada linha de processo da fabrica e fazer o somatório dos items que cada maquina já processou.
			//Aqui também temos de ir ao ArrayList das linhas de processo e somar o numero de items processados por 
			//cada maquina dessa linha de processo. Para depois esse valor ser mostrado.

			
			
			break;

		case 10: // VER O NÚMERO TOTAL DE ITEMS PROCESSADOS PELA FÁBRICA NUMA
					// DADA SEMANA
			
			//Muito semelhante ao case anterior, apenas com a diferença que aqui apenas imprimimos os items 
			//processados durante uma determinada semana, que é definida pelo utilizador.
			
			
			break;

		case 11: // VER INFORMAÇÕES EMPREGADOS

			fabrica.printEngenheiros();
			fabrica.printNaoEngenheiros();
			fabrica.printLimpeza();

			break;

		case 12: // VER SALÁRIOS ANUAIS DOS EMPREGADOS

			for (int i = 0; i < fabrica.engenheiros.size(); i++) {
				fabrica.engenheiros.get(i).printSalarioAnual();
			}
			for (int i = 0; i < fabrica.naoengenheiros.size(); i++) {
				fabrica.naoengenheiros.get(i).printSalarioAnual();
			}
			for (int i = 0; i < fabrica.limpeza.size(); i++) {
				fabrica.limpeza.get(i).printSalarioAnual();
			}

			break;

		case 7:
			int temp;
			do {
				System.out.println("Insira os time steps: ");
				 temp= a.nextInt();

				int[] TimeStep = fabrica.getNumSemanaTimeStep(temp);

				System.out.println("Numero da semana: " + TimeStep[0]);
				System.out.println("TimeStep corrente: " + TimeStep[1]);

				System.out.println("Insira 1 se quiser inserir mais timeSteps ou 2 se quiser sair para o menu");
				voltarInserirTimeStep = a.nextInt();

			} while (voltarInserirTimeStep == 1);

			for (int i = 0; i < fabrica.listaEventosRecorrentes.size(); i++) {
				if (fabrica.listaEventosRecorrentes.get(i).timeStep<=temp) {
					fabrica.listaEventosRecorrentes.get(i).lancarEvento();
					//break;
				}
			}
			
			sistema();

			break;

		}

	}
}
