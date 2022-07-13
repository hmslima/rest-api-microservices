package br.com.hmslima.escola.entity;

import br.com.hmslima.escola.dto.AlunoResponse;
import br.com.hmslima.escola.dto.EnderecoResponse;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="ano")
    private int ano;

    @Column(name="endereco_id")
    private Long enderecoId;

    public Aluno() {
    }

    public Aluno(String nome, String sobrenome, int ano, Long enderecoId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ano = ano;
        this.enderecoId = enderecoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public AlunoResponse getDto () {
        return new AlunoResponse(this.id, this.nome, this.sobrenome, this.ano, new EnderecoResponse());
    }
}
