package ShopingCart.Fabi.Carrito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ShopingCart.Fabi.Carrito.database.MartProductController;
import ShopingCart.Fabi.Carrito.database.MartTiendaController;
import ShopingCart.Fabi.Carrito.database.MartUser;
import ShopingCart.Fabi.Carrito.database.MartEstadio;
import ShopingCart.Fabi.Carrito.database.Cart;
import ShopingCart.Fabi.Carrito.database.MartAsiento;
import ShopingCart.Fabi.Carrito.database.MartAsientoController;
import ShopingCart.Fabi.Carrito.database.MartEstadioController;
import ShopingCart.Fabi.Carrito.database.MartTienda;
import ShopingCart.Fabi.Carrito.database.MartProduct;
import ShopingCart.Fabi.Carrito.database.MartUserController;

import ShopingCart.Fabi.Carrito.database.MartPedido;
import ShopingCart.Fabi.Carrito.database.MartPedidoController;
import ShopingCart.Fabi.Carrito.database.MartProdPorPedido;
import ShopingCart.Fabi.Carrito.database.MartProdPorPedidoController;


@Controller
public class MainSpringController {

MartUserController userController;
MartProductController productController;
MartAsientoController asientoController;
MartEstadioController estadioController;
MartTiendaController tiendaController;
MartPedidoController pedidoController;
MartProdPorPedidoController prodPorPedidoController;

public void setUserController(MartUserController userController) {
this.userController = userController;
}

public void setProductController(MartProductController productController) {
this.productController = productController;
}

public void setAsientoController(MartAsientoController asientoController) {
this.asientoController = asientoController;
}

public void setEstadioController(MartEstadioController estadioController) {
this.estadioController = estadioController;
}

public void setTiendaController(MartTiendaController tiendaController) {
this.tiendaController = tiendaController;
}

public void setPedidoController(MartPedidoController pedidoController) {
this.pedidoController = pedidoController;
}

public void setProdPorPedidoController(MartProdPorPedidoController prodPorPedidoController) {
this.prodPorPedidoController = prodPorPedidoController;
}

@RequestMapping( value={"/users"})
public ModelAndView getAllUsers(){

System.out.println("controller here! " + userController );

String shit = userController.getAllUsers();
String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Users controller **********</div><br><br>"
+ "<p>"+shit+"</p>";
return new ModelAndView("Hola", "message", message);


}

@RequestMapping( value={"/" })
public ModelAndView index() {

//System.out.println("controller here! " + info );
String message = "Welcome to the new Stadium Platform!";
return new ModelAndView("Login", "shittymessage", message);
}

@RequestMapping( value={"/logout" })
public ModelAndView logout(HttpSession session) {
session.invalidate();
//System.out.println("controller here! " + info );
String message = "Welcome to the new stadium platform!!!";
return new ModelAndView("Login", "shittymessage", message);
}

@RequestMapping( value={"/welcome" })
public ModelAndView helloWorld() {

//System.out.println("controller here! " + info );
String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Hi you from controller in Spring!**********</div><br><br>";
return new ModelAndView("welcome", "message", message);
}



@RequestMapping( value={"/{id}"})
public ModelAndView getProduct( @PathVariable(value="id") int id ){

System.out.println("controller here! " + productController + " -> with id " + id);

MartProduct product = productController.getProduct(id);

String message = "";
message += "<div class='panel panel-default'><div class='panel-heading'>";
message += "<h3 class='panel-title'>"+product.getName()+"</h3></div><div class='panel-body'>";
message += "<img src='images/"+product.getImage()+"' height='200px'>";
message += "<br><span id='productId'>"+product.getId()+"</span>";
message += "<div><h3>NAME: "+product.getName()+"</h3></div><p>DESCRIPTION: "+product.getDescription()+"</p>";
message += "<p>PRICE: "+product.getPrice()+"</p>";
message += "<br><div style='width:60px;' style='margin:0 auto;'><input class='form-control' type='number' value='1' size='10' name='qty' id='qty'/></div><br>";
message += "<p><button onclick='addProduct("+product.getId()+");' class='btn btn-primary' type='button'>Agregar al Carrito</button></p>";
message += "</div></div>";

//System.out.println(message);

//String message = "<br><div style='text-align:center;'>"
//+ "<h3>********** Users controller **********</div><br><br>";
return new ModelAndView("Specific", "product", message);

}

@RequestMapping( value={"/products"})
public ModelAndView getAllProducts(){

	System.out.println("controller here! " + productController );
	String message = "";
	List<MartProduct> shit = productController.getAllProducts();
	for(int i=0; i<shit.size();i++){
		MartProduct producto = new MartProduct();
		producto = shit.get(i);
		message += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>";
		message += "<img src='images/"+producto.getImage()+"' height='200px'><div class='caption'>";
		message += "<div><h3>"+producto.getName()+"</h3></div><p>"+producto.getDescription()+"</p>";
		message += "<p>"+producto.getPrice()+"</p>";
		message += "<p><button onclick='searchProduct("+producto.getId()+");' class='btn btn-primary' type='button'>Buy Product</button></p>";
		message += "</div></div></div>";
	}

	return new ModelAndView("Products", "products", message);
}

@RequestMapping( value={"/allTiendas"})
public ModelAndView getAllTiendas(){

	String message = "Hello";
	/*List<MartProduct> shit = productController.getAllProducts();
	for(int i=0; i<shit.size();i++){
		MartProduct producto = new MartProduct();
		producto = shit.get(i);
		message += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>";
		message += "<img src='images/"+producto.getImage()+"' height='200px'><div class='caption'>";
		message += "<div><h3>"+producto.getName()+"</h3></div><p>"+producto.getDescription()+"</p>";
		message += "<p>"+producto.getPrice()+"</p>";
		message += "<p><button onclick='searchProduct("+producto.getId()+");' class='btn btn-primary' type='button'>Buy Product</button></p>";
		message += "</div></div></div>";
	}*/

	return new ModelAndView("Products", "products", message);
}

@RequestMapping( value={"/cart"})
public ModelAndView getCart(HttpSession session){

	String message = "";
	message += "<div class='panel panel-default'><div class='panel-heading'>";
	message += "<h3 class='panel-title'>Shopping Cart</h3></div><div class='panel-body'>";
	message += "<br>ID: <span id='userId'>"+session.getAttribute("user")+"</span>";
	message += "<div><h3>NAME: "+session.getAttribute("name")+"</h3></div>";
	message += "<p>BALANCE: <span id='balance'>"+session.getAttribute("saldo")+"</span></p>";
	message += "<p><button onclick='pay();' class='btn btn-primary' type='button'>Pay</button></p>";
	message += "<br><br>";
	
	if(session.getAttribute("carts")!=null){
		List<Cart> carts = (List<Cart>)session.getAttribute("carts");
		
		float total = 0;
		message += "<table class='table table-hover'><thead></th><th>Product</th><th>Price</th><th>Quantity</th><th>Total</th><tr><th></tr></thead><tbody>";
		if(carts.size()==0){
			
		}else{
			for(int i=0; i<carts.size();i++){
				Cart car = carts.get(i);
				MartProduct prod = productController.getProduct(car.getId());
				float price = prod.getPrice();
				float qty = car.getQty();
				message += "<tr>";
				message += "<td>"+prod.getName()+"</td><td>"+prod.getPrice()+"</td><td>"+car.getQty()+"</td><td>"+price*qty+"</td><td><button onclick='remove("+i+");' class='btn btn-danger' type='button'>Remove</button></td>";
				message += "</tr>";
				total = total + (price*qty);
			}
		}
			
		message += "<tr><th></th><th></th><th>Total:</th><th><span id='totalAll'>"+total+"</span></th></tr>";
		message += "</tbody></table></div></div>";
	} else {
		message += "<p>No items in the car yet...</p>";
	}

	return new ModelAndView("Cart", "cart", message);
}

@RequestMapping( value={"/stores"})
public ModelAndView getStores(HttpSession session){
	String message = "";
	String estadio = (String) session.getAttribute("estadio");
	List<MartTienda> shit = tiendaController.getAll(estadio);
	System.out.println("Shit from the get tienda happens");
	for(int i=0; i<shit.size();i++){
		MartTienda tienda = new MartTienda();
		tienda = shit.get(i);
		message += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>";
		message += "<img src='images/"+tienda.getImagen()+"' height='200px'><div class='caption'>";
		message += "<div><h3>"+tienda.getTienda()+"</h3></div><p>"+tienda.getDesc()+"</p>";
		//message += "<p>"+tienda.getEstadio()+"</p>";
		message += "<p><button onclick='searchStoreArticles("+tienda.getId()+");' class='btn btn-primary' type='button'>Ver artículos</button></p>";
		message += "</div></div></div>";
	}

	return new ModelAndView("Products", "products", message);
}

/*
@RequestMapping( value={"/user/insert/{name}/{email}/{pass}"})
public ModelAndView insertUser( @PathVariable(value="name") String n,
@PathVariable(value="email") String e,
@PathVariable(value="pass") String p
){

MartUser user = new MartUser();
user.setEmail(e);
user.setName(n);
user.setPass(p);


int r = userController.insertUser(user);

String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Users controller Insertion " + r +"**********</div><br><br>";
return new ModelAndView("welcome", "message", message);


}*/

@RequestMapping(value = "/postUser")
public ModelAndView addUser(HttpSession session,@RequestParam("email") String e ,@RequestParam("password") String p){
	System.out.println(e + ":::" + p);
	MartUser user = userController.getAccess(e,p);
	if(user!=null){
		session.setAttribute("email",e);
		session.setAttribute("name",user.getName());
		session.setAttribute("user", user.getId());
		session.setAttribute("saldo", user.getSaldo());
		return new ModelAndView("Code", "shittymessage" , user.getName());
	} else {
		return new ModelAndView("Login", "shittymessage" , "User or Password is incorrect...");
	}
}


@RequestMapping(value="/postLogout")
public ModelAndView payCart(
		HttpSession session){
	session.invalidate();
	//System.out.println("controller here! " + info );
	String message = "Welcome to the new stadium platform!!!";
	return new ModelAndView("Login", "shittymessage", message);
}

@RequestMapping(value = "/tienda")
public ModelAndView getStoreArticles(HttpSession session,@RequestParam("tienda") int t){
	String message = "";
	List<MartProduct> shit = productController.getAllProductsTienda(t);
	for(int i=0; i<shit.size();i++){
		MartProduct producto = new MartProduct();
		producto = shit.get(i);
		message += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>";
		message += "<img src='images/"+producto.getImage()+"' height='200px'><div class='caption'>";
		message += "<div><h3>"+producto.getName()+"</h3></div><p>"+producto.getDescription()+"</p>";
		//message += "<p>"+tienda.getEstadio()+"</p>";
		message += "<p><button onclick='searchProduct("+producto.getId()+");' class='btn btn-primary' type='button'>Añadir al Carrito</button></p>";
		message += "</div></div></div>";
	}

	return new ModelAndView("Products", "products", message);
}

@RequestMapping(value = "/postStart")
public ModelAndView getStart(HttpSession session,@RequestParam("password") String p){
	MartAsiento asiento = asientoController.getSeat2(p);
	MartEstadio est;
	if(asiento!=null){
		String stadium= asiento.getEstadio();
		//System.out.println("stadium:  "+stadium);
		est = estadioController.getStadium(stadium);
		
		session.setAttribute("codigo", p);
		session.setAttribute("estadio", stadium);
		return new ModelAndView("Mart", "username",est.getNombre() );
	}else{
		return new ModelAndView("Code", "shittymessage" , "El código no existe");
	}
}

@RequestMapping(value = "/start")
public ModelAndView findUnique(HttpSession session){
	String name = (String) session.getAttribute("name");
	return new ModelAndView("Mart", "username",name );
}

@RequestMapping(value = "")
public ModelAndView getSeats(HttpSession session){
	return new ModelAndView("Mart", "username" , "Shit");
}

@RequestMapping(value = "/pay")
public ModelAndView pay(HttpSession session,@RequestParam("id") int id ,@RequestParam("pay") float pay){
	
	
	
	String num= (String)session.getAttribute("codigo");
	Date myDate = new Date();
	String date = ""+myDate;
	userController.updateUser(id, pay);
	
	pedidoController.insertPedido(num, pay, date, "l");
	MartUser us = userController.getUser(id);
	
	session.setAttribute("saldo", us.getSaldo());
	
	
	
	String message = "";
	message += "<div class='panel panel-default'><div class='panel-heading'>";
	message += "<h3 class='panel-title'>Shopping Cart</h3></div><div class='panel-body'>";
	message += "<br>ID: <span class='hidden' id='userId'>"+session.getAttribute("user")+"</span>";
	message += "<div><h3>NAME: "+session.getAttribute("name")+"</h3></div>";
	message += "<p>BALANCE: <span id='balance'>"+session.getAttribute("saldo")+"</span></p>";
	message += "<p><button onclick='pay();' class='btn btn-primary' type='button'>Pay</button></p>";
	message += "<br><br>";
	
	MartPedido ped=pedidoController.getLastPedido();
	
	List<Cart> carts1 = (List<Cart>)session.getAttribute("carts");
	for(int i=0; i<carts1.size();i++){
		Cart car1 = carts1.get(i);
		MartProduct prod1 = productController.getProduct(car1.getId());
		prodPorPedidoController.insertProdPedido(ped.getId(), prod1.getId(), car1.getQty());
	}
	
	session.setAttribute("carts", null);
	if(session.getAttribute("carts")!=null){
		List<Cart> carts = (List<Cart>)session.getAttribute("carts");
		
		float total = 0;
		message += "<table class='table table-hover'><thead><tr><th>Product</th><th>Price</th><th>Quantity</th><th>Total</th><th></th></tr></thead><tbody>";
		if(carts.size()==0){
			
			
		}else{
			for(int i=0; i<carts.size();i++){
				Cart car = carts.get(i);
				MartProduct prod = productController.getProduct(car.getId());
				System.out.println("->>>>>>id: "+ped.getId()+" idP: "+prod.getId()+" can: "+car.getQty());
				
				float price = prod.getPrice();
				float qty = car.getQty();
				message += "<tr>";
				message += "<td>"+prod.getName()+"</td><td>"+prod.getPrice()+"</td><td>"+car.getQty()+"</td><td>"+price*qty+"</td><td><button onclick='remove("+i+");' class='btn btn-danger' type='button'>Remove</button></td>";
				message += "</tr>";
				total = total + (price*qty);
			}
		}
			
		message += "<tr><th></th><th></th><th>Total:</th><th><span id='totalAll'>"+total+"</span></th></tr>";
		message += "</tbody></table></div></div>";
	} else {
		message += "<p>No items in the car yet...</p>";
	}
	
	return new ModelAndView("Cart", "cart", message);
}

@RequestMapping(value = "/postCart")
public ModelAndView addCart(HttpSession session,@RequestParam("id") int id ,@RequestParam("qty") int qty){
	Cart cart = new Cart();
	cart.setId(id);
	cart.setQty(qty);
	//System.out.println(cart);
	if(session.getAttribute("carts")!=null){
		List<Cart> carts = (List<Cart>)session.getAttribute("carts");
		carts.add(cart);
		session.setAttribute("carts", carts);
	} else {
		List<Cart> carts = new ArrayList<Cart>();
		carts.add(cart);
		session.setAttribute("carts", carts);
	}
	
	List<Cart> carrits = (List<Cart>)session.getAttribute("carts");
	if(carrits.size()>3){
		Cart car = carrits.get(2);
		System.out.println("Cart: Id "+car.getId()+"|Qty "+car.getQty());
	}
	
	String message = "";
	String estadio = (String) session.getAttribute("estadio");
	List<MartTienda> shit = tiendaController.getAll(estadio);
	System.out.println("Shit from the get tienda happens");
	for(int i=0; i<shit.size();i++){
		MartTienda tienda = new MartTienda();
		tienda = shit.get(i);
		message += "<div class='col-sm-6 col-md-4'><div class='thumbnail'>";
		message += "<img src='images/"+tienda.getImagen()+"' height='200px'><div class='caption'>";
		message += "<div><h3>"+tienda.getTienda()+"</h3></div><p>"+tienda.getDesc()+"</p>";
		//message += "<p>"+tienda.getEstadio()+"</p>";
		message += "<p><button onclick='searchStoreArticles("+tienda.getId()+");' class='btn btn-primary' type='button'>Ver artículos</button></p>";
		message += "</div></div></div>";
	}

	return new ModelAndView("Products", "products", message);
}

@RequestMapping(value = "/remove")
public ModelAndView remove(HttpSession session,@RequestParam("index") int index){
	
	List<Cart> ca = (List<Cart>)session.getAttribute("carts");
	
	ca.remove(index);
	
	session.setAttribute("carts", ca);
	
	String message = "";
	message += "<div class='panel panel-default'><div class='panel-heading'>";
	message += "<h3 class='panel-title'>Shopping Cart</h3></div><div class='panel-body'>";
	message += "<br>ID: <span class='hidden' id='userId'>"+session.getAttribute("user")+"</span>";
	message += "<div><h3>NAME: "+session.getAttribute("name")+"</h3></div>";
	message += "<p>BALANCE: <span id='balance'>"+session.getAttribute("saldo")+"</span></p>";
	message += "<p><button onclick='pay();' class='btn btn-primary' type='button'>Pay</button></p>";
	message += "<br><br>";
	
	
	if(session.getAttribute("carts")!=null){
		List<Cart> carts = (List<Cart>)session.getAttribute("carts");
		
		float total = 0;
		message += "<table class='table table-hover'><thead><tr><th>Product</th><th>Price</th><th>Quantity</th><th>Total</th><th></th></tr></thead><tbody>";
		if(carts.size()==0){
			
			
		}else{
			for(int i=0; i<carts.size();i++){
				Cart car = carts.get(i);
				MartProduct prod = productController.getProduct(car.getId());
				float price = prod.getPrice();
				float qty = car.getQty();
				message += "<tr>";
				message += "<td>"+prod.getName()+"</td><td>"+prod.getPrice()+"</td><td>"+car.getQty()+"</td><td>"+price*qty+"</td><td><button onclick='remove("+i+");' class='btn btn-danger' type='button'>Remove</button></td>";
				message += "</tr>";
				total = total + (price*qty);
			}
		}
			
		message += "<tr><th></th><th></th><th>Total:</th><th><span id='totalAll'>"+total+"</span></th></tr>";
		message += "</tbody></table></div></div>";
	} else {
		message += "<p>No items in the car yet...</p>";
	}

	return new ModelAndView("Cart", "cart", message);
}

/*
* @RequestMapping(value = "/someUrl")
public String someMethod(@RequestParam("value1") String valueOne) {

*
* */
}