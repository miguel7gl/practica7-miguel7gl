package com.example.demo.controller;

import com.example.demo.service.dto.ClienteDTO;
import com.example.demo.service.dto.ClienteElectrodomesticoDTO;
import com.example.demo.service.impl.ElectrodomesticoServiceImpl;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> getAllClientes2() {
        var clientes = clienteService.getClientes();
        return ResponseEntity.ok().body(clientes);
    }

    //CLIENTE-ELECTRODOMESTICO
    @GetMapping("/clientes/con-electrodomesticos")
    public ResponseEntity<List<ClienteElectrodomesticoDTO>> getAllClientes() {
        var electrodomesticos = clienteService.getClientesConElectrodomesticos();
        return ResponseEntity.ok().body(electrodomesticos);
    }

    @PutMapping("/clientes/put-cliente")
    public ResponseEntity<Cliente> updateCliente(String nombre) {
        Cliente cliente = clienteService.updateCliente(nombre);
        if (cliente == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/clientes/eliminar-cliente")
    public ResponseEntity<List<ClienteDTO>> deleteCliente(Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }




}
