package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import ShopingCart.Fabi.Carrito.database.MartUserController.UserMapper;

public class MartProductController {
	
	private MartDao dao;
	 
	 @Autowired
	 public MartProductController(MartDao dao){
	  this.dao = dao;
	 }
	 //public void getAllUsers(){
	 public List<MartProduct> getAllProducts(){
	  System.out.print("this is dao! "+dao+"   "+this);
	  String sql = "select * from carrito.products";
	  List<MartProduct> products = new ArrayList<MartProduct>();
	  List prods = this.dao.executeQuery(sql,null, new ProductMapper());
	  //System.out.println(prods.size()+"");
	  for(int i=0; i<prods.size();i++){
	   //System.out.println(prods.get(i));
		  products.add((MartProduct)prods.get(i));
	  }
	  return products;
	  
	 }
	 
	 public List<MartProduct> getAllProductsTienda(int id){
		  System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "select * from carrito.products where tienda="+id;
		  List<MartProduct> products = new ArrayList<MartProduct>();
		  List prods = this.dao.executeQuery(sql,null, new ProductMapper());
		  //System.out.println(prods.size()+"");
		  for(int i=0; i<prods.size();i++){
		   //System.out.println(prods.get(i));
			  products.add((MartProduct)prods.get(i));
		  }
		  return products;
		  
		 }
	 
	 public MartProduct getProduct(int id){
		  System.out.print("this is dao! "+dao+"   "+this);
		  String sql = "SELECT * FROM carrito.products WHERE id="+id;
		  MartProduct products = new MartProduct();
		  List prods = this.dao.executeQuery(sql,null, new ProductMapper());
		  //System.out.println(prods.size()+"");
		  for(int i=0; i<prods.size();i++){
		   //System.out.println(prods.get(i));
			  products = (MartProduct)prods.get(i);
		  }
		  return products;
		  
	}
	
	public class ProductMapper implements RowMapper<MartProduct>{

		  @Override
		  public MartProduct mapRow(ResultSet data, int num) throws SQLException {
		   // TODO Auto-generated method stub
		   
		   MartProduct product = new MartProduct();
		   
		   product.setId(data.getInt(1));
		   product.setName(data.getString(2));
		   product.setDescription(data.getString(3));
		   product.setPrice(data.getFloat(4));
		   product.setImage(data.getString(5));
		   product.setTienda(data.getInt(6));
		   
		   return product;
		  }
	}

}