package com.tiago.exspring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TesteController {

    @GetMapping("/teste")
    public String acction(Model model){
        model.addAttribute("nome", "Tiago Nscimento Hilario");
        model.addAttribute("trabalho", "G4F");
        return "teste";
    }


    @GetMapping("/teste2")
    public ModelAndView action2() {
        return new ModelAndView("teste2", Map.of("nome", "treina web"));
    }

    @GetMapping("/teste3")
    public String action3(){
        return"form";
    }
    
    @PostMapping("/teste3")
    public String action4(TesteModel testeModel, Model model){
        model.addAttribute("nome", testeModel.getNome());
        model.addAttribute("idade", testeModel.getIdade());
        System.out.println(testeModel.getNome());
        System.out.println(testeModel.getIdade());   
        return "teste";
    }

}
