package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import az.developia.bookshopping_yaqub_e.dao.UserDAO;
import az.developia.bookshopping_yaqub_e.model.User;

@Controller
public class UserController {
	
   @Autowired
   private UserDAO userDAO;
   	
   @GetMapping(path="/createUserShowForm")
   public String showNewUserFormPage(Model model){
	   User user = new User();
	   model.addAttribute("user",user);
	   return "create-user-form";
   }
   
   @RequestMapping(value = "/createUserProcess", method = RequestMethod.POST)
	public String createUserProcess(  @ModelAttribute("user") User user,Model model) {
     String viewName="";
	  
	  boolean result=  userDAO.createUser(user);
	if(result){
		model.addAttribute("userCreatedSuccessfully", "");
		System.out.println(user);
		viewName="my-custom-login";
	}else{
		model.addAttribute("userAlreadyExists", "");
		viewName="create-user-form";
	}
		 
		return viewName;
	}
	
}
