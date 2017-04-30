package ShopingCart.Fabi.Carrito.database;

public class MartPedido {
	private int id;
	 private String numeroUnico;
	 private float total;
	 private String fecha;
	 private String estatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroUnico() {
		return numeroUnico;
	}
	public void setNumeroUnico(String numeroUnico) {
		this.numeroUnico = numeroUnico;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	@Override
	 public String toString(){
	  return "Pedido: "+getId()+"|total: "+getTotal();
	 }
}
