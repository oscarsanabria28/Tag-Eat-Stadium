package ShopingCart.Fabi.Carrito.database;

public class MartTienda {
	 private int id;
	 private String tienda;
	 private int estadio;
	 private String imagen;
	 private String descripcion;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public int getEstadio() {
		return estadio;
	}
	public void setEstadio(int estadio) {
		this.estadio = estadio;
	}

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDesc() {
		return descripcion;
	}
	public void setDesc(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	 public String toString(){
	  return "Tienda: "+getId()+"|Nombre: "+getTienda()+"|Descripcion: "+getDesc()+"|Estadio: "+getEstadio()+"|Imagen: "+getImagen();
	 }
}
