package com.Sanches.Company.controller.request;

import com.Sanches.Company.enums.StatusTarefa;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class TarefasRequest {
    @NotEmpty(message = "Campo obrigatório")
    private String titulo;
    @NotEmpty(message = "Campo obrigatório")
    private String Descricao;
    @NotEmpty(message = "Campo obrigatório")
    private String prazo;
    @NotEmpty(message = "Campo obrigatório")
    private Long idDepartamento;
    @NotEmpty(message = "Campo obrigatório")
    private Long duracao;
    private Long idFuncionario;
    @NotEmpty(message = "Campo obrigatório")
    private StatusTarefa status;
}
