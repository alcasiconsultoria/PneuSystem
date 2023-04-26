package Entities;

import Enuns.TipoUsuario;

public class Usuario {
    private String nome;
    private TipoUsuario tipo;
    private String senha;
    
    public Usuario(String nome, TipoUsuario tipo, String senha) {
        this.nome = nome;
        this.tipo = tipo;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public TipoUsuario getTipo() {
        return tipo;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

