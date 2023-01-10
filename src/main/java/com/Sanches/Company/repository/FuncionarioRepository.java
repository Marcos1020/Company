package com.Sanches.Company.repository;

import com.Sanches.Company.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByCpf(final String cpf);
    @Query("FROM Funcionario func WHERE func.nome = :nome OR func.cpf = :cpf")
    List<Funcionario> findByNomeOrCpf(@Param(value ="nome")final String nome, @Param(value = "cpf")final String cpf);
}
