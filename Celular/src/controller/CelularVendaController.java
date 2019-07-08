
package controller;

import dao.CelularVendaDAO;
import dao.VendaDAO;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.CelularVenda;
import org.jdesktop.observablecollections.ObservableCollections;

public class CelularVendaController {
     private CelularVenda celularVenda;
    private List<CelularVenda> celularVendas;
    private CelularVendaDAO dao;

    public CelularVendaController(int id) throws Exception {
        dao = new CelularVendaDAO();
        celularVendas = ObservableCollections.observableList(new ArrayList<>());
        pesquisar(id);
    }
    
    private void pesquisar(int id) throws Exception{
        celularVendas.clear();
        celularVendas.addAll(dao.findAll(id));
    }
    
    public void inserirCelularVenda(CelularVenda celularVenda) throws Exception{
        Component rootPane = null;
        dao.add(celularVenda);
        
    }
    
    public boolean atualizarCelularVenda(int id,String descricao, int quantidade_vendida, int id_venda, double valor) throws Exception{
        Component rootPane = null;
        
        celularVenda = new CelularVenda();
        celularVenda.setDescricao(descricao);
        celularVenda.setQuantidade_vendida(quantidade_vendida);
        celularVenda.setValor(valor);
        celularVenda.setId_venda(id_venda);
        JOptionPane.showMessageDialog(rootPane, "Modificação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE, null);
        
        return dao.update(celularVenda,id);
    }
    
    private static double valorTotal;
    
    public void mandaValor(double vl){
        valorTotal = vl;
    }
    
    public int removeCelularVenda(int id, String desc, int qnt,int idVenda) throws Exception{
        Component rootPane = null;
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o item da venda?", "excluir", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            this.updateQntR(desc, qnt);
            VendaDAO vdao = new VendaDAO();
            vdao.updateValorTotalSomado(idVenda, valorTotal);
            return dao.delete(id);
        } else{
           return 0;
        }
        
        
    }
    
    public void listarCelularVendaVendas(int id) throws Exception{
        celularVendas = dao.findAll(id);
    }
    public void ordenaCelularVendaVendas() throws Exception{
        celularVendas = dao.findAlldesc();
    }

    public CelularVenda getCelularVenda() {
        return celularVenda;
    }

    public void setCelularVenda(CelularVenda celularVenda) {
        this.celularVenda = celularVenda;
    }
    
    public void novo(String descricao, int quantidade_vendida, int id_venda, double valor, int id_celular, int qnt_registro) throws Exception{
        
        celularVenda = new CelularVenda();
        celularVenda.setDescricao(descricao);
        celularVenda.setQuantidade_vendida(quantidade_vendida);
        celularVenda.setValor(valor);
        celularVenda.setId_venda(id_venda);
        celularVenda.setId_celular(id_celular);
        celularVenda.setQuantidade_vendida_registro(qnt_registro);
        inserirCelularVenda(celularVenda);
        celularVendas = new ArrayList<>();
    }
    
    public List<CelularVenda> getCelularVendaVendas(){
        return celularVendas;
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
    
    public int recuperaQnt(String descricao) throws SQLException{
        return dao.recuperaQnt(descricao);
    }
    
    public int recuperaQntT(int id,int id_c) throws SQLException{
        return dao.recuperaQntT(id,id_c);
    }
    public int recuperaIdC(String descricao) throws SQLException{
        return dao.recuperaIdC(descricao);
    }
    
    public boolean updateQntR(String descricao, int qnt) throws SQLException, Exception{
        return dao.updateQntR(descricao, qnt);
    }
    
    public int recuperaQntId(int id) throws SQLException{
        return dao.recuperaQntId(id);
    }
    
    public int QntReservadoAtual(String descricao) throws SQLException{
        return dao.QntReservadoAtual(descricao);
    }
    
    public String retornaDescSelecionada(int id) throws SQLException{
        return dao.retornaDescSelecionada(id);
    }
    
    public int recuperaQntTParaVenda(int id) throws SQLException{
        return dao.recuperaQntTParaVenda(id);
    }
    
    public List<CelularVenda> findAllPagar(int id) throws Exception{
    
        return dao.findAllPagar(id);
    }
    
    public int recuperaQntReservada(String descricao) throws SQLException{
    
        return dao.recuperaQntReservada(descricao);
        
    }
    
    public boolean updateQntT(String descricao, int qnt) throws Exception{
    
        return dao.updateQntT(descricao, qnt);
    
    }
    
    
    public int recuperaQntTParaVendaDesc(String desc) throws SQLException{
    
        return dao.recuperaQntTParaVendaDesc(desc);
    }
    
    public boolean updateQntVendida(int id, int qnt) throws Exception{
    
        return dao.updateQntVendida(id, qnt);
        
    }
    
    public double recuperaValor(int id) throws SQLException{
        return dao.recuperaValor(id);
    }
    
    public int recuperaQntRegistro(int id) throws SQLException{
    
        return dao.recuperaQntRegistro(id);
    }
    public void removeCelular(int id) throws Exception{
        dao.delete(id);
    }
    
}
