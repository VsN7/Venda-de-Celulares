
package controller;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import org.jdesktop.observablecollections.ObservableCollections;

public class UsuarioController {
    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO dao;
    private static int id;

    public UsuarioController() throws Exception {
        dao = new UsuarioDAO();
        usuarios = ObservableCollections.observableList(new ArrayList<>());
        pesquisar();
    }
    
    private void pesquisar() throws Exception{
        usuarios.clear();
        usuarios.addAll(dao.findAll());
    }
    
    
    
    public void inserirUsuario(Usuario usuario) throws Exception{
        dao.add(usuario);
    }
    
    public boolean atualixzarUsuario() throws Exception{
        return dao.update(usuario);
    }
    public void lognUsuario(String senha,String login) throws Exception{
        dao.verifica(senha, login);
    }
    
    public int removeUsuario(int id) throws Exception{
        return dao.delete(id);
    }
    
    public void listarUsuarios() throws Exception{
        usuarios = dao.findAll();
    }
    public void ordenaUsuarios() throws Exception{
        usuarios = dao.findAlldesc();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void novo(String login, String senha, String cpf) throws Exception{
        
        usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setCpf(cpf);
        inserirUsuario(usuario);
        usuarios = new ArrayList<>();
    }
    
    public List<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public int verificaCpf(String cpf) throws SQLException{
        return dao.verificaCpf(cpf);
    }
    
    public int verificar(String login, String senha) throws SQLException{
        return dao.verifica(login, senha);
    }
    
    public int retornaId(String login, String senha) throws Exception{
       
        id = dao.retornaId(login,senha);
        return dao.retornaId(login,senha);
                
    }
    
    public int getId(){
        return id;
    }
    
    public int verificaLogin(String login) throws SQLException{
    
        return dao.verificaLogin(login);
        
    }
}
