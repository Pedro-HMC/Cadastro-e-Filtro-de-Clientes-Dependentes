package com.programem.consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//Classe auxiliar, funciona como um local para armazenamento de dependentes

public interface dependenteRepository extends CrudRepository<dependente, Integer>{

    @Query(
  value = "SELECT * FROM dependente d WHERE d.idade > :idade", 
  nativeQuery = true)
Iterable<dependente> findIdadeDependente(@Param("idade")Integer idade);
}