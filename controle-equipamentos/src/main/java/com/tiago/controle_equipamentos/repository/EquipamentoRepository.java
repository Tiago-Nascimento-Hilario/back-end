package com.tiago.controle_equipamentos.repository;

import com.tiago.controle_equipamentos.model.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
