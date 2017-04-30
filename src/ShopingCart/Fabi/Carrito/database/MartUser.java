package ShopingCart.Fabi.Carrito.database;

public class MartUser {
	 private int id;
	 private String name;
	 private String pass;
	 private String email;
	 private float saldo;
	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public String getPass() {
	  return pass;
	 }
	 public void setPass(String pass) {
	  this.pass = pass;
	 }
	 public String getEmail() {
	  return email;
	 }
	 public void setEmail(String email) {
	  this.email = email;
	 }
	 
	 @Override
	 public String toString(){
	  return "User: "+getId()+"|Name: "+getName()+"|Pass: "+getPass()+"|Email: "+getEmail()+"|Saldo: "+getSaldo();
	 }
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	 
	}