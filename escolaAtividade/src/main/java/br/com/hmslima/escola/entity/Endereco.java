package br.com.hmslima.escola.entity;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="rua")
    private String rua;

    @Column(name="numero")
    private int numero;

    public Endereco() {
    }

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
