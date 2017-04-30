package ShopingCart.Fabi.Carrito.database;

public class MartProduct {
	 private int id;
	 private String name;
	 private String description;
	 private float price;
	 private String image;
	 private int tienda;
	 
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	 public String toString(){
	  return "Product: "+getId()+"|Name: "+getName()+"|Description: "+getDescription()+"|Price: "+getPrice()+"|image: "+getImage();
	 }
	public int getTienda() {
		return tienda;
	}
	public void setTienda(int tienda) {
		this.tienda = tienda;
	}
}
