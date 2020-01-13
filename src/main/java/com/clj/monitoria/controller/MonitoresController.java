package com.clj.monitoria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clj.monitoria.model.Monitores;
import com.clj.monitoria.repository.Monitor;

@Controller
public class MonitoresController {
	 @Autowired
     Monitor monitor; 
     
     @GetMapping("/monitores")
     public ModelAndView Listar() {
  	   ModelAndView modelAndView = new ModelAndView("monitoria");
  	   modelAndView.addObject("Monitores", monitor.findAll());
  	   modelAndView.addObject(new Monitores());
  	   return modelAndView;
     }
     
   
     
     @GetMapping("/monit")
     public String Salvar(@Valid Monitores monitores,  BindingResult result,
     		RedirectAttributes attributes) {
     	if(result.hasErrors()) {
     		return "redirect:/monitores";
     	}
    	  monitor.save(monitores);
    	  attributes.addFlashAttribute("sms", "O monitor(a) "+monitores.getNome()+ " Foi cadastrado com sucesso!");	
    	 return "redirect:/monitores";
     }
     
     
     
     @GetMapping("/EM")
     public String salvar(@Valid Monitores monitores,  BindingResult result,
     		RedirectAttributes attributes) {
     	if(result.hasErrors()) {
     		return "redirect:/monitores";
     	}
    	  monitor.save(monitores);
    	  attributes.addFlashAttribute("mensa", "Monitor editado com sucesso!");	
    	 return "redirect:/monitores";
     }
     
     
   
          
     @GetMapping("/DMonitores/{id}")
     public String delete(@PathVariable("id") Long id) {
    	monitor.deleteById(id);
    	return "redirect:/monitores";
     }
     
     @GetMapping("/editarMonitores/{id}")
     public String editarAlunos(@PathVariable("id") Long id,  Model model) {
     	model.addAttribute("dados", monitor.findById(id));
     	return "editarMonitores";
      }

     
     
     
     
     @GetMapping("/userp2")
     public ModelAndView Lista() {
  	   ModelAndView modelAndView = new ModelAndView("usermonitores");
  	   modelAndView.addObject("Monitores", monitor.findAll());
  	   modelAndView.addObject(new Monitores());
  	   return modelAndView;
     }
     
     
     @GetMapping("/user1")
     public String SalvarMonitores(@Valid Monitores monitores,  BindingResult result,
     		RedirectAttributes attributes) {
     	if(result.hasErrors()) {
     		return "redirect:/userp2";
     	}
    	  monitor.save(monitores);
    	  attributes.addFlashAttribute("sms", "O monitor(a) "+monitores.getNome()+ " Foi cadastrado com sucesso!");	
    	 return "redirect:/userp2";
     }
     

     
    

}
