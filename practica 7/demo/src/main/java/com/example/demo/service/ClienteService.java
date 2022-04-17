package com.example.demo.service;

import com.example.demo.service.dto.*;
import com.example.demo.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> getClientes();

    List<ClienteElectrodomesticoDTO> getClientesConElectrodomesticos();

    Cliente updateCliente(Long id, Cliente cliente);

    Cliente deleteCliente(Long id);

}
