package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ShopingCart.Fabi.Carrito.database.MartTiendaController.TiendaMapper;

public class MartPedidoController {
	
	private MartDao dao;
	 
	 @Autowired
	 public MartPedidoController(MartDao dao){
	  this.dao = dao;
	 }
	 
	 public MartPedido getLastPedido(){
		  System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "SELECT * FROM pedido ORDER BY id DESC LIMIT 1;";
		  MartPedido estadios = new MartPedido();
		  List est = this.dao.executeQuery(sql,null, new PedidoMapper());
		  //System.out.println(prods.size()+"");
		  for(int i=0; i<est.size();i++){
		   //System.out.println(prods.get(i));
			  estadios = (MartPedido)est.get(i);
		  }
		  return estadios;
		  
		 }
	 
	 public void insertPedido(String numeroUni,float total, String fecha, String estatus ){
		 System.out.print("this is dao! "+dao+"   "+this);
		 String sql = "insert into pedido (numeroUnico,fecha, total, estatus) values('"+numeroUni+"','"+fecha+"',"+total+",'no_entregado')";
		 this.dao.updateQuery(sql,null);
	 }
	 
	 public class PedidoMapper implements RowMapper<MartPedido>{

		  @Override
		  public MartPedido mapRow(ResultSet data, int num) throws SQLException {
		   // TODO Auto-generated method stub
		   
			  MartPedido pedido = new MartPedido();
		   
			  pedido.setId(data.getInt(1));
			  pedido.setNumeroUnico(data.getString(2));
			  pedido.setTotal(data.getFloat(4));
			  pedido.setFecha(data.getString(3));
			  pedido.setEstatus(data.getString(5));
		   
		   return pedido;
		  }
	}
}