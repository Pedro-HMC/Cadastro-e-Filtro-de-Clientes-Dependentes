package com.programem.consulta;

public class listaDependentes {
    public String exibeListaDependentes(Iterable<dependente> lista){
        String html = "";

        for(dependente d : lista){
            html = html +
            "<h1>"+ d.getNome()+"</h1>"+
            d.getIdade()+"<br>"
            ;
        }
        return html;
    }
}