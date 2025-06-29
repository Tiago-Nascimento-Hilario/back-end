package com.tiago.controle_equipamentos.controller;

import com.tiago.controle_equipamentos.model.Chamado;
import com.tiago.controle_equipamentos.model.Equipamento;
import com.tiago.controle_equipamentos.model.Status;
import com.tiago.controle_equipamentos.repository.ChamadoRepository;
import com.tiago.controle_equipamentos.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @GetMapping("/novo/{equipamentoId}")
    public String formulario(@PathVariable Long equipamentoId, Model model) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(equipamentoId);
        if (equipamento.isPresent()) {
            Chamado chamado = new Chamado();
            chamado.setEquipamento(equipamento.get());
            model.addAttribute("chamado", chamado);
            model.addAttribute("statusList", Status.values());
            return "chamados/formulario";
        } else {
            return "redirect:/equipamentos";
        }
    }

    @PostMapping
    public String salvar(@ModelAttribute Chamado chamado) {
        chamadoRepository.save(chamado);
        return "redirect:/chamados/" + chamado.getEquipamento().getId();
    }


    @GetMapping("/{equipamentoId}")
    public String listar(@PathVariable Long equipamentoId, Model model) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(equipamentoId);
        if (equipamento.isPresent()) {
            model.addAttribute("equipamento", equipamento.get());
            model.addAttribute("chamados", chamadoRepository.findByEquipamento(equipamento.get()));
            return "chamados/lista";
        } else {
            return "redirect:/equipamentos";
        }
    }

}
