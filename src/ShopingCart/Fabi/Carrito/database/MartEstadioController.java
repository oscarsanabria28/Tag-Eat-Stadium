package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

public class MartEstadioController {
	
	private MartDao dao;
	 
	 @Autowired
	 public MartEstadioController(MartDao dao){
	  this.dao = dao;
	 }
	 //public void getAllUsers(){
	 public List<MartEstadio> getAllStadiums(){
	  System.out.print("this is dao! "+dao+"   "+this);
	  String sql = "select * from carrito.estadios";
	  List<MartEstadio> estadios = new ArrayList<MartEstadio>();
	  List est = this.dao.executeQuery(sql,null, new EstadioMapper());
	  //System.out.println(prods.size()+"");
	  for(int i=0; i<est.size();i++){
	   //System.out.println(prods.get(i));
		  estadios.add((MartEstadio)est.get(i));
	  }
	  return estadios;
	  
	 }
	 
	 public MartEstadio getStadium(String id){
		  //System.out.println("->>>>>>>>old id: "+id);
		  int id_s=Integer.parseInt(id);
		  //System.out.println("->>>>>>>>new id: "+id_s);
		  //System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "SELECT * FROM carrito.estadios WHERE id="+id_s;
		  MartEstadio products = new MartEstadio();
		  List prods = this.dao.executeQuery(sql,null, new EstadioMapper());
		  //System.out.println(prods.size()+"");
		  for(int i=0; i<prods.size();i++){
		   //System.out.println(prods.get(i));
			  products = (MartEstadio)prods.get(i);
		  }
		  return products;
		  
		 }
	
	public class EstadioMapper implements RowMapper<MartEstadio>{

		  @Override
		  public MartEstadio mapRow(ResultSet data, int num) throws SQLException {
		   // TODO Auto-generated method stub
		   
		   MartEstadio stadium = new MartEstadio();
		   
		   stadium.setId(data.getInt(1));
		   stadium.setNombre(data.getString(2));
		   stadium.setUbicacion(data.getString(3));
		   stadium.setEquipo(data.getString(4));
		   stadium.setImagen(data.getString(5));
		   
		   return stadium;
		  }
	}

}