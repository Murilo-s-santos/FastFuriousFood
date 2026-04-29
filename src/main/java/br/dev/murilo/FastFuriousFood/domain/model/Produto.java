package br.dev.murilo.FastFuriousFood.domain.model;

import br.dev.murilo.FastFuriousFood.domain.model.enums.CategoriaProduto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String nome;
    private double vUnit;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    public Produto() {
    }

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

    // Ajustado para refletir o nome do atributo vUnit
    public double getvUnit() {
        return vUnit;
    }

    public void setvUnit(double vUnit) {
        this.vUnit = vUnit;
    }

    // Ajustado para refletir o nome do atributo descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Produto other = (Produto) obj;
        return this.id == other.id;
    }
}