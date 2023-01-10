package com.Sanches.Company.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(NON_NULL)
public class DepartamentoRequest {
    private String nomeDepartamento;
}
