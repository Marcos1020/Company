package com.Sanches.Company.repository;

import com.Sanches.Company.entity.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefas, Long> {

    Tarefas findByTitulo(final String Titulo);
}
