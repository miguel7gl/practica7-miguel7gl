package com.example.demo.service;

import com.example.demo.service.dto.*;

import java.util.List;

public interface ElectrodomesticoService {

    List<ElectrodomesticoDTO> getElectrodomesticos();

    List<ClienteElectrodomesticoDTO> getElectrodomesticosConClientes();
    
}
