package com.programem.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seguradora")
public class clienteController {

  

    @Autowired
    private clienteRepository ClienteRepository; 
    private listaCliente c = new listaCliente();

    @GetMapping("/")
    public String formulario(){
      return "clienteFormulario";
    }

    @PostMapping(path="/adicionar") // Map ONLY POST Requests
  public @ResponseBody String addNewcliente (
      @RequestParam String nome,
      @RequestParam String endereco,
      @RequestParam Integer idade) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    cliente c = new cliente();
    c.setNome(nome);
    c.setIdade(idade);
    c.setEndereco(endereco);
    ClienteRepository.save(c);
    return "Top";
  }
  @GetMapping(path="/lista")
  public @ResponseBody String getAllCliente() {
      Iterable<cliente> resultado = ClienteRepository.findAll();
    return c.exibeListaCliente(resultado);
  }

  @GetMapping(path="/filtroForm")
    public String filtroForm(){
      return "filtroForm";
    }
    
  @GetMapping(path="/filtro")
  public @ResponseBody String getCliente(@RequestParam Integer idade) {
      Iterable<cliente> resultado = ClienteRepository.findIdadeCliente(idade);
    return c.exibeListaCliente(resultado);
  }
}