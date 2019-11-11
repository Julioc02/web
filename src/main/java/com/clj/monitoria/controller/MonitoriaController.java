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

import com.clj.monitoria.model.Aluno;
import com.clj.monitoria.model.Monitores;
import com.clj.monitoria.repository.Alunos;
import com.clj.monitoria.repository.Monitor;

@Controller
public class MonitoriaController {
	
	@Autowired
	Monitor monitor;
		
    @GetMapping("/")
    public ModelAndView ListarHome() {
   	 ModelAndView modelAndView = new ModelAndView("index");
   	 modelAndView.addObject("Monitores", monitor.findAll());
   	 modelAndView.addObject(new Monitores());
   	 return modelAndView;
    }
    
    
    
    
    
    @PostMapping("/monitores")
    public String salvar(@Valid Monitores monitores, BindingResult result,
    		RedirectAttributes attributes) {
    	if(result.hasErrors()) {
    		return "redirect:/";
    	}
   	  monitor.save(monitores);	
   	  attributes.addFlashAttribute("mensagem", "Monitor salvo com sucesso!");	
   	 return "redirect:/";
    }
    
    
    @PostMapping("/malterar")
    public String editarm(@Valid Monitores monitores, BindingResult result,
    		RedirectAttributes attributes) {	
    	if(result.hasErrors()) {
    		return "editarMonitores";
    	}
    	monitor.save(monitores);
    	attributes.addFlashAttribute("sms", "Monitor editado com sucesso!");
    	return "redirect:/";
    }
    

    
    
   @GetMapping("/deletar/{id}")
   public String deletar(@PathVariable("id") Long id) {
   	monitor.deleteById(id);
   	return "redirect:/";
    }
   
   @GetMapping("/editarMonitor/{id}")
   public String editarMonitor(@PathVariable("id") Long id,  Model model) {
   	model.addAttribute("dados", monitor.findById(id));
   	return "editarMonitores";
    }

  
}

