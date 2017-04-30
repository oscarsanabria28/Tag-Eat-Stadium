package ShopingCart.Fabi.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import mx.org.joe.web.database.MartUser;
//import mx.org.joe.web.database.MartUserController;

@Controller
public class MainScreenController {


//UserInfoBean info;
//MartUserController userController;
/*
public void setUserController(MartUserController userController) {
this.userController = userController;
}
*/
/*
@RequestMapping( value={"/users"})
public ModelAndView getAllUsers(){

System.out.println("controller here! " + userController );

userController.getAllUsers();
String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Users controller **********</div><br><br>";
return new ModelAndView("welcome", "message", message);


}

public void setUserInfoBean(UserInfoBean inf){
info = inf;
}
*/
@RequestMapping( value={"/welcome" })
public ModelAndView helloWorld() {

//System.out.println("controller here! " + info );
String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Hi you from controller in Spring!**********</div><br><br>";
System.out.println(message);
return new ModelAndView("Hola", "message", "Hola mundo");
}

/*
@RequestMapping( value={"/user/{id}"})
public ModelAndView getUser( @PathVariable(value="id") int id ){

System.out.println("controller here! " + userController + " -> with id " + id);

MartUser user = userController.getUser(id);

String message = "<br><div style='text-align:center;'>"
+ "<h3>********** Users controller **********</div><br><br>";
return new ModelAndView("welcome", "message", user.getEmail() );


}

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


}

@RequestMapping(value = "/user/postInsert")
public ModelAndView addUser(
@RequestParam("name") String n,
@RequestParam("email") String e ,
@RequestParam("pass") String p
){

System.out.println(n + ":::" + e + ":::" + p);
return new ModelAndView("ajaxResponse", "responseMessage" , "good! " + n + ":::" + e + ":::" + p);

}
*/
/*
* @RequestMapping(value = "/someUrl")
public String someMethod(@RequestParam("value1") String valueOne) {

*
* */
}