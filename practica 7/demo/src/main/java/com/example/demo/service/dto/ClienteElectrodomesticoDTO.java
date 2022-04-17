package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteElectrodomesticoDTO {
    private Long ClienteId;
	private String clienteNombre;
	private String clientePais;
	private String clienteEmail;
    private Long elecId;
    private Long elecCliente;
    private Long elecPotencia;
    private Long elecTiempoFuncionamiento;
}
