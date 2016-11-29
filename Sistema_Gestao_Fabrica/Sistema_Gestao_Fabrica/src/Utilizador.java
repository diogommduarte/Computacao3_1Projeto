import java.io.Serializable;


public class Utilizador implements Serializable   {
	
	
	
	private static final long serialVersionUID = 1L;
	protected String user;
	protected String password;
	
	
	
	public Utilizador(String user, String password) {
		this.user = user;
		this.password = password;
		
		//utilizador.add(this);
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void print(){
		
		System.out.println("Utilizador: " + user);
		System.out.println("Password: " + password);
		
	}
	
}
