package net.atos.crojo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.atos.crojo.dao.UserDAO;
import net.atos.crojo.model.User;



@Controller
public class AppController_User {
	
	private static Logger logJava = Logger.getLogger(AppController_User.class);
	
	@Autowired
	private UserDAO dao;
	
	@RequestMapping("/Crud/User")
	public String viewHomePage(Model model) {
		List<User> listUser = dao.list();
		model.addAttribute("listUser", listUser);
		logJava.info("new_form_User");
		System.out.println("aqui");
	    return "Crud/User";
	}
	
	@RequestMapping("/New/new_User")
	public String showNewForm(Model model) {
		User User = new User();
	    model.addAttribute("User", User);
	    logJava.info("new_form_User");
	    return "New/new_form_User";
	}
	
	@RequestMapping(value = "/save_User", method = RequestMethod.POST)
	public String save(@ModelAttribute("User") User User) {
	    dao.save(User);
	    logJava.info("redirect:/Crud/User");
	    return "redirect:/Crud/User";
	}
	
	@RequestMapping("/Edit/edit_User/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") String id) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_User");
	    User User = dao.get(id);
	    mav.addObject("User", User);
	    logJava.info("/Edit/edit_User/{id}");
	    return mav;
	}
	
	@RequestMapping(value = "/update_User", method = RequestMethod.POST)
	public String update(@ModelAttribute("User") User User) {
	    dao.update(User);
	    logJava.info("redirect:/Crud/User");
	    return "redirect:/Crud/User";
	}
	
	@RequestMapping("/delete_User/{id}")
	public String delete(@PathVariable(name = "id") String id) {
	    dao.delete(id);
	    logJava.info("redirect:/Crud/User");
	    return "redirect:/Crud/User";       
	}	
}
