package ShopingCart.Fabi.Carrito.database;

public class MartProdPorPedido {
	private int idPedido;
	 private int idProducto;
	 private int total;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	@Override
	 public String toString(){
	  return "Pedido: "+getIdPedido()+"|Producto: "+getIdProducto();
	 }
}
