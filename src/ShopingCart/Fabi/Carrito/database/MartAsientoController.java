package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ShopingCart.Fabi.Carrito.database.MartEstadioController.EstadioMapper;

public class MartAsientoController {
	private MartDao dao;
	 
	 @Autowired
	 public MartAsientoController(MartDao dao){
	  this.dao = dao;
	 }
	 //public void getAllUsers(){
	 public List<MartAsiento> getSeat(String code){
		 return null;
	 }
	 
	 public MartAsiento getSeat2(String id){
		  System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "SELECT * FROM carrito.asientos WHERE numerounico='"+id+"'";
		  System.out.println(sql);
		  MartAsiento products = new MartAsiento();
		  List prods = this.dao.executeQuery(sql,null, new AsientoMapper());
		  //System.out.println(prods.size()+"");
		  if(prods.size()>0){
			for(int i=0; i<prods.size();i++){
				   //System.out.println(prods.get(i));
					  products = (MartAsiento)prods.get(i);
			}
				 
				 return products;
		  }else{
				 return null;
		  }
		  
		 }
	
	public class AsientoMapper implements RowMapper<MartAsiento>{

		  @Override
		  public MartAsiento mapRow(ResultSet data, int num) throws SQLException {
		   // TODO Auto-generated method stub
		   
			  MartAsiento asiento = new MartAsiento();
		   
		   asiento.setId(data.getInt(1));
		   asiento.setAsiento(data.getString(2));
		   asiento.setSeccion(data.getString(3));
		   asiento.setFila(data.getString(4));
		   asiento.setEstadio(data.getString(5));
		   asiento.setNumerounico(data.getString(6));
		   
		   return asiento;
		  }
	}
}
