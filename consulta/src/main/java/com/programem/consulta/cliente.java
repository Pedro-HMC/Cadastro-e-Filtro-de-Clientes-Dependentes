package com.programem.consulta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //faz com que o banco de dados crie uma tabela para esse objeto
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    String nome;

    Integer idade;

    String endereco;

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(Integer idade){
        this.idade = idade;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Integer getId(){
        return this.id;
    }

    public String getEndereco(){
        return this.endereco;  
    }

    public String getNome(){
        return this.nome;  
    }

    public Integer getIdade(){
        return this.idade;
    }


}