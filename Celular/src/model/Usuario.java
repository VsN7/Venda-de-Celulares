/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.UsuarioController;
import dao.UsuarioDAO;
import view.LoginView;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/**
 *
 * @author rgarcia
 */
public class Usuario{

    public Usuario(Integer id, String login, String senha, String cpf) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }
    public Usuario(){
    }
    private Integer id;
    
    private String login;
    
    private String senha;
    
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
