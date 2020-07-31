package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seguradoradep")
public class dependenteController {
    listaDependentes listaDependentes = new listaDependentes();

    @Autowired
    private dependenteRepository dependenteRepository; 
    
    @GetMapping("/")
    public String formulario(){
      return "dependenteFormulario";
    }

    @PostMapping(path="/adddependente") // Map ONLY POST Requests
  public @ResponseBody String addNewdependente (
      @RequestParam String nome,
      @RequestParam Integer idade) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    dependente a = new dependente();
    a.setNome(nome);
    a.setIdade(idade);
    dependenteRepository.save(a);
    return "dependente_adicionado";
  }
  @GetMapping(path="/listadep")
  public @ResponseBody String getAlldependente() {
    return listaDependentes.exibeListaDependentes(dependenteRepository.findAll());
  }

  @GetMapping(path="/filtroDepForm")
    public String filtroForm(){
      return "filtroDepForm";
    }
    
  @GetMapping(path="/filtrodep")
  public @ResponseBody String getDependente(@RequestParam Integer idade) {
      Iterable<dependente> resultado = dependenteRepository.findIdadeDependente(idade);
    return listaDependentes.exibeListaDependentes(resultado);
  }
}