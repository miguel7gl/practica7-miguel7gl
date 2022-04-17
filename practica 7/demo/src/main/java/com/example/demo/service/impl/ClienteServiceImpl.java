package com.example.demo.service.impl;

import com.example.demo.repository.ElectrodomesticoRepository;
import com.example.demo.service.dto.ElectrodomesticoDTO;
import com.example.demo.service.dto.ClienteElectrodomesticoDTO;
import com.example.demo.service.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteDTO> getClientes() {
		return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
				.map(obj -> new ClienteDTO(
						obj.getClienteId(),
						obj.getClienteNombre(),
						obj.getClientePais(),
						obj.getClienteEmail()))
				.toList();
	}

	@Override
	public List<ClienteElectrodomesticoDTO> getClientesConElectrodomesticos() {

		String query= """
    			SELECT C.ID, C.NOMBRE, C.PAIS, C.EMAIL
				FROM CLIENTES C, ELECTRODOMESTICOS E
				WHERE C.ID=O.CLIENTE_ID;
				""";

		List<ClienteElectrodomesticoDTO> electrodomesticoList = jdbcTemplate.query(
				query,
				(rs, rowNum) ->
						new ClienteElectrodomesticoDTO(
								rs.getLong("ID"),
								rs.getString("NOMBRE"),
								rs.getString("PAIS"),
								rs.getString("EMAIL"))
		);

		return electrodomesticoList;
	}

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)){
            return clienteRepository.save(cliente);
        }
        else {
            return null;
        }
    }

    @Override
    public Cliente deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
