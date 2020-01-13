package com.clj.monitoria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clj.monitoria.model.Aluno;

import com.clj.monitoria.repository.Alunos;


@Controller
public class AlunoController {
     @Autowired
     Alunos alunos;
     //metodo para retornar a pagina de login customizada
     
      @GetMapping("/login")
       public String login() {
    	   return "login";
       }
      
     @GetMapping("/")
     public String PaginaInicial() {
    	 return "Home";
     }
  
     
      
    
     @GetMapping("/adm")
     public ModelAndView Listar(Aluno aluno) {
  	   ModelAndView modelAndView = new ModelAndView("alunos");
  	   modelAndView.addObject("Alunos", alunos.findAll());
  	   modelAndView.addObject(new Aluno());
  	   return modelAndView;
     }
     
    
     
     @GetMapping("/aluno")
     public String salvar(@Valid Aluno aluno,  BindingResult result,
     		RedirectAttributes attributes) {
     	if(result.hasErrors()) {
     
     	}
    	  alunos.save(aluno);	
    	  attributes.addFlashAttribute("mensagem", "O aluno(a) "+aluno.getNome()+ " Foi cadastrado com sucesso!");	
    	 return "redirect:/adm";
     }
     
     @GetMapping("/EA")
     public String sms(@Valid Aluno aluno, BindingResult result,
    		 RedirectAttributes attributes) {
    	 if(result.hasErrors()) {
      		return "redirect:/adm";
      	}
         attributes.addFlashAttribute("message", "Aluno editado com sucesso!");
    	 alunos.save(aluno);
    	 return "redirect:/adm";
     }
          
     @GetMapping("/delete/{id}")
     public String delete(@PathVariable("id") Long id) {
    	alunos.deleteById(id);
    	return "redirect:/adm";
     }
     
     @GetMapping("/editarAlunos/{id}")
     public String editarAlunos(@PathVariable("id") Long id,  Model model) {
     	model.addAttribute("dados", alunos.findById(id));
     	return "editarAlunos";
      }

     
     
     
     
     
     
     @GetMapping("/userp1")
     public ModelAndView Lista() {
  	   ModelAndView modelAndView = new ModelAndView("useraluno");
  	   modelAndView.addObject("Alunos", alunos.findAll());
  	   modelAndView.addObject(new Aluno());
  	   return modelAndView;
     }

     
     
     @GetMapping("/user")
     public String SalvarUser(@Valid Aluno aluno,  BindingResult result,
     		RedirectAttributes attributes) {
     	if(result.hasErrors()) {
     		return "redirect:/userp1";
     	}
    	  alunos.save(aluno);	
    	  attributes.addFlashAttribute("mensagem", "O aluno(a) "+aluno.getNome()+ " Foi cadastrado com sucesso!");	
    	 return "redirect:/userp1";
     }

     
     
    
}
