package com.Sanches.Company.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
public class FuncionarioRequest {

    private Long idDepartamento;
    @NotEmpty(message = "O campo cpf é obrigatório")
    private String nome;
    @NotEmpty(message = "O campo cpf é obrigatório")
    @Size(min = 11, max = 12, message = "CPF deve conter no minimo 11 caracters")
    private String cpf;
    private String tarefas;
}
