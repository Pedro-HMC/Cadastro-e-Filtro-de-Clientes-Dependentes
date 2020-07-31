package com.programem.consulta;

public class listaCliente {
    public String exibeListaCliente(Iterable<cliente> lista){
        String html = "";

        for(cliente c : lista){
            html = html +
            "<h1>"+ c.getNome()+"</h1>"+
            c.getIdade()+"<br>"+
            c.getEndereco()
            ;
        }
        return html;
    }
}