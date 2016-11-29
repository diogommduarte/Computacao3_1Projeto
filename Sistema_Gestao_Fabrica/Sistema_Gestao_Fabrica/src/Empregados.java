import java.io.Serializable;

public class Empregados implements Serializable {

	private static final long serialVersionUID = 1L;

	static protected int nextID = 1;

	protected int idEmpregados;
	protected String nome;
	protected String tipo;
	protected double salario;
	protected double salarioAnual;

	public Empregados(String nome, String tipo, double salario, double salarioAnual) {

		idEmpregados = nextID;
		nextID++;

		this.nome = nome;
		this.tipo = tipo;
		this.salario = salario;
		this.salarioAnual = salarioAnual;

	}

	public double getSalarioAnual() {
		
		return salario*12;
	}

	public void setSalarioAnual(double salarioAnual) {
		this.salarioAnual = salarioAnual;
	}

	public int getIdEmpregados() {
		return idEmpregados;
	}

	public void setIdEmpregados(int idEmpregados) {
		this.idEmpregados = idEmpregados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void print() {

		System.out.println(
				"Id:" + idEmpregados + " -> " + "Nome:  " + nome + ", Tipo: " + tipo + ", Salário: " + salario);

	}

	public void printSalarioAnual() {
		System.out.println("Id:" + idEmpregados + " -> " + "Nome:  " + nome + ", Tipo: " + tipo + ", Salário Anual: "
				+ getSalarioAnual());
	}

}
