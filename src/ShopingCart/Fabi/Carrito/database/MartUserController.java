package ShopingCart.Fabi.Carrito.database;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MartUserController {
 private MartDao dao;
 
 @Autowired
 public MartUserController(MartDao dao){
  this.dao = dao;
 }
 //public void getAllUsers(){
 public String getAllUsers(){
  System.out.print("this is dao! "+dao+"   "+this);
  String sql = "select * from carrito.users";
  String user="";
  List users = this.dao.executeQuery(sql,null, new UserMapper());
  System.out.println(users.size()+"");
  for(int i=0; i<users.size();i++){
   System.out.println(users.get(i));
   user +="<br>"+users.get(i);
  }
  return user;
  
 }
 
 public MartUser getAccess(String email, String pass){
	 String sql = "SELECT * FROM carrito.users WHERE email='"+email+"' AND pass='"+pass+"'";
	 MartUser user = new MartUser();
	 List users = this.dao.executeQuery(sql, null, new UserMapper());
	 System.out.println(users.size()+"");
	 if(users.size()>0){
		 for(int i=0; i<users.size();i++){
			  user = (MartUser)users.get(i);
			  System.out.println(user);
			  //user.setName(users.get(i))
		  }
		 
		 return user;
	 }else{
		 return null;
	 }
 }
 
 public MartUser getUser(int id){
	  System.out.print("this is dao! "+dao+"   "+this);
	  String sql = "SELECT * FROM carrito.users WHERE id="+id;
	  MartUser user = new MartUser();
	  List users = this.dao.executeQuery(sql,null, new UserMapper());
	  System.out.println(users.size()+"");
	  for(int i=0; i<users.size();i++){
		  System.out.println(users.get(i));
		  user = (MartUser)users.get(i);
	  }
	  return user;
 }
 
 public void updateUser(int id,float saldo){
	 System.out.print("this is dao! "+dao+"   "+this);
	 String sql = "UPDATE users SET saldo=saldo-"+saldo+" WHERE id='"+id+"'";
	 this.dao.updateQuery(sql,null);
 }
 
 public class UserMapper implements RowMapper<MartUser>{

  @Override
  public MartUser mapRow(ResultSet data, int num) throws SQLException {
   // TODO Auto-generated method stub
   
   MartUser user = new MartUser();
   
   user.setId(data.getInt(1));
   user.setName(data.getString(2));
   user.setPass(data.getString(3));
   user.setEmail(data.getString(4));
   user.setSaldo(data.getFloat(5));
   
   return user;
  }
  
 }
}