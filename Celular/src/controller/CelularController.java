
package controller;

import dao.CelularDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Celular;
import org.jdesktop.observablecollections.ObservableCollections;

public class CelularController {
     private Celular celular;
    private List<Celular> celulares;
    private CelularDAO dao;

    public CelularController() throws Exception {
        dao = new CelularDAO();
        celulares = ObservableCollections.observableList(new ArrayList<>());
        pesquisar();
    }
    
    private void pesquisar() throws Exception{
        celulares.clear();
        celulares.addAll(dao.findAll());
    }
    
    public void inserirCelular(Celular celular) throws Exception{
        Component rootPane = null;
        dao.add(celular); 
        JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        
        
    }
    
    public boolean atualizarCelular(int id,String descricao, String marca, String modelo, double valor, String serie, int qnt) throws Exception{
        Component rootPane = null;
        
        celular = new Celular();
        celular.setDescricao(descricao);
        celular.setMarca(marca);
        celular.setModelo(modelo);
        celular.setValor(valor);
        celular.setSerie(serie);
        celular.setQuantidade(qnt);
        JOptionPane.showMessageDialog(rootPane, "Modificação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        
        return dao.update(celular,id);
    }
    
    public int removeCelular(int id) throws Exception{
        Component rootPane = null;
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "excluir", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(rootPane, "Excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
            return dao.delete(id);
        } else{
           return 0;
        }
        
        
    }
    
    public double buscaValor(String descricao) throws SQLException{
        return dao.buscaValor(descricao);
    }
    
    public void listarCelulares() throws Exception{
        celulares = dao.findAll();
    }
    public void ordenaCelulares() throws Exception{
        celulares = dao.findAlldesc();
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
    
    public void novo(String descricao, String marca, String modelo, double valor, String serie, int qnt, int qntR) throws Exception{
        
        celular = new Celular();
        celular.setDescricao(descricao);
        celular.setMarca(marca);
        celular.setModelo(modelo);
        celular.setValor(valor);
        celular.setSerie(serie);
        celular.setQuantidade(qnt);
        celular.setQuantidadeReservada(qntR);
        inserirCelular(celular);
        celulares = new ArrayList<>();
    }
    
    public List<Celular> getCelulares(){
        return celulares;
    }
    
    public int verificaSerie(String serie) throws SQLException{
        return dao.verificaSerie(serie);
    }
    
    public int verificaDescricao(String descricao) throws SQLException{
        return dao.verificaDescricao(descricao);
    }
    
    public int getId(String serie) throws SQLException{
        return dao.getId(serie);
    }
    
    public int primeiroPasso() throws Exception{
        return dao.primeiroPasso();
    }
    public void buscaId(int id) throws Exception{
        dao.buscaId(id);
    }
    
}
