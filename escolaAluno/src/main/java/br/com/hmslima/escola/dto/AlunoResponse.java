package br.com.hmslima.escola.dto;

import br.com.hmslima.escola.entity.Aluno;

public class AlunoResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private int ano;
    private EnderecoResponse enderecoResponse;

    // Repare como fiz este construtor
    public AlunoResponse(Aluno aluno) {
        this.nome = aluno.getNome();
        this.sobrenome = aluno.getSobrenome();
        this.ano = aluno.getAno();
    }

    public AlunoResponse(Long id, String nome, String sobrenome, int ano, EnderecoResponse enderecoResponse) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ano = ano;
        this.enderecoResponse = enderecoResponse;
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

    public EnderecoResponse getEnderecoResponse() {
        return enderecoResponse;
    }

    public void setEnderecoResponse(EnderecoResponse enderecoResponse) {
        this.enderecoResponse = enderecoResponse;
    }
}
