package pe.com.backend;

public class Client {

	private String email;
	private String nombre;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String email, String nombre) {
		super();
		this.email = email;
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
