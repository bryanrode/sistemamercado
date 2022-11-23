package br.univille.sistemamercado.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ListaCompra {
    // ESSE DAQUI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float valorTotal;
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) 
    private ItensLista listaItens;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) 
    private Cliente cliente;
    
    public ItensLista getListaItens() {
        return listaItens;
    }
    public void setListaItens(ItensLista listaItens) {
        this.listaItens = listaItens;
    }
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

}