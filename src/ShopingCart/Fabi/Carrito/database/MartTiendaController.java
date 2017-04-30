package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ShopingCart.Fabi.Carrito.database.MartUserController.UserMapper;

public class MartTiendaController {
	
	private MartDao dao;
	 
	 @Autowired
	 public MartTiendaController(MartDao dao){
	  this.dao = dao;
	 }
	 //public void getAllUsers(){
	 public List<MartTienda> getAll(String estadio){
	  System.out.print("this is dao! "+dao+"   "+this);
	  String sql = "select * from carrito.tiendas where estadio="+estadio;
	  List<MartTienda> estadios = new ArrayList<MartTienda>();
	  List est = this.dao.executeQuery(sql,null, new TiendaMapper());
	  //System.out.println(prods.size()+"");
	  for(int i=0; i<est.size();i++){
	   //System.out.println(prods.get(i));
		  estadios.add((MartTienda)est.get(i));
	  }
	  return estadios;
	  
	 }
	 
	 public MartTienda getStore(int id){
		  System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "SELECT * FROM carrito.tiendas WHERE id="+id;
		  MartTienda products = new MartTienda();
		  List prods = this.dao.executeQuery(sql,null, new TiendaMapper());
		  //System.out.println(prods.size()+"");
		  for(int i=0; i<prods.size();i++){
		   //System.out.println(prods.get(i));
			  products = (MartTienda)prods.get(i);
		  }
		  return products;
		  
		 }
	
	public class TiendaMapper implements RowMapper<MartTienda>{

		  @Override
		  public MartTienda mapRow(ResultSet data, int num) throws SQLException {
		   // TODO Auto-generated method stub
		   
		   MartTienda tienda = new MartTienda();
		   
		   tienda.setId(data.getInt(1));
		   tienda.setTienda(data.getString(2));
		   tienda.setEstadio(data.getInt(3));
		   tienda.setImagen(data.getString(4));
		   tienda.setDesc(data.getString(5));
		   
		   return tienda;
		  }
	}

}