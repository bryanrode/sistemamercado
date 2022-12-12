package br.univille.sistemamercado.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ListaCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float valorTotal;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) 
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItensLista> listaItens = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) 
    private Entrega endereco;
    
   
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public List<ItensLista> getListaItens() {
        return listaItens;
    }
    public void setListaItens(List<ItensLista> listaItens) {
        this.listaItens = listaItens;
    }
    public Entrega getEndereco() {
        return endereco;
    }
    public void setEndereco(Entrega endereco) {
        this.endereco = endereco;
    }

}
