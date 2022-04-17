package com.example.demo.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.demo.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("SELECT * FROM CLIENTES")
    List<Cliente> myQuery();

    @Query("UPDATE CLIENTES SET CLIENTES.ID= :idCliente WHERE CLIENTES.ID= :id ")
    @Modifying
    int updateClienteById(@Param("idCliente") Long idCliente, @Param("id") Long id);

    
    
}
