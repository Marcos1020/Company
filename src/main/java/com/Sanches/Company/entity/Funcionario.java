package com.Sanches.Company.entity;

import com.Sanches.Company.utils.Constants;
import com.Sanches.Company.utils.ConverterUtil;
import com.Sanches.Company.utils.DateAndTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_FUNCIONARIO")
@SequenceGenerator(name = "sq_tb_funcionario", sequenceName = Constants.SQ_TB_FUNCIONARIO, allocationSize = 1)
public class Funcionario {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tb_funcionario")
    @Id
    @Column(name = "ID_FUNCIONARIO")
    private Long idFuncionario;
    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TAREFAS")
    private String tarefas;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_REGISTRO")
    private Date dataRegistro;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ALTERACAO")
    private Date dataAlteracao;
}
