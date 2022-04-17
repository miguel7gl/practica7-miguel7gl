package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectrodomesticoDTO {
    private Long elecId;
    private Long elecCliente;
    private Long elecPotencia;
    private Long elecTiempoFuncionamiento;      
}
