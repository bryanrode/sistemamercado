package br.univille.sistemamercado.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItensLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private float valorVenda;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) 
    private Produto produto;
    
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public float getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public float getValorFinal(){
        return this.getValorVenda() * this.getQuantidade();
    }
}
