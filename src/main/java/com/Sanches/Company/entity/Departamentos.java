package com.Sanches.Company.entity;

import com.Sanches.Company.utils.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DEPARTAMENTO")
@SequenceGenerator(name = "sq_tb_departamento", sequenceName = Constants.SQ_TB_DEPARTAMENTO, allocationSize = 1)
public class Departamentos {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tb_departamento")
    @NotNull
    @Id
    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;
    @Column(name = "NOME_DEPARTAMENTO")
    private String nomeDepartamento;
}
