package ShopingCart.Fabi.Carrito.database;

public class MartAsiento {
	private int id;
	private String asiento;
	private String seccion;
	private String fila;
	private String estadio;
	private String numerounico;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public String getNumerounico() {
		return numerounico;
	}
	public void setNumerounico(String numerounico) {
		this.numerounico = numerounico;
	}
}
