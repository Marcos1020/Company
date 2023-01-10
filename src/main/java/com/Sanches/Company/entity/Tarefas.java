package com.Sanches.Company.entity;

import com.Sanches.Company.enums.StatusTarefa;
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
@Table(name = "TB_TAREFAS")
@SequenceGenerator(name = "sq_tb_tarefas", sequenceName = Constants.SQ_TB_TAREFAS, allocationSize = 1)
public class Tarefas {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tb_tarefas")
    @Id
    @Column(name = "ID_TAREFA")
    private Long idTarefa;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "PRAZO")
    private String prazo;
    @Column(name = "ID_DEPARTAMENTO")
    private Long idDepartamento;
    @Column(name = "DURACAO")
    private Long duracao;
    @Column(name = "ID_FUNCIONARIO")
    private Long idFuncionario;
    @Column(name = "STATUS_TAREFA")
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_REGISTRO")
    private Date dataRegistro;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_FINALIZACAO")
    private Date dataFinalizacao;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DT_ALOCACAO")
    private Date dataAlocaFuncionario;
}