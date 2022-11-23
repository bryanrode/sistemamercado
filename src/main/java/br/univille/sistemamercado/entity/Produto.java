package br.univille.sistemamercado.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    private String nome;
    private float valor;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Fornecedor fornProduto;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Fornecedor getFornProduto() {
        return fornProduto;
    }
    public void setFornProduto(Fornecedor fornProduto) {
        this.fornProduto = fornProduto;
    }

}
