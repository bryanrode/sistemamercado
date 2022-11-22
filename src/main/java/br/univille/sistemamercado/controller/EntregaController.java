package br.univille.sistemamercado.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemamercado.entity.Entrega;
import br.univille.sistemamercado.service.EntregaService;

@Controller
@RequestMapping("/entregas")
public class EntregaController {
    
    @Autowired
    private EntregaService service;

    @GetMapping
    public ModelAndView index(){
        var listaEntregas = service.getAll();
        return new ModelAndView("entrega/index","listaEntregas",listaEntregas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var entrega = new Entrega();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("entrega", entrega);
        return new ModelAndView("entrega/form",dados);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(Entrega entrega){
        
        service.save(entrega);
        return new ModelAndView("redirect:/entregas");
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaEntrega = service.findById(id);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("entrega",umaEntrega);
        return new ModelAndView("entrega/form", dados);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable ("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/entregas");
    }
}
