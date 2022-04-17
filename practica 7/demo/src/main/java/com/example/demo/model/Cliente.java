package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("CUSTOMERS")
public class Cliente {
	private @Column("ID") @Id Long clienteId;
	private @Column("NOMBRE") String clienteNombre;
	private @Column("PAIS") String clientePais;
	private @Column("EMAIL") String clienteEmail;
}