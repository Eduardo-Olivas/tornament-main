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

import net.atos.crojo.dao.RegistroDAO;
import net.atos.crojo.model.Registro;



@Controller
public class AppController_Registro {
	
	private static Logger logJava = Logger.getLogger(AppController_Registro.class);
	
	@Autowired
	private RegistroDAO dao;
	
	@RequestMapping("/Crud/Registro")
	public String viewHomePage(Model model) {
		List<Registro> listRegistro = dao.list();
		model.addAttribute("listRegistro", listRegistro);
		logJava.info("new_form_Registro");
	    return "Crud/Registro";
	}
	
	@RequestMapping("/New/new_Registro")
	public String showNewForm(Model model) {
		Registro Registro = new Registro();
	    model.addAttribute("Registro", Registro);
	    logJava.info("new_form_Registro");
	    return "New/new_form_Registro";
	}
	
	@RequestMapping(value = "/save_Registro", method = RequestMethod.POST)
	public String save(@ModelAttribute("Registro") Registro Registro) {
	    dao.save(Registro);
	    logJava.info("redirect:/Crud/Registro");
	    return "redirect:/Crud/Registro";
	}
	
	@RequestMapping("/Edit/edit_Registro/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") String id) {
	    ModelAndView mav = new ModelAndView("Edit/edit_form_Registro");
	    Registro Registro = dao.get(id);
	    mav.addObject("Registro", Registro);
	    logJava.info("/Edit/edit_Registro/{id}");
	    return mav;
	}
	
	@RequestMapping(value = "/update_Registro", method = RequestMethod.POST)
	public String update(@ModelAttribute("Registro") Registro Registro) {
	    dao.update(Registro);
	    logJava.info("redirect:/Crud/Registro");
	    return "redirect:/Crud/Registro";
	}
	
	@RequestMapping("/delete_Registro/{id}")
	public String delete(@PathVariable(name = "id") String id) {
	    dao.delete(id);
	    logJava.info("redirect:/Crud/Registro");
	    return "redirect:/Crud/Registro";       
	}	
}
