package br.univille.sistemamercado.controller;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.sistemamercado.entity.ItensLista;
import br.univille.sistemamercado.entity.ListaCompra;
import br.univille.sistemamercado.service.ClienteService;
import br.univille.sistemamercado.service.EntregaService;
import br.univille.sistemamercado.service.ListaCompraService;
import br.univille.sistemamercado.service.ProdutoService;

@Controller
@RequestMapping("/listacompras")
public class ListaCompraController {
    
    @Autowired
    private ListaCompraService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EntregaService entregaService;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(){
        var listaCompra = service.getAll();
        return new ModelAndView("listacompra/index","listaCompra",listaCompra);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var listacompra = new ListaCompra();
        var listaClientes = clienteService.getAll();
        var listaEntregas = entregaService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listacompra", listacompra);
        dados.put("listaClientes",listaClientes);
        dados.put("listaEntregas",listaEntregas);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem",new ItensLista());
        return new ModelAndView("listacompra/form",dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(ListaCompra listacompra){
        
        service.save(listacompra);
        return new ModelAndView("redirect:/listacompras");
    }
    
    @PostMapping(params = "incitem")
    public ModelAndView incluirItem(ListaCompra listaCompra, 
                ItensLista novoItem){
        listaCompra.getListaItens().add(novoItem);
        
        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listacompra",listaCompra);
        dados.put("listaClientes",listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem",new ItensLista());
        return new ModelAndView("listaCompra/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerItem(@RequestParam("removeitem") int index, ListaCompra listaCompra){
        listaCompra.getListaItens().remove(index);

        var listaClientes = clienteService.getAll();
        var listaProdutos = produtoService.getAll();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listacompra",listaCompra);
        dados.put("listaClientes",listaClientes);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoItem",new ItensLista());
        return new ModelAndView("listaCompra/form", dados);
    }

}
