package com.apihemocentro.dto;


import java.util.List;

public class BancoDeSangueDTO {

    private Long id;

    private String nome;

    private String endereco;

    private String telefone;

    private List<String> deficitSanguineo;

    private String email;



    public BancoDeSangueDTO(String message) {
        String[] fields = message.split(";");
        this.nome = fields[0];
        this.email = fields[2];
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<String> getDeficitSanguineo() {
        return deficitSanguineo;
    }

    public void setDeficitSanguineo(List<String> deficitSanguineo) {
        this.deficitSanguineo = deficitSanguineo;
    }

    public String getEmail() {   return email;    }

    public void setEmail(String email) {   this.email = email;   }


}
