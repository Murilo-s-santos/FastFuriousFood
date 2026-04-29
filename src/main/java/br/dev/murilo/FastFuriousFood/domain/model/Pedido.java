package br.dev.murilo.FastFuriousFood.domain.model;

import br.dev.murilo.FastFuriousFood.domain.model.enums.StatusPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String cpf;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    private LocalDateTime dtAberto;
    private LocalDateTime dtPronto;
    private LocalDateTime dtEntregue;
    
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
    
    public Pedido(){}
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.id == other.id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDtAberto() {
        return dtAberto;
    }

    public void setDtAberto(LocalDateTime dtAberto) {
        this.dtAberto = dtAberto;
    }

    public LocalDateTime getDtPronto() {
        return dtPronto;
    }

    public void setDtPronto(LocalDateTime dtPronto) {
        this.dtPronto = dtPronto;
    }

    public LocalDateTime getDtEntregue() {
        return dtEntregue;
    }

    public void setDtEntregue(LocalDateTime dtEntregue) {
        this.dtEntregue = dtEntregue;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
      
}
