package com.Sanches.Company.controller.response;

import com.Sanches.Company.utils.ConverterUtil;
import com.Sanches.Company.utils.DateAndTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponse {

    private Long idFuncionario;
    private Long idDepartamento;
    private String nome;
    private String cpf;
    private String tarefas;
    @JsonDeserialize(using = DateAndTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ConverterUtil.FORMATO_DATA)
    private Date dataRegistro;
}
