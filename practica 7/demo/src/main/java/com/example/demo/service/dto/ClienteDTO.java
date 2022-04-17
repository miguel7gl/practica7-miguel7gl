package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	private Long clienteId;
	private String clienteNombre;
	private String clientePais;
	private String clienteEmail;
}