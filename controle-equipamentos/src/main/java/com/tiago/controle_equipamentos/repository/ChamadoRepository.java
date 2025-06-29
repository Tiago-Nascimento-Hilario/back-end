package com.tiago.controle_equipamentos.repository;

import com.tiago.controle_equipamentos.model.Chamado;
import com.tiago.controle_equipamentos.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByEquipamento(Equipamento equipamento);
}
