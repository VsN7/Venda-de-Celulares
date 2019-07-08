
package controller;

import dao.CelularVendaDAO;
import dao.VendaDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Venda;
import org.jdesktop.observablecollections.ObservableCollections;

public class VendasController {
     private Venda venda;
    private List<Venda> vendas;
    private VendaDAO dao;

    public VendasController() throws Exception {
        dao = new VendaDAO();
        vendas = ObservableCollections.observableList(new ArrayList<>());
        pesquisar();
    }
    
    private void pesquisar() throws Exception{
        vendas.clear();
        vendas.addAll(dao.findAll());
    }
    
    public void inserirVenda(Venda venda) throws Exception{
        Component rootPane = null;
        dao.add(venda); 
        JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        
        
    }
    
    public boolean atualizarVenda(int id, String cliente) throws Exception{
        Component rootPane = null;
        
        venda = new Venda();
        venda.setCliente(cliente);
        JOptionPane.showMessageDialog(rootPane, "Modificação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        
        return dao.update(venda,id);
    }
    
    public boolean updateData(Date d, int id) throws Exception{
        
        venda = new Venda();
        venda.setData(d);
        return dao.updateData(venda,id);
        
    }
    
    public int removeVenda(int id) throws Exception{
        CelularVendaDAO cvdao = new CelularVendaDAO();
        Component rootPane = null;
        JOptionPane.showMessageDialog(rootPane, "Excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        cvdao.deleteItensVenda(id);
        return dao.delete(id);
    }
    
    public void listarVendas() throws Exception{
        vendas = dao.findAll();
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public void novo(String cliente, Date data,String situacao) throws Exception{
       
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        UsuarioController uc = new UsuarioController();
        c.setTime(d);
        
        venda = new Venda();
        venda.setCliente(cliente);
        venda.setData(d);
        venda.setSituacao(situacao);
        venda.setId_user(uc.getId());
        venda.setValorTotal(0);
        inserirVenda(venda);
        vendas = new ArrayList<>();
    }
    
    public List<Venda> getVendas(){
        return vendas;
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
    
    public String buscaSerie(String descricao) throws Exception{
        return dao.buscaSerie(descricao);
    }
    
    public List<String> getCelular(){
        return dao.getCelular();
    }
    
    public boolean updateSituacao(String descricao,int id) throws Exception{
        return dao.updateSituacao(descricao,id);
    }
    
    public boolean updateValorTotalSomado(int id, double valorT) throws Exception{
        return dao.updateValorTotalSomado(id,valorT);
    }
    
    public double retornaValorTotal(int id) throws SQLException{
        return dao.retornaValorTotal(id);
    }
    
}










/*public void novo(String venda, String cliente, Date data, double preco, String situacao) throws Exception{
        
        venda = new Venda();
        venda.setVenda(venda);
        venda.setCliente(cliente);
        venda.setData(data);
        venda.setPreco(preco);
        venda.setSituacao(situacao);
        inserirVenda(venda);
        vendas = new ArrayList<>();
    }*/