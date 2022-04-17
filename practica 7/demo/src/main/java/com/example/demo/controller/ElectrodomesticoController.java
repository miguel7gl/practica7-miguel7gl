package com.example.demo.controller;

import com.example.demo.service.ClienteService;
import com.example.demo.service.ElectrodomesticoService;
import com.example.demo.service.dto.ClienteElectrodomesticoDTO;
import com.example.demo.service.dto.ElectrodomesticoDTO;
//import com.example.demo.service.dto.OrderProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ElectrodomesticoController {

    @Autowired
    private ElectrodomesticoService electrodomesticoService;

    @GetMapping("/electrodomesticos")
    public ResponseEntity<List<ElectrodomesticoDTO>> getElectrodomesticos() {
        var electrodomesticos = electrodomesticoService.getElectrodomesticos();
        return ResponseEntity.ok().body(electrodomesticos);
    }

    //INNER-JOIN
    @GetMapping("/electrodomesticos/con-clientes")
    public ResponseEntity<List<ClienteElectrodomesticoDTO>> getOrdersWithCustomers() {
        var electrodomesticos = electrodomesticoService.getElectrodomesticosConClientes();
        return ResponseEntity.ok().body(electrodomesticos);
    }
}
