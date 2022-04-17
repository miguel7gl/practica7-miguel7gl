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

public class Electrodomestico {
    private @Column("ID") @Id Long elecId;
	private @Column("ID_CLIENTE") Long elecCliente;
	private @Column("POTENCIA") Long elecPotencia;
	private @Column("TIEMPO_FUNCIONAMIENTO") Long elecTiempoFuncionamiento;
}
