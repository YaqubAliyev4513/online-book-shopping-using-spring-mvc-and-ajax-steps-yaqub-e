package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping_yaqub_e.config.MySession;
import az.developia.bookshopping_yaqub_e.dao.BookDAO;
import az.developia.bookshopping_yaqub_e.model.Book;


@Controller
public class BookController {

  @Autowired
  public BookDAO bookDAO;
  private String username;
  
  @Autowired
  private MySession mySession;
	
  @GetMapping(path={"/","/home"})
  public String showHomePage(){
	  return "home";
  }
  
  @GetMapping(path="/showLoginPage")
  public String returnLoginPage(){
	  return "my-custom-login";
  }
  
  
  @GetMapping(path="/books")
  public String showBookListPage(Model model){
	  Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	  String username = loggedInUser.getName();
	  mySession.setMessage("Hello session");
	  mySession.setUsername(username);
	  this.username=username;
	  model.addAttribute("books", bookDAO.findAllByUsername(this.username));
	  return "book-list";
  }
  
  @GetMapping(path="/orders")
  public String showOrdersPage(){
	  return "orders";
  }
  
  @GetMapping(path="/customer")
  public String showCustomerPage(){
	  return "customer-ajax";
  }
  
  
  @GetMapping(path="/addbook")
  public String showAddBookForm(Model model){
	  Book book = new Book();
	  book.setId(0);
	  model.addAttribute("book",book);
	  return "add-book";
  }
  @PostMapping("/addbook/{id}")
	public String addBook(Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-book";
		}
        book.setUsername(username); 
		bookDAO.save(book);
		model.addAttribute("books", bookDAO.findAll());
		return "redirect:/books";
	}
  
  @GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Book book = bookDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

		model.addAttribute("book", book);
		return "edit-book";
	}
  
  @GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id, Model model) {
		Book book = bookDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
		bookDAO.delete(book);
		model.addAttribute("books", bookDAO.findAll());
		return "redirect:/books";
	}
}
