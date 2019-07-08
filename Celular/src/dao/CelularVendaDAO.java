package dao;

import conectar.ConnectionFactory;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.CelularVenda;

public class CelularVendaDAO{
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public CelularVendaDAO() {
    }
    
   private Connection getConnection() throws SQLException{
       Connection conn;
       conn = ConnectionFactory.getInstance().getConnection();
       return conn;
   }
   
   public boolean add(CelularVenda celularVenda) throws Exception{
       try{
           String queryString = "INSERT INTO celular_venda(descricao, quantidade_vendida, id_venda,valor,id_celular,quantidade_vendida_registro)"
                   + "VALUES(?,?,?,?,?,?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1,celularVenda.getDescricao());
           ptmt.setInt(2,celularVenda.getQuantidade_vendida());
           ptmt.setInt(3,celularVenda.getId_venda());
           ptmt.setDouble(4,celularVenda.getValor());
           ptmt.setInt(5,celularVenda.getId_celular());
           ptmt.setInt(6,celularVenda.getQuantidade_vendida_registro());
           ptmt.executeUpdate();
           return true;                   
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection,ptmt,resultSet);
       }
   }
   
   public int verificaSerie(String serie) throws SQLException{
       String queryString = "SELECT serie FROM celularVenda where serie = '"+serie+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String serieVerifica= "";
           while(resultSet.next()){
                serieVerifica = resultSet.getString("serie");
                }
           if(!serieVerifica.equals(serie)){
               return 1;
           }else{
               return 0;
           }
   }
   
   
   
   public int recuperaQnt(String descricao) throws SQLException{
       
       Component rootPane = null;
       int qnt = 0;
       String queryString = "SELECT quantidade FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("quantidade");
                }
       return qnt;
   }
   
   public int recuperaQntRegistro(int id) throws SQLException{
       
       Component rootPane = null;
       int qnt = 0;
       String queryString = "SELECT quantidade_vendida_registro FROM celular_venda where id = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("quantidade_vendida_registro");
                }
       return qnt;
   }
   
   public double recuperaValor(int id){
       
       Component rootPane = null;
       double val=0;
       try{
       String queryString = "SELECT valor FROM celular_venda where id = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       
       while(resultSet.next()){
                val = resultSet.getDouble("valor");
            }
       return val;
       }catch(Exception e){
           return 5;
       }
   }
   
   
   public int recuperaQntReservada(String descricao) throws SQLException{
       
       Component rootPane = null;
       int qnt = 0;
       String queryString = "SELECT quantidade_reservada FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("quantidade_reservada");
                }
       return qnt;
   }
   
   
   public int recuperaQntId(int id) throws SQLException{
       
       Component rootPane = null;
        int qnt = 0;
       String queryString = "SELECT quantidade_vendida FROM celular_venda where id = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("quantidade_vendida");
                }
       return qnt;
   }
   
   //QntReservadoAtual
   
   public int QntReservadoAtual(String descricao) throws SQLException{
       
       Component rootPane = null;
        int qnt = 0;
       String queryString = "SELECT quantidade_reservada FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("quantidade_reservada");
                }
       return qnt;
   }
   
   
   public String retornaDescSelecionada(int id) throws SQLException{
       
       Component rootPane = null;
        String desc = "";
       String queryString = "SELECT descricao FROM celular_venda where id = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    desc = resultSet.getString("descricao");
                }
       return desc;
   }
   
   
   public int recuperaQntT(int id,int id_c) throws SQLException{
       
       Component rootPane = null;
        int qnt = 0;
       String queryString = "SELECT SUM(quantidade_vendida) FROM celular_venda where id_venda = "+id+" AND id_celular = "+id_c;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("SUM(quantidade_vendida)");
                }
       return qnt;
   }
   
   
   public int recuperaQntTParaVenda(int id) throws SQLException{
       
       Component rootPane = null;
        int qnt = 0;
       String queryString = "SELECT SUM(quantidade_vendida) FROM celular_venda where id_venda = "+id;
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("SUM(quantidade_vendida)");
                }
       return qnt;
   }
   
   
   public int recuperaQntTParaVendaDesc(String desc) throws SQLException{
       
       Component rootPane = null;
        int qnt = 0;
       String queryString = "SELECT SUM(quantidade_vendida) FROM celular_venda where descricao = '"+desc+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    qnt = resultSet.getInt("SUM(quantidade_vendida)");
                }
       return qnt;
   }
   
   //somarrr todo a qnt baseada na descrição e colocar no campo do celular est res
   
   public int recuperaIdC(String descricao) throws SQLException{
       
       Component rootPane = null;
       int id = 0;
       String queryString = "SELECT id FROM celular where descricao = '"+descricao+"'";
       connection = getConnection();
       ptmt = connection.prepareStatement(queryString);
       resultSet = ptmt.executeQuery(queryString);
       resultSet.getRow();
       while(resultSet.next()){
                    id = resultSet.getInt("id");
                }
       return id;
   }
   
   public int verificaDescricao(String descricao) throws SQLException{
       String queryString = "SELECT descricao FROM celularVenda where descricao = '"+descricao+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery(queryString);
           resultSet.getRow();
           String descricaoVerifica= "";
           while(resultSet.next()){
                descricaoVerifica = resultSet.getString("descricao");
                }
           if(!descricaoVerifica.equals(descricao)){
               return 1;
           }else{
               return 0;
           }
   }
   
   public boolean update(CelularVenda celularVenda, int id) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE celular_venda SET descricao = ?, marca = ?, modelo = ?, valor = ?, serie = ?, quantidade = ? WHERE id ="+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setString(1,celularVenda.getDescricao());
           ptmt.setInt(2,celularVenda.getQuantidade_vendida());
           ptmt.setInt(3,celularVenda.getId_venda());
           ptmt.setDouble(4,celularVenda.getValor());
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public boolean updateQntR(String descricao, int qnt) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE celular SET quantidade_reservada = ? WHERE descricao = '"+descricao+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setInt(1,qnt);
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public boolean updateQntVendida(int id, int qnt) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE celular_venda SET quantidade_vendida = ? WHERE id = "+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setInt(1,qnt);
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public boolean updateQntT(String descricao, int qnt) throws Exception{
       try{ ///UPDATE `usuario` SET `login`='v',`senha`='4',`cpf`='new' WHERE cpf = '056.647.421-27'
           String queryString = "UPDATE celular SET quantidade = ? WHERE descricao = '"+descricao+"'";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setInt(1,qnt);
           ptmt.executeUpdate();
           return true;
       } catch (SQLException e){
           e.printStackTrace();
           return false;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
           
         
           
           
   public int delete(int id) throws Exception{
       try{
           String queryString = "DELETE FROM celular_venda WHERE id=?";
           connection = getConnection();
           ptmt= connection.prepareStatement(queryString);
           ptmt.setInt(1,id);
           int val = ptmt.executeUpdate();
           return val;
       } catch (SQLException e){
           e.printStackTrace();
           return -1;
       }finally {
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public int deleteItensVenda(int id) throws Exception{
       try{
           String queryString = "DELETE FROM celular_venda WHERE id_venda=?";
           connection = getConnection();
           ptmt= connection.prepareStatement(queryString);
           ptmt.setInt(1,id);
           int val = ptmt.executeUpdate();
           return val;
       } catch (SQLException e){
           e.printStackTrace();
           return -1;
       }finally {
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public List<CelularVenda> findAll(int id) throws Exception{
       List<CelularVenda> celularVendas = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM celular_Venda where id_venda ="+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               celularVendas.add(new CelularVenda(resultSet.getInt("id"),resultSet.getString("descricao"),
                       resultSet.getInt("quantidade_vendida"),resultSet.getDouble("valor"),resultSet.getInt("id_venda"),resultSet.getInt("quantidade_vendida_registro")));
           }
           return celularVendas;
       } catch (SQLException e){
           e.printStackTrace();
           return celularVendas;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public List<CelularVenda> findAllPagar(int id) throws Exception{
       List<CelularVenda> celularVendas = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM celular_Venda where id_venda ="+id;
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               celularVendas.add(new CelularVenda(resultSet.getInt("id"),resultSet.getString("descricao"),
                       resultSet.getInt("quantidade_vendida"),resultSet.getDouble("valor"),resultSet.getInt("id_venda"),resultSet.getInt("quantidade_vendida_registro")));
           }
           return celularVendas;
       } catch (SQLException e){
           e.printStackTrace();
           return celularVendas;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public int primeiroPasso() throws Exception{
       List<CelularVenda> celularVendas = new ArrayList<>();
       try{
           int i=0;
           String queryString = "SELECT * FROM celularVenda";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               i++;
           }
           if(i>0)
            return 1;
           else
             return 0;  
       } catch (SQLException e){
           e.printStackTrace();
           return 2;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public void buscaId(int id) throws Exception{
       List<CelularVenda> celularVendas = new ArrayList<>();
       try{
           int i=0;
           String queryString = "SELECT * FROM celularVenda";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               if(id == celularVendas.get(i).getId()){
                   System.out.println(celularVendas.get(i).getId());
               }
               i++;
           }
       } catch (SQLException e){
           e.printStackTrace();
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   
   public int getId(String serie){
       String queryString = "SELECT id FROM celularVenda where serie = '"+serie+"'";
        try {
            connection = getConnection();
        
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery(queryString);
            resultSet.getRow();
            int getId= 0;
            while(resultSet.next()){
                    getId = resultSet.getInt("id");
                }
            return getId;
           } catch (SQLException ex) {
            return 0;
        } 
   }
   
   public List<CelularVenda> findAlldesc() throws Exception{
       List<CelularVenda> celularVendas = new ArrayList<>();
       try{
           String queryString = "SELECT * FROM celularVenda order by nome desc";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           resultSet = ptmt.executeQuery();
           while(resultSet.next()){
               celularVendas.add(new CelularVenda(resultSet.getInt("id"),resultSet.getString("descricao"),
                       resultSet.getInt("quantidade_vendida"),resultSet.getDouble("valor"),resultSet.getInt("id_venda"),resultSet.getInt("quantidade_vendida_registro")));
           }
           return celularVendas;
       } catch (SQLException e){
           e.printStackTrace();
           return celularVendas;
       }finally{
           closeConnection(connection, ptmt, resultSet);
       }
   }
   
   public void closeConnection(Connection conn, Statement st, ResultSet rs) throws Exception{
       close(conn, st, null);
   }
   
   public void closeConnection(Connection conn) throws Exception{
       close(conn,null,null);
   }
   
   public void close(Connection conn, Statement st, ResultSet rs) throws Exception{
       try{
           if(rs != null) rs.close();
           if(st != null) st.close();
           if(conn != null) conn.close();
       } catch (Exception e){
           
           throw new Exception(e.getMessage());
       }
   }
   
   
}
