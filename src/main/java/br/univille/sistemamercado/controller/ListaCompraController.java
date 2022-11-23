package br.univille.sistemamercado.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemamercado.entity.ListaCompra;
import br.univille.sistemamercado.service.ListaCompraService;

@Controller
@RequestMapping("/listacompras")
public class ListaCompraController {
    
    @Autowired
    private ListaCompraService service;

    @GetMapping
    public ModelAndView index(){
        var listaCompra = service.getAll();
        return new ModelAndView("listacompra/index","listaCompra",listaCompra);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var listacompra = new ListaCompra();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listacompra", listacompra);
        return new ModelAndView("listacompra/form",dados);
    }

    @PostMapping(params = "form")
    public ModelAndView save(ListaCompra listacompra){
        
        service.save(listacompra);
        return new ModelAndView("redirect:/listacompras");
    }
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var umaListaCompra = service.findById(id);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listacompra",umaListaCompra);
        return new ModelAndView("listacompra/form", dados);

    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable ("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/listacompras");
    }

}
