package com.apihemocentro.dto;


public class DoadorDTO {


    private Long id;

    private String nome;

    private int idade;

    private String tiposanguineo;

    private String Rg;

    private Boolean ativo;

    private String email;

    public DoadorDTO(String message) {
        String[] fields = message.split(";");

        this.nome = fields[0];
        this.email = fields[2];

    }


    public DoadorDTO() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTiposanguineo() {
        return tiposanguineo;
    }

    public void setTiposanguineo(String tiposanguineo) {
        this.tiposanguineo = tiposanguineo;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {   return email;   }

    public void setEmail(String email) {  this.email = email;  }
}
