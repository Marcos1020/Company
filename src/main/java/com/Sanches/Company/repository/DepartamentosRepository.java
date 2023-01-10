package com.Sanches.Company.repository;

import com.Sanches.Company.entity.Departamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentosRepository extends JpaRepository<Departamentos, Long> {

    Departamentos findByNomeDepartamento(final String nomeDepartamento);
}
