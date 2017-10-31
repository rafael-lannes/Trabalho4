/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;


public class Cliente {

    private int id;
    private String nome;
    private String endereço;
    private String bairro;
    private String cidade;
    private long cep;
    private String estado;
    private String referencia;
    private long cpf;
    private long rg;
    private long Telfixo;
    private long Celular;
    private long cartao;
    private String bandeira;

    public Cliente(int id, String nome, String endereço, String bairro, String cidade, long cep, String estado, String referencia, long cpf, long rg, long Telfixo, long Celular,long cartao, String bandeira) {

        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.rg = rg;
        this.Telfixo = Telfixo;
        this.Celular = Celular;
        this.cartao = cartao;
        this.bandeira = bandeira;
    }

    public Cliente(int id, String endereço, String bairro, String cidade, long cep, String estado, String referencia,long Telfixo, long Celular) {
        
        this.id = id;
        this.endereço = endereço;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this. estado = estado;
        this.referencia = referencia;
        this.Telfixo = Telfixo;
        this.Celular = Celular;
    }

    public Cliente(int id,long cartao, String bandeira ) {
        
        this.id = id;
        this.cartao = cartao;
        this.bandeira = bandeira;
    }
    
    public Cliente(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    
     public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
     public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
     public long getCEP() {
        return cep;
    }

    public void setCEP(long cep) {
        this.cep = cep;
    }
    
     public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
     public long getCPF() {
        return cpf;
    }

    public void setCPF(long cpf) {
        this.cpf = cpf;
    }
    
     public long getRG() {
        return rg;
    }

    public void setRG(long rg) {
        this.rg = rg;
    }
    
     public long getTel() {
        return Telfixo;
    }

    public void setTel(long Telfixo) {
        this.Telfixo = Telfixo;
    }
    
     public long getCel() {
        return Celular;
    }

    public void setCel(long Celular) {
        this.Celular = Celular;
    }
    
     public long getCartao() {
        return cartao;
    }

    public void setCartao(long cartao) {
        this.cartao = cartao;
    }
    
     public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

}

