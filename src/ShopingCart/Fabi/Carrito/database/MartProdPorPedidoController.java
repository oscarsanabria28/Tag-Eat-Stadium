package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MartProdPorPedidoController {
 private MartDao dao;
 
 @Autowired
 public MartProdPorPedidoController(MartDao dao){
  this.dao = dao;
 }
 //public void getAllUsers(){
 public void insertProdPedido(int idP,int idPro, int cantidad ){
	 System.out.print("this is dao! "+dao+"   "+this);
	 String sql = "insert into prodPorPedido (idPedido,idProducto, cantidad) values("+idP+","+idPro+","+cantidad+")";
	 this.dao.updateQuery(sql,null);
 }
}