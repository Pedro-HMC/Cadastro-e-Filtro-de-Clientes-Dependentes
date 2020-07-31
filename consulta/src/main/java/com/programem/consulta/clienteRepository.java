package com.programem.consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//Classe auxiliar, funciona como um local para armazenamento de clientes

public interface clienteRepository extends CrudRepository<cliente, Integer>{
    
    @Query(
  value = "SELECT * FROM cliente c WHERE c.idade > :idade", 
  nativeQuery = true)
Iterable<cliente> findIdadeCliente(@Param("idade")Integer idade);
}