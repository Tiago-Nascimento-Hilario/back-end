package com.tiago.controle_equipamentos.controller;

import com.tiago.controle_equipamentos.model.Equipamento;
import com.tiago.controle_equipamentos.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping()
    public  String listar(Model model){
        model.addAttribute("equipamentos", equipamentoRepository.findAll());
        return "equipamentos/lista";
    }

    @GetMapping("/novo")
    public String formulario(Model model){
        model.addAttribute("equipamento", new Equipamento());
        return  "equipamentos/formulario";
    }

    @PostMapping
    public  String salvar(@ModelAttribute Equipamento equipamento){
        equipamentoRepository.save(equipamento);
        return  "redirect:/equipamentos";
    }

}
