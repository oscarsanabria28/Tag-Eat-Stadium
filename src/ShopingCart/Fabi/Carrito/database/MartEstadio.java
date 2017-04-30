package ShopingCart.Fabi.Carrito.database;

public class MartEstadio {

	 private int id;
	 private String nombre;
	 private String equipo;
	 private String ubicacion;
	 private String descripcion;
	 private String imagen;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	@Override
	 public String toString(){
	  return "Estadio: "+getId()+"|Nombre: "+getNombre()+"|Ubicación: "+getUbicacion()+"|Equipo: "+getEquipo()+"|Imagen: "+getImagen();
	 }
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
