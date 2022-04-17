package com.example.demo.service.impl;

import com.example.demo.repository.ElectrodomesticoRepository;
import com.example.demo.service.ElectrodomesticoService;
import com.example.demo.service.dto.ElectrodomesticoDTO;
import com.example.demo.service.dto.ClienteElectrodomesticoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ElectrodomesticoServiceImpl implements ElectrodomesticoService {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	private ElectrodomesticoRepository electrodomesticoRepository;

	@Override
	public List<ElectrodomesticoDTO> getElectrodomesticos() {
		return StreamSupport.stream(electrodomesticoRepository.findAll().spliterator(), false)
				.map(obj -> new ElectrodomesticoDTO(
						obj.getElectId(),
						obj.getElecCliente(),
						obj.getElecPotencia(),
                        obj.getElecTiempoFuncionamiento()))
				.toList();
	}

	@Override
	public List<ClienteElectrodomesticoDTO> getElectrodomesticosConClientes() {
		// TODO Auto-generated method stub
		return null;
	}
}
